package it.groppedev.lesson3.exercise1.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import it.groppedev.lesson3.exercise1.SwimmingResponse;

public class Sampler implements Analyzable
{
	private static final String NAME_BATTERIO_PREFIX = "batterio_";
	private static final String NAME_ID = "id";
	private static final String NAME_DATA = "data";
	private static final String DATE_PATTERN = "ddMMyyyy";
	private Date dataRilevamento;
	private Collection<Batterio> batteriAnalizzati;
	private final String id;
	
	public Sampler(Date date)
	{
		this(date, RandomStringUtils.randomNumeric(5));
	}
	
	private Sampler(Date date, String id)
	{
		this.dataRilevamento = date;
		this.batteriAnalizzati = new ArrayList<Batterio>();
		this.id = RandomStringUtils.randomNumeric(5);
	}
	
	public static Sampler fromRecord(Map<String, String> record)
	{
		try
		{
			Sampler sampler = new Sampler(new SimpleDateFormat(DATE_PATTERN).parse(record.get(NAME_DATA)), record.get(NAME_ID));
			for(Map.Entry<String, String> entry : record.entrySet())
			{
				if(entry.getKey().startsWith(NAME_BATTERIO_PREFIX))
				{
					String batterioName = entry.getKey().substring(NAME_BATTERIO_PREFIX.length());
					Batterio batterio = BatterioFactory.newBatterioByName(BatterioEnum.fromName(batterioName), Integer.valueOf(entry.getValue()));
					
					sampler.addBatterio(batterio);
				}
			}
			return sampler;
		} 
		catch (ParseException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	public String serialize()
	{
		StringBuilder sb = new StringBuilder()
				.append(NAME_ID).append("=").append(this.id);
		for(Batterio batterio : this.batteriAnalizzati)
		{
			sb.append(",")
			.append(NAME_BATTERIO_PREFIX).append(batterio.getName()).append("=").append(batterio.getValue());
		}
		sb.append(",")
		.append(NAME_DATA).append("=").append(new SimpleDateFormat(DATE_PATTERN).format(this.dataRilevamento));
		
		return sb.toString();
	}
	
	public String getId()
	{
		return id;
	}

	public void addBatterio(Batterio batterio)
	{
		this.batteriAnalizzati.add(batterio);
	}
	
	public Date dataRilevamento()
	{
		return dataRilevamento;
	}
	
	@Override
	public SwimmingResponse analyze()
	{
		// Balneabilità
		int numeroBatteriAnalizzati = this.batteriAnalizzati.size();
		int totaleBatteriConBalneabilita = this.batteriAnalizzati.stream()
				.mapToInt((b) -> { return b.respectTheLimit() ? 1 : 0; })
				.reduce(0, Integer::sum);
		boolean balneabile = numeroBatteriAnalizzati == totaleBatteriConBalneabilita;
		
		// Qualità dell'acqua
		WaterQuality averageWaterQuality = WaterQuality.INSUFFICIENTE;
		if(balneabile)
		{
			double mediaQualitaAcqua = this.batteriAnalizzati.stream()
					.mapToInt(Batterio::waterQualityWeight)
					.average()
					.orElse(WaterQuality.NON_DISPONIBILE.weight());
			averageWaterQuality = WaterQuality.selectByWeightFactor(mediaQualitaAcqua);
		}
		
		SwimmingResponse swimmingResponse = new SwimmingResponse();
		swimmingResponse.setSwimming(balneabile);
		swimmingResponse.setWaterQuality(averageWaterQuality.name());
		return swimmingResponse;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batteriAnalizzati == null) ? 0 : batteriAnalizzati.hashCode());
		result = prime * result + ((dataRilevamento == null) ? 0 : dataRilevamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sampler other = (Sampler) obj;
		if (batteriAnalizzati == null)
		{
			if (other.batteriAnalizzati != null)
				return false;
		} else if (!batteriAnalizzati.equals(other.batteriAnalizzati))
			return false;
		if (dataRilevamento == null)
		{
			if (other.dataRilevamento != null)
				return false;
		} else if (!dataRilevamento.equals(other.dataRilevamento))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Sampler [dataRilevamento=" + dataRilevamento + ", batteriAnalizzati=" + batteriAnalizzati + ", id=" + id + "]";
	}
}

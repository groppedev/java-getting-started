package it.groppedev.lesson3.exercise1.model;

public class StabilimentoBalneare
{
	private final int anno;
	private final String localita;
	private final String spiaggia;
	
	public StabilimentoBalneare(int anno, String localita, String spiaggia)
	{
		this.anno = anno;
		this.localita = localita;
		this.spiaggia = spiaggia;
	}

	public int getAnno()
	{
		return anno;
	}

	public String getLocalita()
	{
		return localita;
	}

	public String getSpiaggia()
	{
		return spiaggia;
	}
	
	public String alias()
	{
		return new StringBuilder()
				.append(Integer.valueOf(this.anno))
				.append("-")
				.append(this.localita)
				.append("-")
				.append(this.spiaggia)
				.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + ((spiaggia == null) ? 0 : spiaggia.hashCode());
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
		StabilimentoBalneare other = (StabilimentoBalneare) obj;
		if (anno != other.anno)
			return false;
		if (localita == null)
		{
			if (other.localita != null)
				return false;
		} else if (!localita.equals(other.localita))
			return false;
		if (spiaggia == null)
		{
			if (other.spiaggia != null)
				return false;
		} else if (!spiaggia.equals(other.spiaggia))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "StabilimentoBalneare [anno=" + anno + ", localita=" + localita + ", spiaggia=" + spiaggia + "]";
	}
}

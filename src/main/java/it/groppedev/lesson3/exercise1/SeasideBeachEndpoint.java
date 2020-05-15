package it.groppedev.lesson3.exercise1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.groppedev.lesson3.exercise1.model.BatterioEnterococco;
import it.groppedev.lesson3.exercise1.model.BatterioEscherichiaColi;
import it.groppedev.lesson3.exercise1.model.Sampler;
import it.groppedev.lesson3.exercise1.model.StabilimentoBalneare;
import it.groppedev.lesson3.exercise1.repository.DataFileSamplerRepository;
import it.groppedev.lesson3.exercise1.repository.ISamplerRepository;

/**
 * Endpoint di tipo SINGLETON {@link SeasideApplication#getSingletons()}
 * 
 * L'endpoint è un dispatcher per l'esecuzione remota dei task tramite REST API
 * 
 * @author GROMAS
 */
@Path("/{location}/{year}/{beach}")
public class SeasideBeachEndpoint
{
	/**
	 * URL: http://localhost:9091/seaside/lignano/2020/spiaggiacomunale/info?id=1111
	 */
	@GET
	@Path("info")
	public Response waterInfo(@PathParam("location") String location, 
			                  @PathParam("year") int year,
							  @PathParam("beach") String beach,
							  @QueryParam("id") String samplerId)
	{
		StabilimentoBalneare stabilimento = new StabilimentoBalneare(year, location, beach);
		
		ISamplerRepository repository = getSamplerRepository(stabilimento);
		
		Sampler sampler = repository.load(samplerId);
		SwimmingResponse swimmingResponse = sampler.analyze();
		
		return Response.status(Response.Status.OK)
					   .entity(toJSON(swimmingResponse))
				       .type(MediaType.APPLICATION_JSON)
				       .build();
	}

	/**
	 * URL: http://localhost:9091/seaside/lignano/2020/spiaggiacomunale/newsample
	 * 		data=14052020&enterococchi=10&escherichiacoli=20
	 * @throws ParseException 
	 */
	@POST
	@Path("newsample")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String newSample(@PathParam("location") String location, 
						    @PathParam("year") int year,
						    @PathParam("beach") String beach,
						    @FormParam("data") String dateAsString,
						    @FormParam("enterococchi") int enterococchi,
						    @FormParam("escherichiacoli") int escherichiacoli) throws ParseException
	{
		Date date = new SimpleDateFormat("ddMMyyyy").parse(dateAsString);
		
		StabilimentoBalneare stabilimento = new StabilimentoBalneare(year, location, beach);
		
		Sampler sampler = new Sampler(date);
		sampler.addBatterio(new BatterioEnterococco(enterococchi));
		sampler.addBatterio(new BatterioEscherichiaColi(escherichiacoli));

		ISamplerRepository repository = getSamplerRepository(stabilimento);
		repository.save(sampler);
		
		return sampler.getId();
	}
	
	private static ISamplerRepository getSamplerRepository(StabilimentoBalneare stabilimento)
	{
		return new DataFileSamplerRepository(SeasideServerMain.dataDirectory(), stabilimento);
	}
	
	private static String toJSON(SwimmingResponse swimmingResponse)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try
		{
			return objectMapper.writeValueAsString(swimmingResponse);
		} 
		catch (JsonProcessingException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
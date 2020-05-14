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
import javax.ws.rs.core.MediaType;

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
	
	private int counter;

	/**
	 * URL: http://localhost:9091/seaside/lignano/2020/spiaggiacomunale/info
	 */
	@GET
	@Path("info")
	@Produces({ MediaType.APPLICATION_JSON})
	public SwimmingResponse waterInfo(@PathParam("location") String location, 
								  	  @PathParam("year") int year,
								      @PathParam("beach") String beach)
	{
		System.out.println(String.format("Hit Balenabilita' [%d] localita:=%s anno:=%s spiaggia:=%s",
						   ++this.counter, location, year, beach));
		
		return new SwimmingResponse(true, "ECCELLENTE");
	}
	
	/**
	 * URL: http://localhost:9091/seaside/lignano/2020/spiaggiacomunale/newsample
	 * 		data=14052020&enterococchi=10&escherichiacoli=20
	 * @throws ParseException 
	 */
	@POST
	@Path("newsample")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Date newSample(@PathParam("location") String location, 
						  @PathParam("year") int year,
						  @PathParam("beach") String beach,
						  @FormParam("data") String dateAsString,
						  @FormParam("enterococchi") int enterococchi,
						  @FormParam("escherichiacoli") int escherichiacoli) throws ParseException
	{
		System.out.println(String.format("Hit New Sample' [%d] localita:=%s anno:=%s spiaggia:=%s",
						   ++this.counter, location, year, beach));
		Date date = new SimpleDateFormat("ddMMyyyy").parse(dateAsString);
		System.out.println(date);
		return date;
	}
}
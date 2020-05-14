package it.groppedev.lesson3.exercise1;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@ApplicationPath("/seaside")
public class SeasideApplication extends Application
{
	public static final Charset ENCODING = Charset.forName("UTF8");

	public static String encodingName()
	{
		return ENCODING.name();
	}

	@Override
	public Set<Class<?>> getClasses()
	{
        return Stream.of(OpenApiResource.class).collect(Collectors.toSet());

	}

	@Override
	public Set<Object> getSingletons()
	{
		return Stream.of(new SeasideBeachEndpoint()).collect(Collectors.toSet());
	}
}
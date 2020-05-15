package it.groppedev.lesson3.exercise1;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

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
        return Collections.emptySet();

	}

	@Override
	public Set<Object> getSingletons()
	{
		return Stream.of(new SeasideBeachEndpoint()).collect(Collectors.toSet());
	}
}
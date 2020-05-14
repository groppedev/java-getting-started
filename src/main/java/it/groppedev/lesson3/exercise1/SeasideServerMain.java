package it.groppedev.lesson3.exercise1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;

public class SeasideServerMain
{
	private static UndertowJaxrsServer server;
	private static String SERVER_PORT = System.getProperty("org.jboss.resteasy.port", "9091");
	// "0.0.0.0" al posto di "localhost" per i containers
	private static String SERVER_HOST = System.getProperty("org.jboss.resteasy.host", "localhost"); 

	public static void main(String...args) throws IOException
	{
		String dataFilesFolder = args.length > 0 ? args[0] : "seaside_data";
		// Directory corrente
		Path currentRelativePath = Paths.get("");
		Path dataDirectory = Files.createDirectories(currentRelativePath.resolve(dataFilesFolder));
		System.out.println(String.format("DATA Directory -> '%s'", dataDirectory.toAbsolutePath().toFile()));
		
		startServer();
	}
	
	public static UndertowJaxrsServer startServer()
	{
		Undertow.Builder builder = Undertow.builder()
				.addHttpListener(Integer.parseInt(SERVER_PORT), SERVER_HOST);
		server = new UndertowJaxrsServer().start(builder);
		server.deploy(SeasideApplication.class);

		return server;
	}
	
	public static void stopServer()
	{
		server.stop();
	}
	
	public static String serverPort()
	{
		return SERVER_PORT;
	}
	
	public static String serverHost()
	{
		return SERVER_HOST;
	}
}

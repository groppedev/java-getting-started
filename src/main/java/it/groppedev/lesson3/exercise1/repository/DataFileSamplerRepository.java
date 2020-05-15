package it.groppedev.lesson3.exercise1.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.groppedev.lesson3.exercise1.model.Sampler;
import it.groppedev.lesson3.exercise1.model.StabilimentoBalneare;

public class DataFileSamplerRepository implements ISamplerRepository
{
	private Path dataStoreFile;
	
	public DataFileSamplerRepository(Path dataFilePath, StabilimentoBalneare stabilimentoBalneare)
	{
		this.dataStoreFile = dataFilePath.resolve(stabilimentoBalneare.alias().concat(".data"));
	}
	
	@Override
	public Sampler load(String id)
	{
		try(BufferedReader reader = Files.newBufferedReader(this.dataStoreFile))
		{
			List<Map<String, String>> recordsFiltered = reader.lines()
				.map(DataFileSamplerRepository::fromString)
				.filter((m) -> m.containsValue(id))
				.collect(Collectors.toList());
			
			return Sampler.fromRecord(recordsFiltered.get(0));
		} 
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	private static Map<String, String> fromString(String rawRecord)
	{
		Map<String, String> recordMap = new HashMap<String, String>();
		String[] entries = StringUtils.split(rawRecord, ",");
		for(String entry : entries)
		{
			String[] entrySplitted = StringUtils.split(entry, "=");
			recordMap.put(entrySplitted[0], entrySplitted[1]);
		}
		return recordMap;
	}

	@Override
	public void save(Sampler sampler)
	{
		try(BufferedWriter writer = Files.newBufferedWriter(this.dataStoreFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND);)
		{
			writer.write(sampler.serialize());
			writer.write("\n");
		} 
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
}

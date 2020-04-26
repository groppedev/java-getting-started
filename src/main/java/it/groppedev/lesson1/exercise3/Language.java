package it.groppedev.lesson1.exercise3;

public enum Language
{
	ITALIAN("it", "Ciao"),
	ENGLISH("en", "Hello");
	
	private final String alias;
	private final String greetingWord;
	
	private Language(String alias, String greetingWord)
	{
		this.alias = alias;
		this.greetingWord = greetingWord;
	}
	
	public String getAlias()
	{
		return alias;
	}

	public String getGreetingWord()
	{
		return greetingWord;
	}

	public static Language fromString(String alias)
	{
		for(Language language : Language.values())
		{
			if(language.alias.equalsIgnoreCase(alias))
			{
				return language;
			}
		}
		throw new IllegalArgumentException(String.format("Language not found for alias: '%s'", alias));
	}
}

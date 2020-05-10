package it.groppedev.lesson2.exercise3;

public enum Language
{
	ITALIAN("it", "Ciao %s, sono JAVA ed ho %d anni!"),
	ENGLISH("en", "Hello %s, I am JAVA and I am %d years old!");
	
	private final String message;
	private final String alias;

	private Language(String alias, String message)
	{
		this.message = message;
		this.alias = alias;
	}

	public String getMessage()
	{
		return message;
	}
	
	public static Language fromString(String languageAlias)
	{
		for(Language lang : Language.values())
		{
			if(lang.alias.equals(languageAlias))
			{
				return lang;
			}
		}
		throw new IllegalArgumentException(String.format("Nessun linguaggio trovato per l'alias '%s'", languageAlias));
	}
}

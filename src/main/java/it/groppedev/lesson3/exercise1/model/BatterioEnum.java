package it.groppedev.lesson3.exercise1.model;

public enum BatterioEnum
{
	ENTEROCOCCO,
	ESCHERICHIACOLI;
	
	public String nameLowerCase()
	{
		return this.name().toLowerCase();
	}
	
	public static BatterioEnum fromName(String batterioName)
	{
		for(BatterioEnum batterio : BatterioEnum.values())
		{
			if(batterioName.equals(batterio.nameLowerCase()))
			{
				return batterio;
			}
		}
		throw new IllegalArgumentException(String.format("Nessum batterio trovato per il nome '%s'", batterioName));
	}
}

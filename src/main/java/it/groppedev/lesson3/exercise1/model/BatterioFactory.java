package it.groppedev.lesson3.exercise1.model;

public class BatterioFactory
{
	public static Batterio newBatterioByName(BatterioEnum batterioEnum, int value)
	{
		switch (batterioEnum)
		{
		case ENTEROCOCCO:
			return new BatterioEnterococco(value);
		case ESCHERICHIACOLI:
			return new BatterioEscherichiaColi(value);
		default:
			throw new IllegalArgumentException(String.format("Impossibile istanziare il batterio '%s'", batterioEnum));
		}
	}
}

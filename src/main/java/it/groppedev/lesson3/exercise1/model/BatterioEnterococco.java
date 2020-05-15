package it.groppedev.lesson3.exercise1.model;

public class BatterioEnterococco extends Batterio
{
	public static int LIMIT_MAX;
	public static int LIMIT_MEDIUM;
	public static int LIMIT_MIN;
	
	static
	{
		LIMIT_MAX = Integer.valueOf(System.getProperty("enterococco.max", "500"));
		LIMIT_MEDIUM = Integer.valueOf(System.getProperty("enterococco.medium", "50"));
		LIMIT_MIN = Integer.valueOf(System.getProperty("enterococco.min", "5"));
	}
	
	public BatterioEnterococco(int value)
	{
		super(value, "enterococco");
	}

	@Override
	public boolean respectTheLimit()
	{
		return this.getValue() < LIMIT_MAX ? true : false;
	}

	@Override
	public WaterQuality waterQuality()
	{
		if(this.getValue() <= LIMIT_MIN)
		{
			return WaterQuality.ECCELLENTE;
		}
		else if(this.getValue() > LIMIT_MIN && this.getValue() < LIMIT_MEDIUM)
		{
			return WaterQuality.BUONA;
		}
		else if(this.getValue() >= LIMIT_MEDIUM && this.getValue() < LIMIT_MAX)
		{
			return WaterQuality.SUFFICIENTE;
		}
		return WaterQuality.INSUFFICIENTE;
	}
}

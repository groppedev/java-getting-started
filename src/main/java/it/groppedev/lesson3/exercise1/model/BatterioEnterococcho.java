package it.groppedev.lesson3.exercise1.model;

public class BatterioEnterococcho extends Batterio
{
	public static final int LIMIT_MAX = 500;
	public static final int LIMIT_MEDIUM = 50;
	public static final int LIMIT_MIN = 5;
	
	public BatterioEnterococcho(int value)
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

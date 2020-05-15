package it.groppedev.lesson3.exercise1.model;

public enum WaterQuality
{
	INSUFFICIENTE(1),
	SUFFICIENTE(2),
	BUONA(3),
	ECCELLENTE(4),
	NON_DISPONIBILE(5);
	
	private final int weight;

	private WaterQuality(int weight)
	{
		this.weight = weight;
	}

	public int weight()
	{
		return weight;
	}
	
	public static WaterQuality selectByWeightFactor(double weightFactor)
	{
		int calculatedWeight = (int) Math.floor(weightFactor);
		return fromWeight(calculatedWeight);
	}
	
	private static WaterQuality fromWeight(int weight)
	{
		for(WaterQuality waterQuality : WaterQuality.values())
		{
			if(waterQuality.weight() == weight)
			{
				return waterQuality;
			}
		}
		return NON_DISPONIBILE;
	}
}

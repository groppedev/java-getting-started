package it.groppedev.lesson3.exercise1;

public class SwimmingResponse
{
	private boolean isSwimming;
	private String waterQuality;
	
	public boolean isSwimming()
	{
		return isSwimming;
	}
	public void setSwimming(boolean isSwimming)
	{
		this.isSwimming = isSwimming;
	}
	public String getWaterQuality()
	{
		return waterQuality;
	}
	public void setWaterQuality(String waterQuality)
	{
		this.waterQuality = waterQuality;
	}
	@Override
	public String toString()
	{
		return "SwimmingResponse [isSwimming=" + isSwimming + ", waterQuality=" + waterQuality + "]";
	}
}

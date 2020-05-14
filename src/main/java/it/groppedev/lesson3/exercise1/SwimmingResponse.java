package it.groppedev.lesson3.exercise1;

public class SwimmingResponse
{
	private boolean isSwimming;
	private String waterQuality;
	
	public SwimmingResponse(boolean isSwimming, String waterQuality)
	{
		this.isSwimming = isSwimming;
		this.waterQuality = waterQuality;
	}
	
	public boolean isSwimming()
	{
		return isSwimming;
	}
	public void setBalneabile(boolean isSwimming)
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
}

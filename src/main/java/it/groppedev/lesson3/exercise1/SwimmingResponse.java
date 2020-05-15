package it.groppedev.lesson3.exercise1;

import it.groppedev.lesson3.exercise1.model.WaterQuality;

public class SwimmingResponse
{
	private boolean isSwimming;
	private WaterQuality waterQuality;
	
	public boolean isSwimming()
	{
		return isSwimming;
	}
	public void setSwimming(boolean isSwimming)
	{
		this.isSwimming = isSwimming;
	}
	public WaterQuality getWaterQuality()
	{
		return waterQuality;
	}
	public void setWaterQuality(WaterQuality waterQuality)
	{
		this.waterQuality = waterQuality;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (isSwimming ? 1231 : 1237);
		result = prime * result + ((waterQuality == null) ? 0 : waterQuality.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SwimmingResponse other = (SwimmingResponse) obj;
		if (isSwimming != other.isSwimming)
			return false;
		if (waterQuality != other.waterQuality)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "SwimmingResponse [isSwimming=" + isSwimming + ", waterQuality=" + waterQuality + "]";
	}
}

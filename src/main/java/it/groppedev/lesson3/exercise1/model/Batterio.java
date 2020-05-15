package it.groppedev.lesson3.exercise1.model;

public abstract class Batterio
{
	private final int value;
	private final String name;
	
	public Batterio(int value, String name)
	{
		this.value = value;
		this.name = name;
	}
	
	protected int getValue()
	{
		return value;
	}

	protected String getName()
	{
		return name;
	}

	public abstract boolean respectTheLimit();
	
	public abstract WaterQuality waterQuality();
	
	public int waterQualityWeight()
	{
		return waterQuality().weight();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
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
		Batterio other = (Batterio) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Batterio [value=" + value + ", name=" + name + "]";
	}
}

package it.groppedev.lesson2.exercise1.refactor;

public class Greeting
{
	private final int javaAge;
	private final String language;
	private final String person;

	public Greeting(int javaAge, String language, String person)
	{
		this.javaAge = javaAge;
		this.language = language;
		this.person = person;
	}

	public int getJavaAge()
	{
		return javaAge;
	}

	public String getLanguage()
	{
		return language;
	}

	public String getPerson()
	{
		return person;
	}
	
	public void print()
	{
		if(this.getLanguage().equals(Constants.ITALIAN_ALIAS))
		{
			printMessage(this.getJavaAge(), this.getPerson(), Constants.ITALIAN_TXT);
		}
		else
		{
			printMessage(this.getJavaAge(), this.getPerson(), Constants.ENGLISH_TXT);
		}
	}
	
	private static void printMessage(int javaAge, String person, String message)
	{
		System.out.println(String.format(message, person, javaAge));
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + javaAge;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Greeting other = (Greeting) obj;
		if (javaAge != other.javaAge)
			return false;
		if (language == null)
		{
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (person == null)
		{
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Greeting [javaAge=" + javaAge + ", language=" + language + ", person=" + person + "]";
	}

}
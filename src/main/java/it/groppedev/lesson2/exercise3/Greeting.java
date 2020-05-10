package it.groppedev.lesson2.exercise3;

public class Greeting
{
	private final int javaAge;
	private final Language language;
	private final String person;

	public Greeting(int javaAge, Language language, String person)
	{
		this.javaAge = javaAge;
		this.language = language;
		this.person = person;
	}

	public int getJavaAge()
	{
		return javaAge;
	}

	public Language getLanguage()
	{
		return language;
	}

	public String getPerson()
	{
		return person;
	}
	
	public String getPersonLowerCase()
	{
		return person.toLowerCase();
	}
	
	public String messageToPrint()
	{
		return String.format(this.getLanguage().getMessage(), this.getPerson(), this.getJavaAge());
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
		if (language != other.language)
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
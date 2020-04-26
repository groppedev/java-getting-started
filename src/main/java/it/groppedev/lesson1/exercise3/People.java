package it.groppedev.lesson1.exercise3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class People implements Iterable<Person>
{
	private List<Person> personList;
	
	public static People fromNames(String[] names)
	{
		People people = new People();
		for(String name : names)
		{
			people.addPerson(new Person(name));
		}
		return people;
	}
	
	private People()
	{
		this.personList = new ArrayList<Person>();
	}
	
	public void addPerson(Person person)
	{
		this.personList.add(person);
	}

	@Override
	public Iterator<Person> iterator()
	{
		return personList.iterator();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personList == null) ? 0 : personList.hashCode());
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
		People other = (People) obj;
		if (personList == null)
		{
			if (other.personList != null)
				return false;
		} else if (!personList.equals(other.personList))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "People [personList=" + personList + "]";
	}
}

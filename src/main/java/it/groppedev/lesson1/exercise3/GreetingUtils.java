package it.groppedev.lesson1.exercise3;

public class GreetingUtils
{
	public String composeGreeting(String greetingWord, Person person)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(greetingWord);
		sb.append(" ");
		sb.append(person.getName());
		sb.append("!");
		return sb.toString();
	}
}

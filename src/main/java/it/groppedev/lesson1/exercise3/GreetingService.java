package it.groppedev.lesson1.exercise3;

public class GreetingService
{
	private GreetingFactory factory;
	
	public GreetingService(GreetingFactory factory)
	{
		this.factory = factory;
	}
	
	public void printGreetings(Person person)
	{
		IGreeting greeting = this.factory.newGreeting();
		System.out.println(greeting.greetingText(person));
	}
}

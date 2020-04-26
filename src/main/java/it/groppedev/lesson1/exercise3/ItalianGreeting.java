package it.groppedev.lesson1.exercise3;

public class ItalianGreeting implements IGreeting
{
	private final static String GREETING_WORD = Language.ITALIAN.getGreetingWord();

	private final GreetingUtils utils;
	
	public ItalianGreeting(GreetingUtils utils)
	{
		this.utils = utils;
	}

	@Override
	public String greetingText(Person person)
	{
		System.out.println("Hit object -> " + this);
		return this.utils.composeGreeting(GREETING_WORD, person);
	}
}

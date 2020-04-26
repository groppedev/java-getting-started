package it.groppedev.lesson1.exercise3;

public class GreetingFactory
{
	private Language language;
	
	public GreetingFactory(Language language)
	{
		this.language = language;
	}
	
	public IGreeting newGreeting()
	{
		GreetingUtils greetingUtils = new GreetingUtils();
		IGreeting greetingImplToReturn = null;
		switch (this.language)
		{
		case ITALIAN:
			greetingImplToReturn = new ItalianGreeting(greetingUtils);
			break;
		case ENGLISH:
			greetingImplToReturn = new EnglishGreeting(greetingUtils);
			break;
		default:
			throw new IllegalArgumentException(String.format("Invalid language '%s'", this.language.name()));
		}
		return greetingImplToReturn;
	}
}

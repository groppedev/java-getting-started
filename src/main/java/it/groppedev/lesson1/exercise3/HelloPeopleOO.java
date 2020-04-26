package it.groppedev.lesson1.exercise3;

/**
 * @author groppedev
 */
public class HelloPeopleOO
{
	public static void main(String[] args)
	{
		// 1) Select the language from the java properties -Duser.language
		Language language = Language.fromString(System.getProperty("user.language"));
		// 2) Create People collection from people names provided with args String array
		People people = People.fromNames(args);
		// 3) New instance of the Greeting factory that require a language as dependency
		GreetingFactory factory = new GreetingFactory(language);
		// 4) New instance of the Greeting service that require a factory as dependency
		GreetingService service = new GreetingService(factory);
		// 5) Iteration over people collection, printing greeting for each person in that collection
		for(Person person : people)
		{
			service.printGreetings(person);
		}
	}
}

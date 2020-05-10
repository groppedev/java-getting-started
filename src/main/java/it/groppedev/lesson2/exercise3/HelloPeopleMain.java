package it.groppedev.lesson2.exercise3;

import it.groppedev.lesson2.exercise3.print.PrintService;

/**
 * @author groppedev
 */
public class HelloPeopleMain
{
	public static void main(String[] args)
	{
		int javaAge = calculateJavaAge();
		Language language = selectLanguage();

		// Massimo Marco Matteo
		for(String person : args)
		{
			System.out.println(String.format("Persona corrente '%s'", person));
			PrintService.print(new Greeting(javaAge, language, person));
		}
	}

	private static int calculateJavaAge()
	{
		int currentYear = java.time.Year.now().getValue();
		int javaAge = currentYear - Constants.JAVA_YEAR_OF_BIRTH;
		return javaAge;
	}

	private static Language selectLanguage()
	{
		// -Duser.language=it
		return Language.fromString(System.getProperty(Constants.USER_LANGUAGE_PROPERTY));
	}
}

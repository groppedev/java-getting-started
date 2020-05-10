package it.groppedev.lesson2.exercise2;

/**
 * @author groppedev
 */
public class HelloPeopleDebug
{
	public static void main(String[] args)
	{
		int javaAge = calculateJavaAge();
		String language = selectLanguage();

		// Massimo Marco Matteo
		for(String person : args)
		{
			System.out.println(String.format("Persona corrente '%s'", person));
			Greeting greeting = new Greeting(javaAge, language, person);
			greeting.print();
		}
	}

	private static int calculateJavaAge()
	{
		int currentYear = java.time.Year.now().getValue();
		int javaAge = currentYear - Constants.JAVA_YEAR_OF_BIRTH;
		return javaAge;
	}

	private static String selectLanguage()
	{
		// -Duser.language=it
		String language = System.getProperty(Constants.USER_LANGUAGE_PROPERTY);
		return language;
	}
}

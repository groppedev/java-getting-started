package it.groppedev.lesson1.exercise2;

/**
 * @author groppedev
 */
public class HelloPeople
{
	private static final String USER_LANGUAGE_PROPERTY = "user.language";
	private static final String ITALIAN_ALIAS = "it";
	
	private static final String ENGLISH_TXT = "Hello %s, I am JAVA and I am %d years old!";
	private static final String ITALIAN_TXT = "Ciao %s, sono JAVA ed ho %d anni!";
	
	private static final int JAVA_YEAR_OF_BIRTH = 1995;

	public static void main(String[] args)
	{
		int currentYear = java.time.Year.now().getValue();
		int javaAge = currentYear - JAVA_YEAR_OF_BIRTH;
		// -Duser.language=it
		String language = System.getProperty(USER_LANGUAGE_PROPERTY);

		// Massimo Marco Matteo
		for(String person : args)
		{
			if(language.equals(ITALIAN_ALIAS))
			{
				System.out.println(String.format(ITALIAN_TXT, person, javaAge));
			}
			else
			{
				System.out.println(String.format(ENGLISH_TXT, person, javaAge));
			}
		}
	}
}

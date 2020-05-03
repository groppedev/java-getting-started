package it.groppedev.lesson1.exercise1;

/**
 * @see https://dzone.com/articles/java-string-format-examples
 * @author groppedev
 */
public class HelloJava
{
	private static final int JAVA_YEAR_OF_BIRTH = 1995;
	
	public static void main(String[] args)
	{
		int currentYear = java.time.Year.now().getValue();
		int javaAge = currentYear - JAVA_YEAR_OF_BIRTH;
		
		System.out.println(String.format("Ciao, sono JAVA ed ho %d anni!", javaAge));
	}
}

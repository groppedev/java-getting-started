package it.groppedev.lesson1.exercise1;

/**
 * @author groppedev
 */
public class HelloJava
{
	private static final String MSG_TEXT = "Ciao, sono JAVA ed ho %d anni!";
	private static final int JAVA_YEAR_OF_BIRTH = 1995;
	
	public static void main(String[] args)
	{
		int currentYear = java.time.Year.now().getValue();
		int javaAge = currentYear - JAVA_YEAR_OF_BIRTH;
		
		String msg = String.format(MSG_TEXT, javaAge);
		System.out.println(msg);
	}
}

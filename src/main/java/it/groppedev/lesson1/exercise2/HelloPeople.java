package it.groppedev.lesson1.exercise2;

/**
 * @author groppedev
 */
public class HelloPeople
{
	public static void main(String[] args)
	{
		// Massimo Marco Matteo
		for(String person : args)
		{
			// -Duser.language=it
			String language = System.getProperty("user.language");
			if(language.equals("it"))
			{
				System.out.println("Ciao " + person + "!");
			}
			else
			{
				System.out.println("Hello " + person + "!");
			}
		}
	}
}

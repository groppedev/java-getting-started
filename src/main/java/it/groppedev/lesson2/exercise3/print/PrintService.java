package it.groppedev.lesson2.exercise3.print;

import it.groppedev.lesson2.exercise3.Greeting;

/**
 * -Dprint=synch|async|asynclambda
 */
public class PrintService
{
	private static final IPrintService printService;

	static
	{
		String printServiceType = System.getProperty("print", "sync");
		switch (printServiceType)
		{
		case "synch":
			printService = new PrintServiceSynch();
			break;
		case "async":
			printService = new PrintServiceAsync();
			break;
		case "asynclambda":
			printService =  new PrintServiceAsyncLambda();
			break;
		default:
			throw new IllegalArgumentException(String.format("Nessun servizio di stampa trovato per la tipo '%s'", printServiceType));
		}
	}

	public static void print(Greeting greeting)
	{
		printService.print(greeting);
	}
}

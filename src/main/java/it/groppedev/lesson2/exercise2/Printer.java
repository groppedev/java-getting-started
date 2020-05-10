package it.groppedev.lesson2.exercise2;

public class Printer
{
	/**
	 * Stampa il messaggio in input in modo sincrono.
	 * 
	 * @param messageToPrint Messaggio da stampare
	 * @param person Persona per la quale si vuole stampare il messaggio
	 */
	public static void printSynch(String messageToPrint, String person)
	{
		System.out.println(String.format("Thread '%s' nome '%s'", Thread.currentThread().getName(), person));
		System.out.println(messageToPrint);
	}
	
	/**
	 * Stampa il messaggio in input in modo asincrono creando un nuovo Thread.
	 * 
	 * @param messageToPrint Messaggio da stampare
	 * @param person Persona per la quale si vuole stampare il messaggio
	 */
	public static void printAsync(String messageToPrint, String person)
	{
		String threadName = "thread-print-" + person.toLowerCase();
		Thread printThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(String.format("Thread '%s' nome '%s'", Thread.currentThread().getName(), person));
				System.out.println(messageToPrint);
			}
		}, threadName);
		printThread.start();
	}
	
	/**
	 * Stampa il messaggio in input in modo asincrono creando un nuovo Thread ma sfruttando la sintassi delle Lambda Expression.
	 * 
	 * @param messageToPrint Messaggio da stampare
	 * @param person Persona per la quale si vuole stampare il messaggio
	 */
	public static void printAsyncLambda(String messageToPrint, String person)
	{
		String threadName = "thread-print-" + person.toLowerCase();
		Thread printThread = new Thread(() -> {
					System.out.println(String.format("Thread '%s' nome '%s'", Thread.currentThread().getName(), person));
					System.out.println(messageToPrint);
		}, threadName);
		printThread.start();
	}
}

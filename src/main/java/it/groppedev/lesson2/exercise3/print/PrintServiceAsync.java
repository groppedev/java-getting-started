package it.groppedev.lesson2.exercise3.print;

import it.groppedev.lesson2.exercise3.Greeting;

public class PrintServiceAsync implements IPrintService
{
	@Override
	public void print(Greeting greeting)
	{
		String threadName = "thread-print-" + greeting.getPersonLowerCase();
		Thread printThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(String.format("Thread '%s' nome '%s'", Thread.currentThread().getName(), greeting.getPerson()));
				System.out.println(greeting.messageToPrint());
			}
		}, threadName);
		printThread.start();
	}
}

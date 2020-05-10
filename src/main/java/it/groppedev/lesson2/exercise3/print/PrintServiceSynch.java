package it.groppedev.lesson2.exercise3.print;

import it.groppedev.lesson2.exercise3.Greeting;

public class PrintServiceSynch implements IPrintService
{
	@Override
	public void print(Greeting greeting)
	{
		System.out.println(String.format("Thread '%s' nome '%s'", Thread.currentThread().getName(), greeting.getPerson()));
		System.out.println(greeting.messageToPrint());
	}
}

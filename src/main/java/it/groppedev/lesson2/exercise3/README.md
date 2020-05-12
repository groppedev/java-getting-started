# Lezione 2 - Esercizio 3

> Nell'[esercizio precedente](../exercise2/), sono state introdotte, 3 differenti modalità per stampare il messaggio di saluto nella console. 
> In questo esercizio è richiesto di implementare il requisito di poter cambiare modalità di stampa del messaggio senza dovre cambiare il codice sorgente sfruttando la programmazione ad oggetti e polimorfismo.

Per comodità è stato introdotto l'enumerato `Language`. In questo `Enum` è stato gestito anche il testo del saluto che non è più rappresentato con una costante per ogni linguaggio disponibile.

```java
public enum Language
{
	ITALIAN("it", "Ciao %s, sono JAVA ed ho %d anni!"),
	ENGLISH("en", "Hello %s, I am JAVA and I am %d years old!");
	
	private final String message;
	private final String alias;

	private Language(String alias, String message)
	{
		this.message = message;
		this.alias = alias;
	}

	public String getMessage()
	{
		return message;
	}
	
	public static Language fromString(String languageAlias)
	{
		for(Language lang : Language.values())
		{
			if(lang.alias.equals(languageAlias))
			{
				return lang;
			}
		}
		String errorMsg = String.format("Nessun linguaggio trovato per l'alias '%s'", languageAlias);
		throw new IllegalArgumentException(errorMsg);
	}
}
```

### Differenti metodi di stampa

Metodo | Descrizione
------------ | -------------
`Printer#printSynch(String messageToPrint, String person)` | Stampa sincrona nel _Thread Main_
`Printer#printAsync(String messageToPrint, String person)` | Stampa asincrona con creazione di un nuovo _Thread_ per ogni invocazione
`Printer#printAsyncLambda(String messageToPrint, String person)` | Stampa asincrona con creazione di un nuovo _Thread_ per ogni invocazione utilizzando la sintassi delle _Lambda Expressions_

### Passaggi da eseguire:
1. Introdurre l'interfaccia `IPrintService` e creare il metodo astratto `print`. Prevedere per l'interfaccia un unico parametro di tipo `Greeting`
2. Creare una classe concreta di implementazione per ogni tipologia di serivizio di stampa. Creare quindi le classi `PrintServiceSynch`, `PrintServiceAsync` e `PrintServiceAsyncLambda`. Ogni classe deve implementare l'interfaccia `IPrintService`.
3. Tramite appositi strumenti di _refactor_ spostare il codice del vecchio servizio di stampa (`Printer`) nelle apposite nuove classi appena create.
4. Creare un servizio chiamato `PrintService` che esponga un unico metodo `PrintService.print(Greeting greeting)`
5. Nel servizio `PrintService` aggiungere la logica di selezione dell'implementazione corretta per il servizio di stampa basandosi sulla proprietà in input `print` (`System.getProperty("print", "sync")`). In questo caso il servizio di stampa svolge anche il compito di _Factory_ per la creazione degli oggetti di tipo `IPrintService`
6. Se viene passato in input un tipo di servizio non valido, deve essere sollevata una specifica eccezione di tipo `IllegalArgumentException` che indichi all'utilizzatore quale sia stata la causa dell'errore.


# Proposta di soluzione

1. Interfaccia `IPrintService`

```java
public interface IPrintService
{
	void print(Greeting greeting);
}
```

2.  Creazione classi concrete `PrintServiceSynch`, `PrintServiceAsync` e `PrintServiceAsyncLambda`
3.  Spostamento codice dalla classe `Printer` alle nuove implementazioni

```java
public class PrintServiceSynch implements IPrintService
{
	@Override
	public void print(Greeting greeting)
	{
		System.out.println(String.format("Thread '%s' nome '%s'", 
				Thread.currentThread().getName(), greeting.getPerson()));
		System.out.println(greeting.messageToPrint());
	}
}
```
```java
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
				System.out.println(String.format("Thread '%s' nome '%s'", 
						Thread.currentThread().getName(), greeting.getPerson()));
				System.out.println(greeting.messageToPrint());
			}
		}, threadName);
		printThread.start();
	}
}
```
```java
public class PrintServiceAsyncLambda implements IPrintService
{
	@Override
	public void print(Greeting greeting)
	{
		String threadName = "thread-print-" + greeting.getPersonLowerCase();
		Thread printThread = new Thread(() ->  {
			System.out.println(String.format("Thread '%s' nome '%s'", 
					Thread.currentThread().getName(), greeting.getPerson()));
			System.out.println(greeting.messageToPrint());
		}, threadName);
		printThread.start();
	}
}

```

3. Codice dopo il refactor della classe `Constants`

```java
public class Constants
{
	static final String USER_LANGUAGE_PROPERTY = "user.language";
	static final String ITALIAN_ALIAS = "it";
	static final String ENGLISH_TXT = "Hello %s, I am JAVA and I am %d years old!";
	static final String ITALIAN_TXT = "Ciao %s, sono JAVA ed ho %d anni!";
	static final int JAVA_YEAR_OF_BIRTH = 1995;
}
```

4. Codice dopo il refactor della classe `Greeting`

```java
public class Greeting
{
	private final int javaAge;
	private final String language;
	private final String person;

	public Greeting(int javaAge, String language, String person)
	{
		this.javaAge = javaAge;
		this.language = language;
		this.person = person;
	}

	public int getJavaAge()
	{
		return javaAge;
	}

	public String getLanguage()
	{
		return language;
	}

	public String getPerson()
	{
		return person;
	}
	
	public void print()
	{
		if(this.getLanguage().equals(Constants.ITALIAN_ALIAS))
		{
			printMessage(this.getJavaAge(), this.getPerson(), Constants.ITALIAN_TXT);
		}
		else
		{
			printMessage(this.getJavaAge(), this.getPerson(), Constants.ENGLISH_TXT);
		}
	}
	
	private static void printMessage(int javaAge, String person, String message)
	{
		System.out.println(String.format(message, person, javaAge));
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + javaAge;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		if (javaAge != other.javaAge)
			return false;
		if (language == null)
		{
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (person == null)
		{
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Greeting [javaAge=" + javaAge + ", language=" + language + ", person=" + person + "]";
	}
}
```

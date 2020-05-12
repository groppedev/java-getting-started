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
		String errorMsg = String.format("Nessun linguaggio trovato per l'alias '%s'", 
										languageAlias);
		throw new IllegalArgumentException(errorMsg);
	}
}
```

********** Il testo del saluto da un costante diventa una proprietà dell'enumerato.
********** Creare un servizio di stampa con differenti opzioni


### Passaggi da eseguire:
1. Rinominare la classe `HelloPeople` in `HelloPeopleDebug`
2. Creare una classe `Constants` e spostare tutte le constanti in questa nuova classe
3. Creare un apposito metodo `HelloPeopleDebug#selectLanguage` con il compito di selezionare la lingua da utilizzare (Attualmente viene letta la proprietÃ  di sistema `System.getProperty`)
4. Creare un apposito metodo `HelloPeopleDebug#printGreetingByLanguage` che esegue il compito di stampare nella console il saluto per ogni persona in input
5. Creare un apposito metodo `HelloPeopleDebug#calculateJavaAge` che calcola gli anni di Java
6. Rimuovere la duplicazione nel metodo `HelloPeopleDebug#printGreetingByLanguage` creando un apposito metodo che esegue solo la stampa in console accettando come parametro il saluto a seconda del linguaggio
7. Introdurre un apposito oggetto `Greeting` da passare come unico parametro al metodo `HelloPeopleDebug#printGreetingByLanguage`
8. Incapsulare le variabili di istanza dell'oggetto `Greeting` creando appositi metodi `getter`
9. Rendere tutte le variabili di istanza dell'oggetto `Greeting` immutabili utilizzando la keyword `final` una volta eseguita questa operazione cancellare tutti i metodi `setter`
10. Generare automaticamente i metodi `Greeting#equals` e `Greeting#hashCode`
11. Generare automaticamente il metodo `Greeting#toString`
12. Creare un apposito metodo `Greeting#print` e spostare in questo metodo tutta la logica di stampa del messaggio

# Proposta di soluzione

1. Codice originale di partenza

```java
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
```

2. Codice dopo il refactor della main class `HelloPeopleDebug`

```java
public class HelloPeopleDebug
{
	public static void main(String[] args)
	{
		int javaAge = calculateJavaAge();
		String language = selectLanguage();

		// Massimo Marco Matteo
		for(String person : args)
		{
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

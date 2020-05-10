# Lezione 2 - Esercizio 1

> Partendo dall'esercizio 2 della lezione 1, utilizzare Eclipse per svolgere alcune operazioni di refactor del codice e successivamente prendere confidenza con gli strumenti di DEBUG.

### Passaggi da eseguire:
1. Rinominare la classe `HelloPeople` in `HelloPeopleDebug`
2. Creare una classe `Constants` e spostare tutte le constanti in questa nuova classe
3. Creare un apposito metodo `HelloPeopleDebug#selectLanguage` con il compito di selezionare la lingua da utilizzare (Attualmente viene letta la proprietà di sistema `System.getProperty`)
4. Creare un apposito metodo `HelloPeopleDebug#printGreetingByLanguage` che esegue il compito di stampare nella console il saltuto per ogni persona in input
5. Creare un apposito metodo `HelloPeopleDebug#calculateJavaAge` che calcola gli anni di Java
6. Rimuovere la duplicazione nel metodo `HelloPeopleDebug#printGreetingByLanguage` creando un apposito metodo che esegue solo la stampa in console accettando come parametro il saluto a seconda del linguaggio
7. Introdurre un apposito oggetto `Greeting` da passare come unico parametro al metodo `HelloPeopleDebug#printGreetingByLanguage`
8. Incapsulare le variabili di istanza dell'oggetto `Greeting` creando appositi metodi `getter`
9. Rendere tutte le variabili di istanza dell'oggetto `Greeting` immutabili utilizzando la keyword `final` una volta eseguita questa operazione cancellare tutti i metodi `setter`
10. Generare automaticamente i metodi `Greeting#equals` e `Greeting#hashCode`
11. Generare automaticamente il metodo `Greeting#toString`
12. Creare un apposito metodo `Greeting#print` e spostare in questo metodo tutta la logica di stampa del messaggio


# Proposta di soluzione

1. Eseguire i passaggi da 1 a 5, già indicati per l'[Esercizio 1](../exercise1) <br/><br/>
2. Creare un nuovo file chiamato `HelloPeople.java` utilizzando il comando `vi HelloPeople.java` <br/><br/>
3. Scrivere nel file il seguente codice sorgente Java, entrando in modalità `INSERT` premendo il tasto `i`, una volta terminata la scrittura del codice sorgente, digitare il comando `ESC + :x` per salvare il file. Per uscire senza salvare digitare invece il comando `ESC + :q!` <br/>
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
		String language = System.getProperty(USER_LANGUAGE_PROPERTY);

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
4. Compilare il codice sorgente Java utilizzando gli strumenti messi a disposizione dalla JDK, eseguire quindi il comando `javac HelloPeople.java` per ottenere il file `HelloPeople.class` composto da `bytecode` <br/><br/>
5. Eseguire il programma `HelloPeople` digitando il comando `java -Duser.language=it HelloPeople Marco Massimo Matteo` ottenendo il seguente risultato a video <br/>
```console
Ciao Marco, sono JAVA ed ho 25 anni!
Ciao Massimo, sono JAVA ed ho 25 anni!
Ciao Matteo, sono JAVA ed ho 25 anni!
```
6. Eseguire nuovamente il programma `HelloPeople`, ma impostando una lingua differente da IT (ES: EN). Digitare il comando `java -Duser.language=en HelloPeople Marco Massimo Matteo` per ottenere il seguente risultato a video <br/>
```console
Hello Marco, I am JAVA and I am 25 years old!
Hello Massimo, I am JAVA and I am 25 years old!
Hello Matteo, I am JAVA and I am 25 years old!
```
6. Eseguire un'ultima volta il programma `HelloPeople`, aggiungendo però ulteriori persone da salutare (Luca Giovanni). Digitare il comando `java -Duser.language=it HelloPeople Marco Massimo Matteo Luca Giovanni` per ottenere il seguente risultato a video <br/>
```console
Ciao Marco, sono JAVA ed ho 25 anni!
Ciao Massimo, sono JAVA ed ho 25 anni!
Ciao Matteo, sono JAVA ed ho 25 anni!
Ciao Luca, sono JAVA ed ho 25 anni!
Ciao Giovanni, sono JAVA ed ho 25 anni!
```

### Approfondimento

Comando da analizzare: `java -Duser.language=it HelloPeople Marco Massimo Matteo`

Porzione Comando | Descrizione
------------ | -------------
`java` | Comando per eseguire una applicazione Java
`-Duser.language=it` | Valorizzazione della proprietà di sistema `user.language` con il valore `it` 
`HelloPeople` | Nome della `Main Class` da eseguire
`Marco` `Massimo` `Matteo` | Elenco argomenti forniti per il parametro `String[] args` del metodo `HelloPeople#main(String[] args)`
  
***
[![Home][img_home]][href_home]
[![Lesson1][img_lesson]][href_lesson]

<!-- Definizione dei link per la navigazione -->
[img_home]: <../../../../../resources/images/navigation/home.png>
[href_home]: <https://groppedev.github.io/java-getting-started/>
[img_lesson]: <../../../../../resources/images/navigation/books.png>
[href_lesson]: <../>
[magnifying_glass_24]: <../../../../../resources/images/navigation/magnifier.png>

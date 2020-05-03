# Lezione 1 - Esercizio 2

> Partendo dall'esercizio 1, per ogni nome di persona fornito in input, produrre un saluto da stampare in console nella lingua speficata dalle proprietà di sistema

### Passaggi da eseguire:
1. Scrivere il codice sorgente del programma con un editor di testo e salvare il file **.java**
2. Utilizzare una JDK per compilare il programma Java tramite il comando `javac` per ottenere il file **.class**
3. Utilizzare una JRE per eseguire il programma Java compilato (il file **.class**) tramite il comando `java` per ottenere l'output del programma in console. Devono essere forniti dei parametri di input ed una proprietà di sistema che indichi il linguaggio da utilizzare.

# Proposta di soluzione

1. Eseguire gli stessi passaggi dell'esercizio 1, dal punto 1 al punto 5 </br>
2. Creare un nuovo file chiamato `HelloPeople.java` utilizzando il comando `vi HelloPeople.java` </br>
3. Scrivere nel file il seguente codice sorgente Java, entrando in modalità `INSERT` premendo il tasto `i`, una volta terminata la scrittura del codice sorgente, digitare il comando `ESC + :x` per salvare il file. Per uscire senza salvare digitare invece il comando `ESC + :q!` </br>
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
4. Compilare il codice sorgente Java utilizzando gli strumenti messi a disposizione dalla JDK, eseguire quindi il comando `javac HelloPeople.java` per ottenere il file `HelloPeople.class` composto da `bytecode` <br/>
5. Eseguire il programma `HelloPeople` digitando il comando `java -Duser.language=it HelloPeople Marco Massimo Matteo` ottenendo il seguente risultato a video </br>
```console
Ciao Marco, sono JAVA ed ho 25 anni!
Ciao Massimo, sono JAVA ed ho 25 anni!
Ciao Matteo, sono JAVA ed ho 25 anni!
```
6. Eseguire nuovamente il programma `HelloPeople`, ma impostando una lingua differente da IT (ES: EN). Digitare il comando `java -Duser.language=en HelloPeople Marco Massimo Matteo` per ottenere il seguente risultato a video </br>
```console
Hello Marco, I am JAVA and I am 25 years old!
Hello Massimo, I am JAVA and I am 25 years old!
Hello Matteo, I am JAVA and I am 25 years old!
```
6. Eseguire un'ultima volta il programma `HelloPeople`, aggiungendo però ulteriori persone da salutare (Luca Giovanni). Digitare il comando `java -Duser.language=it HelloPeople Marco Massimo Matteo Luca Giovanni` per ottenere il seguente risultato a video </br>
```console
Ciao Marco, sono JAVA ed ho 25 anni!
Ciao Massimo, sono JAVA ed ho 25 anni!
Ciao Matteo, sono JAVA ed ho 25 anni!
Ciao Luca, sono JAVA ed ho 25 anni!
Ciao Giovanni, sono JAVA ed ho 25 anni!
```
***
[![Home][img_home]][href_home]
[![Lesson1][img_lesson]][href_lesson]

<!-- Definizione dei link per la navigazione -->
[img_home]: <http://files.softicons.com/download/toolbar-icons/soft-icons-by-lokas-software/png/48x48/0007-home.png>
[href_home]: <https://groppedev.github.io/java-getting-started/>
[img_lesson]: <http://files.softicons.com/download/toolbar-icons/ravenna-3d-icons-by-double-j-design/png/48x48/Books.png>
[href_lesson]: <../>

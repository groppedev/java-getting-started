# Lezione 2 - Esercizio 1

> Partendo dall'esercizio 2 della lezione 1, utilizzare Eclipse per svolgere alcune operazioni di refactor del codice e successivamente prendere confidenza con gli strumenti di DEBUG.

### Passaggi da eseguire:
1. Rinominare la classe `HelloPeople` in `HelloPeopleDebug`
2. Creare una classe `Constants` e spostare tutte le constanti in questa nuova classe
3. Creare un apposito metodo `HelloPeopleDebug#selectLanguage` con il compito di selezionare la lingua da utilizzare (Attualmente viene letta la proprietà di sistema `System.getProperty`)
4. Creare un apposito metodo `HelloPeopleDebug#printGreetingByLanguage` che esegue il compito di stampare nella console il saluto per ogni persona in input
5. Creare un apposito metodo `HelloPeopleDebug#calculateJavaAge` che calcola gli anni di Java
6. Rimuovere la duplicazione nel metodo `HelloPeopleDebug#printGreetingByLanguage` creando un apposito metodo che esegue solo la stampa in console accettando come parametro il saluto a seconda del linguaggio
7. Introdurre un apposito oggetto `Greeting` da passare come unico parametro al metodo `HelloPeopleDebug#printGreetingByLanguage`
8. Incapsulare le variabili di istanza dell'oggetto `Greeting` creando appositi metodi `getter`
9. Rendere tutte le variabili di istanza dell'oggetto `Greeting` immutabili utilizzando la keyword `final` una volta eseguita questa operazione cancellare tutti i metodi `setter`
10. Generare automaticamente i metodi `Greeting#equals` e `Greeting#hashCode`
11. Generare automaticamente il metodo `Greeting#toString`
12. Creare un apposito metodo `Greeting#print` e spostare in questo metodo tutta la logica di stampa del messaggio
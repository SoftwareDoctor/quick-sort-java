# QuickSort for Trekking

Questo progetto è un'applicazione Java basata su Spring Boot che fornisce servizi per gestire escursioni di trekking. Utilizza un algoritmo di ordinamento QuickSort per ordinare le escursioni in base al livello di difficoltà (in questo caso i km).

## Tecnologie utilizzate
- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- H2 Database
- Maven 3.9.5
- MapStruct 1.5

## Avvio del Progetto
Per avviare il progetto, segui questi passaggi:

### Prerequisiti
Assicurati di avere Java 17 installato sul tuo sistema.

### Clonare il Repository
Clona il repository del progetto sul tuo computer utilizzando Git. Puoi farlo eseguendo il seguente comando da riga di comando:
```
git clone <url_del_repository>
```

### Aprire il Progetto
Apri il progetto clonato in un IDE compatibile con Maven, ad esempio IntelliJ IDEA, Eclipse o Visual Studio Code. Puoi importare il progetto come progetto Maven.

### Configurare il Database H2
Modifica le proprietà del database H2 nel file `application.properties`, che si trova nella directory `src/main/resources`. Assicurati di configurare correttamente l'URL del database, il nome utente e la password in base alle tue esigenze.

### Eseguire il Progetto
Esegui il progetto come un'applicazione Spring Boot. Puoi farlo facendo clic sul pulsante "Run" nell'IDE oppure eseguendo il seguente comando da riga di comando:
```
mvn spring-boot:run
```

### Interrogazione del Database tramite Interfaccia Console
Il progetto utilizza un database H2 in memory per memorizzare le escursioni trekking. È possibile interrogare il database utilizzando la console di H2, abilitata durante l'esecuzione dell'applicazione.

#### Accesso alla console di H2
Avvia l'applicazione Spring Boot, apri un browser web e vai all'indirizzo `http://localhost:8080/h2-console`. Nella schermata di login della console di H2, immetti le seguenti informazioni (oppure inserisci quelle che hai modificato nel file `application.properties`):
- JDBC URL: `jdbc:h2:mem:TrekkingQuickSort`
- Username: `escursionista`
- Password: `quickSort`

Fai clic sul pulsante "Connetti" per accedere al database.

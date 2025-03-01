# Sistema di Prenotazione Viaggi Web

Questo progetto implementa un sistema di prenotazione viaggi, sviluppato utilizzando Servlet Java, JSP, HTML/CSS e un database relazionale. L'applicazione consente di aggiungere una prenotazione tramite form e 
visualizzarne poi una tabella completa con poissibilità di rimozione

## Caratteristiche Principali

* **Prenotazione Viaggi:** Gli utenti possono prenotare inserendo i criteri di prenotazione.
* **Visualizzazione Dettagli:** Per ogni viaggio, vengono visualizzati dettagli dettatti dal form di prenotazione.
* **Gestione Prenotazioni:** Gli utenti registrati possono visualizzare o cancellando i viaggi.

## Tecnologie Utilizzate

* **Backend:** Java Servlet, JSP
* **Frontend:** HTML, CSS, JavaScript (opzionale)
* **Database:** MySQL
* **Server Applicativo:** Apache Tomcat 10.0.1

## Installazione

1.  Clona la repository sul tuo computer
2.  Importa il progetto nel tuo IDE (es. Eclipse, IntelliJ IDEA).
3.  Configura la connessione al database nel file `web.xml` o in un file di configurazione separato.
4.  Distribuisci l'applicazione sul tuo server applicativo (es. Tomcat).
5.  Accedi all'applicazione tramite il tuo browser all'indirizzo `http://localhost:8080/[nome dell'applicazione]`.

## Configurazione del Database

* Crea un database con il nome `viaggi`.
* Crea le tabelle necessarie utilizzando lo script SQL fornito nel file `database.sql` (se presente).
* Modifica il file `web.xml` o il file di configurazione del database per inserire le credenziali di accesso al database.

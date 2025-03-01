package connettore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Questa classe ha il compito di comunicare con un DBMS
public class GestoreConnessione {
//	localhost:8889=SOCKET
//  localhost e' la combo: router+numero pc
//	localhost mio pc:
//	ip
//  identificativo macchina
	
	//DRIVER:libreria che deve saper parlare il dialetto del DBMS scelto
	private final String DRIVER="com.mysql.cj.jdbc.Driver";
	//Credenziali per la connessione
	private final String URLDB="jdbc:mysql://localhost:8889/AgenziaViaggi";
	private final String USERDBMS="root";
	private final String PASSWORDDBMS="root";//root per MAMP;String vuota per XAMP
	//L'oggetto Connection oltre a rappresentare la connesione effettiva a DBMS,
	//mi serve per inizializzare il preparatore di comandi SQL:il PreparedStatement.
	//Il PeparedStatement e' l'oggetto con cui scriveremo ed eseguiremo i comandi SQL in java
	private Connection conn;//polimorfismo per interfaccia
	
	public 	Connection apriConnessione() {
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URLDB,USERDBMS,PASSWORDDBMS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//PATTERN SINGLETON
	//Impone che una classe venga istanziata una sola volta
	//per evitare di occupare invano la heap memory(la memoria dedicata ua sola volta
	// oggetti/istanze)
	//Una classe e' modellata come Singleton se prevede:
	//1)Il costruttore privato
	//2)L'attributo statico instance
	//3)Il getter statico getInstance()
//----------------------------------------------------------
	//Variabile di classe=Variabile statica
	//Variabile svincolata dagli oggeti; e' richiamabile solo usando come
	//prefisso il nome della classe
	//es.:GestoreConnessione.instance=null;
	private static GestoreConnessione instance;
	
	//Static mi dice che il metodo puo' essere chiamato
	//usando il nome della classe come prefisso
	//es.:GestoreConnesione.getIstance();
	//un metodo statico puo' vedere solo attributi statici
	//in quanto quelli non statici interessano agli oggetti
	public static GestoreConnessione getInstance() {
		if(instance==null) {
			instance=new GestoreConnessione();
		}
		return instance;
	}
	
	private GestoreConnessione() {}
	//////////////////////////////
}

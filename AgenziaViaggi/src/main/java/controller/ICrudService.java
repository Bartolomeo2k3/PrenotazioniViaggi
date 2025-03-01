package controller;
import java.util.List;
import model.*;

public interface ICrudService {

	public boolean prenota(PrenotazioneAereo prenotazione);
	public List<PrenotazioneAereo>leggi();
	public boolean annulla(int id);

}

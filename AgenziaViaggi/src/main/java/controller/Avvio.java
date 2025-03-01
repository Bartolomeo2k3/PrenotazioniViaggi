package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PrenotazioneAereo;
import model.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet("/Avvio")
public class Avvio extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudService crud = new CrudService();
		if(request.getParameter("scelta")!=null) {
			int id;

			int scelta=Integer.parseInt(request.getParameter("scelta"));
			switch(scelta) {
			case 1:
				List<PrenotazioneAereo> prenotazioni=crud.leggi();
				request.setAttribute("prenotazioni", prenotazioni);
				request.getRequestDispatcher("tabella.jsp").forward(request, response);
				break;
			case 2:
				id=Integer.parseInt(request.getParameter("id"));
				crud.annulla(id);
				response.sendRedirect("Avvio?scelta=1");
				break;
			}	
		}else {
			response.sendRedirect("home.html");
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Il metodo getParameter vuile come stringa il valore
		//proprietà name nell'input
		//int scelta=Integer.parseInt(request.getParameter("scelta"));
		//int id=Integer.parseInt(request.getParameter("id"));
		String nomeCliente=request.getParameter("nome_cliente");
		String cognomeCliente=request.getParameter("cognome_cliente");
		Date dataPartenza=Date.valueOf(request.getParameter("data_partenza"));
		Date dataArrivo=Date.valueOf(request.getParameter("data_arrivo"));
		String CfCliente=request.getParameter("codice_fiscale");
		String Da=request.getParameter("da");
		String A=request.getParameter("a");
		String CompagniaAerea=request.getParameter("compagnia_aerea");
		double ImportoPagato=Integer.parseInt(request.getParameter("importo_pagato"));
		int nAdulti=Integer.parseInt(request.getParameter("n_adulti"));
		int nBambini=Integer.parseInt(request.getParameter("n_bambini"));
		boolean bagagli=Boolean.parseBoolean(request.getParameter("bagaglio"));
		
		PrenotazioneAereo prenotazione = new PrenotazioneAereo();
		CrudService crud = new CrudService();

		prenotazione.setNomeCliente(nomeCliente);
		prenotazione.setCognomeCliente(cognomeCliente);
		prenotazione.setCfCliente(CfCliente);
		prenotazione.setCompagniaAerea(CompagniaAerea);
		prenotazione.setDataArrivo(dataArrivo);
		prenotazione.setDataPartenza(dataPartenza);
		prenotazione.setDa(Da);
		prenotazione.setA(A);
		prenotazione.setImportoPagato(ImportoPagato);
		prenotazione.setBagagli(bagagli);
		prenotazione.setnAdulti(nAdulti);
		prenotazione.setnBambini(nBambini);
		
		//switch(scelta){
		//case 4:
			crud.prenota(prenotazione);
			response.sendRedirect("form.html");
			//break;
		//}
	}
}
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connettore.GestoreConnessione;
import model.*;

public class CrudService implements ICrudService {

	@Override
	public boolean prenota(PrenotazioneAereo prenotazione) {
		Connection conn=GestoreConnessione.getInstance().apriConnessione();
		String sql="insert into prenotazione_aereo(nome_cliente,cognome_cliente,codice_fiscale,compagnia_aerea,n_adulti,n_bambini,data_partenza,data_arrivo,da,a,importo_pagato,bagaglio) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		//il PS è l'oggetto che compila ed esegue il comando SQL mandato al DBMS scelto(mysql)
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, prenotazione.getNomeCliente());//Sostituisco il primo ? col nome effettivo e così via
			ps.setString(2, prenotazione.getCognomeCliente());
			ps.setString(3, prenotazione.getCfCliente());
			ps.setString(4, prenotazione.getCompagniaAerea());
			ps.setInt(5, prenotazione.getnAdulti());
			ps.setInt(6, prenotazione.getnBambini());
			ps.setDate(7, prenotazione.getDataPartenza());
			ps.setDate(8, prenotazione.getDataArrivo());
			ps.setString(9, prenotazione.getDa());
			ps.setString(10, prenotazione.getA());
			ps.setDouble(11, prenotazione.getImportoPagato());
			ps.setBoolean(12, prenotazione.isBagagli());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		return false;
		
	}

	@Override
	public List<PrenotazioneAereo> leggi() {
		List<PrenotazioneAereo> prenotazioni=new ArrayList<>();
		PrenotazioneAereo prenotazione=null;
		Connection conn=GestoreConnessione.getInstance().apriConnessione();
		String sql="select * from prenotazione_aereo";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				prenotazione=new PrenotazioneAereo();
				prenotazione.setId(rs.getInt("id"));
				prenotazione.setNomeCliente(rs.getString("nome_cliente"));
				prenotazione.setCognomeCliente(rs.getString("cognome_cliente"));
				prenotazione.setCfCliente(rs.getString("codice_fiscale"));
				prenotazione.setCompagniaAerea(rs.getString("compagnia_aerea"));
				prenotazione.setnAdulti(rs.getInt("n_adulti"));
				prenotazione.setnBambini(rs.getInt("n_bambini"));
				prenotazione.setDataPartenza(rs.getDate("data_partenza"));
				prenotazione.setDataArrivo(rs.getDate("data_arrivo"));
				prenotazione.setDa(rs.getString("da"));
				prenotazione.setA(rs.getString("a"));
				prenotazione.setImportoPagato(rs.getDouble("importo_pagato"));
				prenotazione.setBagagli(rs.getBoolean("bagaglio"));
				prenotazioni.add(prenotazione);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		return prenotazioni;
		
	}

	@Override
	public boolean annulla(int id) {
			GestoreConnessione gc = GestoreConnessione.getInstance();
			Connection conn = gc.apriConnessione();
			String sql = "delete from prenotazione_aereo where id=?";
			PreparedStatement ps = null;

			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				return true;
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
	
	}


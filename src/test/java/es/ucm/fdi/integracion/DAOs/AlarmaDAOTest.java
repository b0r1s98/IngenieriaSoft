package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaDAOTest {
	
	
	public void setup(AlarmaDAOImp alarmaDAO){
		
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, true, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, true, "song2.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al5", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al6", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al7", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al8", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al9", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al10", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al11", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al13", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al14", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al15", 12, 23, false, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al16", 12, 23, false, "mytone1.mp3"));	
	}
	
	@Test
	public void getActiveTest(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		setup(alarmaDAO);
		ArrayList<AlarmaPOJO> activas = alarmaDAO.getActive();
		System.out.println(activas);
		ArrayList<AlarmaPOJO> esperadas = new ArrayList<>();
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al1"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al2"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al3"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al4"));
		for(AlarmaPOJO a: activas){
			assertTrue(esperadas.contains(a));
		}
	}
}
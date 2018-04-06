package es.ucm.fdi;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.AlarmaSA;
import es.ucm.fdi.negocio.AlarmaSAImp;
import es.ucm.fdi.negocio.PreguntaSA;
import es.ucm.fdi.negocio.PreguntaSAImp;
import es.ucm.fdi.negocio.TestperclanSA;
import es.ucm.fdi.negocio.TestperclanSAImp;

public class FullTest {

	private UsuarioDAOImp usuarioDAO;
	private AlarmaDAOImp alarmaDAO;
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO;
	private PreguntaDAOImp preguntaDAO;
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO;
	private UsuarioClanDAOImp usuarioClanDAO;
	private ClanDAOImp clanDAO;
	
	public FullTest(){
		usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(new BDHashMap<AlarmaUsuarioPOJO>());
		preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		preguntaUsuarioDAO= new PreguntaUsuarioDAOImp(new BDHashMap<PreguntaUsuarioPOJO>());
		usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		clanDAO = new ClanDAOImp (new BDHashMap<ClanPOJO>());
		
		
		setup();
	}

	private void setup(){

		//Creacion de usuarios
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001, "hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147, "hello321", "England"));
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099, "yoselchinito", "China"));
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez", 1365, "holamamasita", "Colombia"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244, "soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111, "soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("sergil", "Sergio Gil", 823, "soysergi", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("daniv", "Dani Valverde", 730, "soydani", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545, "soypablo", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc", "Spain"));
		
		
		//Creacion de alarmas
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, true, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		for(int i = 5; i<17;i++){
			alarmaDAO.save(new AlarmaPOJO("al"+i, 12, 23, true, "mytone1.mp3"));
		}
		
		//Asignacion de usuarios y alarmas
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al1", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al2", "peter_hy"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al3", "xu_xu"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al4", "Wiledk7"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al5", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al6", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al7", "sergil"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al8", "daniv"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al9", "pablitos"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al10", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al11", "jaime123"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al12", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al13", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al14", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al15", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al16", "franqui"));
		
		//Creacion de clanes
		TestperclanSAImp testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,usuarioDAO);
		testperclanSA.crearClan("javigm", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("franqui", "Los Matinfos");
		
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("a2", "cual es la capital de francia?", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("a3", "cual es la capital de italia?", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("a4", "cual es la capital de reino unido?", respuestas1, 4));
		
		ArrayList<String> respuestas2=new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("a7", "cual es la capital de checoslovaquia?", respuestas2, 3));
		preguntaDAO.save(new PreguntaPOJO("a8", "cual es la capital de alemania?", respuestas2, 4));
		
		ArrayList<String> respuestas3=new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a9", "cual es la capital de egipto?", respuestas3, 1));
		preguntaDAO.save(new PreguntaPOJO("a10", "cual es la capital de dinamarca?", respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("a11", "cual es la capital de suecia?", respuestas3, 3));
		preguntaDAO.save(new PreguntaPOJO("a12", "cual es la capital de finlandia?", respuestas3, 4));	
		
		for(int i = 1; i<13; i++){
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a"+i,"peter_hy"));
		}
		
	}
	
	@Test
	public void Testpertar(){
		UsuarioPOJO user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		AlarmaPOJO a = (AlarmaPOJO) alarmaDAO.getFromId("al2");
		Assert.assertTrue("La alarma al2 debería existir", a!=null);
		Assert.assertTrue("La alarma al2 debería estar activa", a.isActive());
		AlarmaSA alarmaSA = new AlarmaSAImp(alarmaDAO);
		alarmaSA.reproducirAlarma(a);
		//Suena
		PreguntaPOJO pregunta = (PreguntaPOJO) preguntaDAO.getFromId(preguntaUsuarioDAO.getPreguntas("peter_hy").get(0));
		Assert.assertTrue("La pregunta debería existir", pregunta!=null);
		//Mostrar pregunta
		PreguntaSA preguntaSA = new PreguntaSAImp(preguntaDAO);
		assertTrue("Debería ser correcta",preguntaSA.comprobarRespuesta("a2",2));
		alarmaSA.desconectarAlarma(a);
		
		TestperclanSA testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO);
		testperclanSA.getRanking(user.getIdClan());
		//Mostrar ranking
	}
	@Test
	public void TestGanador(){
		TestperclanSAImp tesperclan=new TestperclanSAImp(clanDAO,usuarioClanDAO,usuarioDAO);
		ArrayList<UsuarioPOJO> usuarios=tesperclan.getRanking("Los Matinfos");
		assertTrue("Debería ir en este orden",usuarios.get(0).getId().equals("borisc"));
		assertTrue("Debería ir en este orden",usuarios.get(1).getId().equals("franqui"));
		assertTrue("Debería ir en este orden",usuarios.get(2).getId().equals("javigm"));
		tesperclan.setGanador("Los Matinfos");
		assertTrue("Boris debería ser el ganador",((UsuarioPOJO)usuarioDAO.getFromId("borisc")).isEsGanador());
		
	}
}

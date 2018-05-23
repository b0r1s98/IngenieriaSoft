package es.ucm.fdi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.TestperclanSAImp;

/**
 * Clase que contiene los test que comprueban la secuencia de TestperclanSA
 */

public class FullClanTest {
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(
			new BDHashMap<UsuarioPOJO>());
	private ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
	private PreguntaClanDAOImp preguntaClanDAO = new PreguntaClanDAOImp(
			new BDHashMap<PreguntaClanPOJO>());
	private UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(
			new BDHashMap<UsuarioClanPOJO>());
	private TestperclanSAImp testperclanSA;

	/**
	 * Creacion de los clanes y de sus usuarios
	 */
	@Before
	public void setup() {
		new InicializaClanDAOImp1().inicializa(clanDAO);
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaPreguntaClanDAOImp1().inicializa(preguntaClanDAO);

		testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,
				usuarioDAO, preguntaClanDAO);
	}
	
	/**
	 * 
	 * Comprueba una simulacion de una secuencia de acciones del testperclan.
	 *
	 */
	@Test
	public void TestClan() {
		//Probamos que se crea el clan correctamente
		testperclanSA.crearClan("jc", "GITI");
		assertTrue("El clan deberia crearse y jc ser su lider", clanDAO.getFromId("GITI") != null);
	
		//Anadimos dos usuarios y comprobamos que forman parte y que el numero de miembros corresponde
		testperclanSA.anadirUsuarioClan("daniv", "GITI");
		testperclanSA.anadirUsuarioClan("franqui", "GITI");
		
		assertTrue("daniv deberia formar parte del clan", usuarioClanDAO.getMiembrosClan("GITI").contains("daniv"));
		assertTrue("franqui deberia formar parte del clan", usuarioClanDAO.getMiembrosClan("GITI").contains("franqui"));
		assertTrue("El numero de miembros deberia ser tres", usuarioClanDAO.getMiembrosClan("GITI").size() == 3);
		
		//Asignamos un ranking y comprobamos que esta en orden
		testperclanSA.setRanking((UsuarioPOJO) usuarioDAO.getFromId("jc"), 1);
		testperclanSA.setRanking((UsuarioPOJO) usuarioDAO.getFromId("daniv"), 3);
		testperclanSA.setRanking((UsuarioPOJO) usuarioDAO.getFromId("franqui"), 2);		
		ArrayList<UsuarioPOJO> ranking = testperclanSA.getRanking("GITI");
		
		ArrayList<UsuarioPOJO> esperado = new ArrayList<UsuarioPOJO>();
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("daniv"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("franqui"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("jc"));

		assertEquals("Se comprueba que los usuarios estan bien ordenados en el ranking",
				ranking, esperado);
		
		//Se elimina un usuario y comprobamos que ya no forma parte, ademaas comprobamos que el lider ha cambiado.
		testperclanSA.eliminarUsuarioClan("jc");
		
		assertFalse("jc ya no debe ser miembro del clan", usuarioClanDAO.getMiembrosClan("GITI").contains("jc"));
		assertEquals("daniv debe ser el nuevo lider del clan", "franqui", ((ClanPOJO) clanDAO.getFromId("GITI")).getLider());
		
		//Se asigna al ganador y se comprueba que efectivamente lo es.
		testperclanSA.setGanador("GITI");
		assertTrue("daniv deberia ser el ganador", ((UsuarioPOJO) usuarioDAO.getFromId("daniv")).isEsGanador());
		
	}

}
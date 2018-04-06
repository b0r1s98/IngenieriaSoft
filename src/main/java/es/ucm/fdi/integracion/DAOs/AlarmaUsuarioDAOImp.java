package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.datos.*;

public class AlarmaUsuarioDAOImp extends HashMapDAO<AlarmaUsuarioPOJO> implements AlarmaUsuarioDAO{
	
	public AlarmaUsuarioDAOImp(BDHashMap<AlarmaUsuarioPOJO> BD) {
		super(BD);
	}

	@Override
	public ArrayList<String> getAlarmasUsuario(String idUsuario) {
		ArrayList<String> listaAlarmas = new ArrayList<>();
		for(String a: BD.getIds()){
			if(BD.find(a).getIdUsuario().equals(idUsuario)){
				listaAlarmas.add(a);
			}
		}
		return listaAlarmas;
	}
}
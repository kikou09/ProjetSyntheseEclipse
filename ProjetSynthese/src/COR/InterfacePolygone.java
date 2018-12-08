package COR;

import Graphique.Erreur;

public class InterfacePolygone extends InterfaceForme {

	public InterfacePolygone(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Polygone")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg) throws Erreur {
		// TODO Auto-generated method stub
		
	}

}

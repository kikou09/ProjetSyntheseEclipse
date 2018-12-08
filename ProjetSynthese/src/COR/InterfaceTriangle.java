package COR;

import Graphique.Erreur;

public class InterfaceTriangle extends InterfaceForme {

	public InterfaceTriangle(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Triangle")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg) throws Erreur {
		// TODO Auto-generated method stub
		
	}



}

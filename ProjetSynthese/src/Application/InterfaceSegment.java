package Application;

import COR.InterfaceForme;
import Graphique.Erreur;

public class InterfaceSegment extends InterfaceForme {

	public InterfaceSegment(InterfaceForme suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saitInteragir(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executerInteraction(String msg)
			throws Erreur, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub

	}

}

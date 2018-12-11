package COR;

import Graphique.Erreur;

public abstract class InterfaceForme {
	
	private InterfaceForme suivant=null;
	
	
	public InterfaceForme(InterfaceForme suivant) {
		this.suivant=suivant;
		
		
	}
	
	public InterfaceForme getSuivant() {
		
		return this.suivant;
	}
	
	
	public abstract boolean saitInteragir(String msg);
	public abstract void executerInteraction(String msg) throws Erreur, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	
	public void interagir(String msg) throws Exception {
		
		if (saitInteragir(msg))
			executerInteraction(msg);
		else if (suivant != null)
			suivant.interagir(msg);
		else 
			throw new Exception("pas d'interaction pour"+ msg);
		
	}
	

}

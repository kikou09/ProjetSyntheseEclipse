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
	
	public void interagir(String msg) throws Erreur{
		
		if (saitInteragir(msg))
			
			try {
				executerInteraction(msg);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				System.err.println("Erreur lors du dessin de la forme");
				e.printStackTrace();
			}
		else if (suivant != null)
			suivant.interagir(msg);
		else 
			throw new Erreur("pas d'interaction pour"+ msg);
		
	}
	

}

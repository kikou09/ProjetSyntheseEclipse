package COR;

import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Classe mère Interface pour la chaine de responsablitees
 */
public abstract class InterfaceForme {
	
	private InterfaceForme suivant=null;
	
	
	public InterfaceForme(InterfaceForme suivant) {
		this.suivant=suivant;
		
		
	}
	
	public InterfaceForme getSuivant() {
		
		return this.suivant;
	}
	
	/**
	 * Fonction booleenne
	 * @param msg forme à dessiner 
	 * @return vrai si l'interface peut peut executer le dessin contenu dans msg
	 */
	public abstract boolean saitInteragir(String msg);
	
	/**
	 * Si saitInteragir renvoie vrai , execute le dessin
	 * @param msg forme à dessiner
	 * @throws Erreur en cas d'erreur de construction de la fenêtre ou en cas d'erreur de dessin
	 */
	public abstract void executerInteraction(String msg , Fenetre fen) throws Erreur;
	
	
	/**
	 * S'occupe de trouver quel maillon de la chaine peut executer le dessin 
	 * @param msg forme à dessiner
	 * @throws Erreur si aucun maillon ne peut dessiner la forme
	 */
	public void interagir(String msg , Fenetre fen) throws Erreur{
		
		if (saitInteragir(msg))
			
			try {
				executerInteraction(msg,fen);
			} catch (Erreur e) {
				System.err.println("Erreur lors du dessin de la forme");
				e.printStackTrace();
			}
		else if (suivant != null)
			suivant.interagir(msg,fen);
		else 
			throw new Erreur("pas d'interaction pour"+ msg);
		
	}
	

}

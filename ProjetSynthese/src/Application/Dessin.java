package Application;


/**
 * @authors SCHUSTER Jorane NUSS Alexis 
 * @version 1.10
 */

import COR.*;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Classe qui s'occupe d'initialiser la chaine de responsabilit�es et de lancer le dessin de la forme
 * @author Jorane SCHUSTER , Alexis NUSS
 */
public class Dessin {
	
	private static Dessin dessin=null;
	
	public static InterfaceForme ihm=initialiserInterface();	
	
	private Dessin() throws Erreur {
		
	}
	
	/**
	 * @return le dessin si il existe et le cr�er sinon 
	 * @throws Erreur 
	 */
	public static Dessin instanceDessin() throws Erreur {
		if(dessin==null)
			dessin=new Dessin();
		return dessin;
		
	}
	
	/**
	 * Transformation Monde-Ecran
	 * @param p = point � transformer
	 */
	public void TransformationCoordonnees(Point p) {
		
		p.setX(p.getX()+(Fenetre.width/2));
		p.setY(p.getY()+(Fenetre.height/2));
	}

	/**
	 * Initialise la chaine de responsabilit�es et lance le dessin
	 * @param forme forme � dessiner
	 * @throws Erreur en cas de probl�me lors du dessin
	 */
	public void Dessiner(String forme) throws Erreur {
		
		if(ihm==null){
			System.out.println("L'application ne fait rien ");
			System.exit(0);
		}
		
		Fenetre fen=new Fenetre();
		
		ihm.interagir(forme,fen);
		
        fen.afficher();
		
	}
	
	/**
	 * Creer l'interface de la chaine de responsabilit�es
	 * @return InterfaceForme 
	 */
	public static InterfaceForme initialiserInterface() {
		
		InterfaceForme monInterface=null;
		monInterface=new InterfaceCercle(monInterface);
		monInterface=new InterfacePolygone(monInterface);
		monInterface= new InterfaceTriangle(monInterface);
		monInterface=new InterfaceSegment(monInterface);
		monInterface=new InterfaceFormeComposee(monInterface);
		return monInterface;
	}

}

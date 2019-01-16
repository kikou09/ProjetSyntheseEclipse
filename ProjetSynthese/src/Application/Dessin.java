package Application;

import java.util.ArrayList;

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
 * static int lambdaE1 , lambdaE2 , a ,b = constante utilis� pour la transformation
 */
public class Dessin {
	
	private static Dessin dessin=null;

	/*public static int lambdaE1=30;
	public static int lambdaE2=30;
	public static int a=60;
	public static int b=25;*/
	
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
		/*p.setX(p.getX()*lambdaE1 +a );
		p.setY(p.getY()*lambdaE2+b);	*/	
	}

	/**
	 * Initialise la chaine de responsabilit�es et lance le dessin
	 * @param forme forme � dessiner
	 * @throws Erreur en cas de probl�me lors du dessin
	 */
	public void Dessiner(String forme, Fenetre fen) throws Erreur {
		
		if(ihm==null){
			System.out.println("L'application ne fait rien ");
			System.exit(0);
		}
		
		ihm.interagir(forme,fen);
		/*for(String f:formes) {
			
			ihm.interagir(f,fen);
		}*/
		
        //fen.afficher();
		
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

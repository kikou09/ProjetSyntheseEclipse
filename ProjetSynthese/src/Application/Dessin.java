package Application;

/**
 * @authors SCHUSTER Jorane NUSS Alexis 
 * @version 1.10
 */

import COR.*;
import Graphique.Erreur;

/**
 * Classe qui s'occupe d'initialiser la chaine de responsabilit�es et de lancer le dessin de la forme
 * @author Jorane SCHUSTER , Alexis NUSS
 * static int lambdaE1 , lambdaE2 , a ,b = constante utilis� pour la transformation
 */
public class Dessin {
	
	private static Dessin dessin=null;

	public static int lambdaE1=60;
	public static int lambdaE2=60;
	public static int a=40;
	public static int b=30;
	
	public static InterfaceForme ihm=null;
	
	
	/**
	 * @return le dessin si il existe et le cr�er sinon 
	 */
	public static Dessin instanceDessin() {
		if(dessin==null)
			dessin=new Dessin();
		return dessin;
		
	}
	
	/**
	 * Transformation Monde-Ecran
	 * @param p = point � transformer
	 */
	public static void TransformationCoordonnees(Point p) {
		
		p.setX(p.getX()*lambdaE1 +a );
		p.setY(p.getY()*lambdaE2+b);		
	}

	/**
	 * Initialise la chaine de responsabilit�es et lance le dessin
	 * @param forme forme � dessiner
	 * @throws Erreur en cas de probl�me lors du dessin
	 */
	public static void Dessiner(String forme) throws Erreur {
		
		ihm=initialiserInterface();
		
		//String msg="Segment :0 1 12 0 red";
		
		if(ihm==null){
			System.out.println("L'application ne fait rien ");
			System.exit(0);
		}
			
		ihm.interagir(forme);
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
		
		return monInterface;
	}

}

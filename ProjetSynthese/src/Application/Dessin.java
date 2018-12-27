package Application;

/**
 * @authors SCHUSTER Jorane NUSS Alexis 
 * @version 1.10
 */

import COR.*;
import Graphique.Erreur;

/**
 * Classe qui s'occupe d'initialiser la chaine de responsabilitées et de lancer le dessin de la forme
 * @author Jorane SCHUSTER , Alexis NUSS
 * static int lambdaE1 , lambdaE2 , a ,b = constante utilisé pour la transformation
 */
public class Dessin {
	
	private static Dessin dessin=null;

	public static int lambdaE1=60;
	public static int lambdaE2=60;
	public static int a=40;
	public static int b=30;
	
	public static InterfaceForme ihm=null;
	
	
	/**
	 * @return le dessin si il existe et le créer sinon 
	 */
	public static Dessin instanceDessin() {
		if(dessin==null)
			dessin=new Dessin();
		return dessin;
		
	}
	
	/**
	 * Transformation Monde-Ecran
	 * @param p = point à transformer
	 */
	public static void TransformationCoordonnees(Point p) {
		
		p.setX(p.getX()*lambdaE1 +a );
		p.setY(p.getY()*lambdaE2+b);		
	}

	/**
	 * Initialise la chaine de responsabilitées et lance le dessin
	 * @param forme forme à dessiner
	 * @throws Erreur en cas de problème lors du dessin
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
	 * Creer l'interface de la chaine de responsabilitées
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

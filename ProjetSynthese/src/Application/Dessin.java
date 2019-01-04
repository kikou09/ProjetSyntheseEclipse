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
 * Classe qui s'occupe d'initialiser la chaine de responsabilitées et de lancer le dessin de la forme
 * @author Jorane SCHUSTER , Alexis NUSS
 * static int lambdaE1 , lambdaE2 , a ,b = constante utilisé pour la transformation
 */
public class Dessin {
	
	private static Dessin dessin=null;

	public static int lambdaE1=30;
	public static int lambdaE2=30;
	public static int a=60;
	public static int b=25;
	
	private InterfaceForme ihm=initialiserInterface();
	private ArrayList<String>formes;
	private Fenetre fen;
	
	
	private Dessin() throws Erreur {
		
		formes=new ArrayList<String>();
		fen=new Fenetre();
	}
	
	/**
	 * @return le dessin si il existe et le créer sinon 
	 * @throws Erreur 
	 */
	public static Dessin instanceDessin() throws Erreur {
		if(dessin==null)
			dessin=new Dessin();
		return dessin;
		
	}
	
	/**
	 * Transformation Monde-Ecran
	 * @param p = point à transformer
	 */
	public void TransformationCoordonnees(Point p) {
		
		p.setX(p.getX()*lambdaE1 +a );
		p.setY(p.getY()*lambdaE2+b);		
	}

	/**
	 * Initialise la chaine de responsabilitées et lance le dessin
	 * @param forme forme à dessiner
	 * @throws Erreur en cas de problème lors du dessin
	 */
	public void Dessiner(String forme) throws Erreur {
		
		formes.add(forme);

		//String msg="Segment :0 1 12 0 red";
		
		if(ihm==null){
			System.out.println("L'application ne fait rien ");
			System.exit(0);
		}
		
		ihm.interagir(forme,fen);
		for(String f:formes) {
			
			ihm.interagir(f,fen);
		}
		
        fen.afficher();
		
	}
	
	/**
	 * Creer l'interface de la chaine de responsabilitées
	 * @return InterfaceForme 
	 */
	public InterfaceForme initialiserInterface() {
		
		InterfaceForme monInterface=null;
		monInterface=new InterfaceCercle(monInterface);
		monInterface=new InterfacePolygone(monInterface);
		monInterface= new InterfaceTriangle(monInterface);
		monInterface=new InterfaceSegment(monInterface);
		
		return monInterface;
	}

}

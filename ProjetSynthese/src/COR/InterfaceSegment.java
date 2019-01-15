package COR;

import java.awt.Color;
import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Maillon de la chaine qui s'occupe du dessin du segment
 */
public class InterfaceSegment extends InterfaceForme {

	public InterfaceSegment(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Segment")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg , Fenetre fen) throws Erreur {
		
	Fenetre fen2=new Fenetre();
	String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");
	
    int     x1 = (int) Double.parseDouble(tabMsg[0]) ,
            y1 =  (int) Double.parseDouble(tabMsg[1]),
    		x2 = (int) Double.parseDouble(tabMsg[2]),
            y2 =  (int) Double.parseDouble(tabMsg[3]);

    
    Point p1=new Point(x1,y1);
    Point p2=new Point(x2,y2);

	String couleur = tabMsg[4];

    try {
		Color c = (Color) Color.class.getField(couleur.trim()).get(null);
		fen.graphics.setColor(c);
	} 
	catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		e.printStackTrace();
	}
    
	Dessin.instanceDessin().TransformationCoordonnees(p1); 
	Dessin.instanceDessin().TransformationCoordonnees(p2); 
	
	fen2.graphics.drawLine(p1.getX(),p1.getY(), p2.getX(), p2.getY());
	fen2.afficher();

	}

}



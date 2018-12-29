package COR;

import java.awt.Color;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * 
 * Interface pour le Segment 
 *
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
	public void executerInteraction(String msg , Fenetre fen) {
		
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
    
	Dessin.TransformationCoordonnees(p1); 
	Dessin.TransformationCoordonnees(p2); 

	int[] x={p1.getX(),p2.getX(),p1.getX()};
	int[] y={p1.getY(),p2.getY(),p1.getY()};
	
	fen.graphics.drawLine(p1.getX(),p1.getY(), p2.getX(), p2.getY());

	}

}



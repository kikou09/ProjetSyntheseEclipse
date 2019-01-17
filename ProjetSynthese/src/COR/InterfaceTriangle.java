package COR;

import java.awt.*;
import Application.Dessin;
import Graphique.*;

/**
 * Maillon de la chaine qui s'occupe du dessin du triangle
 */
public class InterfaceTriangle extends InterfaceForme {

	public InterfaceTriangle(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Triangle")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg, Fenetre fen) throws Erreur{
		
		String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");
		
        int     x1 = (int) Double.parseDouble(tabMsg[0]) ,
                y1 =  (int) Double.parseDouble(tabMsg[1]),
        		x2 = (int) Double.parseDouble(tabMsg[2]),
                y2 =  (int) Double.parseDouble(tabMsg[3]),
        		x3 =  (int) Double.parseDouble(tabMsg[4]),
                y3 =  (int) Double.parseDouble(tabMsg[5]);
        
        Point p1=new Point(x1,y1);
        Point p2=new Point(x2,y2);
        Point p3=new Point(x3,y3);
        
        		
		String couleur = tabMsg[6];
        try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        
		Dessin.instanceDessin().TransformationCoordonnees(p1); 
		Dessin.instanceDessin().TransformationCoordonnees(p2); 
		Dessin.instanceDessin().TransformationCoordonnees(p3); 

		int[] x={p1.getX(),p2.getX(),p3.getX(),p1.getX()};
		int[] y={p1.getY(),p2.getY(),p3.getY(),p1.getY()};
		
		System.out.println(p1.getX());
		//fen.graphics.drawPolygon(x,y,x.length);
		fen.graphics.fillPolygon(x,y,x.length);
		
    }



}

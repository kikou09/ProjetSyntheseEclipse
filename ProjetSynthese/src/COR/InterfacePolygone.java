package COR;

import java.awt.*;
import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Maillon de la chaine qui s'occupe du dessin du polygone
 */
public class InterfacePolygone extends InterfaceForme {

	public InterfacePolygone(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Polygone")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg , Fenetre fen) throws Erreur{
		
		String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");

		int nbPoints =Integer.parseInt(tabMsg[0]);
		int indice=1;	
		int[] pointsX=new int[nbPoints+1];
		int[] pointsY=new int[nbPoints+1];
		
		System.out.println(pointsX.length);
		
        for(int i=0; i<nbPoints; i++) {
        	
        	int x=(int) Double.parseDouble(tabMsg[indice]);
			int y=(int) Double.parseDouble(tabMsg[indice+1]);
        	Point p=new Point(x,y);
    		Dessin.instanceDessin().TransformationCoordonnees(p); 
        	pointsX[i]=p.getX();
        	pointsY[i]=p.getY();
        	indice=indice+2;
        }
        
		String couleur = tabMsg[indice];
		pointsX[pointsX.length-1]=pointsX[0];
		pointsY[pointsY.length-1]=pointsY[0];
        
		try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		fen.graphics.drawPolygon(pointsX,pointsY,pointsX.length);
		fen.graphics.fillPolygon(pointsX,pointsY,pointsX.length);

		
	}

}

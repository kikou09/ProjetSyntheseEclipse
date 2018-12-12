package COR;

import java.awt.*;
import java.lang.reflect.*;
import java.util.*;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

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
	public void executerInteraction(String msg) throws Erreur{
		//Scanner scanner = new Scanner(msg.substring(msg.indexOf(":") + 1, msg.length()));
		String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");
        Fenetre fen = new Fenetre();

		int nbPoints =Integer.parseInt(tabMsg[0]);
		int indice=1;
	
		int[] pointsX=new int[nbPoints+1];
		int[] pointsY=new int[nbPoints+1];
		
        for(int i=0; i<nbPoints; i++) {
        	
        	int x=(int) Double.parseDouble(tabMsg[indice]);
			int y=(int) Double.parseDouble(tabMsg[indice+1]);
        	Point p=new Point(x,y);
    		Dessin.TransformationCoordonnees(p); 
        	pointsX[i]=p.getX();
        	pointsY[i]=p.getY();
        	indice=indice+2;
        }
		String couleur = tabMsg[indice];
        
		try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		pointsX[nbPoints+1]=pointsX[0];
		pointsY[nbPoints+1]=pointsY[0];
		
		
		fen.graphics.drawPolygon(pointsX,pointsY,pointsX.length);
		fen.graphics.fillPolygon(pointsX,pointsY,pointsX.length);

        fen.afficher();
		
	}

}

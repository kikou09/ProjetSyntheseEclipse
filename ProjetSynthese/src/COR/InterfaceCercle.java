package COR;

import java.awt.Color;
import java.util.Scanner;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

public class InterfaceCercle extends InterfaceForme {

	public InterfaceCercle(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
        if (msg.contains("Cercle")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg , Fenetre fen) throws Erreur {
		
         String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");
		 int  xCentre = (int) Double.parseDouble(tabMsg[0]),
                 yCentre = (int) Double.parseDouble(tabMsg[1]),
                 rayon   = (int) Double.parseDouble(tabMsg[2]);
		 
         Point centre= new Point(xCentre , yCentre);

		String couleur = tabMsg[3];
		 try {
				Color c = (Color) Color.class.getField(couleur.trim()).get(null);
				fen.graphics.setColor(c);
			} 
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	       
		Dessin.TransformationCoordonnees(centre); 
		fen.graphics.drawOval(centre.getX(),centre.getY(), rayon*10 , rayon*10);
		fen.graphics.fillOval(centre.getX(), centre.getY(), rayon*10, rayon*10);

	}

}

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
	public void executerInteraction(String msg) throws Erreur {
		
		 //Scanner scanner = new Scanner(msg.substring(msg.indexOf(":")+1, msg.length()));
         Fenetre fen = new Fenetre();

         String tabMsg[]=msg.substring(msg.indexOf(":")+1).split(" ");
		 int  xCentre = (int) Double.parseDouble(tabMsg[0]),
                 yCentre = (int) Double.parseDouble(tabMsg[1]),
                 rayon   = (int) Double.parseDouble(tabMsg[2]);

		String couleur = tabMsg[3];
		 try {
				Color c = (Color) Color.class.getField(couleur.trim()).get(null);
				fen.graphics.setColor(c);
			} 
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	       
		//Il faut créer une classe Point pour pouvoir le modifier 
		Dessin.TransformationCoordonnees(xCentre, yCentre); 
		System.out.println(xCentre);
		fen.graphics.drawOval(xCentre, yCentre, rayon , rayon);
		fen.graphics.fillOval(xCentre, yCentre, rayon, rayon);

        fen.afficher();  

	}

}

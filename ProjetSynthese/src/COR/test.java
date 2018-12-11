package COR;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Scanner;

import Graphique.Erreur;
import Graphique.Fenetre;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Erreur {
			
			String msg="qqch: 100 200 40 blue";
			Scanner scanner = new Scanner(msg.substring(msg.indexOf(":")+1, msg.length()));

			 int     xCentre = scanner.nextInt(),
	                 yCentre = scanner.nextInt(),
	                 rayon   = scanner.nextInt();
			 
			 String couleur = scanner.nextLine();

	        Fenetre fen = new Fenetre();
	        try {
				Color c = (Color) Color.class.getField(couleur.trim()).get(null);
				fen.graphics.setColor(c);
			} 
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	        

	         fen.graphics.drawOval (xCentre, yCentre, rayon, rayon);
	         fen.graphics.fillOval (xCentre, yCentre, rayon, rayon);// dessine sur le tampon vid�o. coordonn�es en dur : tr�s maladroit
	         fen.afficher();  
			
		}

}

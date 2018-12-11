package COR;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Scanner;

import Graphique.Erreur;
import Graphique.Fenetre;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Erreur {

	        Fenetre fen = new Fenetre();
	        int[] x={0,400};
			int[] y={300,0};
			fen.graphics.drawPolygon(x,y,x.length);
			fen.graphics.fillPolygon(x,y,x.length);

	        fen.afficher();
			
		}

}

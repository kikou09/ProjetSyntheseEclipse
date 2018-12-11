package COR;

import java.awt.*;
import java.lang.reflect.*;
import java.util.*;

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
		Scanner scanner = new Scanner(msg.substring(msg.indexOf(":") + 1, msg.length()));
		int nbPoints = scanner.nextInt();
		int[] x = new int[nbPoints+1];
		int[] y = new int[nbPoints+1];
        for(int i=0; i<nbPoints; i++) {
        	x[i]=scanner.nextInt();
        }
		for(int j=0; j<nbPoints; j++) {
			y[j]=scanner.nextInt();
		}
		x[nbPoints]= x[0];
		y[nbPoints]= y[0];
		System.out.println(x[1]);
		String couleur = scanner.nextLine();
        Fenetre fen = new Fenetre();
        
		try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		fen.graphics.drawPolygon(x,y,x.length);
		fen.graphics.fillPolygon(x,y,x.length);

        fen.afficher();
		
	}

}

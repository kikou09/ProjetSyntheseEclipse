package COR;

import java.awt.*;
import java.util.*;
import java.lang.reflect.*;

import Graphique.*;

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
	public void executerInteraction(String msg) throws Erreur{
		Scanner scanner = new Scanner(msg.substring(msg.indexOf(":") + 1, msg.length()));
		
        int     x1 = scanner.nextInt(),
        		x2 = scanner.nextInt(),
        		x3 = scanner.nextInt(),
                y1 = scanner.nextInt(),
                y2 = scanner.nextInt(),
                y3 = scanner.nextInt();
        
		int[] x={x1,x2,x3,x1};
		int[] y={y1,y2,y3,y1};
		
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

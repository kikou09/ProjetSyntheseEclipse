package COR;

import java.util.Scanner;

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
		
		 Scanner scanner = new Scanner(msg.substring(msg.indexOf(":")+1, msg.length()));

		 int     xCentre = scanner.nextInt(),
                 yCentre = scanner.nextInt(),
                 rayon   = scanner.nextInt();


         Fenetre fen = new Fenetre();

         fen.graphics.drawOval (xCentre, yCentre, rayon, rayon); // dessine sur le tampon vidéo. coordonnées en dur : très maladroit
         fen.afficher();  

	}

}

package Formes;
import java.awt.*;
import java.util.Scanner;

public class Cercle extends Forme{
	private double rayon;
	private double x,y;
	
    //Constructeur
    Cercle(int xCentre, int yCentre, int rayon, String couleur) {
    	super(couleur);
        this.x = xCentre;
        this.y = yCentre;
        this.rayon = rayon;
    }
	
    public void dessiner(Graphics graphics) {
        graphics.drawOval(x, y, rayon, couleur); // dessine sur le tampon vidéo. coordonnées en dur : très maladroit
    }
	// getters et setter à faire
	
	public Forme Charger(String msg) {
        if(msg.contains("Cercle")) {
            double xCentre, yCentre, rayon;
            String couleur;
            // A voir la récupération
            Scanner scanner = new Scanner(msg.substring(msg.indexOf(":")+1, msg.length()));

            xCentre = scanner.nextInt();
            yCentre = scanner.nextInt();
            rayon   = scanner.nextInt();

            return new Cercle(xCentre, yCentre, rayon, couleur);
        }

        //Si on a pas réussi à la comprendre, on appel l'expert suivant
        if(chaine != null)
            return chaine.charger(msg);

        return null;
	}
}

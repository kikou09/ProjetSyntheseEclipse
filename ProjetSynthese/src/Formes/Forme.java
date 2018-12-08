package Formes;
import Graphique.Fenetre;
import java.awt.*;

public abstract class Forme {
	
	private String couleur;
	
	public Forme(String couleur) {
		
		this.couleur=couleur;
	}
    //Afficher cette forme sur une nouvelle fenêtre
    public void afficher() {
        Fenetre fun = new Fenetre();
    }

    //Dessiner la forme
    public abstract void dessiner(Graphics graphics);
    
    public abstract Forme Charger(String msg);
}

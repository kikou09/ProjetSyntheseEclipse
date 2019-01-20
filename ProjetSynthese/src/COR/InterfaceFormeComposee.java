package COR;

import java.awt.Color;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Maillon de la chaine qui s'occupe du dessin du polygone
 */
public class InterfaceFormeComposee extends InterfaceForme {

	public InterfaceFormeComposee(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Forme Composee;")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg, Fenetre fen) throws Erreur {
		
		int i=1,j;
		String fc = null;
		int pos= msg.indexOf(";");
		String tabMsg[]=msg.substring(pos+1).split(";");
		String couleur = tabMsg[0];
		
		try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//Traitement special si forme composee imbriquees
		while(i<tabMsg.length-1) {
			if(tabMsg[i].equals("Forme Composee")) {
				j=i;
				while(!tabMsg[j].equals("/"))
					j++;
				while(i<=j) {
					fc+=tabMsg[i]+ ";";
					i++;
				}
				Dessin.ihm.interagir(fc,fen);
			}
			else {
				Dessin.ihm.interagir(tabMsg[i],fen);
				i++;
			}
		}
		
	}

}


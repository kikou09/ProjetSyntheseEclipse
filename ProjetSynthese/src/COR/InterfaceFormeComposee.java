package COR;

import java.awt.Color;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

public class InterfaceFormeComposee extends InterfaceForme {

	public InterfaceFormeComposee(InterfaceForme suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String msg) {
		if (msg.contains("Forme Composee")) {
        	return true;
        }
        return false;
	}

	@Override
	public void executerInteraction(String msg, Fenetre fen) throws Erreur {
		
		int i;
		int pos= msg.indexOf(";");
		String tabMsg[]=msg.substring(pos+1).split(";");
		String couleur = tabMsg[tabMsg.length-1];
		
		try {
			Color c = (Color) Color.class.getField(couleur.trim()).get(null);
			fen.graphics.setColor(c);
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		for(i=0;i<tabMsg.length-1;i++) {
			
			Dessin.ihm.interagir(tabMsg[i],fen);
		}
		
	
	}

}

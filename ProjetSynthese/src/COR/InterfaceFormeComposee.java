package COR;

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
		System.out.println("ok");
		Fenetre fen2=new Fenetre();
		int pos= msg.indexOf("]");
		String tabMsg[]=msg.substring(msg.indexOf("[")+1,msg.length()-(pos+1)).split(";");
		
		for(i=0;i<tabMsg.length;i++) {
			
			System.out.println(tabMsg[i]);
			//Dessin.ihm.interagir(tabMsg[i],fen2);
		}
	
		//fen2.afficher();

	}

}

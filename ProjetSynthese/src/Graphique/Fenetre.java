package Graphique;

import Formes.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Fenetre {
	

  Frame f1AR;
  BufferStrategy stratégie;
  public Graphics graphics;
  
  static int numero=0;

    public Fenetre() throws Erreur {
        try {
            f1AR = new Frame(" Frame n°" + (++numero));

            f1AR.setBounds(30, 60, 400, 400);       // coordonnées en dur : très maladroit
            f1AR.setVisible(true);              // rend le frame visible sur l'écran
            f1AR.setIgnoreRepaint(true);        // désactive l'appel automatique de la fct paint(...) par repaint()


            f1AR.createBufferStrategy(1);  // crée une stratégie de tampon d'image à 1 tampon vidéo
            Thread.sleep(150);                       // au moins 150 ms !!!! pour laisser au système le temps de créer le buffer d'image

            stratégie = f1AR.getBufferStrategy();
            graphics = stratégie.getDrawGraphics(); // le graphics sert à dessiner sur le tampon
        }

        catch (InterruptedException e) {
        		throw new Erreur("Impossible de créer la fenetre");
        }
    }
    
    public void afficher() {

        stratégie.show();       // place le tampon sur l'écran : la technique utilisée dépend du type de stratégie utilisé : blitting, pointeur vidéo, etc.
        graphics.dispose();    
    }
}


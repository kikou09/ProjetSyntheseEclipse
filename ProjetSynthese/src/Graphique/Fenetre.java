package Graphique;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Fenetre {
	

  Frame f1AR;
  BufferStrategy strategie;
  public Graphics graphics;
  
  static int numero=0;

    public Fenetre() throws Erreur {
        try {
            f1AR = new Frame(" Frame numero " + (++numero));

            f1AR.setBounds(30, 60, 400, 400);       // coordonn�es en dur : tr�s maladroit
            f1AR.setVisible(true);              // rend le frame visible sur l'�cran
            f1AR.setIgnoreRepaint(true);        // d�sactive l'appel automatique de la fct paint(...) par repaint()


            f1AR.createBufferStrategy(1);  // cr�e une strat�gie de tampon d'image � 1 tampon vid�o
            Thread.sleep(150);                       // au moins 150 ms !!!! pour laisser au syst�me le temps de cr�er le buffer d'image

            strategie = f1AR.getBufferStrategy();
            graphics = strategie.getDrawGraphics(); // le graphics sert � dessiner sur le tampon
        }

        catch (InterruptedException e) {
        		throw new Erreur("Impossible de creer la fenetre");
        }
    }
    
    public void afficher() {

        strategie.show();       // place le tampon sur l'�cran : la technique utilis�e d�pend du type de strat�gie utilis� : blitting, pointeur vid�o, etc.
        graphics.dispose();    
    }
}


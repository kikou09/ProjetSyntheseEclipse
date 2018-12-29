package Graphique;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Fenetre {
	

  Frame f1AR;
  BufferStrategy strategie;
  public Graphics graphics;
  static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
  public static int height = (int)dimension.getHeight();
  public static int width  = (int)dimension.getWidth();
  
  static int numero=0;

    public Fenetre() throws Erreur {
        try {
            f1AR = new Frame(" Frame numero " + (++numero));

            f1AR.setBounds(0, 0, width, height);    
            f1AR.setVisible(true);              // rend le frame visible sur l'�cran
            f1AR.setIgnoreRepaint(true);        // d�sactive l'appel automatique de la fct paint(...) par repaint()


            f1AR.createBufferStrategy(1);  // cr�ee une strat�gie de tampon d'image sur un tampon vide
            Thread.sleep(150);                       // Pour laisser au syst�me le temps de cr�eer le buffer d'image

            strategie = f1AR.getBufferStrategy();
            graphics = strategie.getDrawGraphics(); // le graphics sert � dessiner sur le tampon
        }

        catch (InterruptedException e) {
        		throw new Erreur("Impossible de creer la fenetre");
        }
    }
    
    public void afficher() {

        strategie.show();       // place le tampon sur l'�cran
        graphics.dispose();    
        graphics = strategie.getDrawGraphics();
    }
}


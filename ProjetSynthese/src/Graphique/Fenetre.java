package Graphique;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/**
 * Classe Fenetre
 * Gestion de la fenetre pour le dessin 
 */
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
            f1AR.setVisible(true);              // rend le frame visible sur l'écran
            f1AR.setIgnoreRepaint(true);        // désactive l'appel automatique de la fct paint(...) par repaint()
            
            f1AR.addWindowListener(new WindowAdapter(){
            	public void windowClosing(WindowEvent windowEvent) {
            		f1AR.dispose();
            	}
            });

            f1AR.createBufferStrategy(1);  // créee une stratégie de tampon d'image sur un tampon vide
            Thread.sleep(150);                       // Pour laisser au système le temps de créeer le buffer d'image

            strategie = f1AR.getBufferStrategy();
            graphics = strategie.getDrawGraphics(); // le graphics sert à dessiner sur le tampon
        }

        catch (InterruptedException e) {
        		throw new Erreur("Impossible de creer la fenetre");
        }
    }

	public void afficher() {

        strategie.show();       // place le tampon sur l'écran
        graphics.dispose();    
    }
}


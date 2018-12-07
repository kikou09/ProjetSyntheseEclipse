package Graphique;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Fenetre {
    Frame f1AR;
    static short numero=0;

    Fenetre(Forme obj) {
        try {
            f1AR = new Frame(" Superbe Frame unique et inégalable n°" + (++numero));

            f1AR.setBounds(30, 60, 400, 400);       // coordonnées en dur : très maladroit

            f1AR.setVisible(true);              // rend le frame visible sur l'écran
            f1AR.setIgnoreRepaint(true);        // désactive l'appel automatique de la fct paint(...) par repaint()


            int numBuffers = 1;
            f1AR.createBufferStrategy(numBuffers);  // crée une stratégie de tampon d'image à 1 tampon vidéo
            Thread.sleep(150);                       // au moins 150 ms !!!! pour laisser au système le temps de créer le buffer d'image

            BufferStrategy stratégie = f1AR.getBufferStrategy();
            Graphics graphics = stratégie.getDrawGraphics();
// le graphics sert à dessiner sur le tampon

            obj.dessiner(graphics);

            stratégie.show();       // place le tampon sur l'écran : la technique utilisée dépend du type de stratégie utilisé : blitting, pointeur vidéo, etc.

            graphics.dispose();     // En finir avec la vie
        }

catch (InterruptedException e) {
            // il n'y à rien à faire sauf mourir
        }
    }
}

package Graphique;

import Formes.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Fenetre {
    Frame f1AR;
    static short numero=0;

    public Fenetre(Forme obj) {
        try {
            f1AR = new Frame(" Superbe Frame unique et in�galable n�" + (++numero));

            f1AR.setBounds(30, 60, 400, 400);       // coordonn�es en dur : tr�s maladroit

            f1AR.setVisible(true);              // rend le frame visible sur l'�cran
            f1AR.setIgnoreRepaint(true);        // d�sactive l'appel automatique de la fct paint(...) par repaint()


            int numBuffers = 1;
            f1AR.createBufferStrategy(numBuffers);  // cr�e une strat�gie de tampon d'image � 1 tampon vid�o
            Thread.sleep(150);                       // au moins 150 ms !!!! pour laisser au syst�me le temps de cr�er le buffer d'image

            BufferStrategy strategie = f1AR.getBufferStrategy();
            Graphics graphics = strategie.getDrawGraphics();
// le graphics sert � dessiner sur le tampon

            obj.dessiner(graphics);

            strategie.show();       // place le tampon sur l'�cran : la technique utilis�e d�pend du type de strat�gie utilis� : blitting, pointeur vid�o, etc.

            graphics.dispose();     // En finir avec la vie
        }

catch (InterruptedException e) {
            // il n'y � rien � faire sauf mourir
        }
    }
}

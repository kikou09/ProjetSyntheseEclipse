package Serveur;

import java.io.*;
import java.net.Socket;

/**
 * thread et socket cot� serveur :  traite les requ�tes d'un client
 * ici le serveur, pour chaque cha�ne de caract�res re�ue d'un client, la transforme en majuscule puis la renvoie au client
 * */
public class ReceveurEnvoyeur extends Thread  {

    Socket socket;  int noConnexion; // num�ro du client distant

    BufferedReader fluxEntrant;	PrintStream fluxSortant;

    /**
     * Suppose socket d�j� connect� vers le client n� noConnexion
     * @param noConnexion : n� du client
     * */
    public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion) throws IOException {

        super(groupe,"ReceveurEnvoyeur");
        this.socket = socket;
        this.noConnexion = noConnexion;

        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        /* � pr�sent fluxEntrant est pr�t pour lire du texte provenant du client */

        fluxSortant = new PrintStream(this.socket.getOutputStream());
        /* � pr�sent fluxSortant est pr�t pour renvoyer des r�ponses textuelles au client */
    }



    public void run() {

        String ligne;	String reponse;

        /*try  {

            ligne = fluxEntrant.readLine(); // saisit le texte du client
            System.out.println(" le client n� "+this.noConnexion+" a envoy� : ");
            System.out.println(ligne); // �cho de la question sur la console
            System.out.println(ligne); // �cho de la question sur la console

            //Forme obj = new Croix(new Rond(null)).charger(ligne); //Interpr�tation du msg par ces doux experts

            if(obj!=null) {
                reponse = ligne.concat(" a ete cree.\n");
                obj.afficher();
            }
            else reponse = "Impossible de cr�er l'objet";

            fluxSortant.println(reponse); // envoi de la reponse au client
        }

        catch(IOException erreur) { System.err.println(" on ne peut pas lire sur le socket provenant du client");}

    }// run*/
} // ReceveurEnvoyeur
}

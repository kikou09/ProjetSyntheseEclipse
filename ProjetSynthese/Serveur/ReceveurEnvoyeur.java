package Serveur;

import java.net.*;
import java.io.*;
/**
 * thread et socket coté serveur :  traite les requêtes d'un client
 * ici le serveur, pour chaque chaîne de caractères reçue d'un client, la transforme en majuscule puis la renvoie au client
 * */
public class ReceveurEnvoyeur extends Thread  {

    Socket socket;  int noConnexion; // numéro du client distant

    BufferedReader fluxEntrant;	PrintStream fluxSortant;

    /**
     * Suppose socket déjà connecté vers le client n° noConnexion
     * @param noConnexion : n° du client
     * */
    public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion) throws IOException {

        super(groupe,"ReceveurEnvoyeur");
        this.socket = socket;
        this.noConnexion = noConnexion;

        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        /* à présent fluxEntrant est prêt pour lire du texte provenant du client */

        fluxSortant = new PrintStream(this.socket.getOutputStream());
        /* à présent fluxSortant est prêt pour renvoyer des réponses textuelles au client */
    }



    public void run() {

        String ligne;	String réponse;

        try  {

            ligne = fluxEntrant.readLine(); // saisit le texte du client
            System.out.println(" le client n° "+this.noConnexion+" a envoyé : ");
            System.out.println(ligne); // écho de la question sur la console
            System.out.println(ligne); // écho de la question sur la console

            Forme obj = new Croix(new Rond(null)).charger(ligne); //Interprétation du msg par ces doux experts

            if(obj!=null) {
                réponse = ligne.concat(" a ete cree.\n");
                obj.afficher();
            }
            else réponse = "Impossible de créer l'objet";

            fluxSortant.println(réponse); // envoi de la reponse au client
        }

        catch(IOException erreur) { System.err.println(" on ne peut pas lire sur le socket provenant du client");}

    }// run
} // ReceveurEnvoyeur

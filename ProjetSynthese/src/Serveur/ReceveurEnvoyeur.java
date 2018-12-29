package Serveur;

import java.io.*;
import java.net.Socket;

import Application.Dessin;
import Graphique.Erreur;

/**
 * thread et socket cot� serveur :  traite les requ�tes d'un client
 * Pour chaque chaine de caract�res recue d'un client, la transforme en majuscule puis la renvoie au client
 * */
public class ReceveurEnvoyeur extends Thread  {

    Socket socket;  int noConnexion; // num�ro du client distant

    BufferedReader fluxEntrant;	
    PrintStream fluxSortant;

    /**
     * Suppose socket deja connect� vers le client num noConnexion
     * @param noConnexion : num du client
     * */
    public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion) throws IOException {

        super(groupe,"ReceveurEnvoyeur");
        this.socket = socket;
        this.noConnexion = noConnexion;
        System.out.println(fluxEntrant);

        /*fluxEntrant lit le texte provenant du client */
        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        /*fluxSortant renvoie des r�ponses textuelles au client */
        fluxSortant = new PrintStream(this.socket.getOutputStream());
    }



    public void run() {

        String ligne;	
        String reponse;

        try  {
        	while(! isInterrupted()) {
	            ligne = fluxEntrant.readLine(); // saisit le texte du client
	            System.out.println(" le client num "+this.noConnexion+" a envoy� : ");
	            System.out.println(ligne); // question sur la console
	
	            reponse = ligne.concat("a ete cree.\n");
	
	            //singleton dessin
				try {
					
					Dessin.instanceDessin().Dessiner(ligne);
				} 
				catch (Erreur e) {		
					reponse="Impossible de dessiner l'objet";
				}
				System.out.println(reponse);
	            fluxSortant.println(reponse); // envoi de la reponse au client
	            //sleep(5);
	        }
         }
        catch(IOException erreur) { 
        	System.err.println(" Impossible de lire sur le socket provenant du client");
        } /*catch (InterruptedException e) {
			e.printStackTrace();
		}*/

    }
} 

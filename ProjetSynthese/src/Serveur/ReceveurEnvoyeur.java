package Serveur;

import java.io.*;
import java.net.Socket;

import Application.Dessin;
import Graphique.Erreur;
import Graphique.Fenetre;

/**
 * Classe ReceveurEnvoyeur 
 * thread et socket coté serveur :  traite les requêtes d'un client
 * Recoit une chaine de caractères contenant la forme à dessiner avec ses coordonnees , la dessine
 * Et renvoie une confirmation au client
 * */
public class ReceveurEnvoyeur extends Thread  {

    Socket socket;  int noConnexion; // numéro du client distant

    BufferedReader fluxEntrant;	
    PrintStream fluxSortant;

    /**
     * Suppose que le socket est deja connecté vers le client num noConnexion
     * @param noConnexion : num du client
     * */
    public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion) throws IOException {

        super(groupe,"ReceveurEnvoyeur");
        this.socket = socket;
        this.noConnexion = noConnexion;
        System.out.println(fluxEntrant);

        /*fluxEntrant lit le texte provenant du client */
        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        /*fluxSortant renvoie des réponses textuelles au client */
        fluxSortant = new PrintStream(this.socket.getOutputStream());
    }


    /**
     * Lit la requête du client et lance le dessin traité par la chaine de 
     * responsabilitées 
     * @see Dessin
     */
    public void run() {

        String ligne;	
        String reponse;
        Fenetre fen;

        try  {
        	
        	while(! isInterrupted()) {
        		
	            ligne = fluxEntrant.readLine(); // Le texte du client
	            System.out.println(" le client num "+this.noConnexion+" a envoyé : ");
	            System.out.println(ligne); // Requete sur la console
	
	            reponse = ligne.concat("a ete cree.\n");
	
	            //singleton dessin
				try {
					
	        		fen=new Fenetre();
					Dessin.instanceDessin().Dessiner(ligne, fen);
		            fen.afficher();
				} 
				catch (Erreur e) {		
					reponse="Impossible de dessiner l'objet";
				}
				
				System.out.println(reponse);
	            fluxSortant.println(reponse); // envoi de la reponse au client
	            sleep(5);
	        }
         }
        catch(IOException erreur) { 
        	System.err.println(" Impossible de lire sur le socket provenant du client");
        } catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
} 

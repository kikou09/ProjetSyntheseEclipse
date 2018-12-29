package Serveur;
import java.io.IOException;
import java.net.*;

import Serveur.ReceveurEnvoyeur;

public class Serveur {
	
	private static int noConnexion=0;
	private static ServerSocket serveur;
	private static ThreadGroup groupe;
    private static Socket nouveauClientSocket;


    public static void main(String[] args)throws Exception {

        serveur = new ServerSocket(9111); // place un serveur � l'�coute sur le port 9111
        //si le param�tre = 0 alors la JVM choisit un port libre

        System.out.println("serveur d�marr� : "+serveur);

        InetAddress cetteMachine;
        int portLocal;

        portLocal = serveur.getLocalPort();

        cetteMachine = InetAddress.getLocalHost();

        System.out.println("adresse IP du serveur : "+cetteMachine.getHostAddress());
        System.out.println("port du serveur : "+portLocal);

        groupe = new ThreadGroup("socketsClients");
        //attente infinie du serveur sur le port

        while(true) {

            nouveauClientSocket = serveur.accept(); // attente de connexion de la part d'un nouveau client
            noConnexion++; // la connexion a eu lieu et un socket a �t� cr�� : nouveauClientSocket
            System.out.println("Connexion r�ussie n� : "+noConnexion);

            nouveauClient();
            /*Cr�ation d'un thread pour g�rer les transactions avec le nouvau client en parall�le
             * avec les autres clients d�j� connect�s et avec l'attente perp�tuelle du serveur*/
        }
    }
    
    public static void nouveauClient() {
    	
    	ReceveurEnvoyeur nouveauClientThread;
  
        try {
			nouveauClientThread = new ReceveurEnvoyeur(nouveauClientSocket, groupe, noConnexion);
	        nouveauClientThread.start();    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}

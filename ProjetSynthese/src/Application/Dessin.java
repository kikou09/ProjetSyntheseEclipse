package Application;

import COR.*;


public class Dessin {
	
	static int lambdaE1=50;
	static int lambdaE2=-50;
	static int a=150;
	static int b=250;
	
	public static InterfaceForme ihm=null;
	
	public static void TransformationCoordonnees(int x , int y) {
		
		x=x*lambdaE1+a;
		y=y*lambdaE2+b;
		
	}

	public static void main(String[] args) {
		
		ihm=initialiserInterface();
		String msg="Cercle :2 1 6 red";
		if(ihm==null){
			System.out.println("L'application ne fait rien ");
			System.exit(0);
		}	
		
		try {
			
			ihm.interagir(msg);
		}
		catch(Exception e) {
			
			System.out.println("\n");
			System.err.println(e.getMessage());
		}

	}
	
	
public static InterfaceForme initialiserInterface() {
		
		InterfaceForme monInterface=null;
		monInterface=new InterfaceCercle(monInterface);
		monInterface=new InterfacePolygone(monInterface);
		monInterface= new InterfaceTriangle(monInterface);
		monInterface=new InterfaceSegment(monInterface);

		
		
		return monInterface;
	}

}

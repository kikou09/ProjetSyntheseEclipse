package COR;

public abstract class InterfaceForme {
	
	private InterfaceForme suivant=null;
	
	
	public InterfaceForme(InterfaceForme suivant) {
		this.suivant=suivant;
		
		
	}
	
	public InterfaceForme getSuivant() {
		
		return this.suivant;
	}
	
	
	public abstract boolean saitInteragir(Object choix);
	public abstract void executerInteraction(Object o);
	public abstract String getDescription();
	
	public void interagir(Object choix) throws Exception {
		
		if (saitInteragir(choix))
			executerInteraction(choix);
		else if (suivant != null)
			suivant.interagir(choix);
		else 
			throw new Exception("pas d'interaction pour"+ choix);
		
	}
	

}

package COR;

/**
 * Classe point , utile pour la transformation des coordonnees en monde-ecran
 * @author Jorane
 */
public class Point {
	
	private int x,y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

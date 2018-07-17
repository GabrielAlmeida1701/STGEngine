package Utils;

public class fVector2 {
	
	public float x, y;
	
	public fVector2() {
		x = 0;
		y = 0;
	}
	
	public fVector2(double x, double y) {
		this.x = (float) x;
		this.y = (float) y;
	}
	
	public static fVector2 add(Vector2 v1, Vector2 v2) {
		return new fVector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static fVector2 minus(Vector2 v1, Vector2 v2) {
		return new fVector2(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static fVector2 mult(Vector2 v1, float v2) {
		return new fVector2( (v1.x * v2), (v1.y * v2));
	}
	
	public static fVector2 mult(Vector2 v1, double v2) {
		return new fVector2( (v1.x * v2), (v1.y * v2));
	}
	
	public static fVector2 zero() {
		return new fVector2();
	}
	
	public static fVector2 one() {
		return new fVector2 (1,1);
	}
	
	@Override
	public String toString() {
		return "fVector2 ("+x+", "+y+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) return false;
		boolean verX = ((fVector2)obj).x == x;
		boolean verY = ((fVector2)obj).y == y;
		
		return verX && verY;
	}
}

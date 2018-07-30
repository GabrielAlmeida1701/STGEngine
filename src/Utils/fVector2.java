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
	
	public static fVector2 add(fVector2 v1, fVector2 v2) {
		return new fVector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static fVector2 add(fVector2 v1, Vector2 v2) {
		return new fVector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static fVector2 minus(fVector2 v1, fVector2 v2) {
		return new fVector2(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static fVector2 minus(fVector2 v1, Vector2 v2) {
		return new fVector2(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static fVector2 mult(fVector2 v1, float v2) {
		return new fVector2( (v1.x * v2), (v1.y * v2));
	}
	
	public static fVector2 mult(fVector2 v1, double v2) {
		return new fVector2( (v1.x * v2), (v1.y * v2));
	}
	
	public static fVector2 divide(fVector2 v1, float v2) {
		return new fVector2( (int)(v1.x / v2), (int)(v1.y / v2));
	}
	
	public static fVector2 divide(fVector2 v1, double v2) {
		return new fVector2( (int)(v1.x / v2), (int)(v1.y / v2));
	}
	
	public static fVector2 divide(Vector2 v1, float v2) {
		return new fVector2( (int)(v1.x / v2), (int)(v1.y / v2));
	}
	
	public static fVector2 zero() {
		return new fVector2();
	}
	
	public static fVector2 one() {
		return new fVector2 (1,1);
	}
	
	public static float dot(fVector2 v1, fVector2 v2) {
		return (v1.x * v2.x) + (v1.y * v2.y);
	}
	
	public static float angle(fVector2 v1, fVector2 v2) {
		return (dot(v1, v2) / (v1.magnitude() * v2.magnitude())) * 57.2958f;
	}
	
	
	public float magnitude() {
		return (float) Math.sqrt( (x*x) + (y*y) );
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

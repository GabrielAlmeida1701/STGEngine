package STG.Utils;

public class Vector2 {

	public int x, y;
	
	public Vector2() {
		x = 0;
		y = 0;
	}
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector2 add(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static Vector2 add(Vector2 v1, fVector2 v2) {
		return new Vector2(v1.x + ((int)v2.x), v1.y + ((int)v2.y));
	}
	
	public static Vector2 minus(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static Vector2 mult(Vector2 v1, float v2) {
		return new Vector2( (int)(v1.x * v2), (int)(v1.y * v2));
	}
	
	public static Vector2 mult(Vector2 v1, double v2) {
		return new Vector2( (int)(v1.x * v2), (int)(v1.y * v2));
	}
	
	public static Vector2 divide(Vector2 v1, float v2) {
		return new Vector2( (int)(v1.x / v2), (int)(v1.y / v2));
	}
	
	public static Vector2 divide(Vector2 v1, double v2) {
		return new Vector2( (int)(v1.x / v2), (int)(v1.y / v2));
	}
	
	public static Vector2 copy(Vector2 org) {
		return new Vector2(org.x, org.y);
	}
	
	public static Vector2 zero() {
		return new Vector2();
	}
	
	public static Vector2 one() {
		return new Vector2 (1,1);
	}
	
	public static int dot(Vector2 v1, Vector2 v2) {
		return (v1.x * v2.x) + (v1.y * v2.y);
	}
	
	public static int det(Vector2 v1, Vector2 v2) {
		return (v1.x * v2.x) - (v1.y * v2.y);
	}
	
	public static float angle(Vector2 v1, Vector2 v2) {
		return (float)(Math.atan2(det(v1, v2), dot(v1, v2)))*180;
	}
	
	
	public float magnitude() {
		return (float) Math.sqrt( (x*x) + (y*y) );
	}
	
	@Override
	public String toString() {
		return "Vector2 ("+x+", "+y+")";
	}
	 
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) return false;
		boolean verX = ((Vector2)obj).x == x;
		boolean verY = ((Vector2)obj).y == y;
		
		return verX && verY;
	}
}

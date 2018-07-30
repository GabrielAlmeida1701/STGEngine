package Utils;

public class Rect {

	public Vector2 position;
	public Vector2 size;
	
	public Rect(Vector2 position, Vector2 size) {
		this.position = position;
		this.size = size;
	}
	
	public Rect(int px, int py, int sx, int sy) {
		position = new Vector2(px, py);
		size = new Vector2(sx, sy);
	}
	
	public boolean InBounds(Vector2 vec) {
		/*Console.log("Vec "+vec);
		Console.log("Pos "+ position + " -- " +size);
		Console.log("======");*/
		
		return
		(vec.x >= position.x && vec.y >= position.y)
		&&
		(vec.x <= position.x + size.x &&
		 vec.y <= position.y + size.y);
	}
	
	public boolean InBounds(int x, int y) {
		return
		(x >= position.x && y >= position.y)
		&&
		(x <= position.x + size.x &&
		 y <= position.y + size.y);
	}
}

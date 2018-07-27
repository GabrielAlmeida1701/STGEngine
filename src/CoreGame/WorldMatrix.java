package CoreGame;

import java.awt.Dimension;

import Utils.Console;
import Utils.Vector2;
import Utils.fVector2;

public class WorldMatrix {
	
	private static fVector2 worldScale;
	
	public static void SetWorldScale(Dimension gameDim, Dimension screenDim) {
		fVector2 gd = new fVector2(gameDim.width, gameDim.height);
		fVector2 sd = new fVector2(screenDim.width, screenDim.height);
		
		worldScale = new fVector2(sd.x/gd.x, sd.y/gd.y);
		Console.log("Game to screen scale: " + worldScale);
	}

	public static Vector2 scale(Vector2 vec) {
		Vector2 res = new Vector2(
				(int) (vec.x * worldScale.x),
				(int) (vec.y * worldScale.y)
			);
		
		return res;
	}
	
	public static fVector2 fScale(Vector2 vec) {
		fVector2 res = new fVector2(
				(int) (vec.x * worldScale.x),
				(int) (vec.y * worldScale.y)
			);
		
		return res;
	}
}

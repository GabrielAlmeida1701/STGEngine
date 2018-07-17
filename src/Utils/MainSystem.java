package Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Base.Main;

public class MainSystem {

	public MainSystem() { ref = this; }
	
	public static MainSystem ref;
	
	public static double deltaTime;
	public static Vector2 Offset = Vector2.zero();
	public static boolean isPlaying;
	
	public static BufferedImage LoadSpriteAsset(String sprite) {
		return (BufferedImage) ref.LoadImage(sprite);
	}
	
	public static boolean CanUpdate() {
		return (Main.isEditor && isPlaying) || !Main.isEditor;
	}
	
	public Image LoadImage(String sprite) {
		try {
			return ImageIO.read(getClass().getResourceAsStream("/" + sprite));
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
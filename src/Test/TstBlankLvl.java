package Test;

import Components.Rotate;
import CoreGame.MapTileCtrl;
import STG_Object.Tile;
import Utils.Vector2;
import Utils.fVector2;

public class TstBlankLvl extends MapTileCtrl {

	public TstBlankLvl() { super("Blank Level"); }
	
	public void Start(){
		MapSize = new Vector2(400, 200);
		
		Tile tile = new Tile(0, "tst", "tst.png");
		tile.transform.position = new Vector2(60, 60);
		tile.transform.scale = new fVector2(.5f, .5f);
		tile.AddComponent(new Rotate(5));
		
		frTiles.add(tile);
	}
}

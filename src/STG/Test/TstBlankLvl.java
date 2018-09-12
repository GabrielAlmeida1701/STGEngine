package STG.Test;

import STG.Components.Rotate;
import STG.CoreGame.MapTileCtrl;
import STG.STG_Object.Tile;
import STG.Utils.Vector2;
import STG.Utils.fVector2;

public class TstBlankLvl extends MapTileCtrl {

	public TstBlankLvl() { super("Blank Level"); }
	
	public void Start(){
		MapSize = new Vector2(400, 200);
		
		Tile gran = new Tile(0, "tst", "tst.png");
		gran.transform.Position(Vector2.zero());
		gran.AddComponent(new Rotate(2));
		
		Tile tile = new Tile(0, "tst", "tst.png");
		tile.SetParent(gran);
		tile.transform.Position(new Vector2(60, 60));
		tile.transform.scale = new fVector2(.5f, .5f);
		tile.AddComponent(new Rotate(2));
		
		Tile child = new Tile(0, "tst-Child", "tst.png");
		child.SetParent(tile);
		child.transform.LocalPosition(new Vector2(75, 0));
		child.transform.scale = new fVector2(.5f, .5f);
		child.AddComponent(new Rotate(3));
		
		frTiles.add(gran);
		frTiles.add(tile);
		frTiles.add(child);
	}
}

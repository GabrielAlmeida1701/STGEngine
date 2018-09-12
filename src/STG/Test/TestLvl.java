package STG.Test;

import STG.Components.Move;
import STG.CoreGame.*;
import STG.STG_Object.Tile;
import STG.Utils.*;

public class TestLvl extends MapTileCtrl {

	public TestLvl() { super("Teste lvl 1"); }
	
	public void Start() {
		MapSize = new Vector2(600, 200);
		
		Tile tile = new Tile(0, "tst1", "tst.png");
		tile.transform.Position(new Vector2(50, 50));
		tile.transform.scale = new fVector2(.2f, .2f);
		tile.AddComponent(new Move());
		
		Tile tile2 = new Tile(0, "tst2", "tst.png");
		tile2.transform.Position(new Vector2(150, 100));
		tile2.transform.angle = 45f;
		
		frTiles.add(tile);
		frTiles.add(tile2);
	}
	
	float t = 0;
	int fi;
	public void Update() {
		t += MainSystem.deltaTime / 10;
		if(t > 10) {
			Tile tile = new Tile(0, "tst " + fi, "tst.png");
			tile.transform.Position(new Vector2(50, 50));
			tile.transform.scale = new fVector2(.2f, .2f);
			tile.AddComponent(new Move(2f));
			
			frTiles.add(tile);
			t = 0;
			fi++;
		}
	}
}

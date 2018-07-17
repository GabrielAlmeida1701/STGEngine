package Test;

import Components.Move;
import CoreGame.*;
import Utils.*;
import STG_Object.Tile;

public class TestLvl extends MapTileCtrl {

	public TestLvl() { super("Teste lvl 1"); }
	
	public void Start() {
		MapSize = new Vector2(600, 200);
		
		Tile tile = new Tile(0, "tst1", "tst.png");
		tile.transform.position = new Vector2(50, 50);
		tile.transform.scale = new fVector2(.2f, .2f);
		tile.AddComponent(new Move());
		
		Tile tile2 = new Tile(0, "tst2", "tst.png");
		tile2.transform.position = new Vector2(150, 100);
		
		frTiles.add(tile);
		frTiles.add(tile2);
	}
	
	float t = 0;
	int fi;
	public void Update() {
		t += MainSystem.deltaTime / 10;
		if(t > 10) {
			Tile tile = new Tile(0, "tst " + fi, "tst.png");
			tile.transform.position = new Vector2(50, 50);
			tile.transform.scale = new fVector2(.2f, .2f);
			tile.AddComponent(new Move(2f));
			
			frTiles.add(tile);
			t = 0;
			fi++;
		}
	}
}

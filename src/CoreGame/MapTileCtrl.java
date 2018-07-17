package CoreGame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import STG_Object.Tile;
import Utils.*;

public class MapTileCtrl {
    
    public String name;
    
    public List<Tile> bgTiles = new ArrayList<>(); //Background Layer
    public List<Tile> gmTiles = new ArrayList<>(); //Game Layer
    public List<Tile> frTiles = new ArrayList<>(); //Front Layer
    public List<Tile> uiTiles = new ArrayList<>(); //UI Layer
    
    public Vector2 MapSize;
    
    @SuppressWarnings("unused")
	private boolean firstFrame = true;
    
    public MapTileCtrl(String name) {
    	this.name = name;
    }
    
    public void Start(){
        Console.log("All threads have been initialized");
    }
    
    public void Unload(){
        firstFrame = true;
        
        bgTiles.clear();
        gmTiles.clear();
        frTiles.clear();
        uiTiles.clear();
    }
    
    public void Update() {}
    
    public void UpdateGraphics(Graphics g) {
    	if(MainSystem.CanUpdate())
    		Update();
    	
    	for(Tile tile : bgTiles) {
    		if(MainSystem.CanUpdate()) tile.Update();
    		tile.Render(g);
    	}
    	
    	for(Tile tile : gmTiles) {
    		if(MainSystem.CanUpdate()) tile.Update();
    		tile.Render(g);
    	}
    	
    	for(Tile tile : frTiles) {
    		if(MainSystem.CanUpdate()) tile.Update();
    		tile.Render(g);
    	}
    	
    	for(Tile tile : uiTiles) {
    		if(MainSystem.CanUpdate()) tile.Update();
    		tile.Render(g);
    	}
    }
}
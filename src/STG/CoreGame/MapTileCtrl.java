package STG.CoreGame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import STG.STG_Object.Tile;
import STG.Utils.*;

public class MapTileCtrl {
    
    public String name;
    
    public List<Tile> bgTiles = new ArrayList<>(); //Background Layer
    public List<Tile> gmTiles = new ArrayList<>(); //Game Layer
    public List<Tile> frTiles = new ArrayList<>(); //Front Layer
    public List<Tile> uiTiles = new ArrayList<>(); //UI Layer
    
    private Thread updateThread;
    private Thread renderThread;
    private Thread physicThread;
    private Graphics g;
    
    public Vector2 MapSize;
    
    @SuppressWarnings("unused")
	private boolean firstFrame = true;
    
    public MapTileCtrl(String name) {
    	this.name = name;
    	
    	updateThread = new Thread(UpdateLayers);
    	renderThread = new Thread(RenderLayers);
    	physicThread = new Thread(PhysicsLayer);
    }
    
    public void Start(){
    	physicThread.start();
    	updateThread.start();
    	renderThread.start();
        Console.log("All threads have been initialized");
    }
    
    public void Update() {}
    
    public void Unload(){
        firstFrame = true;
        
        bgTiles.clear();
        gmTiles.clear();
        frTiles.clear();
        uiTiles.clear();
        
        updateThread.interrupt();
        renderThread.interrupt();
        physicThread.interrupt();
    }
    
    public void ThreadUpdate(Graphics g) {
    	this.g = g;

    	physicThread.run();
    	updateThread.run();
    	renderThread.run();
    }
    
    public Runnable PhysicsLayer = new Runnable() {
		public void run() {
		}
	};    
    public Runnable UpdateLayers = new Runnable() {
		public void run() {
			if(!MainSystem.CanUpdate()) return;
			
			Update();
			for(Tile tile : bgTiles) tile.Update();
	    	for(Tile tile : gmTiles) tile.Update();
	    	for(Tile tile : frTiles) tile.Update();
	    	for(Tile tile : uiTiles) tile.Update();
		}
	};
    
	public Runnable RenderLayers = new Runnable() {
		public void run() {
	    	for(Tile tile : bgTiles) tile.Render(g);
	    	for(Tile tile : gmTiles) tile.Render(g);
	    	for(Tile tile : frTiles) tile.Render(g);
	    	for(Tile tile : uiTiles) tile.Render(g);
		}
	};
}
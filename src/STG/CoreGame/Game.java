package STG.CoreGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import STG.STG_Object.Camera;
import STG.Utils.Console;
import STG.Utils.Vector2;

public class Game {
    
    private static List<MapTileCtrl> levels = new ArrayList<>();
    private static int crrLvl = 0;
    public static Camera camera = new Camera();
    
    public static void LoadLevel(int lvl){
        if(lvl >= levels.size()) {
            Console.alert("The level " + lvl + " you tried to load dons not exist");
            return;
        }
        
        levels.get(crrLvl).Unload();
        
        crrLvl = lvl;
        levels.get(crrLvl).Start();
        
        Console.log("Level " + levels.get(crrLvl).name + " has been initialized");
    }
    
    public static int LevelCount () { return levels.size(); }
    
    public static int GetCurrentLvlID() { return crrLvl; }
    
    public static MapTileCtrl GetCurrentLvl() {
    	if(levels.size() == 0) return null;
    	return levels.get(crrLvl);
    }
    
    public static MapTileCtrl GetLvl(int lvl) {
    	if(levels.size() == 0) return null;
    	if(lvl >= LevelCount()) return null;
    	
    	return levels.get(lvl);
    }
    
    public static void AddLevel(MapTileCtrl lvl){
        levels.add(lvl);
    }
    
    public static void RemoveLevel (int lvl) {
    	RemoveLevel(levels.get(lvl));
    }
    
    public static void RemoveLevel(MapTileCtrl lvl){
    	if(levels.size() == 0) return;
    	levels.remove(lvl);
    }
    
    public static void ReloadLevel(int lvl) {
    	if(levels.size() == 0) return;
    	if(lvl >= LevelCount()) return;
    	
    	camera.transform.Reset();
    	LoadLevel(lvl);
    }
    
    public static void Update(Graphics g) {
    	if(levels.size() == 0) return;
    	//levels.get(crrLvl).UpdateGraphics(g);
    	levels.get(crrLvl).ThreadUpdate(g);
    	camera.Update();
    }
    
    public static Vector2 MapSize() {
    	if(levels.size() == 0) return Vector2.one();
    	return levels.get(crrLvl).MapSize;
    }
}
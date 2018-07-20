package Base;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import CoreGame.Game;
import CoreGame.Input;
import Editor.EditorGamePanelnput;
import Editor.Views.HierarchyView;
import GameFileSystem.GameBaseConfigs;
import GameFileSystem.GameSettings;
import Test.TestLvl;
import Utils.*;

@SuppressWarnings("serial")
public class GamePanel extends Canvas implements Runnable {
	
    Thread thread;
    BufferStrategy bs;
    Graphics2D g;
    
    public BufferedImage fnd;
    public boolean running;
    public Vector2 offset;
    
    private GameBaseConfigs configs;
    private EditorGamePanelnput egpi;
    
    public GamePanel() {
        addMouseListener(Main.input);
        addMouseMotionListener(Main.input);
        addMouseWheelListener(Main.input);
        
        fnd = MainSystem.LoadSpriteAsset("bg.png");
        configs = GameSettings.GetGameBaseConfigs();
        offset = new Vector2();
        
        if(Main.isEditor)
        	egpi = new EditorGamePanelnput();
    }
    
    @Override
    public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
    } 
    
    public void init(){
    	CalcBufferStrategy(2);
    	
    	g.getDeviceConfiguration()
    	.createCompatibleImage(
    			configs.StartResolution.width,
        		configs.StartResolution.height,
    			Transparency.BITMASK
			);
    	
        Input.StartAxis();
        LoadLevels();
        running = true;
    }
    
    public void CalcBufferStrategy(int buffer) {
    	createBufferStrategy(buffer);
		bs = getBufferStrategy();
    	
        g = (Graphics2D) bs.getDrawGraphics();
    }
    
    public void LoadLevels() {
    	//TEST SPRITE DEV-ONLY
        if(Game.LevelCount() == 0) {
	        Game.AddLevel(new TestLvl());
	        Game.LoadLevel(0);
	        
        } else {
        	Game.ReloadLevel(Game.GetCurrentLvlID());
        }
        
        //LoadLevels
    }
    
    @Override
    public void run() {
        init();
        
        double lastFPSTime = 0;
        int fps = 0, dispFps = 0;
        long lastLoopTime = System.nanoTime();
        final int TG_FPS = 90;
        final long OPTIMAL_TIME = 1000000000 / TG_FPS;
        
        while(running) {
        	long now = System.nanoTime();
        	long updateLength = now - lastLoopTime;
        	lastLoopTime = now;
        	MainSystem.deltaTime = updateLength / ((double) OPTIMAL_TIME);
        	
        	lastFPSTime += updateLength;
        	fps++;
        	
        	if(lastFPSTime >= 1000000000) {
        		dispFps = fps;
        		lastFPSTime = 0;
        		fps = 0;
        	}
        	//Update Input
        	Input.UpdateInput();
        	
        	//Update Word Offset
        	Vector2 bgPos;
        	if(Main.isEditor) {
        		CalculateOffsetCtrl();
        		HierarchyView.me.LoadHierarchy();
        		egpi.Click();
        	}
        	
        	bgPos = Vector2.minus(
        			offset, 
        			Game.camera.transform.position);
        	MainSystem.Offset = bgPos;
        	
        	//Draw drawable area
        	g.drawImage(
        			fnd,
        			bgPos.x,
        			bgPos.y,
        			Game.MapSize().x,
        			Game.MapSize().y,
        			null
    			);
        	
        	//Update and Draw level
        	Game.Update(g);
        	
        	//Draw FPS Counter
        	if(Main.isEditor) g.clearRect(0, 0, 45, 10);
        	g.setFont(EditorDefaults.defaultEditor_font);
        	g.drawString("FPS: " + dispFps, 5, 10);
        	
        	if(Main.isEditor) {
	        	Game.camera.DrawCamera(g, bgPos, configs.StartResolution);
	        	egpi.Draw(g);
        	}
        	
        	//g.dispose();
    		bs.show();
    		
        	try {
        		long waitTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME)/1000000;
        		waitTime = waitTime <= 0 ? 10 : waitTime;
        		Thread.sleep( waitTime );
        		
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        
        thread = null;
    }
    
    void CalculateOffsetCtrl() {
    	if(Input.GetMouseButton(2)) {
    		offset = Vector2.add(offset, Input.GetMouseAxis());
    		repaint();
    	}
    	
    	if(Input.GetMouseButtonDown(2)) CalcBufferStrategy(1);
    	if(Input.GetMouseButtonUp(2)) CalcBufferStrategy(2);
    }
}

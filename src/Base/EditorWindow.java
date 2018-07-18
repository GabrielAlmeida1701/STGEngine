package Base;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import Editor.Views.*;
import GameFileSystem.GameBaseConfigs;
import GameFileSystem.GameSettings;
import Utils.MainSystem;

@SuppressWarnings("serial")
public class EditorWindow extends JFrame {
    
    public GameBaseConfigs gameConfig;
    
    public GamePanel gamePanel;
    
    public EditorWindow(){
        setLayout(null);
        SetMenu();
    	
        //EditorConfigs configs = GameSettings.GetEditorConfigs();
        gameConfig = GameSettings.GetGameBaseConfigs();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Story Maker Editor -- Current Project: " + gameConfig.gameName);
        
        OpenGameWindow();
        OpenHierarchyWindow();
        
        setPreferredSize(new Dimension(600, 500));
        
        pack();
    }
    
    private void SetMenu() {
    	JMenuBar bar = new JMenuBar();
    	
    	JMenu file = new JMenu("File");

    	JMenu window = new JMenu("Window");
    	JMenuItem game = new JMenuItem("Game");
    	JMenuItem hier = new JMenuItem("Hierarchy");
    	JMenuItem prop = new JMenuItem("Properties");
    	game.addActionListener((ActionEvent) -> OpenGameWindow());
    	hier.addActionListener((ActionListener) -> OpenHierarchyWindow());
    	prop.addActionListener((ActionEvent) -> OpenPropertiesWindow());
    	window.add(game);
    	window.add(hier);
    	window.add(prop);
    	
    	JMenu gameM = new JMenu("Game");
    	JMenuItem play = new JMenuItem("Play");
    	JMenuItem pause = new JMenuItem("Pause");
    	JMenuItem stop = new JMenuItem("Stop");
    	play.addActionListener((ActionEvent) -> { MainSystem.isPlaying = true; });
    	pause.addActionListener((ActionEvent) -> { MainSystem.isPlaying = false; });
    	stop.addActionListener((ActionEvent) -> {
    		MainSystem.isPlaying = false;
			gv.ReloadGame();
    	});
    	
    	gameM.add(play);
    	gameM.add(pause);
    	gameM.add(stop);
    	
    	bar.add(file);
    	bar.add(window);
    	bar.add(gameM);
    	
    	setJMenuBar(bar);
    }
    
    GameView gv;
    private void OpenGameWindow() {
    	if(gv == null) gv = new GameView(gameConfig);
    	else {
    		gv = null;
    		gv = new GameView(gameConfig);
    	}
    	
        add(gv);
    }
    
    HierarchyView hv;
    private void OpenHierarchyWindow() {
    	if(hv == null) hv = new HierarchyView();
    	else {
    		hv = null;
    		hv = new HierarchyView();
    	}
    	
        add(hv);
    }
    
    PropertiesView pv;
    private void OpenPropertiesWindow() {
    	if(pv == null) pv = new PropertiesView();
    	else {
    		pv = null;
    		pv = new PropertiesView();
    	}
    	
        add(pv);
    }
}
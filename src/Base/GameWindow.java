package Base;

import java.awt.Dimension;

import javax.swing.*;

import GameFileSystem.*;
import Utils.Console;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	Dimension tool = getToolkit().getScreenSize();
	public static boolean isPlaying;
	
	public GameWindow(){
        
        GameBaseConfigs configs = GameSettings.GetGameBaseConfigs();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(configs.gameName);
        
        if(configs.StartFullscreen){
            setExtendedState(JFrame.MAXIMIZED_BOTH); 
            setUndecorated(true);
            
        } else {
        	Console.log("Game Start: " + configs.StartResolution);
        	
            setSize(configs.StartResolution.width, configs.StartResolution.height);
            setPreferredSize(configs.StartResolution);
            setLocation( (tool.width/2)-(getSize().width/2) , (tool.height/2)-(getSize().height/2) );
        }
        
        add(new GamePanel());
        
        pack();
    }
}
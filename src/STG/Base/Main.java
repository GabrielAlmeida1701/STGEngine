package STG.Base;

import javax.swing.*;

import STG.CoreGame.Input;
import STG.Utils.MainSystem;

public class Main {
    
    public static boolean isEditor = true;
    public static Input input;
    
    public static void main(String[] args){
    	new MainSystem();
    	input = new Input();
    	
    	System.setProperty("-Dsun.java2d.opengl","true");
    	System.setProperty("-Dsun.java2d.pmoffscreen","true");
    	
        JFrame mainWindow;
        if(isEditor)
            mainWindow = new EditorWindow();
        else
            mainWindow = new GameWindow();
        
        mainWindow.setVisible(true);
    } 
}
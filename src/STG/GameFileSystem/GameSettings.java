package STG.GameFileSystem;

import java.awt.Dimension;

import STG.Utils.Console;

public class GameSettings {
    
    public static EditorConfigs GetEditorConfigs(){ return null; }
    
    //public static EditorUserConfigs GetEditorUserConfigs(){ return null; }
    
    public static GameBaseConfigs GetGameBaseConfigs(){
    	GameBaseConfigs configs = new GameBaseConfigs();
    	configs.gameName = "Teste";
        configs.StartFullscreen = false;
        configs.StartResolution = new Dimension(400, 200);
        
        Console.log("Using Test Game Settings");
        
        return configs;
    }
    
    //public static GameCustomConfigs GetGameCustomConfigs(){ return null; }
    
    //public static GameUserConfigs GetGameUserConfigs(){ return null; }
    
    
    public static void SetEditorConfigs(EditorConfigs configs){}
    
    //public static void SetEditorUserConfigs(EditorUserConfigs configs){}
    
    public static void SetGameBaseConfigs(GameBaseConfigs configs){}
    
    //public static void SetGameCustomConfigs(GameCustomConfigs configs){}
    
    //public static void SetGameUserConfigs(GameUserConfigs configs){}
    
}
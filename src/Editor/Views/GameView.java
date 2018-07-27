package Editor.Views;

import Base.GamePanel;
import CoreGame.WorldMatrix;
import Editor.WindowsType.BaseWindow;
import GameFileSystem.GameBaseConfigs;
import Utils.*;

@SuppressWarnings("serial")
public class GameView extends BaseWindow {

	private GamePanel gamePanel;
	
	public GameView(GameBaseConfigs config) {
		super("Game");
		
		setSize(config.StartResolution);
		setLocation(210,0);
		WorldMatrix.SetWorldScale(config.StartResolution, getSize());
		
		gamePanel = new GamePanel();
		add(gamePanel);
	}
	
	public void ReloadGame() {
		if(gamePanel == null) return;
		gamePanel.LoadLevels();
	}
	
	public GamePanel GetGamePanel() { return gamePanel; }
	
	protected void OnWindowResizeBegin() {
		if(gamePanel == null) return;
		gamePanel.CalcBufferStrategy(1);
	}
	
	protected void OnWindowResizeEnd() {
		if(gamePanel == null) return;
		gamePanel.CalcBufferStrategy(2);
	}
	
	protected void OnWindowClose() {
		gamePanel.running = false;
		MainSystem.isPlaying = false;
		remove(gamePanel);
		gamePanel = null;
	}
}

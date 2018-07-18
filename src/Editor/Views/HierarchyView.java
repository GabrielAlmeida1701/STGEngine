package Editor.Views;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import CoreGame.Game;
import CoreGame.MapTileCtrl;
import Editor.UI.Button;
import Editor.WindowsType.Window;
import STG_Object.Tile;
import Utils.Console;

@SuppressWarnings("serial")
public class HierarchyView extends Window {

	public static HierarchyView me;
	
	private final String[] labels = {"Back", "Game", "Front", "UI"};
	private int[] counts = new int[4];
	private JButton[] menus = new JButton[4];
	private List<Button> gameObjs = new ArrayList<>();
	
	public HierarchyView() {
		super("Hierarchy");
		
		setLayout(null);
		setSize(210,370);
		
		bg.setSize(210, 400);
		bg.setLocation(0, 30);

		for(int i=0; i<menus.length; i++) {
			menus[i] = new JButton(labels[i]);
			menus[i].setLocation(i*((getWidth()-10)/4), 0);
			menus[i].setSize(((getWidth()-10)/4), 20);
			menus[i].setMargin(new Insets(0, 0, 0, 0));
			add(menus[i]);
		}

		me = this;
	}
	
	public void LoadHierarchy() {
		if(Game.LevelCount() == 0) return;
		MapTileCtrl map = Game.GetCurrentLvl();
		if(map == null) return;
		
		if(counts[1] != map.frTiles.size()) {
			bg.clear();
			gameObjs.clear();
			int i = 0;
			for(Tile t : map.frTiles) {
				@SuppressWarnings("unused")
				int id = i;
				Button b = new Button(t.name);
				b.SetPosition(0, i*21);
				b.SetSize(getWidth()-5, 20);
				b.AddAction(() -> {
					Console.log(t.name + " Selected");
					
					/*map.frTiles.remove(t);
					gameObjs.remove(b);
					bg.remove(b.uuid);*/
				});
				gameObjs.add(b);
				bg.add(b);
				i++;
			}
			counts[1] = map.frTiles.size();
		}
	}
	
	protected void OnWindowResize() {
		if(me == null) return;
		super.OnWindowResize();
		
		for(int i=0; i<menus.length; i++) {
			menus[i].setLocation(i*((getWidth()-10)/4), 0);
			menus[i].setSize(((getWidth()-10)/4), 20);
			menus[i].setMargin(new Insets(0, 0, 0, 0));
		}
		
		int i=0;
		for(Button j : gameObjs) {
			j.SetPosition(0, i*21);
			j.SetSize(getWidth()-5, 20);
			i++;
		}
	}
}

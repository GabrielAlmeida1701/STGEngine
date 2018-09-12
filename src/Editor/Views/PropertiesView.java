package Editor.Views;

import java.awt.Graphics;

import Editor.WindowsType.Window;
import STG.STG_Object.Tile;

@SuppressWarnings("serial")
public class PropertiesView extends Window {
	
	public static PropertiesView me;
	
	public PropertiesView() {
		super("Properties");
		
		setLayout(null);
		setSize(210,170);
		setLocation(210, 200);
		
		bg.setSize(210, 170);
		
		me = this;
	}
	
	public void OnDraw(Graphics g) {
		if(me == null) return;
		if(HierarchyView.selectedTile == null) return;
		
		Tile t = HierarchyView.selectedTile;
		
		g.drawString(t.name, 15, 15);
		
		if(t.transform.parent == null){
			g.drawString("Postition: " + t.transform.Position().toString(), 15, 25);
			g.drawString("Angle: " + t.transform.angle, 15, 35);
			
		} else {
			g.drawString("Local Postition: " + t.transform.LocalPosition().toString(), 15, 25);
			g.drawString("Postition: " + t.transform.Position().toString(), 15, 35);
			//g.drawString("Angle: " + t.transform.localAngle, 15, 35);
		}
		
		g.drawString("Scale: " + t.transform.scale.toString(), 15, 45);
		
		bg.repaint();
	}
	
	public void Reload() { bg.repaint(); }
}

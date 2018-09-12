package Editor.UI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import STG.Utils.*;

public class Button extends UIElement {

	private BufferedImage selected, normal;
	private boolean isSelected;
	private List<Action> actions = new ArrayList<>();
	
	public Button(String name) {
		LoadSprites();
		rect = new Rect(0, 0, 0, 0);
		this.name = name;
	}
	
	public Button(String name, boolean canSelect) {
		LoadSprites();
		rect = new Rect(0, 0, 0, 0);
		this.name = name;
		this.canSelect = canSelect;
	}
	
	public Button(String name, boolean canSelect, boolean isSelected) {
		LoadSprites();
		rect = new Rect(0, 0, 0, 0);
		this.name = name;
		this.canSelect = canSelect;
		this.isSelected = isSelected;
	}
	
	public Button(String name, Rect rect) {
		LoadSprites();
		this.rect = rect;
		this.name = name;
	}
	
	public void SetPosition(Vector2 position) {
		rect.position = position;
	}
	
	public void SetPosition(int x, int y) {
		rect.position = new Vector2(x, y);
	}
	
	public void SetSize(Vector2 size) {
		rect.size = size;
	}
	
	public void SetSize(int x, int y) {
		rect.size = new Vector2(x, y);
	}
	
	public void Draw(Graphics2D g) {
		BufferedImage img = (isSelected)? selected : normal;
		g.drawRect(
				rect.position.x,
				rect.position.y,
				rect.size.x,
				rect.size.y
				);
		
		g.drawImage(
				img,
				rect.position.x,
				rect.position.y,
				rect.size.x,
				rect.size.y,
				null
			);
		
		g.drawString(
				name,
				rect.position.x + 5,
				rect.position.y +
				rect.size.y / 2 +
				g.getFont().getSize() / 2
			);
	}
	
	public void MouseClick(int mBnt) {
		super.MouseClick(mBnt);
		isSelected = mouseHover;
		if(!mouseHover) return;
		
		for(Action a : actions) a.run();
	}
	
	public void MouseOn() {
		if(!mouseHover) return;
		parent.hoverElement = true;
	}
	
	public void AddAction(Action a) {
		actions.add(a);
	}
	
	private void LoadSprites() {
		selected = new BufferedImage(1,1,BufferedImage.TYPE_INT_BGR);
		selected.setRGB(0, 0, EditorDefaults.selectEditor_Bnt.getRGB());
		
		normal = new BufferedImage(1,1,BufferedImage.TYPE_INT_BGR);
		normal.setRGB(0, 0, EditorDefaults.defaultEditor_Bnt.getRGB());
	}
}

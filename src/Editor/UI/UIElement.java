package Editor.UI;

import java.awt.Graphics2D;
import java.util.UUID;

import CoreGame.Input;
import Utils.*;

public class UIElement {

	public UUID uuid = UUID.randomUUID();
	
	public String name;
	protected Rect rect;
	protected Panel parent;
	protected boolean canSelect = true;
	
	protected boolean mouseHover = false;
	
	public void Draw(Graphics2D g) {}
	
	public void MouseClick(int mBnt) {
		mouseHover = rect.InBounds(Input.mousePosition);
	}
	
	public void MouseOn() {}
	
	public void MouseOut() {}
	
	public void MouseMove() {
		mouseHover = rect.InBounds(Input.mousePosition);
		if(mouseHover) MouseOn();
		else MouseOut();
	}
	
	public void SetParent(Panel parent) {
		this.parent = parent;
	}
}

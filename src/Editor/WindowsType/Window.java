package Editor.WindowsType;

import Editor.UI.Panel;

@SuppressWarnings("serial")
public class Window extends BaseWindow {

	protected Panel bg;
	
	public Window(String wName) {
		super(wName);
		
		bg = new Panel();
		bg.setSize(getWidth(), getHeight());
		bg.setLocation(0, 0);
		bg.SetParent(this);
		add(bg);
	}

	protected void OnWindowResize() {
		if(bg == null) return;
		bg.setSize(getWidth(), getHeight());
		bg.repaint();
	}
}

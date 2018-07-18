package Editor.Views;

import Editor.WindowsType.Window;
import Utils.Console;

@SuppressWarnings("serial")
public class PropertiesView extends Window {
	
	public PropertiesView() {
		super("Properties");
		
		setLayout(null);
		setSize(210,370);
		setLocation(210, 200);
		
		bg.setSize(210, 400);
	}

	protected void OnWindowResize() {
		Console.log(getLocation());
	}
}

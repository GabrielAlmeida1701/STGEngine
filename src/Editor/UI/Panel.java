package Editor.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.UUID;

import javax.swing.JPanel;

import Base.Main;
import Utils.*;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	BufferedImage img;
	private List<UIElement> elements = new ArrayList<>();
	
	public boolean hoverElement;
	
	public Panel() {
		addMouseListener(Main.input);
        addMouseMotionListener(Main.input);
        addMouseWheelListener(Main.input);
        
        img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        img.setRGB(0, 0, EditorDefaults.defaultEditor.getRGB());
	}
	
	public void add(UIElement elemt) {
		elemt.SetParent(this);
		elements.add(elemt);
		repaint();
	}
	
	public void remove(UUID uuid) {
		elements.removeIf(b -> b.uuid == uuid);
		repaint();
	}
	
	public void clear() {
		elements.clear();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		
		if(elements == null || g == null) return;
		for(UIElement e : elements)
			e.Draw((Graphics2D)g);
	}
	
	public void MouseClick(int mBnt){
		if(elements == null) return;
		try {
			for(UIElement e : elements)
				e.MouseClick(mBnt);
		}catch(ConcurrentModificationException e) {}
	}
	
	public void MouseMove() {
		if(elements == null) return;
		try {
			hoverElement = false;
			for(UIElement e : elements) e.MouseMove();
			
			if(hoverElement)
				setCursor(EditorDefaults.cursor_hand);
			else
				setCursor(EditorDefaults.cursor_default);
			
		}catch(ConcurrentModificationException e) {}
	}
}

package Editor.WindowsType;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JInternalFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BaseWindow extends JInternalFrame implements ComponentListener {

	private Timer timer;
	private boolean isResizing;
	
	public BaseWindow(String wName) {
		super(wName);
		addComponentListener(this);
		
		setMinimumSize(new Dimension(100, 100));
		setPreferredSize(getMinimumSize());
		setResizable(true);
        setClosable(true);
        setLocation(0, 0);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		timer = new Timer(200, (ActionEvent) -> {
			OnWindowResizeEnd();
			isResizing = false;
		});
        timer.setRepeats(false);
        timer.setCoalesce(false);
        
        setVisible(true);
	}
	
	@Override
	public void componentMoved(ComponentEvent e) {}
	
	@Override
	public void componentHidden(ComponentEvent e)
	{ OnWindowClose(); }

	@Override
	public void componentResized(ComponentEvent e) {
		if(timer == null) {
			timer = new Timer(200, (ActionEvent) -> {
				OnWindowResizeEnd();
				isResizing = false;
			});
	        timer.setRepeats(false);
	        timer.setCoalesce(false);
		}
		timer.restart();
		OnWindowResize();
		
		if(!isResizing) {
			OnWindowResizeBegin();
			isResizing = true;
		}
	}

	@Override
	public void componentShown(ComponentEvent e)
	{ OnWindowShow(); }
	
	
	protected void OnWindowShow() {}
	
	protected void OnWindowResizeBegin() {}
	
	protected void OnWindowResize() {}
	
	protected void OnWindowResizeEnd() {}
	
	protected void OnWindowClose() {}
}

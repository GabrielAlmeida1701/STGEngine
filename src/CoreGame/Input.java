package CoreGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import Editor.UI.Panel;
import Utils.*;

public class Input implements MouseListener, MouseInputListener, MouseMotionListener, MouseWheelListener{

	private static boolean[] mouseBnts = new boolean[3];
	private static boolean[] mouseBntsDown = new boolean[3];
	private static boolean[] mouseBntsUp = new boolean[3];
	
	private Timer whellT;
	
	public static Vector2 mousePosition = new Vector2();
	public static int blob;
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() instanceof Panel)
			((Panel)e.getComponent()).MouseClick(e.getButton());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mousePosition.x = e.getX();
		mousePosition.y = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition.x = e.getX();
		mousePosition.y = e.getY();
		
		if(e.getComponent() instanceof Panel)
			((Panel)e.getComponent()).MouseMove();
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(whellT == null) {
			whellT = new Timer(200, (ActionEvent) -> {
				blob = 0;
			});
	        whellT.setRepeats(false);
	        whellT.setCoalesce(false);
		}
		whellT.restart();
		
		blob = e.getWheelRotation();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseBntsDown[e.getButton() - 1] = true;
		mouseBnts[e.getButton() - 1] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseBntsUp[e.getButton() - 1] = true;
		mouseBnts[e.getButton() - 1] = false;
	}

	
	//STG Engine Functions
	
	public static boolean GetMouseButton(int bnt) {
		if(bnt > 2) return false;
		return mouseBnts[bnt];
	}
	
	public static boolean GetMouseButtonDown(int bnt) {
		if(bnt > 2) return false;
		boolean res = mouseBntsDown[bnt];
		mouseBntsDown[bnt] = false;
		
		return res;
	}
	
	public static boolean GetMouseButtonUp(int bnt) {
		if(bnt > 2) return false;
		boolean res = mouseBntsUp[bnt];
		mouseBntsUp[bnt] = false;
		
		return res;
	}
	
	private static fVector2 str = new fVector2();
	private static fVector2 prev = new fVector2();
	private static fVector2 axis = new fVector2();
	
	public static void StartAxis() {
		str = new fVector2(mousePosition.x, mousePosition.y);
		prev = fVector2.minus(str, mousePosition);
		prev.x *= -1;
	}
	
	private static void RunMouseAxis() {
		fVector2 dif = fVector2.minus(str, mousePosition);
		dif.x *= -1;

		if(!prev.equals(dif)) {
			fVector2 dist = fVector2.minus(prev, dif);
			axis = fVector2.mult(dist, MainSystem.deltaTime);
			axis.x *= -1;
			
			prev = dif;
		} else
			axis = fVector2.zero(); 
	}
	
	public static fVector2 GetMouseAxis() { return axis; }
	
	
	public static void UpdateInput() {
		RunMouseAxis();
	}
}

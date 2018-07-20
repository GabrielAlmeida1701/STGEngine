package Editor;

import java.awt.Color;
import java.awt.Graphics2D;

import CoreGame.Input;
import Editor.Views.HierarchyView;
import Utils.*;

public class EditorGamePanelnput {
	
	private Rect xAxis;
	private Rect yAxis;
	
	private boolean editing;
	private int axis;
	
	public EditorGamePanelnput() {
		xAxis = new Rect(100, 100, 35, 5);
		yAxis = new Rect(100, 100, 5, 35);
	}
	
	public void Click() {
		if(!Input.GetMouseButton(0) && !editing) return;
		if(HierarchyView.selectedTile == null) return;
		
		if(xAxis.InBounds(Input.mousePosition) && !editing) {
			editing = true;
			axis = 1;
		}
		
		if(yAxis.InBounds(Input.mousePosition) && !editing) {
			editing = true;
			axis = 2;
		}
		
		if(axis == 1) {
			HierarchyView.selectedTile
				.transform.position.x +=
					Input.GetMouseAxis().x;
		}
		
		if(axis == 2) {
			HierarchyView.selectedTile
				.transform.position.y +=
					Input.GetMouseAxis().y;
		}
		
		if(Input.GetMouseButtonUp(0)) editing = false;
	}
	
	public void Draw(Graphics2D g) {
		Color t = g.getColor();
		if(HierarchyView.selectedTile == null || editing) return;
		
		g.setColor(Color.red);
		g.fillRect(
				xAxis.position.x,
				xAxis.position.y,
				xAxis.size.x,
				xAxis.size.y
			);
		
		g.setColor(Color.green);
		g.fillRect(
				yAxis.position.x,
				yAxis.position.y,
				yAxis.size.x,
				yAxis.size.y
			);
		
		g.setColor(t);
	}
	
}

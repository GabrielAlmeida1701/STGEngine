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
		
		Vector2 mouse = Vector2.minus(
				Input.mousePosition, 
				MainSystem.Offset);
		
		if(xAxis.InBounds(mouse) && !editing) {
			editing = true;
			axis = 1;
		}
		
		/*if(yAxis.InBounds(mouse) && !editing) {
			editing = true;
			axis = 2;
		}*/
		
		if(axis == 1) {
			HierarchyView.selectedTile
				.transform.position.x =
					Vector2.add(MainSystem.Offset,
							Input.mousePosition).x;
		}
		
		if(axis == 2) {
			HierarchyView.selectedTile
				.transform.position.y =
					Vector2.add(MainSystem.Offset,
						Input.mousePosition).y;
		}
		
		if(Input.GetMouseButtonUp(0)) editing = false;
	}
	
	public void Draw(Graphics2D g) {
		Color t = g.getColor();
		if(HierarchyView.selectedTile == null || editing) return;
		
		Vector2 pos = Vector2.add(
				HierarchyView.selectedTile.transform.position,
				MainSystem.Offset
				);
		
		xAxis.position = pos;
		yAxis.position = pos;
		
		g.setColor(Color.red);
		g.fillRect(
				pos.x,
				pos.y,
				xAxis.size.x,
				xAxis.size.y
			);
		
		g.setColor(Color.green);
		g.fillRect(
				pos.x,
				pos.y,
				yAxis.size.x,
				yAxis.size.y
			);
		
		g.setColor(t);
	}
	
}

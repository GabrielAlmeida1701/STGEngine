package Editor;

import java.awt.Color;
import java.awt.Graphics2D;

import Editor.Views.HierarchyView;
import STG.CoreGame.Input;
import STG.STG_Object.Tile;
import STG.Utils.*;

public class EditorGamePanelnput {
	
	public enum ToolType {
		Move, Scale, Rotate
	}
	
	public ToolType tool = ToolType.Move;
	
	private Rect xAxis;
	private Rect yAxis;
	
	private boolean editing;
	private int axis;
	private Tile tile;
	
	public EditorGamePanelnput() {
		xAxis = new Rect(100, 100, 35, 5);
		yAxis = new Rect(100, 100, 5, 35);
	}
	
	float angStart;
	public void Click() {
		float s = MainSystem.WorldScale;
		s -= Input.blob * .01f;
		MainSystem.WorldScale = s;
		
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
		
		switch (tool) {
		case Move:
			Move();
			break;
		case Rotate:
			Rotate();
			break;
		case Scale:
			Scale();
			break;
		}
		
		if(Input.GetMouseButtonUp(0)) {
			editing = false;
			axis = 0;
		}
	}
	
	Vector2 t = Vector2.zero();
	private void Move() {
		if(Input.GetMouseButtonDown(0)) {
			t = Vector2.divide(
					Vector2.minus(
							Vector2.add(tile.transform.Position(), MainSystem.Offset),
							Input.mousePosition),
					MainSystem.WorldScale
				);
		}
		
		if(axis == 1) {
			Vector2 p = tile.transform.Position();
			p.x = -(int)((Vector2.minus(MainSystem.Offset, Input.mousePosition)).x / MainSystem.WorldScale); 
			tile.transform.Position(p);
		}
		
		if(axis == 2) {
			Vector2 p = tile.transform.Position();
			p.y = -(int)((Vector2.minus(MainSystem.Offset, Input.mousePosition)).y / MainSystem.WorldScale);
			tile.transform.Position(p);
		}
	}
	
	private void Rotate() {
		if(Input.GetMouseButtonDown(0)) {
			angStart = HierarchyView.selectedTile
					.transform.angle;
		}
		
		if(Input.GetMouseButton(0)) {
			float angEnd = Vector2.angle(xAxis.position,
					Input.mousePosition);
			
			float angle = (angStart - angEnd);
			if(angle < 0) angle += 180; 
			
			HierarchyView.selectedTile
				.transform.angle = angle;
		}
	}
	
	private void Scale() {
		if(axis == 1)
			HierarchyView.selectedTile.transform.scale.x += (Input.GetMouseAxis().x) * .01f;
		
		if(axis == 2)
			HierarchyView.selectedTile.transform.scale.y += (Input.GetMouseAxis().y) * .01f;
	}
	
	public void Draw(Graphics2D g) {
		Color t = g.getColor();
		if(HierarchyView.selectedTile == null || editing) return;
		tile = HierarchyView.selectedTile;
		
		Vector2 pos = Vector2.add(
				Vector2.mult(tile.transform.Position(), MainSystem.WorldScale),
				MainSystem.Offset
			);
		
		xAxis.position = pos;
		yAxis.position = pos;
		
		Color tmp = g.getColor();
		
		g.setStroke(EditorDefaults.gameViewStroke);
		g.setColor(EditorDefaults.selectObjGameView);
		
		g.drawOval(
				(int)(pos.x-(tile.sprite.getWidth()/2 * (tile.transform.scale.x * MainSystem.WorldScale))) - 2,
				(int)(pos.y-(tile.sprite.getHeight()/2 * (tile.transform.scale.y * MainSystem.WorldScale))) - 2,
				(int)(tile.sprite.getWidth() * (tile.transform.scale.x * MainSystem.WorldScale)) + 4,
				(int)(tile.sprite.getHeight() * (tile.transform.scale.y * MainSystem.WorldScale)) + 4
			);
		
		g.setStroke(EditorDefaults.defaultEditorStroke);
		g.setColor(tmp);
		
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

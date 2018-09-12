package STG.STG_Object;

import STG.Utils.*;

public class Transform {

	public Tile parent;
	
	private Vector2 position;
	private Vector2 localPosition;
	
	public float angle;
	public fVector2 scale;
	
	public Transform() {
		localPosition = Vector2.zero();
		position = Vector2.zero();
		scale = fVector2.one();
		angle = 0;
	}
	
	public void Reset() {
		localPosition = Vector2.zero();
		position = Vector2.zero();
		scale = fVector2.one();
		angle = 0;
	}

	public Vector2 Position() {
		if(parent == null) return position;
		position = Vector2.add(parent.transform.position, localPosition);
		return position;
	}
	
	public Vector2 Position(Vector2 nPos) {
		position = nPos;
		if(parent == null) return position;
		
		localPosition = Vector2.minus(position, parent.transform.position);
		return position;
	}
	
	public Vector2 LocalPosition() {
		if(parent == null) return position;
		return localPosition;
	}
	
	public Vector2 LocalPosition(Vector2 nlPos) {
		if(parent == null) return Position(nlPos);
		
		localPosition = nlPos;
		position = Vector2.add(parent.transform.position, localPosition);
		return localPosition;
	}
	
	public float LocalAngle() {
		if(parent == null) return angle;
		return angle - parent.transform.angle;
	}
}

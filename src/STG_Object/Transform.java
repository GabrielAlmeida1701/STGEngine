package STG_Object;

import Utils.*;

public class Transform {

	public Vector2 position;
	public float angle;
	public fVector2 scale;
	
	public Transform() {
		position = Vector2.zero();
		scale = fVector2.one();
		angle = 0;
	}
	
	public void Reset() {
		position = Vector2.zero();
		scale = fVector2.one();
		angle = 0;
	}
}

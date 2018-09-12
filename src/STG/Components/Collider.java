package STG.Components;

import STG.Utils.Vector2;

public class Collider extends Component{

	public Vector2 velocity;
	public int density;
	public boolean isArea;
	public boolean isStatic;
	
	public void Start() {}
	
	public void Update() {}
	
	public synchronized Vector2 GetPosition() {
		return transform.Position();
	}
	
	public synchronized void PhysicUpdate() {
		if(isStatic) return;
		
		Vector2 nPos = Vector2.add(transform.Position(), velocity);
		transform.Position(nPos);
	}
	
	public float GetMass() { return density; }
	
	public String toString() {
		return "Collider ["+ tile.name +"]";
	}
}

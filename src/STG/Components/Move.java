package STG.Components;

import STG.Utils.MainSystem;

public class Move extends Component {

	public float speed = 1;
	
	public Move() {}
	public Move(float s) {speed = s;}
	
	public void Start() { }

	public void Update() {
		transform.Position().x += (int)(MainSystem.deltaTime * speed);
	}
}

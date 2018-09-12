package STG.Components;

import STG.Utils.MainSystem;

public class Rotate extends Component {

public float speed = 1;
	
	public Rotate() {}
	public Rotate(float s) {speed = s;}
	
	public void Start() { }

	public void Update() {
		transform.angle += (int)(MainSystem.deltaTime * speed);
	}
}

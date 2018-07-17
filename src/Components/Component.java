package Components;

import STG_Object.Tile;
import STG_Object.Transform;

public abstract class Component {

	public boolean enable;
	
	protected Transform transform;
	protected Tile tile;
	
	public abstract void Start() ;
	
	public abstract void Update() ;
	
	public void SetTile(Tile tile) {
		this.tile = tile;
		SetTransform(this.tile.transform);
		enable = true;
	}
	
	public void SetTransform(Transform transform) {
		this.transform = transform;
		enable = true;
	}
	
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) return false;
		String s = getClass().getName();
		
		return s.equals(obj.getClass().getName());
	} 
}

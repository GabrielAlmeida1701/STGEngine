package STG.STG_Object;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import STG.Components.Component;
import STG.Utils.MainSystem;
import STG.Utils.Vector2;

public class Camera {

	public Transform transform;
	private List<Component> components;
	
	public Camera() {
		transform = new Transform();
		components = new ArrayList<>();
	}
	
	public Component AddComponent(Component comp) {
    	comp.SetTransform(transform);
    	components.add(comp);
    	
    	return components.get(components.size()-1);
    }
	
	public void RemoveComponent(Component comp) {
    	if(components.contains(comp))
    		components.remove(comp);
    }
	
	public void Start(){
        for(Component comp : components){
            if(comp.enable) comp.Start();
        }
    }
	
	public void Update(){
        for(Component comp : components)
        	if(comp.enable) comp.Update();
    }
	
	//Editor Only
	public void DrawCamera(Graphics g, Vector2 offset, Dimension dim) {
		g.drawRect(
    			offset.x + transform.Position().x,
    			offset.y + transform.Position().y,
    			(int)(dim.width * MainSystem.WorldScale),
    			(int)(dim.height * MainSystem.WorldScale)
			);
	}
}

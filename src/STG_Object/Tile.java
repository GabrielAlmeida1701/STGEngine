package STG_Object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Components.Component;
import Utils.*;

public class Tile {
    
	public Transform transform;
    public BufferedImage sprite;
    public boolean collider;
    public boolean useGravity;
    public Tile parent;
    public String name;
    
    public boolean isSelected;
    
    private List<Component> components = new ArrayList<>();
    
    @SuppressWarnings("unused")
	private boolean isEmpty;
    private boolean right = true;
    
    public Tile(){
    	transform = new Transform();
        isEmpty = true;
        name = "Empty Tile";
        collider = false;
    }
    
    public Tile(int layer, String name){
    	transform = new Transform();
        isEmpty = true;
        this.name = name;
        collider = layer == 1;
    }
    
    public Tile(int layer, String name, String sprite){
    	transform = new Transform();
        isEmpty = false;
        this.name = name;
        this.sprite = (BufferedImage) MainSystem.LoadSpriteAsset(sprite);
        collider = layer == 1;
    }
    
    public void Start(){
        for(Component comp : components){
            if(comp.enable) comp.Start();
        }
    }
    
    public void Update(){
        for(Component comp : components)
        	if(comp.enable) comp.Update();
        
        if(transform.angle > 360) transform.angle = 0;
    }
    
    public void SetPosition(int x, int y){
    	transform.position.x = x;
    	transform.position.y = y;
    }
    
    public void SetPosition(Vector2 position){
    	transform.position = position;
    }
    
    public void SetParent(Tile tile) {
    	parent = tile;
    }
    
    public void Flip(){
        right = !right;
    }
    
    public Component AddComponent(Component comp) {
    	comp.SetTile(this);
    	components.add(comp);
    	
    	return components.get(components.size()-1);
    }
    
    public void RemoveComponent(Component comp) {
    	if(components.contains(comp))
    		components.remove(comp);
    }
    
    public void Render(Graphics g){
    	AffineTransform at = new AffineTransform();
    	Graphics2D g2 = (Graphics2D)g;
    	
    	Vector2 
    	fPos = Vector2.add(MainSystem.Offset, Vector2.mult(transform.position, MainSystem.WorldScale));
    	
    	at.translate(fPos.x, fPos.y);
    	at.rotate(Math.toRadians(transform.angle));
    	at.scale(
    			transform.scale.x * MainSystem.WorldScale,
    			transform.scale.y * MainSystem.WorldScale
			);
    	
    	at.translate(-sprite.getWidth()/2, -sprite.getHeight()/2);
    	g2.drawImage(sprite, at, null);
    }
}
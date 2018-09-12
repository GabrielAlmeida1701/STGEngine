package STG.Components;

import java.awt.Color;
import java.awt.Graphics;

public class CircleCollider extends Collider {

	public float radius;
	
	public double area(){
        return Math.PI * Math.pow(radius,2);
    }
	
	public void DrawEditor(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawOval(transform.Position().x, transform.Position().y, (int)(radius*2), (int)(radius*2));
	}
	
	public float GetMass() {
    	return (float) (area() * density);
    }
}

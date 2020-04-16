package main;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Graphic implements Renderable{
	
	public Graphic parent;
	
	public ArrayList<Renderable> subGraphics = new ArrayList<>();
	public ArrayList<Double> order = new ArrayList<>();
	
	public int x=0, y=0;
	
	public Graphic(int x, int y, Graphic parent){
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
	public Graphic(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Graphic(Graphic parent) {
		this.parent = parent;
	}
	public Graphic() {}
	
	public int add(Renderable O, double priority){
		int x;
		if (subGraphics.size() == 0){
			subGraphics.add(O);
			order.add(priority);
			x = subGraphics.size();
		}
		else if (priority > order.get(subGraphics.size()-1)){
			subGraphics.add(O);
			order.add(priority);
			x = subGraphics.size();
		}
		else {
			for (x=0; priority>order.get(x); x++);
			subGraphics.add(x, O); 
			order.add(x, priority);
		}
		return x;
	}
	
	
	public void renderSelf(Graphics g){
		for(int n = subGraphics.size()-1; n>=0; n--){
			subGraphics.get(n).render(g);
		}
	}
	
	public abstract void render(Graphics g);
	
}

package main;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Graphic implements Renderable{
	
	public Graphic parent;
	
	public ArrayList<Renderable> subGraphics = new ArrayList<>();
	public ArrayList<Double> order = new ArrayList<>();
	
	public int x=0, y=0, width=0, height=0;
	
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
		int index;
		if (subGraphics.size() == 0){
			subGraphics.add(O);
			order.add(priority);
			index = subGraphics.size();
		}
		else if (priority > order.get(subGraphics.size()-1)){
			subGraphics.add(O);
			order.add(priority);
			index = subGraphics.size();
		}
		else {
			for (index=0; priority>order.get(index); index++);
			subGraphics.add(index, O); 
			order.add(index, priority);
		}
		return index;
	}
	
	public void remove(Renderable O) {
		int index = subGraphics.indexOf(O);
		order.remove(index);
		subGraphics.remove(index);
	}
	
	
	public void renderSelf(Graphics g){
		for(int n = subGraphics.size()-1; n>=0; n--){
			subGraphics.get(n).render(g);
		}
	}
	
	public void setBounds(int x, int y, int width, int height) {
		this.x = x; this.y = y;
		this.width = width; this.height = height;
	}
	
	public int xrel(double subx) {
		return x + (int)subx;
	}
	
	public int yrel(double suby) {
		return y + (int)suby;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public abstract void render(Graphics g);
	
	public abstract void close();
	
	
}

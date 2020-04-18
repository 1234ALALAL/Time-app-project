package main;

import java.awt.Graphics;

/*
 * This is a class that combines the Graphic and Task class into one.
 * It can be used for things that need both actions and graphics done.
 */

public abstract class Widget implements Renderable, Tickable {
	
	protected Widget parent;
	
	public Graphic graphic;
	public Task task;
	
	
	public Widget(Graphic graphic, Task task) {
		this.graphic = graphic;
		this.task = task;
	}
	public Widget(Graphic graphic) {
		this.graphic = graphic;
		task = new MyTask();
	}
	public Widget(Task task) {
		this.task = task;
		graphic = new MyGraphic();
	}
	public Widget(Widget parent) {
		graphic = new MyGraphic();
		task = new MyTask();
		this.parent = parent;
	}
	public Widget() {
		graphic = new MyGraphic();
		task = new MyTask();
	}
	
	
	public abstract void render(Graphics g);
	
	public abstract void tick();
	
	public abstract void close();
	
	public void renderSelf(Graphics g) {
		graphic.renderSelf(g);
	}
	
	public void tickSelf() {
		task.tickSelf();
	}
	
	public void addG(Renderable G, double priority) {
		graphic.add(G, priority);
	}
	public void addT(Tickable T, double priority) {
		task.add(T, priority);
	}
	public void addW(Widget W, double Gpriority, double Tpriority) {
		graphic.add(W, Gpriority);
		task.add(W, Tpriority);
	}
	
	public void removeG(Renderable G) {
		graphic.remove(G);
	}
	public void removeT(Tickable T) {
		task.remove(T);
	}
	public void removeW(Widget W) {
		graphic.remove(W);
		task.remove(W);
	}
	
	private class MyGraphic extends Graphic {
		public void render(Graphics g) {}
		public void close() {}
	}
	private class MyTask extends Task {
		public void tick() {}
	}
}

package main;

import java.awt.Graphics;

public interface Renderable extends Tickable{
	public void render(Graphics g);
}

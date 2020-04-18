package screens;

import java.awt.Color;
import java.awt.Graphics;

import main.*;

public class BannerMenu extends Widget{
	
	private Color background = new Color(120,120,120);
	
	
	public BannerMenu(Widget parent) {
		super(parent);
		graphic.setBounds(0, 0, parent.graphic.getWidth(), 20);
	}
	
	public void render(Graphics g) {
		g.setColor(background);
		g.fillRect(graphic.x,graphic.y,graphic.width,graphic.height);
	}

	public void tick() {
		
	}

	public void close() {
		
	}


}

package screens;

import java.awt.Color;
import java.awt.Graphics;

import main.Widget;

public class OptionMenu extends Widget{
	
	private Color background = new Color(100,100,100);
	
	
	public OptionMenu(Widget parent) {
		super(parent);
		graphic.setBounds(0, 20, 350, parent.graphic.getHeight());
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

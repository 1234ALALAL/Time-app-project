package widgets;

import java.awt.Color;
import java.awt.Graphics;

import main.*;

public class Button extends Widget{
	
	private UserInput input = Main.main.input;
	
	private Text text;
	private Color background;
	private Color shadow = new Color(255,255,255,30);
	
	private boolean hover = false;
	private boolean clicked = false;
	
	public Button(int x, int y, int width, int height) {
		graphic.setBounds(x, y, width, height);
	}
	public Button(int x, int y, int width, int height, Text text, Color background) {
		graphic.setBounds(x, y, width, height);
		this.text = text;
		 this.background = background;
	}
	
	public void setText(Text text) {
		this.text = text;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	
	public void render(Graphics g) {
		if (hover) {
			if (clicked)
				renderClicked(g);
			else
				renderHover(g);
		} else {
			renderNone(g);
		}
		
	}
	
	protected void renderClicked(Graphics g) {
	}
	protected void renderHover(Graphics g) {
		renderNone(g);
		g.setColor(shadow);
		g.fillRect(graphic.x, graphic.y, graphic.width, graphic.height);
	}
	protected void renderNone(Graphics g) {
		g.setColor(background);
		g.fillRect(graphic.x, graphic.y, graphic.width, graphic.height);
		text.render(g);
	}

	@Override
	public void tick() {
		hover = input.mouseInBounds(graphic.x, graphic.y, graphic.width, graphic.height);
		if (hover) {
			clicked = input.mouseDown(1);
			if (clicked) {
				act();
			}
		} else {
			clicked = false;
		}
	}

	@Override
	public void close() {
		
	}
	
	public void act() {};
	
}

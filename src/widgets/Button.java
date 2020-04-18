package widgets;

import java.awt.Color;
import java.awt.Graphics;

import main.*;

public class Button extends Widget{
	
	private UserInput input = Main.main.input;
	
	private Text text;
	private Color background;
	
	private boolean hover = false;
	private boolean clicked = false;
	
	public Button(int x, int y, int width, int height) {
		graphic.setBounds(x, y, width, height);
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
		
	}
	protected void renderNone(Graphics g) {
		
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

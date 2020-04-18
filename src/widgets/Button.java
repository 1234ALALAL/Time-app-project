package widgets;

import java.awt.Graphics;

import main.*;

public class Button extends Widget{
	
	private UserInput input = Main.main.input;
	
	private boolean hover = false;
	private boolean clicked = false;
	
	public Button(int x, int y, int width, int height) {
		graphic.setBounds(x, y, width, height);
	}
	
	public void render(Graphics g) {
		
		
	}


	@Override
	public void tick() {
		hover = input.mouseInBounds(graphic.x, graphic.y, graphic.width, graphic.height);
		if (hover) {
			clicked = input.mouseDown(1);
		}
	}

	@Override
	public void close() {
		
	}
	
}

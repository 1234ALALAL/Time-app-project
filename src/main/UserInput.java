package main;

import java.awt.event.*;
import java.util.ArrayList;


public class UserInput implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	Main main;
	
	public UserInput(){
		this.main = Main.main;
	}
	
	//Mouse Input
		private int mouseX = 50, mouseY = 50; 
		private boolean[] mouseDown = {false,false,false};
		
		public int mouseX() {
			return mouseX - main.window.graphX;
		}
		public int mouseY() {
			return mouseY - main.window.graphY;
		}
		public boolean mouseDown(int button){
			return mouseDown[button-1];
		}
		public boolean mouseInBounds(int x, int y, int width, int height){
			return mouseX()>=x && mouseX()<=x+width && mouseY()>=y && mouseY()<=y+height;
		}

		
		
		public void mouseMoved(MouseEvent m){
			mouseX = m.getX(); mouseY = m.getY();
		}
		public void mouseDragged(MouseEvent m) {
			mouseX = m.getX(); mouseY = m.getY();
		}
		
		public void mousePressed(MouseEvent m){
			mouseDown[m.getButton()-1] = true;
		}
		public void mouseReleased(MouseEvent m) {
			mouseDown[m.getButton()-1] = false;
		}
		public void mouseClicked(MouseEvent m) {
		}
		public void mouseEntered(MouseEvent m) {
		}
		public void mouseExited(MouseEvent m) {
		}
		public void mouseWheelMoved(MouseWheelEvent m){
		}

		
	//Key Input
		private ArrayList<Integer> keysDown = new ArrayList<>();
			
		public boolean keyDown(int keycode){
			return keysDown.contains(keycode);
		}
		public void keyPressed(KeyEvent k) {
			if (!keysDown.contains(k.getKeyCode())) {
				keysDown.add(k.getKeyCode());
				System.out.println("Key pressed: "+k.getKeyCode());
			}
		}
		public void keyReleased(KeyEvent k) {
			keysDown.remove((Integer)k.getKeyCode());
		}
		public void keyTyped(KeyEvent k) {	
		}
			
}

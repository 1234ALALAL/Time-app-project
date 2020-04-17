package main;

public class Main implements Runnable{
	
	public static Main main;
	
	//Global objects
	public Thread thread;
	public UserInput input;
	public Window window;
	public Graphic mainGraphic;
	public Task mainTask;
	
	
	//local variables
	private final boolean inDeveloperMode = false;
	
	private boolean running;
	
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		Main.main = this;
		
		input = new UserInput();
		window = new Window();
		
		if (inDeveloperMode){
			start();
		}
		else {
			start();
		}
	}
		
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 100.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				delta--;
			}
			if (running)
				render();
		}
		stop();
	}
	
	private void render(){
		window.render();
	}
	
	
	//Thread Methods	
	public synchronized void start(){
		if (thread == null) thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}
	
}

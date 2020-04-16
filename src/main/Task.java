package main;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Task implements Tickable{
	public ArrayList<Tickable> subTasks = new ArrayList<>();
	public ArrayList<Double> order = new ArrayList<>();
	
	public int add(Renderable O, double priority){
		int x;
		if (subTasks.size() == 0){
			subTasks.add(O);
			order.add(priority);
			x = subTasks.size();
		}
		else if (priority > order.get(subTasks.size()-1)){
			subTasks.add(O);
			order.add(priority);
			x = subTasks.size();
		}
		else {
			for (x=0; priority>order.get(x); x++);
			subTasks.add(x, O); 
			order.add(x, priority);
		}
		return x;
	}
	
	public void tickSelf(Graphics g){
		for(int n = subTasks.size()-1; n>=0; n--){
			subTasks.get(n).tick();
		}
	}
	
	public abstract void tick();
}

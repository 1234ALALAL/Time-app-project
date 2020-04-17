package main;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Task implements Tickable{
	
	
	public ArrayList<Tickable> subTasks = new ArrayList<>();
	public ArrayList<Double> order = new ArrayList<>();
	
	
	public int add(Tickable O, double priority){
		int index;
		if (subTasks.size() == 0){
			subTasks.add(O);
			order.add(priority);
			index = subTasks.size();
		}
		else if (priority > order.get(subTasks.size()-1)){
			subTasks.add(O);
			order.add(priority);
			index = subTasks.size();
		}
		else {
			for (index=0; priority>order.get(index); index++);
			subTasks.add(index, O); 
			order.add(index, priority);
		}
		return index;
	}
	
	public void remove(Tickable O) {
		int index = subTasks.indexOf(O);
		order.remove(index);
		subTasks.remove(index);
	}
	
	public void tickSelf(){
		for(int n = subTasks.size()-1; n>=0; n--){
			subTasks.get(n).tick();
		}
	}
	
	public abstract void tick();
	
	
}

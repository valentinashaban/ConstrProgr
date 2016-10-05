package model;

import java.util.ArrayList;

public class Block {
	private String name;
	private int time;
	private boolean finished;
	private Constraint cons;
	
	public Block() {}

	public Block(String name, int time, int num, ArrayList<String> consList) {
		this.name = name;
		this.time = time;
		this.finished = false;
		cons = new Constraint(num, consList);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Constraint getCons() {
		return cons;
	}

	public void setCons(Constraint cons) {
		this.cons = cons;
	}

	@Override
	public String toString() {
		return "Block [name=" + name + ", time=" + time + ", cons=" + cons + "]";
	}
	
}

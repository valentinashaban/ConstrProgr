package model;

public class Block {
	private String name;
	private int time;
	private int priority;
	private boolean finished;
	
	public Block() {}

	public Block(String name, int time, int priority) {
		this.name = name;
		this.time = time;
		this.priority = priority;
		this.finished = false;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Override
	public String toString() {
		return "Block [name=" + name + ", time=" + time + ", priority=" + priority + ", finished=" + finished + "]";
	}
	
}

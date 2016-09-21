package model;

public class Block {
	private int time;
	private int priority;
	private boolean finished;
	
	public Block() {}

	public Block(int time, int priority) {
		this.time = time;
		this.priority = priority;
		this.finished = false;
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
		return "Block [time=" + time + ", priority=" + priority + ", finished=" + finished + "]";
	}
}

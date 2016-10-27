package model;

import java.util.ArrayList;

public class Constraint implements Cloneable {
	private int numTops;
	
	// blocks that should be finished first
	ArrayList<String> consBlocks = new ArrayList<>();

	public Constraint() {}

	@SuppressWarnings("unchecked")
	public Constraint(int numTops, ArrayList<String> consBlocks) {
		this.numTops = numTops;
		this.consBlocks = (ArrayList<String>) consBlocks.clone();
	}

	public int getNumTops() {
		return numTops;
	}

	public ArrayList<String> getConsBlocks() {
		return consBlocks;
	}

	public void setConsBlocks(ArrayList<String> consBlocks) {
		this.consBlocks = consBlocks;
		this.numTops = consBlocks.size();
	}

	@Override
	public String toString() {
		return "Constraint [numTops=" + numTops + ", consBlocks=" + consBlocks + "]";
	}
}

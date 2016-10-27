package control;

import java.util.ArrayList;

import model.Block;

public class Executor {
	private static StringBuilder result = new StringBuilder();
	private static int timeResult;
	private static ArrayList<Block> independent = new ArrayList<>();
	private static ArrayList<Block> dependent = new ArrayList<>();
	private static int booleanCount;
	private static int finishedCount;

	public Executor() {
	}

	public static StringBuilder getResult() {
		return result;
	}

	public static int getTimeResult() {
		return timeResult;
	}

	public static void getPath(ArrayList<Block> blocks) {

		for (Block i : blocks) {
			if (i.getCons().getNumTops() == 0 && !i.isFinished()) {
				independent.add(i);
			} else {
				dependent.add(i);
			}
		}
		
		int maxTime = 0;
		for (int i = 0; i < independent.size(); i++) {
			if (independent.get(i).getTime() > maxTime)
				maxTime = independent.get(i).getTime();
			
			independent.get(i).setFinished(true);
			result.append(independent.get(i).getName()).append(" ");
		}
		
		timeResult += maxTime;
		
		do {
			Executor.dependentRes(blocks);
			
			finishedCount = 0;
			for (Block i : blocks)
				if (i.isFinished())
					finishedCount++;
		} while (finishedCount != blocks.size());
			
		System.out.println("Path: " + result);
		System.out.println("Time: " + timeResult);
	}

	public static void isExecuting(String name) {
		System.out.println("Block " + name + " is executing.");
	}
	
	private static void dependentRes(ArrayList<Block> blocks) {
		for (Block i : dependent) {
			booleanCount = 0;
			for (Block j : blocks) {
				for (String s : i.getCons().getConsBlocks()) {
					if (j.getName().equals(s) && j.isFinished())
						booleanCount++;
				}
			}
			
			if (booleanCount == i.getCons().getNumTops() && !i.isFinished()) {
				timeResult += i.getTime();
				result.append(i.getName()).append(" ");
				i.setFinished(true);
			}
 		}
	}
}

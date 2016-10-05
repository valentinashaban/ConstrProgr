package control;

import java.util.ArrayList;

import model.Block;

public class Executor {
	private static StringBuilder result = new StringBuilder();
	private static int timeResult;

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
			if (i.getCons().getNumTops() == 0) {
				timeResult += i.getTime();
				result.append(i.getName()).append(", ");
				i.setFinished(true);
				Executor.isExecuting(i.getName());
			} else {
				for (Block j : blocks) {
					for (String k : i.getCons().getConsBlocks()) {
						if (j.getName().equals(k)) {
							if (j.isFinished()) {
								timeResult += i.getTime();
								result.append(i.getName()).append(", ");
								i.setFinished(true);
								Executor.isExecuting(i.getName());
							} else
								continue;
						}
					}
				}
			}
		}
		System.out.println("Path: " + result);
		System.out.println("Execution time: " + timeResult);
	}
	
	public static void isExecuting(String name) {
		System.out.println("Block " + name + " is executing.");
	}
}

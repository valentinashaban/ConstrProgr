package control;

import java.util.ArrayList;

import model.Block;

public class Executor {
	private static StringBuilder result = new StringBuilder();
	private static int timeResult;

	public Executor() {
	}

	public static void findMinPath(ArrayList<Block> blocks) {
		ArrayList<Block> highPriority = new ArrayList<>();
		ArrayList<Block> mediumPriority = new ArrayList<>();
		ArrayList<Block> lowPriority = new ArrayList<>();

		for (Block i : blocks) {
			if (i.getPriority() == 9 || i.getPriority() == 10)
				highPriority.add(i);

			if (i.getPriority() <= 8 && i.getPriority() >= 3)
				mediumPriority.add(i);

			if (i.getPriority() == 2 || i.getPriority() == 1)
				lowPriority.add(i);
		}

		if (!highPriority.isEmpty()) {
			for (Block i : highPriority) {
				timeResult += i.getTime();
				executeProc(i);
				result.append(i.getName()).append(",  ");
			}
		}

		if (!mediumPriority.isEmpty()) {
			for (Block i : mediumPriority) {
				for (Block j : mediumPriority) {
					if (i.getPriority() == j.getPriority()) {
						if (i.getTime() >= j.getTime()) {
							timeResult += i.getTime();
							executeProc(i);
							result.append(i.getName()).append(",  ");
						} else {
							timeResult += j.getTime();
							executeProc(j);
							result.append(j.getName()).append(",  ");
						}
					} else {
						timeResult += i.getTime();
						executeProc(i);
						result.append(i.getName()).append(",  ");
					}
				}
			}
		}

		int minBlocksTime;
		if (!lowPriority.isEmpty()) {
			minBlocksTime = lowPriority.get(0).getTime();

			for (Block i : lowPriority) {
				if (i.getTime() < minBlocksTime)
					minBlocksTime = i.getTime();
				executeProc(i);
				result.append(i.getName()).append(",  ");
			}
			timeResult += minBlocksTime;
		}

		System.out.println("Path: " + result);
		System.out.println("Time: " + timeResult);
	}

	public static void executeProc(Block b) {
		System.out.println("Block " + b.getName() + " is executing in " + b.getTime() + " minutes.");
	}
}

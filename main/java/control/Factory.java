package control;

import java.util.ArrayList;
import java.util.Scanner;

import model.Block;

public class Factory {
	private int time;
	private int priority;
	private int numBlocks;

	public Factory() {
	}

	public void createBlocks(ArrayList<Block> blocks) {
		int counter = 1;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of blocks:");
		System.out.println();
		numBlocks = sc.nextInt();

		for (int i = 0; i < numBlocks; i++) {
			System.out.println("Enter " + counter + " block's time: ");
			System.out.println();
			time = sc.nextInt();

			while (priority > 10 || priority <= 0) {
				System.out.println("Enter " + counter + " block's priority(from 1 to 10): ");
				System.out.println();
				priority = sc.nextInt();
			}

			blocks.add(new Block(time, priority));
			counter++;
		}
	}
}

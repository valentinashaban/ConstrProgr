package control;

import java.util.ArrayList;
import java.util.Scanner;

import model.Block;

public class Factory {
	
	private String name;
	private int time;
	private int numBlocks;
	private int numTops;
	private ArrayList<String> cons = new ArrayList<>();

	public Factory() {}

	public void createBlocks(ArrayList<Block> blocks) {
		int counter = 1;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of blocks:");
		System.out.println();
		numBlocks = sc.nextInt();

		for (int i = 0; i < numBlocks; i++) {
			
			System.out.println("Enter " + counter + " block's name: ");
			System.out.println();
			name = sc.next();
			
			System.out.println("Enter " + counter + " block's time: ");
			System.out.println();
			time = sc.nextInt();

			System.out.println("Enter the number of previous blocks: ");
			System.out.println();
			numTops = sc.nextInt();
			
			for (int j = 0; j < numTops; j++) {
				System.out.println("Enter the names of previous blocks: ");
				System.out.println();
				cons.add(sc.next());
			}
			
			blocks.add(new Block(name, time, numTops, cons));
			counter++;
			name = "";
			time = 0;
			numTops = 0;
			cons.removeAll(cons);
		}
	}
}

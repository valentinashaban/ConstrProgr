package control;

import java.util.ArrayList;
import model.Block;

public class Main {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		
		ArrayList<Block> blocks = new ArrayList<>();
		factory.createBlocks(blocks);
		
		for (Block i : blocks)
			System.out.println(i);
		
		Executor.findMinPath(blocks);
	}
	
}

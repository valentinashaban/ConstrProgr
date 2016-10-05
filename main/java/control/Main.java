package control;

import java.util.ArrayList;
import model.Block;

public class Main {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		
		ArrayList<Block> blocks = new ArrayList<>();
		factory.createBlocks(blocks);
		/*blocks.add(new Block("a", 5, 0, new ArrayList<String>()));
		blocks.add(new Block("b", 8, 2, new ArrayList<String>() {{
			this.add("a");
			this.add("c");
		}}));
		blocks.add(new Block("c", 3, 1, new ArrayList<String>() {{
			this.add("d");
		}}));
		blocks.add(new Block("d", 6, 0, new ArrayList<String>()));*/
		
		for (Block i : blocks)
			System.out.println(i);
		
		Executor.getPath(blocks);
	}
	
}

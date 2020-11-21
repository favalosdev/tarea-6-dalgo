package uniandes.algorithms.minimumcostpath;

import java.io.BufferedReader;
import java.io.FileReader;

public class FirstExcerciseMain {

	private final static String SMALL_SET = "./data/distances5.txt";
	
	private final static String MEDIUM_SET = "./data/distances100.txt";
	
	private final static String BIG_SET = "./data/distances1000.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			String chosen = "";
			
			if      (args[1].equals("s")) chosen = SMALL_SET;
			else if (args[1].equals("m")) chosen = MEDIUM_SET;
			else if (args[1].equals("b")) chosen = BIG_SET;
			
			BufferedReader counter = new BufferedReader(new FileReader(chosen));
			String current = null;
			int rows = 1;
			int cols = counter.readLine().split("\t").length;
			
			while ((current = counter.readLine()) != null) rows++;
			
			int[][] matrix = new int[rows][cols];
			
			counter.close();
			
			BufferedReader parser = new BufferedReader(new FileReader(chosen));
			int i = 0;
			
			while ((current = parser.readLine()) != null) {
				String[] values = current.split("\t");
				
				for (int j = 0; j < values.length; j++) matrix[i][j] = Integer.parseInt(values[j]);
				i++;
			}
			
			parser.close();
			
			// Prompt the user to choose an algorithm
			
			System.out.println("Matrix lodaded correctly!");
			
			// Either Dijkstras, BellmanFords or FloydWarschalls
			String algorithmClassName = FirstExcerciseMain.class.getPackage().getName() + "." + args[0] + "Algorithm";
			MinimumCostPathAlgorithm finder = (MinimumCostPathAlgorithm)Class.forName(algorithmClassName).newInstance();
			
			System.out.println("Chosen class: " + algorithmClassName);
			
			finder.findPaths(matrix);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

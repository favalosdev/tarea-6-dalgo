package uniandes.algorithms.minimumcostpath;

import java.io.BufferedReader;
import java.io.FileReader;

public class FirstExcerciseMain {

	private final static String SMALL = "./data/distances5.txt";
	
	private final static String MEDIUM = "./data/distances100.txt";
	
	private final static String BIG = "./data/distances1000.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			String chosen = "";
			
			if      (args[1].equals("s")) chosen = SMALL;
			else if (args[1].equals("m")) chosen = MEDIUM;
			else if (args[1].equals("b")) chosen = BIG;
			
			BufferedReader counter = new BufferedReader(new FileReader(chosen));
			String current = null;
			int rows = 1;
			int cols = counter.readLine().split("\t").length;
			
			while ((current = counter.readLine()) != null) rows++;
			
			Double[][] weight = new Double[rows][cols];
			
			counter.close();
			
			BufferedReader parser = new BufferedReader(new FileReader(chosen));
			int i = 0;
			
			while ((current = parser.readLine()) != null) {
				String[] values = current.split("\t");
				
				for (int j = 0; j < values.length; j++) {	
					if (values[j].equals("-1")) weight[i][j] = Double.POSITIVE_INFINITY;
					else                        weight[i][j] = Double.parseDouble((values[j]));
				}
				i++;
			}
			
			parser.close();
			
			// Prompt the user to choose an algorithm
			
			System.out.println("Matrix lodaded correctly!");
			
			// Either Dijkstras, BellmanFords or FloydWarschalls
			String algorithmClassName = FirstExcerciseMain.class.getPackage().getName() + "." + args[0] + "Algorithm";
			MinimumCostPathAlgorithm finder = (MinimumCostPathAlgorithm)Class.forName(algorithmClassName).newInstance();
			
			System.out.println("Chosen class: " + algorithmClassName);
			
			// Print matrix
			
			Double [][] minimumCost = finder.findPaths(weight);
			
			// Test for small and medium only!
			
			for (int row = 0; row < minimumCost.length; row++) {
				for (int col = 0; col < minimumCost.length; col++) {
					System.out.print(minimumCost[row][col] + " "); 
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

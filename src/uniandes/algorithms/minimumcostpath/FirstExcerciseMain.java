package uniandes.algorithms.minimumcostpath;

import java.io.BufferedReader;
import java.io.FileReader;

import uniandes.structures.Graph;

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
					
					if (!values[j].equals("-1")) weight[i][j] = Double.parseDouble(values[j]);
					else weight[i][j] = null;
				}
				i++;
			}

			parser.close();
			
			System.out.println("Matriz cargada correctamente.");
			
			// Either Dijkstras, BellmanFords or FloydWarschalls
			
			Graph graph = new Graph(weight, true);
			
			System.out.println("Grafo cargado correctamente");
			
			Double[][] minimumCost = null;
			
			if (args[0].equals("FloydWarshalls")) {
				FloydWarshallsAlgorithm alg = new FloydWarshallsAlgorithm(weight);
				minimumCost = alg.findPaths();
			} else if (args[0].equals("Dijkstras")) {
				DijkstrasAlgorithm alg = new DijkstrasAlgorithm(graph);
				minimumCost = alg.findPaths(weight);
			} else if (args[0].equals("BellmanFords")) {
				BellmanFordsAlgorithm alg = new BellmanFordsAlgorithm(graph);
				minimumCost = alg.findPaths();
			}

			System.out.println("Algoritmo escogido: " + args[0]);

			// Test for small and medium only!

			System.out.println("Los caminos mínimos son: ");
			if (minimumCost != null) {
				for (int row = 0; row < minimumCost.length; row++) {
					for (int col = 0; col < minimumCost.length; col++) {
						System.out.print(minimumCost[row][col] + " "); 
					}
					System.out.println();
				}
			} else {
				System.out.println("No se pudo cargar la matriz. Ocurrió un error.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}	
}

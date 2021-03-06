package uniandes.algorithms.minimumcostpath;

import java.io.BufferedReader;
import java.io.FileReader;

import uniandes.structures.Graph;

public class FirstExerciseMain {

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
					weight[i][j] = Double.parseDouble(values[j]);
				}
				i++;
			}

			parser.close();
			
			System.out.println("Matriz cargada correctamente.");
			
			// Either Dijkstras, BellmanFords or FloydWarschalls
			
			Graph graph = new Graph(weight);
			
			System.out.println("Grafo cargado correctamente.");
			
			Double[][] minimumCost = null;
			
			
			long start = System.currentTimeMillis();
			if (args[0].equals("FloydWarshall")) {
				FloydWarshallsAlgorithm alg = new FloydWarshallsAlgorithm(weight);
				minimumCost = alg.findPaths();
			} else if (args[0].equals("Dijkstra")) {
				DijkstrasAlgorithm alg = new DijkstrasAlgorithm(graph);
				minimumCost = alg.findPaths();
			} else if (args[0].equals("BellmanFord")) {
				BellmanFordsAlgorithm alg = new BellmanFordsAlgorithm(graph);
				minimumCost = alg.findPaths();
			}

			System.out.println("Algoritmo escogido: " + args[0] + ".");
			
			long end = System.currentTimeMillis();
			
			long elapsedTime = end - start;
			
			System.out.println("Tiempo transcurrido: " + elapsedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

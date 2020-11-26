package uniandes.algorithms.dfs;

import java.io.BufferedReader;
import java.io.FileReader;

import uniandes.structures.Graph;

public class ThirdExerciseMain {

	// TODO: Find suitable data sets for algorithms
	private final static String ERROR = "./data/distances5.txt";
	
	private final static String TOP = "./data/topSort.txt";

	public static void main(String[] args) {
		try {
			String chosen = "";
			
			if (args[0].equals("error")) chosen = ERROR;
			else if (args[0].equals("top")) chosen = TOP;
			
			BufferedReader counter = new BufferedReader(new FileReader(chosen));
			String current = null;
			int rows = 1;
			int cols = counter.readLine().split("\t").length;

			while ((current = counter.readLine()) != null) rows++;

			Double[][] incidence = new Double[rows][cols];

			counter.close();

			BufferedReader parser = new BufferedReader(new FileReader(chosen));
			int i = 0;

			while ((current = parser.readLine()) != null) {
				String[] values = current.split("\t");

				for (int j = 0; j < values.length; j++) {
					incidence[i][j] = Double.parseDouble(values[j]);
				}
				i++;
			}

			parser.close();
			System.out.println("Matriz cargada correctamente.");
			
			Graph graph = new Graph(incidence);
			System.out.println("Grafo cargado correctamente.");
			
			DFS dfs = new DFS(graph);
			
			dfs.topologicalSort();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

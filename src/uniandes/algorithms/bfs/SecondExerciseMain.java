package uniandes.algorithms.bfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import uniandes.structures.Graph;
import uniandes.structures.Vertex;

public class SecondExerciseMain {

	private final static String SOURCE = "./data/bfsTest.txt";
	
	public static void main(String[] args) {
		
		try {
			BufferedReader counter = new BufferedReader(new FileReader(SOURCE));
			String current = null;
			int rows = 1;
			int cols = counter.readLine().split("\t").length;

			while ((current = counter.readLine()) != null) rows++;

			Double[][] incidence = new Double[rows][cols];

			counter.close();

			BufferedReader parser = new BufferedReader(new FileReader(SOURCE));
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
			
			BFS bfs = new BFS(graph);
			
			LinkedList<LinkedList<Vertex>> components = bfs.connecetedComponents();
			
			System.out.print("{");
			for (LinkedList<Vertex> component : components) {
				System.out.print("{ ");
				for (Vertex v : component) {
					System.out.print(v.getIndex() + " ");
				}
				System.out.print("} ");
			}
			
			System.out.print("}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

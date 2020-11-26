package uniandes.algorithms.minimumcostpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import algorithms.exceptions.InvalidGraphException;
import uniandes.structures.Edge;
import uniandes.structures.Graph;
public class DijkstrasAlgorithm {
	
	private Graph graph;
	
	public DijkstrasAlgorithm(Graph graph) {
		this.graph = graph;
	}
	
	public Double[][] findPaths() {

		// Create matrix to calculate the things as they should be
		try {
			// Construir matriz de caminos mínimos
			Double[][] distances = new Double[graph.V()][graph.V()];

			for (int key = 0; key < graph.V(); key++) {

				Double[] values = dijkstra(key);

				for (int j = 0; j < values.length; j++)
					distances[j][key] = values[j]; 
			}
			
			return distances;

		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Double[] dijkstra(int source) throws InvalidGraphException {

		// Create estimates

		Double[] distance = new Double[graph.V()];

		for (int i = 0; i < graph.V(); i++) {
			distance[i] = Double.POSITIVE_INFINITY;
		}

		distance[source] = 0.0;

		for (int times = 0; times < graph.V() - 1; times++) {
			for (Edge e : graph.getEdges()) {

				int start = e.getSource().getIndex();

				int end = e.getDest().getIndex();

				if (distance[start] + e.getCost() < distance[end]) {
					distance[end] = distance[start] + e.getCost();
				}
			}
		}
		
		for (Edge e : graph.getEdges()) 
		{

			if (e.getCost() < 0 && e.getCost() !=-1) 
			{
				throw new InvalidGraphException("El algoritmo de Dijkstra solo puede manejar pesos positivos.");
			}
		}
		
		for (Edge e : graph.getEdges()) {
			int start = e.getSource().getIndex();

			int end = e.getDest().getIndex();

			if (distance[start] + e.getCost() < distance[end]) {
				throw new InvalidGraphException("El grafo contiene un ciclo negativo.");
			}
		}

		return distance;
	}
}




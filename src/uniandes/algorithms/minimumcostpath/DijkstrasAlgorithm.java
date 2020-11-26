package uniandes.algorithms.minimumcostpath;

import java.util.Comparator;
import java.util.PriorityQueue;

import algorithms.exceptions.InvalidGraphException;
import uniandes.structures.Edge;
import uniandes.structures.Graph;
import uniandes.structures.Vertex;

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
				Vertex source = graph.getVertexes().get(key);
				dijkstra(source);
				
				for (Vertex v : graph.getVertexes()) {
					distances[v.getIndex()][key] = v.getDist();
				}
			}
			
			return distances;

		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void dijkstra(Vertex source) throws InvalidGraphException {		
		// Método para inicializar Dijkstra
		for (Vertex v : graph.getVertexes())
			v.setDist(Double.POSITIVE_INFINITY);
		
		source.setDist(0.0);
		
		// Crear MinPriorityQueue
		
		PriorityQueue<Vertex> minPQ = new PriorityQueue<Vertex>(graph.V(), new VertexComparator());
		
		// Llenar la minPQ
		for (Vertex v : graph.getVertexes())
			minPQ.add(v);
		
		while (!minPQ.isEmpty()) {
			Vertex u = minPQ.poll();
			
			for (Edge e : u.getAdj()) {
				Vertex end = e.getDest();
				
				if (minPQ.contains(end)) {
					Double offer = u.getDist() + e.getCost();
					
					if (offer < end.getDist())
						end.setDist(offer);
				}
			}
		}
	}
	
	public class VertexComparator implements Comparator<Vertex> {
		
		@Override
		public int compare(Vertex v1, Vertex v2) {
			return Double.compare(v1.getDist(), v2.getDist());
		}
	}
}




package uniandes.algorithms.minimumcostpath;
import algorithms.exceptions.InvalidGraphException;
import uniandes.structures.Edge;
import uniandes.structures.Graph;
import uniandes.structures.Vertex;

public class BellmanFordsAlgorithm {
	
	private Graph graph;
	
	public BellmanFordsAlgorithm(Graph graph) {
		this.graph = graph;
	}
	
	public Double[][] findPaths() {
		// Create matrix to calculate the things as they should be
		try {
			// Construir matriz de caminos mínimos
			Double[][] distances = new Double[graph.V()][graph.V()];

			for (int key = 0; key < graph.V(); key++) {
				Vertex source = graph.getVertexes().get(key);
				bellmanFord(source);
				
				for (Vertex v : graph.getVertexes())
					distances[v.getIndex()][key] = v.getDist();
			}
			
			return distances;

		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void bellmanFord(Vertex source) throws InvalidGraphException {
		for (Vertex v : graph.getVertexes())
			v.setDist(Double.POSITIVE_INFINITY);

		source.setDist(0.0);
		
		for (int times = 0; times < graph.V() - 1; times++) {
			for (Edge e : graph.getEdges()) {
				Vertex start = e.getSource();
				Vertex end = e.getDest();

				if (start.getDist() + e.getCost() < end.getDist())
					end.setDist(start.getDist() + e.getCost());
			}
		}
		
		for (Edge e : graph.getEdges()) {
			Vertex start = e.getSource();
			Vertex end = e.getDest();

			if (start.getDist() + e.getCost() < end.getDist())
				throw new InvalidGraphException("El grafo contiene un ciclo negativo.");
		}
	}
}

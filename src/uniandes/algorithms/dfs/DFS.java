package uniandes.algorithms.dfs;

import java.util.LinkedList;
import java.util.Queue;

import algorithms.exceptions.InvalidGraphException;
import uniandes.structures.Edge;
import uniandes.structures.Graph;
import uniandes.structures.Vertex;

public class DFS {

	private Graph graph;

	public DFS(Graph graph) {
		this.graph = graph;
	}

	public void topologicalSort() {
		try {
			Queue<Vertex> ordered = new LinkedList<Vertex>();

			for (Vertex v : graph.getVertexes()) {
				if (!v.isVisitedPerm()) {
					topologicalSortUtil(ordered, v);
				}
			}
			
			// Reportar los vértices
			
			while (!ordered.isEmpty()) {
				System.out.print(ordered.poll().getIndex());
				
				if (ordered.peek() != null) System.out.print(" ->");
				
				System.out.println();
			}
			
		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
		}
	}

	private void topologicalSortUtil(Queue<Vertex> ordered, Vertex source) throws InvalidGraphException {
		if (source.isVisitedPerm()) return;
		if (source.isVisitedTemp()) throw new InvalidGraphException("Grafo inválido. Contiene un ciclo.");

		source.setVisitedTemp(true);

		for (Edge e : source.getAdj()) topologicalSortUtil(ordered, e.getDest());

		source.setVisitedTemp(false);
		source.setVisitedPerm(true);

		ordered.add(source);
	}
}

package uniandes.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

import uniandes.structures.Edge;
import uniandes.structures.Graph;
import uniandes.structures.Vertex;

public class BFS {
	private Graph graph;
	
	public BFS(Graph graph) {
		this.graph = graph;
	}
	
	public LinkedList<LinkedList<Vertex>> connecetedComponents() {
		LinkedList<LinkedList<Vertex>> components = new LinkedList<LinkedList<Vertex>>();
		
		for (Vertex v : graph.getVertexes()) {
			if (!v.isVisitedPerm()) {
				LinkedList<Vertex> component = bfsUtil(v);
				components.add(component);
			}
		}
		
		return components;
	}
	
	public LinkedList<Vertex> bfsUtil(Vertex source) {
		Queue<Vertex> explored = new LinkedList<Vertex>();
		LinkedList<Vertex> component = new LinkedList<Vertex>();
		source.setVisitedPerm(true);
		explored.add(source);
		component.add(source);

		while (!explored.isEmpty()) {
			Vertex v = explored.poll();
			
			for (Edge e : v.getAdj()) {
				Vertex end = e.getDest();
				
				if (!end.isVisitedPerm()) {
					end.setVisitedPerm(true);
					explored.add(end);
					component.add(end);
				}
			}
		}
		
		return component;
	}
}
package uniandes.structures;
import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Vertex> vertexes; 
	
	private LinkedList<Edge> edges;
	
	private int V;
	
	public Graph(Double[][] matrix) {
		this.V = 0;
		this.vertexes = new LinkedList<Vertex>();
		this.edges = new LinkedList<Edge>();
		
		for (int i = 0; i < matrix.length; i++) addVertex(i);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != -1.0 && i != j) {
					addEdge(i, j, matrix[i][j]);
				}
			}
		}
	}
	
	public LinkedList<Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(LinkedList<Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	public void addEdge(int source, int dest, Double cost) {
		Vertex v1 = vertexes.get(source);
		Vertex v2 = vertexes.get(dest);
		
		Edge edge = new Edge(v1, v2, cost);
		
		v1.getAdj().add(edge);
		edges.add(edge);
	}
	
	private void addVertex(int index) {
		Vertex v = new Vertex(index);
		vertexes.add(v);
		V++;
	}
	
	public int V() {
		return V;
	}
	
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	
	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}
}

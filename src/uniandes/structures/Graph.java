package uniandes.structures;
import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Vertex> vertexes;
	
	private boolean directed;
	
	private LinkedList<Edge> edges;
	
	private int V;
	
	private int E;
	
	public Graph(Double[][] matrix, boolean directed) {
		this.directed = directed;
		this.V = 0;
		this.E = 0;
		this.vertexes = new LinkedList<Vertex>();
		this.edges = new LinkedList<Edge>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != -1 && i != j) {
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

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public void addEdge(int source, int dest, Double cost) {
		if (vertexes.get(source) == null) addVertex(source);
		if (vertexes.get(dest) == null) addVertex(dest);
		
		Vertex v1 = vertexes.get(source);
		Vertex v2 = vertexes.get(dest);
		
		Edge edge = new Edge(v1, v2, cost);
		
		v1.getAdj().add(edge);
		edges.add(edge);
		
		if (!directed) {
			Edge reverse = new Edge(v2, v1, cost);
			v2.getAdj().add(reverse);
			edges.add(reverse);
		}
	}
	
	private void addVertex(int index) {
		Vertex v = new Vertex(index);
		vertexes.add(v);
		V++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	
	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}
}

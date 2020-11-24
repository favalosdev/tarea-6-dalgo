package uniandes.structures;

import java.util.LinkedList;

public class Vertex {
	
	private int index;
	
	private LinkedList<Edge> adj;
	
	// Variables auxiliares
	private boolean visited;
	
	private Double dist;
	
	public Vertex(int index) {
		this.index = index;
		this.adj = new LinkedList<Edge>();
		this.visited = false;
		this.dist = null;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

	public LinkedList<Edge> getAdj() {
		return adj;
	}

	public void setAdj(LinkedList<Edge> adj) {
		this.adj = adj;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Double getDist() {
		return dist;
	}

	public void setDist(Double dist) {
		this.dist = dist;
	}
}

package uniandes.structures;

import java.util.LinkedList;

public class Vertex {
	
	private int index;
	
	private LinkedList<Edge> adj;
	
	// Variables auxiliares
	private boolean visitedTemp;
	
	private boolean visitedPerm; 
	
	private Double dist;
	
	public Vertex(int index) {
		this.index = index;
		this.adj = new LinkedList<Edge>();
		this.visitedTemp = false;
		this.visitedPerm = false;
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
	
	public boolean isVisitedTemp() {
		return visitedTemp;
	}
	
	public void setVisitedTemp(boolean visitedTemp) {
		this.visitedTemp = visitedTemp;
	}

	public boolean isVisitedPerm() {
		return visitedPerm;
	}

	public void setVisitedPerm(boolean visitedPerm) {
		this.visitedPerm = visitedPerm;
	}

	public Double getDist() {
		return dist;
	}

	public void setDist(Double dist) {
		this.dist = dist;
	}
}

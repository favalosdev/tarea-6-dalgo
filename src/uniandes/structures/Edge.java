package uniandes.structures;

public class Edge {
	
	private Vertex source;
	
	private Vertex dest;
	
	private Double cost;
	
	public Edge(Vertex source, Vertex dest, Double cost) {
		this.source = source;
		this.dest = dest;
		this.cost = cost;
	}
	
	public Vertex getSource() {
		return source;
	}
	
	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDest() {
		return dest;
	}

	public void setDest(Vertex dest) {
		this.dest = dest;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
}

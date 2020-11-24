package uniandes.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
	public static void main(String [] args)
	{
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(4, 5);
		theGraph.addEdge(1, 4);
		
		System.out.println("Visits: ");
		theGraph.bfs();
		System.out.println();
		
	}

}

class Vertex
{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab)
	{
		label = lab;
		wasVisited = false;
	}
}

class Graph{

	private final int MAX_VERTS = 100;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue<Integer> q;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		q = new LinkedList<Integer>();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v)
	{
		System.out.println(vertexList[v].label);
	}
	
	public int getAdjUnvisitedVertex (int v)
	{
		
		for (int i = 0; i < nVerts; i++)
		{
			if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
				return i;
		}
		return -1;
	}
	
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		q.add(0);
		int v2;
		
		while(!q.isEmpty())
		{
			int v1 = q.remove();
			while((v2=getAdjUnvisitedVertex(v1))!=-1)
			{
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				q.add(v2);
			}
		}
	}
	
}
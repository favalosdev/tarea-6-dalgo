package uniandes.algorithms.bfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SecondExerciseMain {

	public static void main(String[] args)
	{
		//Load input data

		List<List<Integer>> matrix = new ArrayList<>();

		try {

			//Creation of a List of strings from the original string, convert list of strings to list of ints with convertStringListToIntList method, add to matrix.
			File myObj = new File("C:\\Users\\Daniel\\Desktop\\Dalgo\\tarea-6-dalgo\\src\\uniandes\\algorithms\\bfs\\data.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				List<String> listOfString = new ArrayList<String>(Arrays.asList(data.split(" ")));
				List<Integer> listOfInteger = convertStringListToIntList(listOfString, Integer::parseInt); 
				matrix.add(listOfInteger);
				System.out.println(data);
			}
			myReader.close();


			//			//Verification that the matrix has the correct values.
			//			for (int i = 0; i < matrix.get(0).size(); i++) 
			//			{
			//				for (int j = 0; j < matrix.size(); j++) {
			//					System.out.println(matrix.get(i).get(j));
			//				}
			//			}
			//
			bfs(matrix);


		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static <T, U> List<U> 
	convertStringListToIntList(List<T> listOfString, 
			Function<T, U> function) 
	{ 
		return listOfString.stream().map(function).collect(Collectors.toList()); 
	} 

	public static void bfs(List<List<Integer>> matrix)
	{
		//x is used to verify that all vertices have been explored
		int x = matrix.size();
		//y is to use the lenght of the matrix
		int y = matrix.get(0).size();

		//for the order of evaluation
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);

		//To keep track of where you are
	
		

		List<Integer> resp = new ArrayList();
		
		String respfinal="";
		
		while(x>=0)
		{
//			System.out.println("entra");
			while(q.size() != 0)
			{
//				System.out.println("entra2");
//				System.out.println(q.element());
				for (int i = 0; i < y; i++) 
				{

					if (matrix.get(q.element()).get(i) == 1)
					{
						if(resp.lastIndexOf(i)==-1)
						{
//							System.out.println("entra3");
							q.add(i);
							resp.add(i);
						}
						else
						{
							break;
						}

						System.out.println(resp);
					}

				}
				x--;
//				System.out.println(x);
				q.remove();
			}
			resp.add(-1);

			if(verifyOtherElements(resp,y)==-1)
			{
				break;
			}
			q.add(verifyOtherElements(resp, y));
			resp.add(verifyOtherElements(resp, y));
		}
		System.out.println(resp);
		respfinal += "{";
		
		boolean segmento = false;
		for (int i = 0; i < resp.size(); i++)
		{
			if(resp.get(i)!=-1)
			{
				if(!segmento)
				{
					respfinal+="{";
				}	
				respfinal+=resp.get(i);
				if(resp.get(i+1)!=-1)
				{
					respfinal+=",";
				}
				segmento = true;
			}
			else
			{
				segmento = false;
				respfinal+="}";
			}
		}
		respfinal += "}";
		
		System.out.println(respfinal);
	}
	
	
	public static int verifyOtherElements(List<Integer> resp, int y)
	{
		int resp2 = -1;
		for (int i = 0; i < y; i++) 
		{
			for (int j = 0; j < resp.size(); j++)
			{
				if(!resp.contains(i))
				{
					resp2=i;

				}
			}
		}
		return resp2;
	}


}






//class Vertex
//{
//	public char label;
//	public boolean wasVisited;
//	
//	public Vertex(char lab)
//	{
//		label = lab;
//		wasVisited = false;
//	}
//
//}
//
//class Graph{
//
//	
//	private Vertex vertexList[];
//	private int adjMat[][];
//	private int nVerts;
//	private Queue<Integer> q;
//	
//	public Graph(List<List<Integer>> matrix) 
//	{
//		vertexList = new Vertex[matrix.size()];
//		adjMat = new int[matrix.size()][matrix.get(0).size()];
//		nVerts = 0;
//		q = new LinkedList<Integer>();
//	}
//	
//	public void addVertex(char lab) {
//		vertexList[nVerts++] = new Vertex(lab);
//	}
//	
//	public void addEdge(int start, int end)
//	{
//		adjMat[start][end] = 1;
//		adjMat[end][start] = 1;
//	}
//	
//	public void displayVertex(int v)
//	{
//		System.out.println(vertexList[v].label);
//	}
//	
//	public int getAdjUnvisitedVertex (int v)
//	{
//		
//		for (int i = 0; i < nVerts; i++)
//		{
//			if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
//				return i;
//		}
//		return -1;
//	}
//	
//	public void bfs() 
//	{
//		
//		vertexList[0].wasVisited = true;
//		displayVertex(0);
//		q.add(0);
//		int v2;
//		
//		while(!q.isEmpty())
//		{
//			int v1 = q.remove();
//			while((v2=getAdjUnvisitedVertex(v1))!=-1)
//			{
//				vertexList[v2].wasVisited = true;
//				displayVertex(v2);
//				q.add(v2);
//			}
//		}
//	}
//}







//public int[][] transformToArrays(List<List<Integer>> matrix)
//{
//	int [][] array = new int[matrix.size()][matrix.get(0).size()];
//	for (int i = 0; i < matrix.size(); i++) {
//	    ArrayList<String> row = matrix.get(i);
//	    array[i] = row.toArray(new int[row.size()]);
//	}
//	return array;
//}


//// prints BFS traversal from a given source s 
//void BFS(int s) 
//{ 
//  // Mark all the vertices as not visited(By default 
//  // set as false) 
//  boolean visited[] = new boolean[V]; 
//
//  // Create a queue for BFS 
//  LinkedList<Integer> queue = new LinkedList<Integer>(); 
//
//  // Mark the current node as visited and enqueue it 
//  visited[s]=true; 
//  queue.add(s); 
//
//  while (queue.size() != 0) 
//  { 
//      // Dequeue a vertex from queue and print it 
//      s = queue.poll(); 
//      System.out.print(s+" "); 
//
//      // Get all adjacent vertices of the dequeued vertex s 
//      // If a adjacent has not been visited, then mark it 
//      // visited and enqueue it 
//      Iterator<Integer> i = adj[s].listIterator(); 
//      while (i.hasNext()) 
//      { 
//          int n = i.next(); 
//          if (!visited[n]) 
//          { 
//              visited[n] = true; 
//              queue.add(n); 
//          } 
//      } 
//  }



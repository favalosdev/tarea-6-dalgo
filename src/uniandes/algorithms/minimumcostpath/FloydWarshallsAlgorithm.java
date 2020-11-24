package uniandes.algorithms.minimumcostpath;

public class FloydWarshallsAlgorithm implements MinimumCostPathAlgorithm {
	
	public Double[][] findPaths(Double[][] weight) {		
		// Change non-existent edges, otherwise the algorithm won't work
		
		// TODO: Revisar cambio aquí
		
		return floydWarshall(weight);
	}
	
	private Double[][] floydWarshall(Double[][] weight) {
		int n = weight.length;
		
		Double [][] distances = weight;
		
		for (int k = 1; k < n; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (!weight[i][j].equals(Double.POSITIVE_INFINITY)) 
						distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
				}
			}
		}
		
		return distances;
	}
}

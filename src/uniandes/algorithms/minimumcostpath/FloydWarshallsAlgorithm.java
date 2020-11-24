package uniandes.algorithms.minimumcostpath;

public class FloydWarshallsAlgorithm {

	private Double[][] weight;
	
	public FloydWarshallsAlgorithm(Double[][] weight) {
		this.weight = weight;
	}
	
	public Double[][] findPaths() {		
		// Change non-existent edges, otherwise the algorithm won't work
		
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight.length; j++) {
				if (weight[i][j] == -1) {
					weight[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}

		Double [][] distances = weight;

		for (int k = 1; k < weight.length; k++) {
			for (int i = 1; i < weight.length; i++) {
				for (int j = 1; j < weight.length; j++) {		
					distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
				}
			}
		}

		return distances;
	}
}

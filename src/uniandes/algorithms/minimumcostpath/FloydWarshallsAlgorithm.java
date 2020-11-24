package uniandes.algorithms.minimumcostpath;

public class FloydWarshallsAlgorithm implements MinimumCostPathAlgorithm {

	public Double[][] findPaths(Double[][] weight) {		
		// Change non-existent edges, otherwise the algorithm won't work

		// TODO: Filtrar los valores de acuerdo a lo que se observa.

		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight.length; j++) {
				if (weight[i][j] == - 1) {
					weight[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}

		return floydWarshall(weight);
	}

	private Double[][] floydWarshall(Double[][] weight) {
		int n = weight.length;

		Double [][] distances = weight;

		for (int k = 1; k < n; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
				}
			}
		}

		return distances;
	}
}

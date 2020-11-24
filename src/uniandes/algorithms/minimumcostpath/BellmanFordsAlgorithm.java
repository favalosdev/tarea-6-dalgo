package uniandes.algorithms.minimumcostpath;
import algorithms.exceptions.InvalidGraphException;

public class BellmanFordsAlgorithm implements MinimumCostPathAlgorithm {

	public Double[][] findPaths(Double[][] weight) {

		// Create matrix to calculate the things as they should be
		try {
			int n = weight.length;

			Double[][] minimumCosts = new Double[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Double[] cost = bellmanFord(weight, i);
					minimumCosts[j][i] = cost[j];
				}
			}
			
			return minimumCosts;
		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Double[] bellmanFord(Double [][] weight, int source) throws InvalidGraphException {

		// Create estimates
		int n = weight.length;

		Double[] shortestPathEstimate = new Double[n];
		Integer[] parent = new Integer[n];

		for (int i = 0; i < n; i++) {
			shortestPathEstimate[i] = Double.POSITIVE_INFINITY;
			parent[i] = null;
		}

		shortestPathEstimate[source] = 0.0;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (shortestPathEstimate[k] > shortestPathEstimate[j] + weight[j][k]) {
						shortestPathEstimate[k] = shortestPathEstimate[j] + weight[j][k];
						parent[k] = j;
					} 
				}
			}
		}

		// Construct matrix with estimates from each point

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (shortestPathEstimate[x] > shortestPathEstimate[y] + weight[y][x])
					throw new InvalidGraphException("The graph is invalid because it contains a negative cycle in it.");
			}
		}

		return shortestPathEstimate;
	}

}

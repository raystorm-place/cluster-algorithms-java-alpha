/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.util.CalculationUtil;
import de.raystorm.algorithm.distance.EuclideanDistance;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.output.Cluster;

import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Markus
 *Dieser Index misst die G�te eines gegebenen Clusterings. Jes besser das Clustering desto
  groesser wird der Index
  
  The idea behind the CH measure is to compute the sum of squared errors
(distances) between the kth cluster and the other k - 1 clusters, and
compare that to the internal sum of squared errors for the k clusters
(taking their individual squared error terms and summing them). 
In effect, this is a measure of inter-cluster
dissimilarity over intra-cluster dissimilarity.

Now, if B(k) and W(k) are both measures of difference/dissimilarity, then
a larger CH value indicates a better clustering, since the between
cluster difference should be high, and the within cluster difference
should be low. 

another way to calculate B(k) is 
B = T - W 
where T is the sum of squared error for all elements to the global average
 */
public class CalinskiHarabasz   {
	
	public float calculateIndex(Dataset clusteredData) {
		
		int numOfElemetns = clusteredData.size();
		int numOfClusters = clusteredData.getClustermap().size();
		EuclideanDistance dm = new EuclideanDistance();
		float[] centeroidOfAllData = this.getCentroidOfDataset(clusteredData);
		Map<Integer, Cluster> clustermap = clusteredData.getClustermap();
		//to calculate this index we need at least two clusters
		if (clustermap.size() >= 2) {
		// To calculate CH-index we need to calc. the squared error function for
		// every cluster (within cluster ss) and the sse between the centroids of the
		//clusters and the global centroid (between cluster).
		
		
		
			LinkedHashSet<Integer> keys = new LinkedHashSet<Integer>();
			keys.addAll(clustermap.keySet());
			Float withinSumOfSquares = 0.0f, betweenSumOfSquares = 0.0f;
			 //for all clusters calc withinSS and betweenSS
			for (Integer integer : keys) {
				Cluster cluster = clustermap.get(integer);
				withinSumOfSquares += cluster.getSumOfSquaredError(dm);
				
				betweenSumOfSquares += (cluster.size())*(float)Math.pow(dm.calculate(centeroidOfAllData, cluster.getCentroid()),2);

			}

			// withinSumOfSquares =
			// float ch = (numOfClusters - numOfElemetns);
			float CH =  (betweenSumOfSquares / (numOfClusters -1)) /
						(withinSumOfSquares /(numOfElemetns-numOfClusters));
			return CH;
		} else{
			//there are less than 2 clusters wich means we can't calculate this index
			// (results in division by zero). return NAN
			return Float.NaN;
		}

		

	}

	/**
	 * This calculates the "average" point of a dataset
	 * @param clusteredData the dataset
	 * @return the centroid of the dataset
	 */
	private float[] getCentroidOfDataset(Dataset clusteredData) {

		
		if (clusteredData.size() == 0) {
			throw new IllegalArgumentException("empty dataset passed "
					+ clusteredData
					+ " there must be at least one datapoint in the dataset");
		} else {
			// start with the first element
			float[] sum = clusteredData.get(0).getFeatures();
			for (int i = 1; i < clusteredData.size(); i++) {
				FeatureVector currVect = clusteredData.get(i);
				sum = CalculationUtil.vectorAddition(sum, currVect
						.getFeatures());
			}
			// calculate center of Cluster by dividing sum by number of
			// clusterelements
			float[] centroid = CalculationUtil.scalarMultiplication(
					1.0f / clusteredData.size(), sum);
			return centroid;
		}

	}
	

}

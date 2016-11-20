/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.distance.linkage.Linkage;
import de.raystorm.algorithm.input.Dataset;

import java.util.Map;

import de.raystorm.algorithm.output.Cluster;
import de.raystorm.algorithm.distance.EuclideanDistance;
import de.raystorm.algorithm.distance.linkage.SingleLinkage;

/**
 * the goal of this index is to maximize inter cluster distance (calculated by single linkage)
 * while minimizing intra-cluster distance. The bigger the better.
 * @author Markus
 *
 */
public class DunnIndex {
	
	public float calculateIndex(Dataset clusteredDataset){
		 Map<Integer, Cluster> clustermap = clusteredDataset.getClustermap();
		 Integer[] clusterIds = (Integer[]) clustermap.keySet().toArray(new Integer[0]);
		 
		 float maxIntraClusterdist = 0;
		 Float minClusterDistance = null;
		 float temp = 0;
		 float clustDist  ;
		 Cluster clusterA, clusterB;
		 EuclideanDistance dist = new EuclideanDistance();  //could be passed as param
		 Linkage singleLinkage = new SingleLinkage(dist);
		 
		 for (int i = 0; i < clusterIds.length; i++) {
			clusterA = clustermap.get(clusterIds[i]);
			temp = clusterA.getMaxIntraClusterDistance(dist);
			if (temp > maxIntraClusterdist) {
				maxIntraClusterdist = temp;
			}
			for (int j = i + 1; j < clusterIds.length; j++) {
				clusterB = clustermap.get(clusterIds[j]);
				clustDist = singleLinkage.calculateClusterdistance(clusterA, clusterB);
				if (minClusterDistance == null || clustDist < minClusterDistance){
					minClusterDistance = clustDist;
				}

			}
		}

		 if (minClusterDistance == null){
			 return Float.NaN; //This normaly means we have only one cluster
			 // and can therefore not calculate anything
		 }
		return   minClusterDistance / maxIntraClusterdist;
		
		
	}

}

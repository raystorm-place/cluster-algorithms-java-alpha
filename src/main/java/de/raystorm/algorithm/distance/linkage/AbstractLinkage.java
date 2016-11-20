/**
 * 
 */
package de.raystorm.algorithm.distance.linkage;

import de.raystorm.algorithm.distance.DistanceMeasure;
import de.raystorm.algorithm.output.Cluster;

/**
 * @author Markus
 *
 */
public abstract class AbstractLinkage implements Linkage  {
	
	protected DistanceMeasure distanceMeasure;
	
	public AbstractLinkage(DistanceMeasure distanceMeasure){
		this.distanceMeasure = distanceMeasure;
		
	}
	
	/* (non-Javadoc)
	 * @see Linkage#calculateClusterdistance(Cluster, Cluster)
	 */
	public float calculateClusterdistance(Cluster cluster1, Cluster cluster2) {
		return this.calculateClusterdistance(cluster1.getClusterelements(),
				cluster2.getClusterelements());
		
	}
	
	public String toString(){
		return this.getClass().getSimpleName();
	}

}

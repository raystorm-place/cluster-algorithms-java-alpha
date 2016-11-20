/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.Dataset;

/**
 * @author Markus
 *
 */
public class FowlkesMallowsIndex extends AbstractCountingPairsIndex{
	
	public float calculateIndex(Dataset clusteredData) {
		this.countPairs(clusteredData);
		double fowlkesMallowsIndex =  a / Math.sqrt((a + b) * (a + c));
		return (float) fowlkesMallowsIndex;

	}

}

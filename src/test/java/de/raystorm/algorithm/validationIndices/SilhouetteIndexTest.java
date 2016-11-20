/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.Leader;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class SilhouetteIndexTest {
	private Dataset trivialTestset;
	
	@Before
	public void setup(){
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =InputReader.readFromResourceFile("easy.valid");
		Leader leaderClusterer = new Leader();
		leaderClusterer.setEpsilon(1);
		leaderClusterer.doClustering(trivialTestset);
	}

	/**
	 * Test method for {@link DBIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		System.out.println(trivialTestset);
		SilhouetteIndex siIndex = new SilhouetteIndex();
		float result = siIndex.calculateIndex(this.trivialTestset);
		System.out.println("Average Silhouette for this Cluster is = "+ result);
	}

}

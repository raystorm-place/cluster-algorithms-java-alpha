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
public class BipartiteIndexTest {
	private Dataset trivialTestset;
	
	@Before
	public void setup(){

		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =InputReader.readFromResourceFile("90.valid");
		Leader leaderClusterer = new Leader();
		leaderClusterer.setEpsilon(10);
		leaderClusterer.doClustering(trivialTestset);
	}

	/**
	 * Test method for {@link DBIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		BPIndex bpIndex = new BPIndex();
		float result = bpIndex.calculateIndex(this.trivialTestset);
		System.out.println("Bipartite-Index for this Clustering is = "+ result);
	}

}

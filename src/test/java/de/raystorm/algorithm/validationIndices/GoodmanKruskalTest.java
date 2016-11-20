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
public class GoodmanKruskalTest {

	private Dataset trivialTestset;
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
			this.trivialTestset =inputReader.readFromResourceFile("90.valid");
			Leader leaderClusterer = new Leader();
			leaderClusterer.setEpsilon(5);
			leaderClusterer.doClustering(trivialTestset);
	}
	
	/**
	 * Test method for {@link GoodmanKruskal#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		GoodmanKruskal gkCalculator = new GoodmanKruskal();
		System.out.println(gkCalculator.calculateIndex(trivialTestset));
	}

}

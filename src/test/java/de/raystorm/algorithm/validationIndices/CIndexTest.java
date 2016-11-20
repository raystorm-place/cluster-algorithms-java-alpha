/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import static org.junit.Assert.*;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;

import org.junit.Before;
import org.junit.Test;

import de.raystorm.algorithm.algorithms.Leader;

/**
 * @author Markus
 *
 */
public class CIndexTest {
	private Dataset trivialTestset;
	
	@Before
	public void setup(){
		InputReader inputReader = new InputReader();
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =inputReader.readFromResourceFile("90.valid");
		Leader leaderClusterer = new Leader();
		leaderClusterer.setEpsilon(3);
		leaderClusterer.doClustering(trivialTestset);
	}

	/**
	 * Test method for {@link CIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		CIndex index = new CIndex();
		float result = index.calculateIndex(trivialTestset);
		assertEquals (0, result,0.01);
		System.out.println(result);
	}

}

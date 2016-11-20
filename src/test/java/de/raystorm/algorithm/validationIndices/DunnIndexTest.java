/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import static org.junit.Assert.assertEquals;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.Leader;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class DunnIndexTest {
	private Dataset trivialTestset;
	
	@Before
	public void setup(){
		InputReader inputReader = new InputReader();
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =inputReader.readFromResourceFile("easy.valid");
		Leader leaderClusterer = new Leader();
		leaderClusterer.setEpsilon(4);
		leaderClusterer.doClustering(trivialTestset);
	}

	/**
	 * Test method for {@link CIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		DunnIndex index = new DunnIndex();
		float result = index.calculateIndex(trivialTestset);
		System.out.println(trivialTestset);
		assertEquals (1.118034, result, 0.01); //TODO Stimmt das resultat?

	}

}

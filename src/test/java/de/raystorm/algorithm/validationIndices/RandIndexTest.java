/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.KMeans;
import de.raystorm.algorithm.distance.EuclideanDistance;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class RandIndexTest {
	private Dataset trivialTestset;

	
	@Before
	public void setup(){
		InputReader inputReader = new InputReader();
	
		this.trivialTestset =inputReader.readFromResourceFile("90.valid");
		KMeans kmeans = new KMeans(new EuclideanDistance(),100) ;
		kmeans.doClustering(trivialTestset);

	}

	/**
	 * Test method for {@link DBIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		RandIndex ji = new RandIndex();
		float result = ji.calculateIndex(this.trivialTestset);
		System.out.println(this.trivialTestset);
		System.out.println( "Rand Index = "+ result);
	}


}

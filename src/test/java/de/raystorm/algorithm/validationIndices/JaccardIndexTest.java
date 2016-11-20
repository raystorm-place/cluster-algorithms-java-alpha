/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.distance.EuclideanDistance;
import de.raystorm.algorithm.algorithms.KMeans;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class JaccardIndexTest {
	private Dataset trivialTestset;

	
	@Before
	public void setup(){
		InputReader inputReader = new InputReader();
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =inputReader.readFromResourceFile("easy.valid");
		KMeans kmeans = new KMeans(new EuclideanDistance(),3) ;
		kmeans.doClustering(trivialTestset);

	}

	/**
	 * Test method for {@link DBIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		JaccardIndex ji = new JaccardIndex();
		float result = ji.calculateIndex(this.trivialTestset);
		System.out.println( "Jaccard Index = "+ result);
	}


}

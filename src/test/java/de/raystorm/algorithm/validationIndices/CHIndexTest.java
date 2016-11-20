/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import static org.junit.Assert.assertEquals;
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
public class CHIndexTest {
	private Dataset trivialTestset;
	
	@Before
	public void setup(){
		InputReader inputReader = new InputReader();
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		this.trivialTestset =inputReader.readFromResourceFile("easy.valid");
//		Leader leaderClusterer = new Leader();
//		leaderClusterer.setEpsilon(2);
//		leaderClusterer.doClustering(trivialTestset);
		KMeans kmeans = new KMeans(new EuclideanDistance());
		kmeans.setNumOfClusters(10);
		kmeans.doClustering(this.trivialTestset);
	}

	/**
	 * Test method for {@link CIndex#calculateIndex(Dataset)}.
	 */
	@Test
	public void testCalculateIndex() {
		System.out.println(trivialTestset);
		CalinskiHarabasz index = new CalinskiHarabasz();
		float result = index.calculateIndex(trivialTestset);
		assertEquals (77.109, result, 0.01); //this is the result for this clustering with 100% accuracy
		
	}

}


package de.raystorm.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.input.InputReader;

import org.junit.Before;
import org.junit.Test;

import de.raystorm.algorithm.algorithms.FastGlobalKMeans;
import de.raystorm.algorithm.distance.EuclideanDistance;

/**
 * @author Markus
 *
 */
public class FastGlobalKMeansTest {
	
	private Dataset testset;
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			this.testset =inputReader.readFromResourceFile("90.valid");
			this.testset.reset();
	}
	
	
	
	@Test
	public void testFastGlobalKMeans(){
		for (FeatureVector featureVector : testset) {
			assertEquals(FeatureVector.UNCLASSIFIED ,featureVector.getCalculatedClusternumber() );
		}
		FastGlobalKMeans fgkm = new FastGlobalKMeans( new EuclideanDistance());
		fgkm.doClustering(testset);

		for (FeatureVector featureVector : testset) {
			 assertFalse(FeatureVector.UNCLASSIFIED == featureVector.getCalculatedClusternumber());
		}
		System.out.print(testset.toString());
	}
}

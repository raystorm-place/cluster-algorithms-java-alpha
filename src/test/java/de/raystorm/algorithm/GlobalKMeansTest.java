/**
 * 
 */
package de.raystorm.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.GlobalKMeans;
import de.raystorm.algorithm.distance.EuclideanDistance;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class GlobalKMeansTest {
	
	private Dataset testset;
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			this.testset =inputReader.readFromResourceFile("trivial.valid");
			this.testset.reset();
	}
	
	
	
	@Test
	public void testGlobalKMeans(){
		for (FeatureVector featureVector : testset) {
			assertEquals(FeatureVector.UNCLASSIFIED ,featureVector.getCalculatedClusternumber() );
		}
		GlobalKMeans gkm = new GlobalKMeans( new EuclideanDistance());
		gkm.doClustering(testset);

		for (FeatureVector featureVector : testset) {
			 assertFalse(FeatureVector.UNCLASSIFIED == featureVector.getCalculatedClusternumber());
		}
		System.out.print(testset.toString());
	}
}
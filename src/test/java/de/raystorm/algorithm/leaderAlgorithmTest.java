/**
 * 
 */
package de.raystorm.algorithm;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.Leader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Markus
 *
 */
public class leaderAlgorithmTest {
	
	private Dataset testset;
	
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			this.testset =inputReader.readFromResourceFile("90.valid");
				
	}
	
	
	
	@Test
	public void testleaderClustering(){
		for (FeatureVector featureVector : testset) {
			assertEquals(-1 ,featureVector.getCalculatedClusternumber() );
		}
		Leader leaderClusterer = new Leader();
		leaderClusterer.setEpsilon(14.6f);
		leaderClusterer.doClustering(testset);
		for (FeatureVector featureVector : testset) {
			 assertFalse(-1 == featureVector.getCalculatedClusternumber());
		}
		System.out.print(testset.toString());
	}

}

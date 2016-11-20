/**
 * 
 */
package de.raystorm.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.input.InputReader;

import org.junit.Before;
import org.junit.Test;

import de.raystorm.algorithm.algorithms.DBSCAN;

/**
 * @author Markus
 *
 */
public class DBSCANTest {
	
	private Dataset testset;
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			this.testset =inputReader.readFromResourceFile("easy.valid");
				
	}
	
	
	
	@Test
	public void testDBSCANClustering(){
		for (FeatureVector featureVector : testset) {
			assertEquals(FeatureVector.UNCLASSIFIED ,featureVector.getCalculatedClusternumber() );
		}
		DBSCAN dbscanClusterer = new DBSCAN();
		dbscanClusterer.setEpsilon(3f);
		dbscanClusterer.setMinPoints(2);
		dbscanClusterer.doClustering(testset);
		for (FeatureVector featureVector : testset) {
			 assertFalse(FeatureVector.UNCLASSIFIED == featureVector.getCalculatedClusternumber());
		}
		System.out.print(testset.toString());
	}
}

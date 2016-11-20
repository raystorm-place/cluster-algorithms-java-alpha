package de.raystorm.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.FeatureVector;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.algorithms.HierarchicalClustering;
import de.raystorm.algorithm.distance.EuclideanDistance;
import de.raystorm.algorithm.distance.linkage.SingleLinkage;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Markus
 *
 */
public class HierarchicalTest {
	
	private Dataset testset;
	@Before
	public void setUp(){
			InputReader inputReader = new InputReader();
			this.testset =inputReader.readFromResourceFile("90.valid");
			this.testset.reset();
	}
	
	
	
	@Test
	public void testHierarchicalClustering(){
		for (FeatureVector featureVector : testset) {
			assertEquals(FeatureVector.UNCLASSIFIED ,featureVector.getCalculatedClusternumber() );
		}
		HierarchicalClustering htClusterer = new HierarchicalClustering(new SingleLinkage(new EuclideanDistance()));
		htClusterer.setLimit(745);
		htClusterer.doClustering(testset);
		
		for (FeatureVector featureVector : testset) {
			 assertFalse(FeatureVector.UNCLASSIFIED == featureVector.getCalculatedClusternumber());
		}
		System.out.print(testset.toString());
	}
}
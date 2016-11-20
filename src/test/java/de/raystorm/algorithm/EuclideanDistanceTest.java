/**
 * 
 */
package de.raystorm.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import de.raystorm.algorithm.distance.EuclideanDistance;

/**
 * @author Markus
 *
 */
public class EuclideanDistanceTest {

	/**
	 * Test method for {@link EuclideanDistance#calculate(float[], float[])}.
	 */
	@Test
	public void testCalculate() {
		EuclideanDistance euDist = new EuclideanDistance();
		float[] a = {0,0};
		float[] b = {0,2};
		float[] c = {3,0};
		float[] d = {4,4};
		assertEquals(2,euDist.calculate(a, b), 0.01);
		assertEquals (3, euDist.calculate(a, c), 0.01);
		assertEquals (5.65, euDist.calculate(a, d), 0.01);
		assertEquals (4.123,euDist.calculate(c, d), 0.01);
	}

}

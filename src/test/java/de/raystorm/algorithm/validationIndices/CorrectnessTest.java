/**
 * 
 */
package de.raystorm.algorithm.validationIndices;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author Markus
 *
 */
public class CorrectnessTest {

	private Dataset resultSet;
	@Before
	public void setUp(){
	
			this.resultSet = InputReader.readFromResourceFile("easyFullyCorrect.result",true);
			
	}
	
	@Test
	public void testIndices(){
		CIndex cIndex = new CIndex();
		DBIndex  dbIndex = new DBIndex();
		DunnIndex dunnIndex = new DunnIndex();
		GoodmanKruskal gkIndex = new GoodmanKruskal();
		JaccardIndex jIndex = new JaccardIndex();
		FowlkesMallowsIndex fwIndex = new FowlkesMallowsIndex();
		RandIndex rIndex = new RandIndex();
		BPIndex bpIndex = new BPIndex();
		SilhouetteIndex si = new SilhouetteIndex();
		
		assertEquals(1,rIndex.calculateIndex(resultSet), 0.01);
		assertEquals(1,fwIndex.calculateIndex(resultSet), 0.01);
		assertEquals(1,jIndex.calculateIndex(resultSet), 0.01);
		assertEquals(1,bpIndex.calculateIndex(resultSet), 0.01);
		
		assertEquals(0,cIndex.calculateIndex(resultSet), 0.01);
		assertEquals(1,gkIndex.calculateIndex(resultSet), 0.01);
		assertEquals(0.17,dbIndex.calculateIndex(resultSet), 0.01);
		assertEquals(1.11,dunnIndex.calculateIndex(resultSet), 0.01);
		assertEquals(0.761,si.calculateIndex(resultSet), 0.01);

		
		
	}
	
}

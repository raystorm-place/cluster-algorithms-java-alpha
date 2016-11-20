package de.raystorm.algorithm;


import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import static org.junit.Assert.*;
import org.junit.Test;

public class InputReaderTest {

	@Test
	public void testReadFromfile() {
		InputReader inputReader = new InputReader();
		Dataset testset =inputReader.readFromResourceFile("90.valid");
		assertEquals(90,testset.get(0).getDimension());
		assertEquals(5.34285,testset.get(0).getFeatures()[0],0.00001);
		assertEquals(750,testset.size());
		
	}

}

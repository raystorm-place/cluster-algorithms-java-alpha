package de.raystorm.algorithm;

import de.raystorm.algorithm.validationIndices.CIndexTest;
import de.raystorm.algorithm.validationIndices.GoodmanKruskalTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  EuclideanDistanceTest.class,
  InputReaderTest.class,
  leaderAlgorithmTest.class,
  CIndexTest.class,
  GoodmanKruskalTest.class
  
  
})
public class AllTests {
    // the class remains completely empty, 
    // being used only as a holder for the above annotations
}

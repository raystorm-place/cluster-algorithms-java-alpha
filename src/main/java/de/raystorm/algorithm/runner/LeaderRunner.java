/**
 * 
 */
package de.raystorm.algorithm.runner;

import de.raystorm.algorithm.algorithms.Leader;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.output.ValidationWriter;

import java.util.HashMap;
import java.util.Map;

import de.raystorm.algorithm.algorithms.Algorithms;
import de.raystorm.algorithm.distance.EuclideanDistance;

/**
 * @author Markus
 *
 */
public class LeaderRunner {
	
	public static void main(String[] args) {
		String inputFileName,outputFileName;
		float epsilon;
		if (args.length ==3){
			//read input file path
			inputFileName = args[0];
			outputFileName = args[1];
			epsilon = Float.valueOf(args[2]);
		}
		else{
			throw new IllegalArgumentException();
		}
		Dataset dataset = InputReader.readFromfile(inputFileName);
		
		Leader leader = new Leader();
		leader.setEpsilon(epsilon);
		leader.setDistMeasure(new EuclideanDistance());
		leader.doClustering(dataset);
		InputReader.writeDatasetToFile(outputFileName , dataset);
		Map<String,String> params = new HashMap<String,String>();
		params.put(ValidationWriter.LEADER_EPSILON_LABEL,String.valueOf(epsilon));
		ValidationWriter.printValidationIndices("LEADER", params, dataset);
		ValidationWriter.writeValidationIndice(outputFileName, "Leader", params, dataset);
		ValidationWriter.writeToCSV("result.csv", Algorithms.Leader, dataset, params);


	}

}

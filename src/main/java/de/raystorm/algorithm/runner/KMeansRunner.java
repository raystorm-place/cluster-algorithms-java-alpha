/**
 * 
 */
package de.raystorm.algorithm.runner;

import de.raystorm.algorithm.algorithms.KMeans;
import de.raystorm.algorithm.output.ValidationWriter;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;

import java.util.HashMap;
import java.util.Map;

import de.raystorm.algorithm.algorithms.Algorithms;
import de.raystorm.algorithm.distance.EuclideanDistance;

/**
 * Starts a run of the kmeans algorithm with specifeid parameters and
 * saves results to a file
 * @author Markus
 *
 */
public class KMeansRunner {
	
	public static void main(String[] args) {
		String inputFileName,outputFileName;
		int numOfClusters;
		if (args.length ==3){
			//read input file path
			inputFileName = args[0];
			outputFileName = args[1];
			numOfClusters = Integer.valueOf(args[2]);
		}
		else{
			throw new IllegalArgumentException();
		}
		Dataset dataset = InputReader.readFromfile(inputFileName);

		KMeans kmeans = new KMeans(new EuclideanDistance(),numOfClusters);
		kmeans.doClustering(dataset);
		InputReader.writeDatasetToFile(outputFileName , dataset);
		Map<String,String> params = new HashMap<String,String>();
		params.put(ValidationWriter.KMEANS_K_LABEL,String.valueOf(numOfClusters));
		ValidationWriter.printValidationIndices("KMEANS", params, dataset);
		ValidationWriter.writeToCSV("kmeansResults.csv", Algorithms.KMeans, dataset, params);
		ValidationWriter.writeValidationIndice(outputFileName, "KMeans", params, dataset);

	}

}

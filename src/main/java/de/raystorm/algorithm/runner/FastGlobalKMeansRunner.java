package de.raystorm.algorithm.runner;

import de.raystorm.algorithm.output.ValidationWriter;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;

import java.util.HashMap;
import java.util.Map;

import de.raystorm.algorithm.distance.EuclideanDistance;
import de.raystorm.algorithm.distance.linkage.SingleLinkage;

import de.raystorm.algorithm.algorithms.FastGlobalKMeans;
import de.raystorm.algorithm.algorithms.HierarchicalClustering;

/**
 * 
 * @author Markus
 * 
 */
public class FastGlobalKMeansRunner {

	public static void main(String[] args) {
		String algorithm, inputFileName, outputFileName;
		Integer upperClusterLimit = null;
		if (args.length == 4) {
			algorithm = args[0];
			// read input file path
			inputFileName = args[1];
			outputFileName = args[2];
			upperClusterLimit = Integer.valueOf(args[3]);
		} else if (args.length == 3) {
			algorithm = args[0];
			inputFileName = args[1];
			outputFileName = args[2];
		}

		else {
			throw new IllegalArgumentException();
		}
		Dataset dataset = InputReader.readFromfile(inputFileName);

		if (algorithm.equalsIgnoreCase("fgkm")){
			FastGlobalKMeans fgkm = new FastGlobalKMeans(new EuclideanDistance());
			fgkm.setLimit(upperClusterLimit);
			fgkm.doClustering(dataset);
			InputReader.writeDatasetToFile(outputFileName, dataset);
			Map<String, String> params = new HashMap<String, String>();
			ValidationWriter.writeValidationIndice(outputFileName, "FGKM", params, dataset);
		}
		else if(algorithm.equalsIgnoreCase("hierarchical")){
		
			HierarchicalClustering hc = new HierarchicalClustering(
					new SingleLinkage(new EuclideanDistance()),true);
			hc.setLimit(upperClusterLimit);
			hc.doClustering(dataset);
			Map<String, String> params = new HashMap<String, String>();
			params.put(ValidationWriter.KMEANS_K_LABEL, String.valueOf(upperClusterLimit));
			InputReader.writeDatasetToFile(outputFileName, dataset);
		
		}
	

	}

}

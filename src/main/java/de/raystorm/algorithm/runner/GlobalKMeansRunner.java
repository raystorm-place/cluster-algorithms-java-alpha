package de.raystorm.algorithm.runner;

import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;
import de.raystorm.algorithm.validationIndices.CIndex;
import de.raystorm.algorithm.validationIndices.RandIndex;
import de.raystorm.algorithm.algorithms.GlobalKMeans;
import de.raystorm.algorithm.distance.EuclideanDistance;

	/**
	 * @author Markus
	 *
	 */
	public class GlobalKMeansRunner {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			InputReader inputReader = new InputReader();
			//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
			Dataset dataSet =InputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\easy.valid");
			GlobalKMeans gkmeansClusterer = new GlobalKMeans(new EuclideanDistance());
		
			CIndex cIndex = new CIndex();
			RandIndex randIndex = new RandIndex();
			float bestIndex = 0.0f;
			int best_NumClust = 1;
			gkmeansClusterer.doClustering(dataSet);
			for (int i = 1; i <= dataSet.size(); i++) {
				gkmeansClusterer.getPartialResult(dataSet, i)	;			
				float index = randIndex.calculateIndex(dataSet);
				System.out.println("The Rand index for "+ i+" clusters is "+ index);
				if (index >= bestIndex){
					bestIndex = index;
					best_NumClust = i;
					
				}
					
			}
			System.out.println("The best number of cluster is " + best_NumClust +" with a rand index of "+ bestIndex);
		

	}


}

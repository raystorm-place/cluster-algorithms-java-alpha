/**
 * 
 */
package de.raystorm.algorithm.runner;

import de.raystorm.algorithm.algorithms.KMeans;
import de.raystorm.algorithm.input.Dataset;
import de.raystorm.algorithm.input.InputReader;

import java.util.ArrayList;
import java.util.List;

import de.raystorm.algorithm.validationIndices.CIndex;
import de.raystorm.algorithm.validationIndices.GoodmanKruskal;
import de.raystorm.algorithm.distance.EuclideanDistance;

/**
 * @author Markus
 *
 */
public class KMeansOptimizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader inputReader = new InputReader();
		//this.testset =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		Dataset dataSet =inputReader.readFromfile("C:\\Users\\Markus\\Documents\\Masterarbeit\\Workspace\\Clusterer\\src\\90.valid");
		KMeans kmeansClusterer = new KMeans();
		kmeansClusterer.setDistanceMeasure(new EuclideanDistance());
		

		CIndex cIndex = new CIndex();
		float globalMinIndex =1.0f ;
		int globalMinNumberclust = 0;
		GoodmanKruskal kruski = new GoodmanKruskal();
		List <Float> indexvalues = new ArrayList();
		for (int i = 2; i <=  40; i++  ){
			System.out.println("Iteration " +i+" of 40");
			kmeansClusterer.setNumOfClusters(i);
			for (int j = 0; j <5; j++){
				kmeansClusterer.doClustering(dataSet);
				float index = cIndex.calculateIndex(dataSet);
				if (index < globalMinIndex){
					globalMinIndex = index;
					globalMinNumberclust = i;
				}
				indexvalues.add(index);
				System.out.println ("The C index for K-Means with "+i + " clusters is: "+index );
			}

			

		}
		System.out.println("The best value for numOfClust is " + globalMinNumberclust + " and the smallest value of the cIndex was "+globalMinIndex);

	}

}

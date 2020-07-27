package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import graph.Edge;
import javafx.util.Pair;

@SuppressWarnings("restriction")
public class PrimsAlgorithm {

	List<Integer> visitedVertices = new ArrayList<Integer>();
	Map<Integer, Integer> keyMap = new HashMap<Integer, Integer>();

	public void findMinSpanningTree(LinkedList<Edge>[] adjacencylist, int vertices, int start) {
		List<ResultSet> rs = new ArrayList<ResultSet>();

		// Step 1: Remove loop vertices going to the same vertex
		for (int i = 0; i <= vertices; i++) {
			rs.add(new ResultSet());
			List<Edge> list = adjacencylist[i];
			for (int j = 0; j < list.size(); j++) {
				keyMap.put(list.get(j).source, Integer.MAX_VALUE);
			}
		}
		/*
		 * Step 2: Create a priorityQueue with a comparator in Constructor Comparator is
		 * used for comparing the weights of adjacency vertices. For storing both
		 * Adjacency vertex (Destination) and Weight, we are using "Pair" from JavaFX
		 * Library
		 */
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(vertices,
				new Comparator<Pair<Integer, Integer>>() {
					@Override
					public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
						int weight1 = p1.getValue();
						int weight2 = p2.getValue();

						return weight1 - weight2;

					}
				});

		Pair<Integer, Integer> startPair = new Pair<Integer, Integer>(start, 0);
		pq.add(startPair);

		rs.get(start).parent = -1;
		rs.get(start).weight = 0;

		keyMap.put(start, 0);

		while (!pq.isEmpty()) {

			Pair<Integer, Integer> pair = pq.poll();
			int sourceVertex = pair.getKey();
			visitedVertices.add(sourceVertex);
			List<Edge> adjVertices = adjacencylist[sourceVertex];
			for (int i = 0; i < adjVertices.size(); i++) {
				int source = adjVertices.get(i).source;
				int destination = adjVertices.get(i).destination;
				int weight = adjVertices.get(i).weight;
				Pair<Integer, Integer> temp = new Pair<Integer, Integer>(destination, weight);
				if (!visitedVertices.contains(destination)) {
					if (keyMap.get(destination) > weight) {
						keyMap.put(destination, weight);
						pq.add(temp);
						rs.get(destination).parent = source;
						rs.get(destination).weight = weight;
					}
				}

			}
		}
		int total = 0;
		for (int i = 1; i < rs.size(); i++) {
			total = total + rs.get(i).weight;

		}
		System.out.println("Prim's Algorithm");
		System.out.println("Total Minimum Spanning Tree weight : " + total);
	}

	public class ResultSet {
		int parent;
		int weight;
	}
}
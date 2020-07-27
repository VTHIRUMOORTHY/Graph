package com.datastructures.Graph.Algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

import com.datastructures.Graph.Edge;

@SuppressWarnings("restriction")
public class KruskalsAlgorithm {

	Map<HashMap<Integer, Integer>, Integer> map = new HashMap<HashMap<Integer, Integer>, Integer>();
	Map<Integer, Integer> pathMap = new HashMap<Integer, Integer>();

	public void findMinSpanningTree(LinkedList<Edge>[] adjacencylist, int vertices) {
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(vertices,
				new Comparator<Pair<Integer, Integer>>() {
					@Override
					public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
						int weight1 = p1.getValue();
						int weight2 = p2.getValue();
						return weight1 - weight2;
					}
				});
		System.out.println(vertices);
		int counter = 0;
		for (int i = 0; i < vertices; i++) {
			LinkedList<Edge> list = adjacencylist[i];
			for (int j = 0; j < list.size(); j++) {
				int source = list.get(j).source;
				int destination = list.get(j).destination;
				int weight = list.get(j).weight;
				pathMap.put(source, destination);
				System.out.println("Destination : " + destination);
				System.out.println("Weight : " + weight);
				Pair<Integer, Integer> pair = new Pair<Integer, Integer>(destination, weight);
				pq.add(pair);

			}
		}
		System.out.println(pathMap);
	}

}

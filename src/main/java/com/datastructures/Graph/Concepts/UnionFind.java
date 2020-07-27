package com.datastructures.Graph.Concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnionFind {
	int[] parent;
	List<Integer> visited = new ArrayList<Integer>();

	public boolean isCycle(int start, Map<Integer, List<Integer>> map) {
		parent = new int[map.size()];

		for (int i = 0; i < map.size(); i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < map.size(); i++) {
			List<Integer> list = map.get(i);
			int sourceParent = find(i);
			visited.add(i);
			//System.out.println("Parent for source node " + i + " --> " + sourceParent);
			for (int j = 0; j < list.size(); j++) {
				int destinationParent = find(list.get(j));
				//System.out.println("Parent for destination node " + list.get(j) + " --> " + destinationParent);
				if (sourceParent == destinationParent) {
					if (sourceParent == -1) {
						union(i, list.get(j));
					} else if (!visited.contains(list.get(j))) {
						System.out.println("cycle");
						return true;
					}
				} else {
					union(i, list.get(j));
				}
			}
		}
		return false;

	}

	public void print() {
		for (int i = 0; i < parent.length; i++) {
			// System.out.println(parent[i]);
		}
	}

	public int find(int node) {
		if (parent[node] < 0) {
			return parent[node];
		} else {
			return find(parent[node]);
		}
	}

	public void union(int source, int dest) {
		if (parent[source] < 0) {
			parent[source] += -1;
		}
		//System.out.println("Parent for source node " + source + " --> " + parent[source]);
		parent[dest] = source;
		//System.out.println("Parent for destination node " + dest + " --> " + parent[dest]);
	}

}

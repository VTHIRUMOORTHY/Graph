package graph;

import concepts.ArticulationPoint;
import concepts.UnionFind;
import traversals.BFS;
import traversals.DFS;

class Main {

	public static void main(String args[]) {
		int vertices = 5;
		Graph g = new Graph();

		g.addEdge(1, 2, true);
		g.addEdge(1, 0, true);
		g.addEdge(2, 0, true);
		g.addEdge(0, 3, true);
		g.addEdge(3, 4, true);

		// print the graph.
		System.out.println("Graph:\n" + g.printGraph());

		BFS bfs = new BFS();
		// bfs.traverse(1, g.map);
		DFS dfs = new DFS();
		// dfs.traverse(1, g.map);
		ArticulationPoint ap = new ArticulationPoint();
		// ap.dfsTraverse(1, g.map);

		UnionFind uf = new UnionFind();
		uf.isCycle(0, g.map);
		uf.print();
	}
}

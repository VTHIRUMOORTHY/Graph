package graph;


import java.util.LinkedList;

import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;
import concepts.UnionFind;

public class WeightedGraph {
    

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        @SuppressWarnings("unchecked")
		Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices+1];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <= vertices ; i++) {
            	//System.out.println(i);
                adjacencylist[i] = new LinkedList<>();
            }
        }

        
        public void addEgde(int source, int destination, int weight) {
            Edge sourceEdge = new Edge(source, destination, weight);
            Edge destinationEdge = new Edge(destination, source, weight);
            adjacencylist[source].add(sourceEdge);
            adjacencylist[destination].add(destinationEdge);
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }
      public static void main(String[] args) {
            int vertices = 10;
            Graph graph = new Graph(vertices);
            graph.addEgde(1, 2, 1);
            graph.addEgde(1, 3, 7);
            graph.addEgde(2, 3, 5);
            graph.addEgde(2, 4, 3);
            graph.addEgde(2, 5, 4);
            graph.addEgde(3, 4, 1);
            graph.addEgde(3, 4, 9);
            graph.addEgde(4, 8, 9);
            graph.addEgde(4, 9, 3);
            //graph.addEgde(5, 5, 2);
            graph.addEgde(5, 4, 2);
            graph.addEgde(5, 6, 1);
            graph.addEgde(5, 8, 4);
            graph.addEgde(6, 7, 2);
            graph.addEgde(7, 8, 8);
            graph.addEgde(8, 10, 7);
            graph.addEgde(9, 10, 4);
            graph.printGraph();
            
            PrimsAlgorithm pa = new PrimsAlgorithm();
            //pa.findMinSpanningTree(graph.adjacencylist, vertices, 1);
            
            KruskalsAlgorithm ka = new KruskalsAlgorithm();
            ka.findMinSpanningTree(graph.adjacencylist, vertices);
            
           
        }
}

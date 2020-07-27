package com.datastructures.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	public Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public void addVertex(int label)
    {
        map.put(label, new LinkedList<Integer>());
    }

    public void removeVertex(int label)
    {
        if(hasVertex(label)) {
            map.values().stream().forEach(r -> r.remove(label));
        }
    }

    public void addEdge(int source, int destination, boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public void removeEdge(int source, int destination, boolean bidirectional)
    {
        if(bidirectional) {
            if (hasEdge(source, destination)) {
                map.get(source).remove(source);
                map.get(destination).remove(destination);
            }
        } else {
            map.get(destination).remove(destination);
        }

    }

    public boolean hasVertex(int label)
    {
        if (map.containsKey(label)) {
            System.out.println("The graph contains "
                    + label + " as a vertex.");
            return true;
        }
        else {
            System.out.println("The graph does not contain "
                    + label + " as a vertex.");
            return false;
        }
    }

    public boolean hasEdge(int source, int destination)
    {
        if (map.get(source).contains(destination)) {
            System.out.println("The graph has an edge between "
                    + source + " and " + destination + ".");
            return true;
        }
        else {
            System.out.println("The graph has no edge between "
                    + source + " and " + destination + ".");
            return false;
        }
    }

    public String printGraph()
    {
        StringBuilder builder = new StringBuilder();

        for (Integer v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (Integer w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

}

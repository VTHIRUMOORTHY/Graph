# Prim's Algorithm

### What is Prim's Algorithm?

Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph.

### Algorithm Steps

1. Remove all self-loops
2. Remove all parallel edges. If two nodes have a parallel edge, keep the one which has the least cost
3. **LOOP:** Select a random node. Check the outgoing edge\(s\) of that node and pick the edge with the least cost **\(Make sure no cycle is formed\)**
4. **LOOP END:** Check each node until all nodes are visited. **\(Stop at N-1 edges\)**

### Time Complexity

_**Best Case Complexity**_

O\(VlogV + ElogV\) = O\(ElogV\)O\(VlogV+ElogV\)=O\(ElogV\)

where V are the vertices and E are the edges of the graph.

### Concept

{% embed url="https://youtu.be/QyJ8gOss-Y8" %}

### Approach

**Adjacency List + Priority Queue with Comparator Interface + Pair Class**

1. Comparator is used for comparing the weights of the adjacency vertices
2. For storing both Adjacency vertex \(Destination\) and Weight, we are using "Pair" from JavaFX library

{% hint style="info" %}
**What is priority Queue? -** [**https://www.geeksforgeeks.org/priority-queue-class-in-java-2/**](https://www.geeksforgeeks.org/priority-queue-class-in-java-2/)\*\*\*\*

**What is Pair Class? -**  [**https://www.geeksforgeeks.org/pair-class-in-jav**a/](https://www.geeksforgeeks.org/pair-class-in-java/)\*\*\*\*
{% endhint %}

### Code Repository

{% embed url="https://github.com/VTHIRUMOORTHY/DSA/blob/master/src/main/java/com/datastructures/Graph/Algorithms/PrimsAlgorithm.java" %}

### Solution

{% embed url="https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv" %}



\*\*\*\*

\*\*\*\*

\*\*\*\*


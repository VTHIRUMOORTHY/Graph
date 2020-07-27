package com.datastructures.Graph.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS {

    Stack<Integer> s = new Stack<Integer>();
    List<Integer> result = new ArrayList<Integer>();


    public void traverse(int start, Map<Integer, List<Integer>> map) {
        /*
        Start with any vertex, check if all ADJ vertices are explored if so pop it else add it to stack and result set
        IMP: POP stack if all ADJ vertices are in result set
             PUSH stack (only ONE ADJ VERTEX) if that ADJ vertex is not in result
         */
        result.add(start);
        s.push(start);
        while (!s.isEmpty()) {
            int v = (int) s.peek();
            List<Integer> temp = map.get(v);
            if (result.containsAll(temp)){
                s.pop();
            }
            int i = 0;
            while (i < temp.size()) {
                if (!result.contains(temp.get(i))) {
                    s.push(temp.get(i));
                    result.add(temp.get(i));
                    break;
                }
                i += 1;
            }
        }
        System.out.println(result);
    }
}


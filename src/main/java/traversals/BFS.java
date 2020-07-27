package traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> result = new LinkedList<>();

    public List<Integer> traverse(int startNode, Map<Integer, List<Integer>> map){
       q.add(startNode);
       result.add(startNode);
       while(!q.isEmpty()){
           List<Integer> temp = map.get(q.peek());
           q.remove();
           for(int t : temp){
               if(!result.contains(t)) {
                    q.add(t);
                    result.add(t);
               }
           }
       }
       System.out.println(result);
       return result;
    }
}

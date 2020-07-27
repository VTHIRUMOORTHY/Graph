package concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ArticulationPoint {
	private List<Integer> points = new ArrayList<Integer>();
	private List<Integer> result = new ArrayList<Integer>();
	private Stack<Integer> s = new Stack<Integer>();
	private Map<Integer, Integer> dfn = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> lowValue = new HashMap<Integer, Integer>();
	private Map<Integer,Integer> backEdge = new HashMap<Integer, Integer>();

	// BACKEDGE - for every visited vertex 'v', if there is any adjacent 'u' such that 
	// u is already visited and u is not parent of v. (cycle)
	// 
	private List<Integer> findArticulationPoint(List<Integer> result, Map<Integer, List<Integer>> map) {
		System.out.println(result);
		for (int i = result.size() - 1; i >= 0; i--) {
			int vertex = result.get(i);
			int childValue = getMinLowOfChildren(i, vertex, map);
		}
		return points;
	}

	private int findBackEdge(List<Integer> childList, Map<Integer, List<Integer>> map, int vertex) {

		// 1 - [2,0]
		int parentIndex = result.indexOf(vertex);
		int childIndex = parentIndex + 1;

		// to handle last element
		if (childIndex == result.size()) {
			childIndex = childIndex - 1;
		}
		int childVertex = result.get(childIndex);
		System.out.format("Parent=%d, child=%s, childwithedge=%d", vertex, childList, childVertex);
		System.out.println();
		
		int backVertex = 0;
		for (int i = 0; i < childList.size(); i++) {
			if (childList.get(i) != childVertex) {
				System.out.format("backedge vertex = %d", childList.get(i));
				 backVertex = childList.get(i);
			}
		}
		return backVertex;
	}

	private int getMinLowOfChildren(int index, int vertex, Map<Integer, List<Integer>> map) {
		List<Integer> temp = map.get(vertex);
		int parentDfn = dfn.get(vertex);
		List<Integer> child = new ArrayList<Integer>();
		for (int i = 0; i < temp.size(); i++) {
			int childDfn = dfn.get(temp.get(i));
			if (childDfn > parentDfn) {
				child.add(temp.get(i));
			}
		}
		if (child.size() > 1) {
			findBackEdge(child, map, vertex);
		}
		// Condition for leaf node in spanning tree
		if(index == result.size()-1){
			lowValue.put(vertex, Math.min(dfn.get(vertex), Math.min(Integer.MAX_VALUE, Integer.MAX_VALUE)));
		}else if(index > 0 && index != result.size()-1){
			System.out.format("ind %d v=%d child %s Clowval=%s",index,result.get(index),child,lowValue.get(child.get(0)));
			lowValue.put(vertex, Math.min(dfn.get(vertex), Math.min(lowValue.get(child.get(0)), Integer.MAX_VALUE)));
			System.out.format(" insert%s",lowValue);
			System.out.println();
		}
		// a = [1,2,3,4] b = [1,2] c = a-b = [3,4]

		return 0;
	}

	public void dfsTraverse(int start, Map<Integer, List<Integer>> map) {
		int dfnCounter = 1;
		
		s.push(start);
		result.add(start);
		dfn.put(start, dfnCounter++);
		System.out.format("stack=%s discounter=%s Distime=%s", s.peek(),dfnCounter,dfn);
		System.out.println();
		while (!s.isEmpty()) {
			List<Integer> temp = map.get(s.peek());
			if (result.containsAll(temp)) {
				s.pop();
			}
			
			for (int i = 0; i < temp.size(); i++) {
				if (!result.contains(temp.get(i))) {
					int parentNode = s.peek();
					int childNode = temp.get(i);
					List<Integer> childAdjList = map.get(childNode); 
					for(int j=0; j< childAdjList.size(); j++) {
						if (result.contains(childAdjList.get(j)) && childAdjList.get(j) != parentNode) {
							System.out.println();
							System.out.format("BACKEDGE %s-%s", childNode,childAdjList.get(j));
						}
					}
					result.add(temp.get(i));
					s.push(temp.get(i));
					dfn.put(temp.get(i), dfnCounter++);
					
					/*
					if(lowValue.get(s.peek()) > lowValue.get(temp.get(i))) {
						
					}*/
					//System.out.format("stack=%s discounter=%s Distime: %s", s.peek(),dfnCounter,dfn);
					//System.out.println();
					break;
				}
				/*
				else {
					int childNode = temp.get(i);
					int childDfn = dfn.get(childNode);
					int parentNode = s.peek();
					int parentDfn = dfn.get(parentNode);
					if(lowValue.get(parentNode) > childDfn) {
						lowValue.put(parentNode, childDfn);
					}
				}*/
			}
		}
		System.out.format("Discovery time: %s", dfn);
		System.out.println();
		findArticulationPoint(result, map);
	}
}
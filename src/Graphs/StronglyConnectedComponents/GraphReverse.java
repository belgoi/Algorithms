/*
* Author: David Hinchliffe
* Class used by the client to instantiate the reverse graph object to hold the graph
*  in which the directed arcs are reversed...the head becomes the tail, and the tail becomes
*  the head
*/
package Graphs.StronglyConnectedComponents;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class GraphReverse extends AbstractGraph
{
    public GraphReverse()
    {
        graph=new HashMap<>();
        visitedNodes=new HashSet<>();
        finishingTime=new ArrayDeque<>();   
    }
    
    public Deque<Integer> getFinishingTime()
    {
        return finishingTime;
    }
    
    //here to maintain the AbstractGraph type as used by the client. 
    //method is used by the Graph class. 
    public void setFinishingTime(Deque<Integer> finishingTime){};
    
    //just here to maintain the AbstractGraph type as used by the client. 
    //if client does call it, nothing happens.  
    public void computeScc(){}
    
    //helper loop for the dfsRecursive call.
    public void dfsLoop()
    {
      //traverse the graph in descending order starting at the max key  
      for(int node = maxKey;node>0;node--)
         {
             //visit only those nodes not already visited and are present in the graph, since some
             //tails are absent in forward graph, this has to be checked. 
             if (!visitedNodes.contains(node) && graph.containsKey(node) )
                 dfsRecursive(node);
         }  
    }
    
    //determines the finishing time or the "magical" ordering of the nodes used on the 2nd pass
    private void dfsRecursive(int node)
    {
        //mark node as visited
        visitedNodes.add(node);

        //traverse the graph in reverse order
            for(Integer edge: getEdges(node))
                if (!visitedNodes.contains(edge))
                {
                    dfsRecursive(edge);
                }       
            finishingTime.push(node);

    }
    
}

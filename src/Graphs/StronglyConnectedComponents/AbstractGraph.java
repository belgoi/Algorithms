
/*
* Author: David Hinchliffe
* Abstract class for the two graph classes
* Graph and GraphReverse
*/
package Graphs.StronglyConnectedComponents;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class AbstractGraph
{       
    Map<Integer,Edges> graph;
    Set<Integer> visitedNodes;
    Deque<Integer> finishingTime;
    int maxKey;

    abstract void dfsLoop();
    abstract void computeScc();
    abstract void setFinishingTime(Deque<Integer> finishingTime);
    abstract Deque<Integer>getFinishingTime();
    
    
    //add an edge into the set associated with the key 
    public void addEdge(int key,int edge)
    {
        Edges newEdge;
        if (graph.containsKey(key))
            (graph.get(key)).addEdge(edge);
        else
        {
            newEdge=new Edges();
            newEdge.addEdge(edge);
            graph.put(key,newEdge);
            maxKey= maxKey>key?maxKey:key;
        }
    }
    
    //returns the edge set for the key in the graph
    public Set<Integer> getEdges(int node)
    {
        Edges currentNode;
        Set<Integer> edges = new HashSet<>();
        Iterator it;
        if (graph.containsKey(node))
        {
            currentNode=graph.get(node);
            it=currentNode.getIterator();
            while(it.hasNext())
                edges.add((Integer)it.next());
        }
        return edges;
    }
}

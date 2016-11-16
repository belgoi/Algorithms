/*
* Author: David Hinchliffe
* Class for the edges of the graph
*/
package Graphs.StronglyConnectedComponents;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Edges
{
    private Set<Integer> edges;
    public Edges()
    {
        edges=new HashSet<>();
    }
     public Iterator getIterator()
    {
        return edges.iterator();
    }
    public void addEdge(int head)
    {
        edges.add(head);
    }
    public int getSize()
    {
        return edges.size();
    }
}

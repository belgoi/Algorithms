package Graphs.MinCut;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class MapNode
{
    private List<String> edges;
    
    public MapNode()
    {
        edges=new ArrayList<>();
    }
    public void addEdge(String node)
    {
        edges.add(node);
    }

    public void removeEdge(String node) throws NoSuchElementException
    {
        if(edges.contains(node))
            edges.remove(node);
        else
        {
            System.err.println("The vertex doesn't contain the edge " + node);
            throw new NoSuchElementException();
        }

    }
    public String getRandomEdge()
    {
        Random rand = new Random();
        int count=edges.size();
        if (count==0)
            System.out.println(count);
        
        int index=rand.nextInt(edges.size())+1;
        
        String ed=edges.get(index-1);
        return edges.get(index-1);
        
    }
    public Iterator getIterator()
    {
        return edges.iterator();
    }
    public int numberOfEdges()
    {
        return edges.size();
    }

    public boolean contains(String node)
    {
        return edges.contains(node);
    }
    public void UpdateEdges(String node1,String node2)
    {
        int index = edges.indexOf(node2);
        if (index > -1)
            edges.set(index, node1);
    }
}

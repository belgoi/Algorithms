package Graphs.MinCut;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class MapGraph
{

    private Map<String,MapNode> mapAdjList;
    private String filename;

    public MapGraph(String filename)
    {
       this.filename=new String(filename);
       loadGraph();
    }
    private void loadGraph()
    {    
        mapAdjList=new HashMap<>();
        try
        {
            Scanner input=new Scanner(Paths.get(filename));
            while(input.hasNextLine())
            {
                String[] line=input.nextLine().split("\t");
                MapNode node=new MapNode();
                //add edges
               if (!line[0].equals(""))
               {
                   for (int i=1; i<line.length;++i)
                        node.addEdge(line[i]);
                mapAdjList.put(line[0], node);
               }
                line=null;
            }
            input.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public String getRandomNode()
    {
        //Return a random Node to begin merge 
        List<String> indexOfNodes=new ArrayList<>();
        for (String nodes:mapAdjList.keySet())
        {
            indexOfNodes.add(nodes);
        }
        Random rand=new Random();
        int index=rand.nextInt(indexOfNodes.size());

        return  indexOfNodes.get(index);

    }
    public void removeNode(String node)
    {
        mapAdjList.remove(node);
    }

    public void removeSelfLoop(String node1)
    {
        //removes all of the self loops in the graph
        while((mapAdjList.get(node1)).contains(node1))
                (mapAdjList.get(node1)).removeEdge(node1);

    }
    public void updateMap(String node1,String node2)
    {
        //iterate through key set and update any references to 
        //node2 to become node1
        for(String key:mapAdjList.keySet())
            while((mapAdjList.get(key).contains(node2)))
                (mapAdjList.get(key)).UpdateEdges(node1, node2);
    }
    public void mergeEdges(String startNode,String endNode)
    {
        Iterator iterator=mapAdjList.get(endNode).getIterator();    
        //add all edges of endNode to startNode
        while (iterator.hasNext())
            mapAdjList.get(startNode).addEdge(iterator.next().toString());
    }
    public void ContractEdge()
    {
        String startNode=getRandomNode();
        String endNode= (mapAdjList.get(startNode)).getRandomEdge();

        try{   
                //merge edges starting with startNode and ending with endNode
                mergeEdges(startNode,endNode);
                //update references pointing to endNode to reference startNode
                updateMap(startNode,endNode);
                //remove all self loop edges of startNode created from merging with endNode
                removeSelfLoop(startNode);
                //remove node that was merged into startNode
                mapAdjList.remove(endNode);
        }
        catch(Exception e)
        {
            System.err.println("startNode =" + startNode + " endNode = " + endNode);
            e.printStackTrace();
        }
    }
    public int minCut()
    {
        //uses Karger's contraction algrorithm to get the min cut of a graph
        int minCut=0;
        int tempCut=0;
        //run a sufficienct number of times to find the min cut
        for(int i=0;i<mapAdjList.size()*mapAdjList.size();i++)
        {

            //run until there are only two nodes left
            while(mapAdjList.size()>2)
            { 
                ContractEdge();
            }
          
        for(String key:mapAdjList.keySet())
            tempCut=mapAdjList.get(key).numberOfEdges();
        if (minCut==0 || minCut >tempCut)
            minCut=tempCut;
        
        loadGraph();
        System.out.printf("Iteration: %d min Cut: %d Low Min Cut: %d%n",i+1,tempCut,minCut);
        }  
        return minCut;
    }
 
}

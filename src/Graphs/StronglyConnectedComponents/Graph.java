/*
* Author: David Hinchliffe
* Class used by the client to instantiate the graph obect.
*/
package Graphs.StronglyConnectedComponents;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Graph extends AbstractGraph
{
        private int leader;
        private Map<Integer,Edges> scc;
        public Graph()
        {
            graph=new HashMap<>();
            visitedNodes=new HashSet<>();
            finishingTime=new ArrayDeque<>();
         }
   
        public Deque<Integer> getFinishingTime()
        {
            //return empty finishing time queue since this applies to GraphReverse
            //maintains the type AbstractGraph between Graph and GraphReverse
            return new ArrayDeque<Integer>();
        }
    
        public void setFinishingTime(Deque<Integer> finishingTime)
        {
            this.finishingTime=finishingTime;
        }
        
        private void dfsRecursive(int node)
        {
            //mark node as visited
            visitedNodes.add(node);
            for(Integer edge:getEdges(node))
                if (!visitedNodes.contains(edge))
                {
                    //add the component and its leader to the scc HashMap
                    //key->leader, value->the edges
                    (scc.get(leader)).addEdge(edge);
                     dfsRecursive(edge);
                }    
        }
        //helper loop for the dfsRecursive call. sets up the 
        //lead node the dfs uses to mark the connected components
        public void dfsLoop()
        {
            Edges sccNode;
            scc=new HashMap<>();
            //iterate through graph in order of finishing time as determined by first pass
            while (!finishingTime.isEmpty())
                {
                    //the lead node is the node that begins the dfs, determined by the first pass
                    leader=finishingTime.pop();
                    if (!visitedNodes.contains(leader))
                    {
                        sccNode=new Edges();
                        sccNode.addEdge(leader);
                        scc.put(leader, sccNode);
                        dfsRecursive(leader);
                    }
                }
        }
        public void computeScc()
        {
            //ArrayList to put the scc hashmap in numerical order by size
            List<Integer> sccSizes = new ArrayList<>();

            for (Integer key:scc.keySet())
            {
                sccSizes.add((scc.get(key)).getSize());
            }
            //sort sccSizes in descending order
            Collections.sort(sccSizes,Collections.reverseOrder());
            //print out at most the top five connected components in descending order of size
            for (int i = 0; i <5&&i <sccSizes.size();i++)
                System.out.println(sccSizes.get(i));
        }
}

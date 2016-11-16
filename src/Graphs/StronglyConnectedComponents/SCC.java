/*
*   Author: David Hinchliffe
*   Follows Kosaraju's Algorithm to compute the strongly connected components of a graph
*   the algorithm requires two passes of the depth first search algorithm, the first pass is 
*   performed on the graph, but in reverse order in which the arcs are flipped. This provides 
*   for a "magical" ordering of the nodes so that when the 2nd pass is performed with this ordering on the graph
*   with forward arcs the strongly connected components can be identified
*/
package Graphs.StronglyConnectedComponents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SCC
{
     private static void loadGraph(AbstractGraph graph,AbstractGraph graphReverse,String filename)
    {    
        int tail;
        int head;
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            String currentLine=null;
            
            while((currentLine=input.readLine()) !=null)
            {
                Edges edge;
                String[] line=currentLine.split(" ");
                tail=Integer.parseInt(line[0]);
                head=Integer.parseInt(line[1]);

                //load the forward arc graph
                graph.addEdge(tail, head);
                //load the backward arc graph, just have to reverse the head and tail
                graphReverse.addEdge(head,tail);
            }
            input.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     public static void KosarajuSCC()
     {
         /* due to the size of the graphs, the stack size had to be set to
         * 512mb and the heap size was resized to 2048mb
         */
         
        //graph with forward arcs
        AbstractGraph g=new Graph();
        //graph with reversed arcs
        AbstractGraph gReverse = new GraphReverse();
        System.out.println("Loading graphs...");
        loadGraph(g,gReverse,"c:\\Coursera_Data\\scc.txt");
        //first pass through dfs with edges reversed and in descending order
        System.out.println("Performing first pass...");
        gReverse.dfsLoop();
        //set finishing time from greverse
        g.setFinishingTime(gReverse.getFinishingTime());
        //traverse through the graph forward in order by finishing time
        System.out.println("Performing second pass...");
        g.dfsLoop();
        //prints out the top five strongly connected components by size 
        g.computeScc();
     }
      public static void main(String[] args)
    {   
        KosarajuSCC();

    }
}

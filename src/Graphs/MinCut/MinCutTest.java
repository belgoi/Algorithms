package Graphs.MinCut;

public class MinCutTest
{
    public static void main(String[] args)
    {
        minCut();
    }
    public static void minCut()
    {
        //gets the minCut of a graph
        MapGraph map=new MapGraph("c:\\Coursera_Data\\kargerMinCut.txt");
        System.out.printf("The min cut is: %d%n",map.minCut());
    }
    
}


package Sort;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort
{

    public static void main(String[] args)
    {
        QuickSort();
        MergeSort();
    }
      public static void QuickSort()
    {
      //Load array
      // int[] sortArray=new int[]{11,6,5,3,0,1,8,4,7,2,14,34,89,90,62,21,10,9,100};
      //int[] sortArray=new int[]{11,0,2,1};
      //int[] sortArray=readFile("c:\\10.txt");
      int[] sortArray=readFile("c:\\Coursera_Data\\QuickSort.txt");

        
        /*****Quick Sort*****/
        //Calls Quick Sort and gets the number of comparisons
      QuickSort sort=new QuickSort();
      sort.performSort(sortArray,0,sortArray.length-1);
      int c=sort.getCompare();
      System.out.println("QuickSort Number of comparisons: " + c); 
      //printArray(sortArray); 
         
    }
    public static void MergeSort()
    {
      //Load array
      // int[] sortArray=new int[]{11,6,5,3,0,1,8,4,7,2,14,34,89,90,62,21,10,9,100};
      //int[] sortArray=new int[]{11,0,2,1};
      //int[] sortArray=readFile("c:\\10.txt");
      int[] sortArray=readFile("c:\\Coursera_Data\\IntegerArray.txt");
 
       
      /*****Merge Sort*****/
      //Calls Merge Sort and is returned the number of inversions
      System.out.println("Inverstions via Merge Sort:" + MergeSort.countInversions(sortArray));
     // printArray(sortArray);
      
    }
     public static int[] readFile(String filename)
    {
        List<Integer> inputArray=new ArrayList<Integer>();
        int lines=0;
        try
        {
            Scanner input=new Scanner(Paths.get(filename));
            while(input.hasNext())
            {
                    inputArray.add(input.nextInt());
                    ++lines;
            }
            input.close();
        }
        catch(Exception e)
        {
            System.out.println("Problem with file");
            e.printStackTrace();
        }

        return copyToArray(inputArray);
      
    }
    public static int[] copyToArray(List<Integer> array)
    {
        int[] newArray=new int[array.size()];
        int j=0;
        for (Integer i:array)
            newArray[j++]=i;
        return newArray;
    }
    public static void printArray(int[] array)
    {
        //print sorted Array
        for (int value:array)
            System.out.println(value);

    }
    
}

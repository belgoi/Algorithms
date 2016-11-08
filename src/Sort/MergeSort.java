package Sort;

public class MergeSort
{
public MergeSort(){}
//recursively performs a merge sort on an input array and returns 
//the inversions within the array 
public static long countInversions(int[] sortArray)
{
    int mid=sortArray.length/2;
    long countLeft=0;
    long countRight=0;
    int[]result= new int[sortArray.length];
    
    if(sortArray.length <=1)
       return 0;
    
    int left[] = new int[mid];
    int right[]=new int[sortArray.length-mid];
    
    //copy array
    System.arraycopy(sortArray,0, left,0,mid);
    System.arraycopy(sortArray,left.length,right,0,sortArray.length-mid);
    
    //Divide and Conquer
    countLeft=countInversions(left);
    countRight=countInversions(right);
    //Count split inversions
    long countSplitInv=mergeAndCount(left,right,result);

    //assign sorted array back to original array
    System.arraycopy(result, 0, sortArray, 0, sortArray.length);
    return (countLeft+countRight+countSplitInv);

}
private static long mergeAndCount(int[] left,int[] right, int[] result)
{
   int i=0,j=0,k=0;
   long invCount=0;
   
    while((i<left.length) && (j<right.length))
    {
        if (left[i] < right[j]) //no inversions
            result[k++]=left[i++];
        else //there are inversions
        {
            result[k++]=right[j++];
            invCount+= left.length-i;
        }
    }
    while (i<left.length)
    {
        result[k++]=left[i++];
    }
    while(j<right.length)
    {
        result[k++]=right[j++];
    }
   return invCount; 
}
}

package Sort;

public class QuickSort
{
    //performs the QuickSort sorting routine and calculates the number of comparisons made
    //a choice of 3 methods of choosing the pivot is available
    //the default is using the left most element in the array
    //The right element can also be used as a pivot. To use must uncomment out the appropriate line below
    //The median of threes can also be used a pivot. It takes the left element, the right element and the middle 
    //element and then determines which of those 3 values lies between the other two and uses that as the pivot.
    //To use the appropriate line below must be uncommented.  
    int compare=0;
    int compare2=0;
   public QuickSort(){}
   public int getCompare()
   {
       return compare;
   }
   public void performSort(int[] unsortedArray,int start,int end)
   {
       if(start<end)
       {
            //uses the left index as the default pivot.   
            //To change uncomment out the lines below.
            
            //to use right index as pivot 
            //swap(unsortedArray,end,start);
            
            //to use median of three as pivot
            // swap(unsortedArray,getMedianIndex(unsortedArray,start,end),start);
           
           int pivotIndex=partition(unsortedArray,start,end); 
           compare += pivotIndex-start-1;
           performSort(unsortedArray,start,pivotIndex-1);
           compare += end-pivotIndex+1;
           performSort(unsortedArray,pivotIndex+1,end); //pivot index on the left

//performSort(unsortedArray,pivotIndex+1,end); //pivot index on the right
       }
   }
  
   private int partition(int[] unsortedArray,int leftIndex,int rightIndex)
   {
        //an array of A[leftIndex...rightIndex] will be passed in
        //leftIndex is left most item in subarray
        //rightIndex is right most item in subarray

        int pivotIndex=leftIndex;
        int pivot = unsortedArray[pivotIndex];
        int i=leftIndex+1;
       
        for (int j=leftIndex+1;j<=rightIndex;++j)             
           if(unsortedArray[j]<=pivot)
               swap(unsortedArray,i++,j);
       
        swap(unsortedArray,i-1,leftIndex);//put pivot into its proper place
     
        return i-1;
   }
  
   private void swap(int[] a,int index1,int index2)
   {
        int temp=0;
        temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
   }
   private int getMedianIndex(int[] a,int start,int end)
   {
        int midIndex=0;
        if ((end-start)+1 % 2==0)
           midIndex=(start+((end-start)/2)+1);
        else
           midIndex=(start+(end-start)/2);
       
       //determines the median of three pivot index 
        int x=a[start]-a[midIndex];
        int y=a[midIndex]-a[end];
        int z=a[start]-a[end];
       
        if((x*y)>0) return midIndex; //the middle value is the median
        if ((x*z)>0) return end; //the end value is the median
        return start; //the first value is the median
   }
   
}

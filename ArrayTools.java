/**
 * Some methods to deal with ArrayLists nicely.
 */
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
public class ArrayTools {
 static int swaps;
 static int comps;
  
  public static int find(int num, ArrayList<Integer> nums)
  {
    for(int i = 0; i <= nums.size() - 1; i++)
    {
      if(num == nums.get(i))
      {
        return i;
      }
    }
    return -1;
  }
  public static ArrayList<Integer> createAscRandom(int size)
  {
    ArrayList<Integer> asc = createRandom(size);
    javaSort(asc);
    return asc;
  }
  public static ArrayList<Integer> createDescRandom(int size)
  {
    ArrayList<Integer> temp = createRandom(size);
    ArrayList<Integer> desc = new ArrayList<Integer>();
    javaSort(temp);
    for(int i = temp.size() - 1; i >= 0; i--)
    {
      desc.add(temp.get(i));
    }
    return desc;
  }
  public static ArrayList<Integer> createRandom(int size)
  {
    ArrayList<Integer> chaos = new ArrayList<Integer>();
    for(int i= 1; i <= size; i++)
    {
      Random r = new Random();
      int rInt = r.nextInt(100) + 1;
      chaos.add(rInt);
    }
    return chaos;
  }
  public static int binarySearch(int num, ArrayList<Integer> nums)
  {
    int firstInd = 0;
    int lastInd = nums.size() - 1;
    int avg = 0;
    while(lastInd - firstInd >= 2)
    {
      avg = ((lastInd + firstInd)/ 2);
      if(num == nums.get(avg))
      {
        return avg;
      } 
      else if(num >= nums.get(avg))
      {
        firstInd = avg;
      } 
      else if(num <= nums.get(avg))
      {
        lastInd = avg;
      }
    }
    if(num == nums.get(lastInd))
    {
     return lastInd;
    } 
    else if(num == nums.get(firstInd))
    {
      return firstInd;
    } 
    else 
    {
    return -1;
    }
  }
  public static void bubbleSort(ArrayList<Integer> numbers, boolean efficient) throws FileNotFoundException
  {
    PrintStream statsBoi = new PrintStream("BubbleStatsForNerds.txt");
    long time = 0;
    int comps = 0;
    int swaps = 0;
    long sTime = System.nanoTime();
    boolean swapped;
    int iterations = 0;

    do
    {
      swapped = false;
      for(int i = 0; i <= numbers.size() - (iterations + 2) ; i++)
      {
        if(numbers.get(i) > numbers.get(i+1))
        {
          swap(numbers, i, i+1);
          swapped = true;
          swaps++;
        }
        comps++;
      }
      
      if(efficient)
      {
        iterations++;
      }  
    }while(swapped);

    long eTime = System.nanoTime();
    time = eTime - sTime;
    statsBoi.println(time);
    statsBoi.println(swaps);
    statsBoi.println(comps);
    statsBoi.close();
  }
  public static void javaSort(ArrayList<Integer> nums)
  {
    java.util.Collections.sort(nums);
  }
  public static void insertionSort(ArrayList<Integer> numbers) throws FileNotFoundException
  {
    PrintStream statsBoi = new PrintStream("InsertionStatsForNerds.txt");
    long time = 0;
    int comps = 0;
    int swaps = 0;
    long sTime = System.nanoTime();
    int element;
    int j;

    for(int i = 1; i <= numbers.size() - 1; i++)
    {
      element = numbers.get(i);
      j = i;
      while(j > 0 && numbers.get(j - 1) > element)
      {
        numbers.set(j, numbers.get(j - 1));
        j = j - 1;
        comps++;
        swaps++;
      }
     comps++;
      numbers.set(j, element);
    }

    long eTime = System.nanoTime();
    time = eTime - sTime;
    statsBoi.println(time);
    statsBoi.println(swaps);
    statsBoi.print(comps);
    statsBoi.close();
  }
   public static void selectionSort(ArrayList<Integer> numbers) throws FileNotFoundException
  {
    PrintStream statsBoi = new PrintStream("SelectionStatsForNerds.txt");
    long time = 0;
    int comps = 0;
    int swaps = 0;
    long sTime = System.nanoTime();
    int min;

    
    for(int i = 0; i <= numbers.size()-1; i++)
    {
      min = i;
      for(int j = i+1; j <= numbers.size()-1; j++)
      {
        if(numbers.get(j) < numbers.get(min))
        {
          min = j;
        }
        comps++;
      }
      if(min != i)
      {
        swap(numbers, min, i);
        swaps++;
      }
    }

    long eTime = System.nanoTime();
    time = eTime - sTime;
    statsBoi.println(time);
    statsBoi.println(swaps);
    statsBoi.print(comps);
    statsBoi.close();
  }
   public static void mergeSort(ArrayList<Integer> arr) throws FileNotFoundException
   {
     PrintStream statsBoi = new PrintStream("MergeStatsForNerds.txt");
     long time = 0;
     comps = 0;
     swaps = 0;
     long sTime = System.nanoTime();
     ArrayList<Integer> uwu = mergeSortH(arr);
     arr.clear();
     for(int i = 0; i <= uwu.size() - 1; i++)
     {
       arr.add(uwu.get(i));
     }
     long eTime = System.nanoTime();
    time = eTime - sTime;
    statsBoi.println(time);
    statsBoi.println(swaps);
    statsBoi.print(comps);
    statsBoi.close();
   }
   public static ArrayList<Integer> mergeSortH(ArrayList<Integer> arr)
  {
    int length = arr.size();
    
    if(length <= 1)
    {
      return arr;
    }
    ArrayList<Integer> left = new ArrayList<Integer>();
    int lLength = length / 2;
    ArrayList<Integer> right = new ArrayList<Integer>();
    int rLength = length - length / 2;
    
    for(int i = 0; i <= lLength - 1; i++)
    {
        left.add(arr.get(i));
    }
    for(int i = 0; i <= rLength - 1; i++)
    {
        right.add(arr.get(i + length / 2));
    }   
  return merge(mergeSortH(left), mergeSortH(right), lLength, rLength);
  }
  private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, int lLength, int rLength)
  {
    ArrayList<Integer> merged = new ArrayList<Integer>();   
    int i = 0; // index for left array
    int j = 0; // index for right array
    
    for(int k = 0; k <= lLength + rLength - 1; k++)
    {
      if(i >= lLength) // we have exhausted the left list so add from the right
      {
        merged.add(right.get(j++));
      }
      else if(j >= rLength) // we have exhausted the right list so add from the left
      {
        merged.add(left.get(i++));
      }
      else if(left.get(i) <= right.get(j)) // left is smaller so add it
      {
        merged.add(left.get(i++));
        comps++;
      }
      else // right is smaller so add it
      {
        merged.add(right.get(j++));
        comps++;
      }
      swaps++;
    }
    
    return merged;
  }
    private static void swap(ArrayList<Integer> nums, int a, int b)
  {
    int temp = nums.get(a);
    nums.set(a, nums.get(b));
    nums.set(b, temp);
  }
  public static void print(ArrayList<Integer> nums)
  {
  for(int i = 0; i <= nums.size() - 2; i++)
    {
      System.out.print(nums.get(i) + ",  ");
    }
  System.out.println(nums.get(nums.size() - 1));
  }
}

/**
 * Auto Generated Java Class.
 */
import java.util.ArrayList;
import java.lang.Runtime;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class ArrayToolDriver {
  
  public static void main(String[] args) throws FileNotFoundException
  {
    for(int i = 1; i <= 5; i++)
    {
    Scanner getStats = new Scanner(new File("BubbleStatsForNerds.txt"));
    ArrayList<Integer> nums = ArrayTools.createRandom(5);

    ArrayTools.print(nums);
    ArrayTools.bubbleSort(nums, true); 
    ArrayTools.print(nums);

    System.out.print(getStats.nextLine() + " nanoseconds ");
    System.out.print(getStats.nextLine() + " swaps ");
    System.out.println(getStats.nextLine() + " comparisons ");
    getStats.close();
    }
  }
}

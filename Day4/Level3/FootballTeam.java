
import java.util.Arrays;
public class FootballTeam {
  public static void main(String[] args) {
	int[] heights = generateRandomHeights(11);
	int sum = calculateSum(heights);
	double mean = calculateMean(heights);
	int shortest = findShortestHeight(heights);
	int tallest = findTallestHeight(heights);
	System.out.println("Heights of players: " + Arrays.toString(heights));
	System.out.println("Sum of heights: " + sum + " cm");
	System.out.println("Mean height: " + mean + " cm");
	System.out.println("Shortest player height: " + shortest + " cm");
	System.out.println("Tallest player height: " + tallest + " cm");
  }
  public static int[] generateRandomHeights(int size) {
	int[] heights = new int[size];
	for (int i = 0; i < size; i++) {
  	heights[i] = (int) (Math.random() * 101) + 150;
	}
	return heights;
  }
  public static int calculateSum(int[] heights) {
	int sum = 0;
	for (int height : heights) {
  	sum += height;
	}
	return sum;
  }
  public static double calculateMean(int[] heights) {
	return (double) calculateSum(heights) / heights.length;
  }
  public static int findShortestHeight(int[] heights) {
	int shortest = heights[0];
	for (int height : heights) {
  	if (height < shortest) {
    	shortest = height;
  	}
	}
	return shortest;
  }
  public static int findTallestHeight(int[] heights) {
	int tallest = heights[0];
	for (int height : heights) {
  	if (height > tallest) {
    	tallest = height;
  	}
	}
	return tallest;
  }
}


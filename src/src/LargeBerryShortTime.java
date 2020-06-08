package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class uses an API of pokemon data from pokeapi.co to create a list of berries
 * and then finds the bigger cherry you can grow in the shortest time.
 *
 * @author jimmy
 */

public class LargeBerryShortTime {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Instantiate a list containing all the berries data from the API
		BerriesUtil.instantiateBerriesList();

		ArrayList<Berry> shortestTimes = BerriesUtil.berries.stream()
				// Sort berries by growth time
				.sorted((x1, x2) -> x1.getGrowthTime() - x2.getGrowthTime())
				.collect(Collectors.toCollection(ArrayList::new));
		
		ArrayList<Berry> smallToBigger = shortestTimes.stream()
				// Get berries from the shortest time
				.filter(x -> x.getGrowthTime() == shortestTimes.get(0).getGrowthTime())
				// Sort berries from small to big
				.sorted((x1, x2) -> x1.getSize() - x2.getSize())
				.collect(Collectors.toCollection(ArrayList::new));
		
		// Get the last berry in the list which is the bigger one
		int lastIndex = smallToBigger.size() - 1;
		Berry biggestCherry = smallToBigger.get(lastIndex);
		
		System.out.println("This is the biggest cherry in the shortest time: " + biggestCherry);
	}
}

package src;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 * @author jimmy
 * This class contains all the methods that LargeBerryShortTime class
 * uses to find the biggest cherry in the shortest time 
 */

public class BerriesUtil {

	public static List<Berry> berries = new ArrayList<Berry>();

	public static String getBerryName(int berryNumber) throws IOException {

		JSONObject root = getDataFromAPI(berryNumber);
		String name = (String) root.get("name");

		return name;
	}

	public static int getBerryGrowthTime(int berryNumber) throws IOException {

		JSONObject root = getDataFromAPI(berryNumber);
		int growthTime = (int) root.get("growth_time");

		return growthTime;
	}

	public static int getBerrySize(int berryNumber) throws IOException {

		JSONObject root = getDataFromAPI(berryNumber);
		int size = (int) root.get("size");

		return size;
	}


	public static JSONObject getDataFromAPI(int berryNumber) throws MalformedURLException, IOException {
		String rootURL = "https://pokeapi.co/api/v2/berry/" + berryNumber;

		URL request = new URL(rootURL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream);
		JSONObject root = new JSONObject(response);

		return root;
	}

	public static void instantiateBerriesList() throws IOException {
		System.out.println("Loading list of berries");
		for (int i = 1; i < 65; i++) {
			berries.add(new Berry(getBerryName(i), getBerryGrowthTime(i), getBerrySize(i)));
		}
	}

}

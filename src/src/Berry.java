package src;
/**
 * @author jimmy
 *
 */

public class Berry {
	
	private String name;
	private int growthTime;
	private int size;
	
	public Berry(String name, int growthTime, int size) {
		this.name = name;
		this.growthTime = growthTime;
		this.size = size;
	}
	
	public String toString() {
		return name + ", growth time: " + growthTime + ", size: " + size + "\n";
	}
	
	public int getGrowthTime() {
		return growthTime;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getName() {
		return name;
	}
}

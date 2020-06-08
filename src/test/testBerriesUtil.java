/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import src.BerriesUtil;
import org.junit.jupiter.api.Test;

/**
 * @author jimmy
 *
 */
class testBerriesUtil {

	// Berries for testing 
	int sitrusBerry = 10;
	int cheriBerry = 1;

	@Test
	void testGetBerryName() throws IOException {
		assertEquals("sitrus", BerriesUtil.getBerryName(sitrusBerry));
		assertEquals("cheri", BerriesUtil.getBerryName(cheriBerry));
	}
	
	@Test
	void testgetBerryGrowthTime() throws IOException {
		
		assertEquals(3, BerriesUtil.getBerryGrowthTime(cheriBerry));
		assertEquals(8, BerriesUtil.getBerryGrowthTime(sitrusBerry));
	}

	@Test
	void testGetBerrySize() throws IOException {
		assertEquals(20, BerriesUtil.getBerrySize(cheriBerry));
		assertEquals(95, BerriesUtil.getBerrySize(sitrusBerry));
	}
}

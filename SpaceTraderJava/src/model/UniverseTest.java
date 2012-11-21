package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniverseTest {
	Planet[] planets;

	@Before
	public void setup() {
		planets = Universe.generate();
	}
	/**
	 * Checks to make sure no planets are overlapping.
	 */
	@Test
	public void testPlanetGeneration() {
		for(int i=0;i< planets.length;i++){
			//test that the planets are not null
			assertNotNull(planets[i]);
			
			//test that they have names
			assertNotNull(planets[i].getName());
			
			//test they have a  marketplace
			assertNotNull(planets[i].getMarketplace());
			
			//test that their locations are within the boundaries (600 x 500)
			assertTrue(planets[i].getCoordinates().X<600);
			assertTrue(planets[i].getCoordinates().Y<500);
			
			//test that they don't overlap, ie their distance is greater than their radius
			//crappy O^2 test
			for(int j =0;j<planets.length;j++){
				assertTrue(planets[i].distance(planets[j])<planets[i].radius);
			}
		}
	}
	
}

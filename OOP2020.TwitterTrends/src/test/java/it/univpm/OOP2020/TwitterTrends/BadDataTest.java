package it.univpm.OOP2020.TwitterTrends;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


import it.univpm.OOP2020.TwitterTrends.Util.getCoordinates;
import it.univpm.OOP2020.TwitterTrends.exception.BadDataInput;


public class BadDataTest {

	getCoordinates coord;
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test of IncorrectPlaceName
	 * @throws BadDataInput
	 */
	@Test
	public void test1() throws BadDataInput {
		coord=new getCoordinates();
		assertThrows(BadDataInput.class, ()->coord.getLatLong("IncorrectPlaceNameAncona"));
		//String tmp[]=coord.getLatLong("IncorrectPlaceNameAncona");
		//String expeted[]= {"13.51667","43.61667"};
		//assertArrayEquals(expeted, tmp);
		
		
	}
	@Test
	public void test2() throws BadDataInput {
		coord=new getCoordinates();
		//assertThrows(BadDataInput.class, ()->coord.getLatLong("Ancona"));
		String tmp[]=coord.getLatLong("Ancona");
		String expeted[]= {"13.51667","43.61667"};
		assertArrayEquals(expeted, tmp);
	}


	
}

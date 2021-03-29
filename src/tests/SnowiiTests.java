package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cse237.Resort;

class SnowiiTests {

	@Test
	void testAddResort() {
        List<Resort> resortListUnderTest = new ArrayList<Resort>();
        Resort resortUnderTest = new Resort("wyoming/jackson-hole");
		assertTrue(resortListUnderTest.size() == 0);
		resortListUnderTest.add(resortUnderTest);		
		assertTrue(resortListUnderTest.size() == 1);
	}

}

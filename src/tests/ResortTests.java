package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse237.Resort;

class ResortTests {
	private Resort resortUnderTest;

	@BeforeEach
	void instantiateResort() {
		resortUnderTest = new Resort("wyoming/jackson-hole");
	}

	@Test
	void testBeautifyName() {
		// tests that user can get Snow data of a resort
		String name = resortUnderTest.beautifyName("wyoming/jackson-hole");
		assertEquals(name, "jackson hole");
	}

	@Test
	void testInitialPare() throws Exception {
		// tests that string can be pared
		String paredSite = resortUnderTest.initialPare(
				"wwjencfkwnvhb<ul class=\"sr_snowfall_days scroller\"><li class=\" \"><div class=\"time\">faowefoiawmv</div></div></div></li></ul>");
		assertEquals(paredSite,
				"<ul class=\"sr_snowfall_days scroller\"><li class=\" \"><div class=\"time\">faowefoiawmv");
	}

	@Test
	void testEndPare() {
		// tests that string can be pared
		String dataHolder = resortUnderTest.endPare("ejvo\"aievneroif", "\"");
		assertEquals(dataHolder, "ejvo");
	}

	@Test
	void testPare() {
		// tests that string can be pared
		String paredStr = resortUnderTest.pare("ewofajrnvenfvi", "ajrnv");
		assertEquals(paredStr, "enfvi");
	}
	
	@Test
	void testFormatURL() throws Exception {
		// tests that user can format URL
		resortUnderTest.formatURL();
	}
	
	@Test
	void testSnowDataTable() {
		// tests that data is added to list
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(3);
		resortUnderTest.snowDataTable("\"bluePill\">015\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"\"bluePill\">011\"", testList);
		assertEquals(testList.size(), 11);
	}

	@Test
	void testOrganizeTable() {
		// tests that user that table is organized
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(3);
		int testInts[] = resortUnderTest.organizeTable(testList);
		assertEquals(testInts.length, 2);
	}
	
	@Test
	void testGetSnowData() throws Exception {
		// tests that user can get Snow data of a resort
		resortUnderTest.getSnowData();
	}
}

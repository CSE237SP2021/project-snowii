package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse237.Resort;
import cse237.Snowii;

class SnowiiTests {
	private Snowii snowiiUnderTest;

	@BeforeEach
	void instantiateResort() {
		snowiiUnderTest = new Snowii();
	}

	@Test
	void testPrintDefaultTable() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		List<Resort> resortListUnderTest = new ArrayList<Resort>();
		String resortStringUnderTest[] = new String[] { "wyoming/jackson-hole" };
		snowiiUnderTest.addResort(resortListUnderTest, resortStringUnderTest);
		snowiiUnderTest.printDefaultTable(resortListUnderTest, resortStringUnderTest);
		String expectedOutput = "Snowii: 7-day snow forecast\r\nCurrent resort: wyoming/jackson-hole\r\nDay 1: 0 inches\r\nDay 2: 0 inches\r\nDay 3: 0 inches\r\nDay 4: 0 inches\r\nDay 5: 0 inches\r\nDay 6: 0 inches\r\nDay 7: 0 inches\r\nDay 8: 0 inches\r\nDay 9: 0 inches\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testPrintUserTable() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String resortNameUnderTest = "jackson-hole";
		String urlNameUnderTest = "wyoming/jackson-hole";
		Resort userResortUnderTest = new Resort(urlNameUnderTest);
		snowiiUnderTest.printUserTable(resortNameUnderTest, userResortUnderTest);
		String expectedOutput = "Snowii: 7-day snow forecast\r\nResort: jackson-hole\r\nDay 1: 0 inches\r\nDay 2: 0 inches\r\nDay 3: 0 inches\r\nDay 4: 0 inches\r\nDay 5: 0 inches\r\nDay 6: 0 inches\r\nDay 7: 0 inches\r\nDay 8: 0 inches\r\nDay 9: 0 inches\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testCreateDefaultTable() {
		List<Resort> resortListUnderTest = new ArrayList<Resort>();
		String[] result = snowiiUnderTest.createDefaultTable(resortListUnderTest);
		String[] expectedResult = {"wyoming/jackson-hole", "colorado/vail","colorado/beaver-creek","colorado/breckenridge","colorado/keystone","colorado/crested-butte-mountain-resort","colorado/telluride","colorado/silverton-mountain","utah/park-city-mountain-resort","utah/snowbasin","british-columbia/whistler-blackcomb"};
		assertArrayEquals(expectedResult,result);
	}

	@Test
	void testAddResort() {
		List<Resort> resortListUnderTest = new ArrayList<Resort>();
		String resortStringUnderTest[] = new String[] { "wyoming/jackson-hole" };
		assertTrue(resortListUnderTest.size() == 0);
		snowiiUnderTest.addResort(resortListUnderTest, resortStringUnderTest);
		assertTrue(resortListUnderTest.size() == 1);
	}

}

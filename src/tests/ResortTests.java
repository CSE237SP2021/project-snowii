package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse237.Resort;

class ResortTests {
	private Resort resortUnderTest;
	private String paredSite;

	@BeforeEach
	void instantiateResort() {
		resortUnderTest = new Resort("wyoming/jackson-hole");
	}

	@Test
	void testBeautifyName(){
		// Test that user can get Snow data of a resort
		String name = resortUnderTest.beautifyName("wyoming/jackson-hole");
		assertEquals(name, "jackson hole");
	}

	@Test
	void testInitialPare() throws Exception{
		URL siteurl = new URL("https://www.onthesnow.com/wyoming/jackson-hole/skireport.html");
		BufferedReader inbuff = new BufferedReader(new InputStreamReader(siteurl.openStream()));
		String website = inbuff.lines().collect(Collectors.joining());
		paredSite = resortUnderTest.initialPare(website);
		assertEquals(paredSite, "<ul class=\"sr_snowfall_days scroller\"><li class=\" \"><div class=\"time\">Friday<br><span>4/9</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">4\"</div></div></div></li><li class=\" \"><div class=\"time\">Saturday<br><span>4/10</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Sunday<br><span>4/11</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Monday<br><span>4/12</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Tuesday<br><span>4/13</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\"today \"><div class=\"time\"><script type=\"text/javascript\">                            gotoSlide = 5;                          </script>Today<br><span>4/14</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Thursday<br><span>4/15</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Friday<br><span>4/16</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Saturday<br><span>4/17</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"");
	}

//	@Test
//	void testPare() {
//        paredSite = resortUnderTest.pare(paredSite, "\"bluePill\">");
//		assertEquals(paredSite, "4\"</div></div></div></li><li class=\" \"><div class=\"time\">Saturday<br><span>4/10</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Sunday<br><span>4/11</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Monday<br><span>4/12</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Tuesday<br><span>4/13</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\"today \"><div class=\"time\"><script type=\"text/javascript\">                            gotoSlide = 5;                          </script>Today<br><span>4/14</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Thursday<br><span>4/15</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Friday<br><span>4/16</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"</div></div></div></li><li class=\" \"><div class=\"time\">Saturday<br><span>4/17</span></div><div class=\"station top\"><div class=\"predicted_snowfall\"><div class=\"bluePill\">0\"");
//	}
//
//	@Test
//	void testEndPare() {
//		String dataHolder = resortUnderTest.endPare(paredSite, "\"");
//		assertEquals(dataHolder, 4);
//	}

	@Test
	void testGetSnowData() throws Exception{
		// Test that user can get Snow data of a resort
		resortUnderTest.getSnowData();
	}
}

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse237.Avalanche;



class AvalancheTests {
  private Resort avalancheUnderTest;

	@BeforeEach
	void instantiateAvalanche() {
    avalancheUnderTest = new Avalanche()
  }

  @Test
  void testInitialPare() throws Exception {
    String paredSite = resortUnderTest.initialPare("\"overall_danger_rose\":\"" + "0" + "\"overall_danger_rose_image");
    assertThat(paredSite, not("1"));
  }

  @Test
  void AvalancheForecastTest() throws Exception {
    String b = AvalancheForecast("salt-lake");
    assertThat(b, not(""));
  }

}

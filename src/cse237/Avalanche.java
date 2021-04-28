package cse237;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Avalanche{

    public String InitialPare(String site) {
        // The info we are looking for is always comtained between the following listed elements
        // Find the first element and the second which encompass the info we are looking for
        int iIndex = site.indexOf("\"overall_danger_rose\":\"");
        int bIndex = site.indexOf("\"overall_danger_rose_image");

        // Pare the string using the indecies
        String retstring = site.substring(iIndex, bIndex);
        return retstring;
    }

    public String AvalancheForecast(String area){
      URL siteurl = new URL("https://utahavalanchecenter.org/forecast/"+ area +"/json");
      BufferedReader inbuff = new BufferedReader(new InputStreamReader(siteurl.openStream()));
      String website = inbuff.lines().collect(Collectors.joining());

      String printer = InitialPare(website);

      return printer;
  }
}

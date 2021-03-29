package cse237;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Resort {
    static final int DAYS_SNOW_REPORTED = 9;
    public String name;
    public String queryName;


    private String BeautifyName(String name){
        name = Pare(name, "/");
        name.replace("-", " ");
        return name;
    }

    public Resort(String qName) {

        queryName = qName;
        name = BeautifyName(queryName);
    }

    private String InitialPare(String site) {
        // The info we are looking for is always contained between the following listed elements
        // Find the first element and the second which encompass the info we are looking for
        int iIndex = site.indexOf("<ul class=\"sr_snowfall_days scroller\"><li class=\" \"><div class=\"time\">");
        int bIndex = site.indexOf("</div></div></div></li></ul>");

        // Pare the string using the indices
        String retstring = site.substring(iIndex, bIndex);
        return retstring;
    }

    private String EndPare(String site, String phrase) {
        int index = site.indexOf(phrase);
        if (index >= 0) {
            return site.substring(0, index);
        }
        return "error";
    }


    private String Pare(String site, String phrase) {
        int index = site.indexOf(phrase);
        if (index >= 0) {
            return site.substring(index  + phrase.length());
        }
        return "error";
    }


    public int[] GetSnowData() throws Exception {

        // Query the new info

        URL siteurl = new URL("https://www.onthesnow.com/"+ queryName + "/skireport.html");
        BufferedReader inbuff = new BufferedReader(new InputStreamReader(siteurl.openStream()));

        String website = inbuff.lines().collect(Collectors.joining());

        String paredsite = InitialPare(website);

        List<Integer> snowdata = new ArrayList<Integer>();


        for(int i = 0; i < DAYS_SNOW_REPORTED; i++) {
            paredsite = Pare(paredsite, "\"bluePill\">");
            String dataHolder = EndPare(paredsite, "\"");
            int data = Integer.parseInt(dataHolder);

            snowdata.add(data);
        }

        Object snowArray[] = snowdata.toArray();
        int snowInts[] = new int[snowArray.length];
        for (int i = 0; i < snowArray.length; i++) {
            snowInts[i] = (int) snowArray[i];
        }
        return snowInts;
    }
}
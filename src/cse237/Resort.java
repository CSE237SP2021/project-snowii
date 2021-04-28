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
    
    //Changes resort name from URL form to normal
    public String beautifyName(String name){
    	name = pare(name, "/");
        name = name.replace("-", " ");
        return name;
    }

    public Resort(String qName) {
        queryName = qName;
        name = beautifyName(queryName);
    }

    public String initialPare(String site) {
        // The info we are looking for is always contained between the following listed elements
        // Find the first element and the second which encompass the info we are looking for
        int iIndex = site.indexOf("<ul class=\"sr_snowfall_days scroller\"><li class=\" \"><div class=\"time\">");
        int bIndex = site.indexOf("</div></div></div></li></ul>");

        // Pare the string using the indices
        String retstring = site.substring(iIndex, bIndex);
        return retstring;
    }

    public String endPare(String site, String phrase) {
        int index = site.indexOf(phrase);
        if (index >= 0) {
            return site.substring(0, index);
        }
        return "error";
    }


    public String pare(String site, String phrase) {
        int index = site.indexOf(phrase);
        if (index >= 0) {
            return site.substring(index  + phrase.length());
        }
        return "error";
    }

    //Query the new info
    public String formatURL() throws MalformedURLException, IOException {
		URL siteurl = new URL("https://www.onthesnow.com/"+ queryName + "/skireport.html");
        BufferedReader inbuff = new BufferedReader(new InputStreamReader(siteurl.openStream()));

        String website = inbuff.lines().collect(Collectors.joining());

        String paredSite = initialPare(website);
		return paredSite;
	}
	
	public void snowDataTable(String paredSite, List<Integer> snowdata) {
		for(int i = 0; i < DAYS_SNOW_REPORTED; i++) {
            paredSite = pare(paredSite, "\"bluePill\">");
            String dataHolder = endPare(paredSite, "\"");
            int data = Integer.parseInt(dataHolder);

            snowdata.add(data);
        }
	}
	
	public int[] organizeTable(List<Integer> snowdata) {
		Object snowArray[] = snowdata.toArray();
        int snowInts[] = new int[snowArray.length];
        for (int i = 0; i < snowArray.length; i++) {
            snowInts[i] = (int) snowArray[i];
        }
        return snowInts;
	}
	
	//Gets snow data for each resort
    public int[] getSnowData() throws Exception {
        String paredSite = formatURL();
        List<Integer> snowdata = new ArrayList<Integer>();
        snowDataTable(paredSite, snowdata);

        return organizeTable(snowdata);
    }
}
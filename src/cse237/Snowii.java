package cse237;

import java.util.ArrayList;
import java.util.List;

class Snowii {

    public static void main(String[] args) {

        List<Resort> resorts = new ArrayList<Resort>();

        // Create a list of resorts based on the array of extensions
        String[] resort_exts = createTable(resorts);

        // Print info to terminal
        printTable(resorts, resort_exts);
    }

	private static void printTable(List<Resort> resorts, String[] resort_exts) {
		System.out.println("Snowii: 7-day snow forecast");
        for(int i  = 0; i < resorts.size(); i++) {
            Resort resort = resorts.get(i);
            System.out.println("Current resort: " + resort_exts[i]);
            try {
                int[] data = resort.GetSnowData();
                for (int j = 0; j < data.length; j++) {
                    System.out.println("Day " + (j+1) + ": " + data[j] + " inches");
                }
            } catch(Exception e) {
                System.out.println("An exception occurred while fetching snow data: " + e.getMessage());
            }
        }
	}

	private static String[] createTable(List<Resort> resorts) {
		String resort_exts[] = new String[]{"wyoming/jackson-hole",
            "colorado/vail",
            "colorado/beaver-creek",
            "colorado/breckenridge",
            "colorado/keystone",
            "colorado/crested-butte-mountain-resort",
            "colorado/telluride",
            "colorado/silverton-mountain",
            "utah/park-city-mountain-resort",
            "utah/snowbasin",
            "british-columbia/whistler-blackcomb"
        };

        addResort(resorts, resort_exts);
		return resort_exts;
	}

	private static void addResort(List<Resort> resorts, String[] resort_exts) {
		for(int i = 0; i < resort_exts.length; i++) {
            Resort resort = new Resort(resort_exts[i]);
            resorts.add(resort);
        }
	}
}
package cse237;

import java.util.ArrayList;
import java.util.List;

class Snowii {

	public static void main(String[] args) {

		List<Resort> resorts = new ArrayList<Resort>();

		// Create a default list of resorts based on the array of extensions
		if (args.length == 0) {
			String[] resort_exts = createDefaultTable(resorts);
			// Print info to terminal
			printDefaultTable(resorts, resort_exts);
		}

		//Create a list of user-inputed resort
		else if (args.length == 2) {
			String stateName = args[0].toLowerCase();
			String resortName = args[1];
			String lowerResortName = resortName.toLowerCase();
			String urlName = stateName + "/" + lowerResortName;
			Resort userResort = new Resort(urlName);
			// Print info to terminal
			printUserTable(resortName, userResort);
		}
	}

	private static void printDefaultTable(List<Resort> resorts, String[] resort_exts) {
		System.out.println("Snowii: 7-day snow forecast");
		for(int i  = 0; i < resorts.size(); i++) {
			Resort resort = resorts.get(i);
			System.out.println("Current resort: " + resort_exts[i]);
			try {
				int[] data = resort.getSnowData();
				for (int j = 0; j < data.length; j++) {
					System.out.println("Day " + (j+1) + ": " + data[j] + " inches");
				}
			} 
			catch(Exception e) {
				System.out.println("An exception occurred while fetching snow data: " + e.getMessage());
			}
		}
	}

	private static void printUserTable(String definedResortName, Resort definedResort) {
		System.out.println("Snowii: 7-day snow forecast");
		System.out.println("Resort: " + definedResortName);
		try {
			int[] data = definedResort.getSnowData();
			for (int j = 0; j < data.length; j++) {
				System.out.println("Day " + (j+1) + ": " + data[j] + " inches");
			}
		} 
		catch(Exception e) {
			System.out.println("An exception occurred while fetching snow data: " + e.getMessage());
		}    
	}

	private static String[] createDefaultTable(List<Resort> resorts) {
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
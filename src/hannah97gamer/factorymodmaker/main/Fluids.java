package hannah97gamer.factorymodmaker.main;

import java.util.ArrayList;
import java.util.HashMap;

import hannah97gamer.factorymodmaker.filesystem.Files;

public class Fluids {
	private static Fluids instance;
	private HashMap<String, String> localizedNames;
	private ArrayList<String> fluidList;
	
	private Fluids() {
		fluidList = Util.loadList("fluids");
		localizedNames = Util.parseLocaleFile(Files.getDefaultLocaleFile(), "fluid-name");
	}
	
	public static String[] getFluids() {
		if(instance == null) {
			instance = new Fluids();
		}
		return instance.fluidList.toArray(new String[0]);
	}
	
	public static String getLocalizedName(String name) {
		if(instance == null) {
			instance = new Fluids();
		}
		if(instance.localizedNames.containsKey(name)) {
			return instance.localizedNames.get(name);
		}
		else {
			return name;
		}
	}
	
	public static void addItem(String name, String localizedName) {
		if(instance == null) {
			instance = new Fluids();
		}
		instance.fluidList.add(name);
		instance.localizedNames.put(name, localizedName);
	}
}

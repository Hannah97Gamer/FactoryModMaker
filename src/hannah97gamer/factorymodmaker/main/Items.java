package hannah97gamer.factorymodmaker.main;

import java.util.ArrayList;
import java.util.HashMap;

import hannah97gamer.factorymodmaker.filesystem.Files;

public class Items {
	private static Items instance;
	private HashMap<String, String> localizedNames;
	private ArrayList<String> itemList;
	
	private Items() {
		localizedNames = Util.parseLocaleFile(Files.getDefaultLocaleFile(), "item-name");
		itemList = Util.loadList("items");
	}
	
	public static String[] getItems() {
		if(instance == null) {
			instance = new Items();
		}
		return instance.itemList.toArray(new String[0]);
	}
	
	public static String getLocalizedName(String name) {
		if(instance == null) {
			instance = new Items();
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
			instance = new Items();
		}
		instance.itemList.add(name);
		instance.localizedNames.put(name, localizedName);
	}
}

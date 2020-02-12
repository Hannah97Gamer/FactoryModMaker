package hannah97gamer.factorymodmaker.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Util {

	public static int getClosingCharacterIndex(String test, int start) {
		int depth = 0;
		if(test.charAt(start) != '{') {
			return -1;
		}
		char[] chars = test.toCharArray();
		int i = -1;
		for(i = start; i < chars.length; i++) {
			if(chars[i] == '{')
				depth++;
			else if(chars[i] == '}')
				depth--;
			if(depth == 0)
				break;
		}
		if(depth > 0) {
			return -1;
		}
		else {
			return i;
		}
	}
	
	public static HashMap<String, String> parseLocaleFile(File file, String category) {
		category = "["+category+"]";
		HashMap<String, String> localizedNames = new HashMap<String, String>();
		
		if(file.exists()) {
			try {
				Scanner scan = new Scanner(file);
				
				String input = scan.nextLine();
				while(scan.hasNextLine() && !input.equals(category)) {
					input = scan.nextLine();
				}
				
				if(input.equals(category)) {
					input = scan.nextLine();
					while(!input.equals("")) {
						String[] keyvalue = input.split("=");
						localizedNames.put(keyvalue[0], keyvalue[1]);
						input = scan.nextLine();
					}
				}
				
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return localizedNames;
	}
	
	public static ArrayList<String> loadList(String name) {
		ArrayList<String> items = new ArrayList<String>();
		String path = "/hannah97gamer/factorymodmaker/resources/lists/"+name+".txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new Util().getClass().getResourceAsStream(path)));
		try {
			String input = br.readLine();
			while(input != null) {
				items.add(input);
				input = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
}

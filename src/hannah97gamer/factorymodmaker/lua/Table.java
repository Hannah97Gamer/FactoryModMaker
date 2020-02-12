package hannah97gamer.factorymodmaker.lua;

import java.util.ArrayList;
import java.util.HashMap;

import hannah97gamer.factorymodmaker.lua.exceptions.InvalidTableException;
import hannah97gamer.factorymodmaker.main.Util;

public class Table {
	private ArrayList<LuaKeyValue> elements;

	public Table() {
		elements = new ArrayList<LuaKeyValue>();
	}
	
	public Table(Object table) throws InvalidTableException {
		elements = new ArrayList<LuaKeyValue>();
		
		if(isTable(table)) {
			HashMap<Integer,Table> tables = new HashMap<Integer,Table>();
			int num = 0;
			String data = table.toString().substring(1,table.toString().length()-1);
			int i = data.indexOf('{');
			while(i != -1) {
				int j = Util.getClosingCharacterIndex(data, i);
				if(j == -1) {
					throw new InvalidTableException("No closing table bracket!");
				}
				tables.put(num, new Table(data.substring(i,j+1)));
				data = data.substring(0, i)+"%"+num+++data.substring(j+1);
				i = data.indexOf('{');
			}
			String[] pairs = data.split(",");
			for(String pair:pairs) {
				pair = pair.trim();
				if(pair.contains("=")) {
					String[] keyValue = pair.split("=");
					String key = keyValue[0].trim();
					String value = keyValue[1].trim();
					if(value.charAt(0)=='%') {
						value = tables.get(Character.getNumericValue(value.charAt(1))).toString();
					}
					add(key,value);
				}
				else {
					if(pair.charAt(0)=='%') {
						pair = tables.get(Character.getNumericValue(pair.charAt(1))).toString();
					}
					add(pair);
				}
			}
		}
		else {
			throw new InvalidTableException("Given object is not a table!");
		}
	}
	
	public void add(Object value) {
		elements.add(new LuaKeyValue(null,value.toString()));
	}
	
	public void add(String key, Object value) {
		elements.add(new LuaKeyValue(key,value.toString()));
	}
	
	public void addIfNotNull(String key, Object value) {
		if(value != null && key != null) {
			elements.add(new LuaKeyValue(key,value.toString()));
		}
	}
	
	public String get(String key) {
		for(LuaKeyValue pair:elements) {
			if(pair.getKey()==null)
				continue;
			if(pair.getKey().equals(key)) {
				return pair.getValue();
			}
		}
		return null;
	}
	
	public LuaKeyValue[] getAll() {
		return elements.toArray(new LuaKeyValue[0]);
	}
	
	public void set(String key, Object value) {
		boolean found = false;
		for(LuaKeyValue pair:elements) {
			if(pair.getKey().equals(key)) {
				found = true;
				elements.remove(pair);
				elements.add(new LuaKeyValue(key,value.toString()));
				break;
			}
		}
		if(!found) {
			elements.add(new LuaKeyValue(key,value.toString()));
		}
	}
	
	@Override
	public String toString() {
		String output = "{";
		boolean first = true;
		for(LuaKeyValue pair:elements) {
			if(!first) {
				output += ", ";
			}
			else {
				first = false;
			}
			output += pair;
		}
		output += "}";
		return output;
	}
	
	public static boolean isTable(Object obj) {
		if(obj.toString().charAt(0) == '{' && obj.toString().charAt(obj.toString().length()-1) == '}') {
			return true;
		}
		return false;
	}
}

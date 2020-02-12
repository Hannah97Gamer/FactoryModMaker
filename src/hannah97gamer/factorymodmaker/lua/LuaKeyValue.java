package hannah97gamer.factorymodmaker.lua;

public class LuaKeyValue {
	private String key;
	private String value;
	
	public LuaKeyValue(String key, String value) {
		this.key = key;
		this.value = value.charAt(0)=='{'||value.charAt(0)=='"'?value:String.format("\"%s\"", value);
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		String output = "";
		if(key != null) {
			output += key + " = ";
		}
		output += value;
		return output;
	}
}

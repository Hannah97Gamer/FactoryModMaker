package hannah97gamer.factorymodmaker.prototypes;

import hannah97gamer.factorymodmaker.lua.Table;

public class PrototypeBase {
	private String name;
	private String type;
	
	public PrototypeBase(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public Table getLuaTable() {
		Table t = new Table();
		t.add("name",name);
		t.add("type",type);
		return t;
	}
	
	public void changeName(String name) {
		if(!name.equals("")) {
			this.name = name;
		}
	}
	
	@Override
	public String toString() {
		return getLuaTable().toString();
	}
}

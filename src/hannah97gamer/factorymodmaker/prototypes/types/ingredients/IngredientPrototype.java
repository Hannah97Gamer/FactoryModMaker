package hannah97gamer.factorymodmaker.prototypes.types.ingredients;

import hannah97gamer.factorymodmaker.lua.Table;

public abstract class IngredientPrototype {
	private String type;
	private String name;
	private int amount;
	
	public IngredientPrototype(String type, String name, int amount) {
		this.type = type;
		this.name = name;
		this.amount = amount;
	}
	
	public Table getLuaTable() {
		Table t = new Table();
		t.add("type",type);
		t.add("name",name);
		t.add("amount",amount);
		return t;
	}
}

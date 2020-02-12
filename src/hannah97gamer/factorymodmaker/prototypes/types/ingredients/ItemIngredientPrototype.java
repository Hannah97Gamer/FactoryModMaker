package hannah97gamer.factorymodmaker.prototypes.types.ingredients;

import hannah97gamer.factorymodmaker.lua.Table;

public class ItemIngredientPrototype extends IngredientPrototype {
	private static final String TYPE = "item";
	
	private int catalyst = 0;
	
	public ItemIngredientPrototype(String name, int amount) {
		super(TYPE, name, amount);
	}
	
	public ItemIngredientPrototype setCatalyst(int amount) {
		catalyst = amount;
		return this;
	}
	
	@Override
	public Table getLuaTable() {
		Table t = super.getLuaTable();
		if(catalyst > 0) {
			t.add("catalyst_amount",catalyst);
		}
		return t;
	}
}

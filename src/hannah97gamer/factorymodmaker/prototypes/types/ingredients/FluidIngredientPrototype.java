package hannah97gamer.factorymodmaker.prototypes.types.ingredients;

import hannah97gamer.factorymodmaker.lua.Table;

public class FluidIngredientPrototype extends IngredientPrototype {
	private static final String TYPE = "fluid";
	
	private Double temperature;
	private Double minTemperature;
	private Double maxTemperature;
	private Double catalystAmount;
	private Integer fluidboxIndex;

	public FluidIngredientPrototype(String name, int amount) {
		super(TYPE, name, amount);
	}
	
	public FluidIngredientPrototype setTemperature(double temp) {
		temperature = temp;
		return this;
	}
	
	public FluidIngredientPrototype setMinTemperature(double minTemp) {
		minTemperature = minTemp;
		return this;
	}

	public FluidIngredientPrototype setMaxTemperature(double maxTemp) {
		maxTemperature = maxTemp;
		return this;
	}
	
	public FluidIngredientPrototype setCatalystAmount(double catalyst) {
		catalystAmount = catalyst;
		return this;
	}
	
	public FluidIngredientPrototype setFluidbox(int index) {
		fluidboxIndex = index;
		return this;
	}
	
	@Override
	public Table getLuaTable() {
		Table t = super.getLuaTable();
		t.addIfNotNull("temperature", temperature);
		t.addIfNotNull("minimum_temperature", minTemperature);
		t.addIfNotNull("maximum_temperature", maxTemperature);
		t.addIfNotNull("catalyst_amount", catalystAmount);
		t.addIfNotNull("fluidbox_index", fluidboxIndex);
		return t;
	}
}

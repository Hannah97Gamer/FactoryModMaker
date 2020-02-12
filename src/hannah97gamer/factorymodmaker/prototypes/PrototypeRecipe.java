package hannah97gamer.factorymodmaker.prototypes;

import java.util.ArrayList;

import hannah97gamer.factorymodmaker.lua.Table;
import hannah97gamer.factorymodmaker.prototypes.types.ingredients.IngredientPrototype;

public class PrototypeRecipe extends PrototypeBase {
	private String category;
	private ArrayList<IngredientPrototype> ingredients;
	private ArrayList<IngredientPrototype> results;
	private double energyRequired = 0.5;
	private double emissionsMultiplier = 1.0;
	private String subgroup;
	private boolean enabled = true;
	private boolean hidden = false;
	private String mainProduct;
	
	private String icon;
	private Integer iconSize;
	
	public PrototypeRecipe(String name, String category) {
		super(name,"recipe");
		this.category = category;
		ingredients = new ArrayList<IngredientPrototype>();
		results = new ArrayList<IngredientPrototype>();
	}
	
	public void addIngredient(IngredientPrototype ingredient) {
		ingredients.add(ingredient);
	}
	
	public void addResult(IngredientPrototype result) {
		results.add(result);
	}
	
	public void setMainProduct(String product) {
		mainProduct = product;
	}
	
	public void setIconPath(String path) {
		icon = path;
	}
	
	public void setIconSize(int size) {
		iconSize = size;
	}
	
	public void setEnergyRequired(double energy) {
		energyRequired = energy;
	}
	
	public void setEmissionsMultiplier(double multiplier) {
		emissionsMultiplier = multiplier;
	}
	
	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	@Override
	public Table getLuaTable() {
		Table t = super.getLuaTable();
		
		t.add("category",category);
		
		Table ingredients = new Table();
		for(IngredientPrototype ing:this.ingredients) {
			ingredients.add(ing.getLuaTable());
		}
		t.add("ingredients",ingredients);
		
		Table results = new Table();
		for(IngredientPrototype result:this.results) {
			results.add(result.getLuaTable());
		}
		t.add("results", results);
		
		
		t.add("enabled",enabled);
		t.add("hidden",hidden);
		t.add("energy_required",energyRequired);
		t.add("emissions_multiplier",emissionsMultiplier);
		t.addIfNotNull("subgroup", subgroup);
		t.addIfNotNull("main_product", mainProduct);
		t.addIfNotNull("icon", icon);
		t.addIfNotNull("icon_size", iconSize);
		
		return t;
	}
}

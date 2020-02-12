package hannah97gamer.factorymodmaker.prototypes.types;

import java.awt.Color;

import hannah97gamer.factorymodmaker.lua.Table;

public class TypeColor extends Color {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeColor(int r, int g, int b, int a) {
		super(r,g,b,a);
	}
	
	public TypeColor(Color c) {
		super(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
	}
	
	public Table getLuaTable() {
		Table t = new Table();
		t.add("r",getRed());
		t.add("g",getGreen());
		t.add("b",getBlue());
		t.add("a",getAlpha());
		return t;
	}
}

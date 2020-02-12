package hannah97gamer.factorymodmaker.filesystem;

import java.io.File;

public class Files {
	public static final int WINDOWS = 0;
	
	private static Files instance;
	private int os;
	
	public static void init(int os) {
		instance = new Files(os);
	}
	
	private Files(int os) {
		this.os = os;
	}
	
	public static File getFactorioModFolder() {
		File mods = null;
		switch(instance.os) {
		case WINDOWS:
			mods = new File(System.getenv("APPDATA") + File.separator + "Factorio"+ File.separator +"mods");
		}
		return mods;
	}
	
	public static File getDefaultLocaleFile() {
		return new File(getFactorioDataFolder().getPath() + File.separator + "locale" + File.separator + "en" + File.separator + "base.cfg");
	}
	
	public static File getFactorioDataFolder() {
		File data = null;
		switch(instance.os) {
		case WINDOWS:
			data = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Factorio\\data\\base");
		}
		return data;
	}
}

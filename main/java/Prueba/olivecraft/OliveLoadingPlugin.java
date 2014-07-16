package Prueba.olivecraft;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

@MCVersion(value = "1.7.2")
public class OliveLoadingPlugin implements IFMLLoadingPlugin
{
    public String[] getASMTransformerClass() {
        return new String[] {OliveClassTransformer.class.getName()};
    }
    
    public void injectData(Map<String, Object> data) {}

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

	public String getAccessTransformerClass() {
		return null;
	}

	
}

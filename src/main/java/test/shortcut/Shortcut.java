package test.shortcut;

import org.bukkit.plugin.java.JavaPlugin;
import test.shortcut.Commands.GMA;
import test.shortcut.Commands.GMC;
import test.shortcut.Commands.GMS;
import test.shortcut.Commands.GMSP;

public final class Shortcut extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Shortcut Abilitato!");
        getCommand("gmc").setExecutor(new GMC());
        getCommand("gms").setExecutor(new GMS());
        getCommand("gma").setExecutor(new GMA());
        getCommand("gmsp").setExecutor(new GMSP());
    }

    @Override
    public void onDisable() {
        System.out.println("Shortcut Disabilitato!");
    }
}

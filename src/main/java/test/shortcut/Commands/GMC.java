package test.shortcut.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.annotation.Target;

public class GMC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player)
        {
            if (args.length == 0)
            {
                if (cmd.getName().equalsIgnoreCase("gmc"))
                {
                    if (sender.hasPermission("headstaff.use"))
                    {
                        if (((Player) sender).getGameMode() != GameMode.CREATIVE)
                        {
                            ((Player) sender).setGameMode(GameMode.CREATIVE);
                            sender.sendMessage(ChatColor.AQUA + "Staff >> " + ChatColor.YELLOW + "Hai cambiato la modalità a " + ChatColor.GREEN + "CREATIVA");
                        }
                        else
                        {
                            sender.sendMessage(ChatColor.AQUA + "Staff >> " + ChatColor.YELLOW + "Sei già in modalità " + ChatColor.GREEN + "CREATIVA");
                        }
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.GRAY + "Comando sconosciuto");
                    }
                }
            } else if ((args.length == 1))
            {
                Player targetPlayer = Bukkit.getPlayer(args[0]);
                if (sender.hasPermission("headstaff.use"))
                {
                    if (args[0].equals("*"))
                    {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.setGameMode(GameMode.CREATIVE);
                        }
                        sender.sendMessage(ChatColor.AQUA + "Staff >> " + ChatColor.YELLOW + "Hai cambiato la modalità a " + ChatColor.GREEN + "CREATIVA " + ChatColor.YELLOW + "per tutti i giocatori");
                    }
                    else if (Bukkit.getPlayer(args[0]) != null) {
                        targetPlayer.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(ChatColor.AQUA + "Staff >> " + ChatColor.YELLOW + "Hai cambiato la modalità a " + ChatColor.GREEN + "CREATIVA " + ChatColor.YELLOW + "per il giocatore " + ChatColor.DARK_AQUA + targetPlayer.getName());
                    }
                    else if (Bukkit.getPlayer(args[0]) == null)
                    {
                        sender.sendMessage(ChatColor.RED + "Il giocatore " + ChatColor.DARK_RED + args[0] + ChatColor.RED + " non è online");
                    }
                }
                else
                {
                    sender.sendMessage(ChatColor.GRAY + "Comando sconosciuto");
                }
            }
        }
        else
        {
            System.out.println("Non puoi eseguire questo comando!");
        }
        return false;
    }
}

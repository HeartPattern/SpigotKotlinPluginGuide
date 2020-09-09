package io.heartpattern.kotlinguide

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class KotlinGuidePlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    fun PlayerJoinEvent.onPlayerJoin() {
        player.sendMessage("Hello, ${player.name}")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (label == "test1") {
            if (args.isEmpty())
                sender.sendMessage("Hello")

            when (args[0]) {
                "a" -> sender.sendMessage("You entered a")
                "b" -> sender.sendMessage("B!")
                else -> sender.sendMessage("You enter something else")
            }
        } else if (label == "test2") {
            if (sender is Player)
                sender.health = 0.0
            else
                sender.sendMessage("Console cannot use this command")
        }

        return true
    }
}
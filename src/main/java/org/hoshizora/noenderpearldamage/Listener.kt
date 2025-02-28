package org.hoshizora.noenderpearldamage

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.plugin.java.JavaPlugin

class Listener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerTeleport(event: PlayerTeleportEvent) {
        if (event.cause == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            event.isCancelled = true

            val player: Player = event.player

            Bukkit.getScheduler().runTask(plugin, Runnable {
                player.teleport(event.to)

                player.noDamageTicks = 10
            })
        }
    }

    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entity is Player && event.cause == EntityDamageEvent.DamageCause.FALL) {

            val player = event.entity as Player

            if (player.noDamageTicks > 0) {
                event.isCancelled = true
            }
        }
    }
}

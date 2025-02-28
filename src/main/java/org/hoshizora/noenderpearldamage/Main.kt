package org.hoshizora.noenderpearldamage

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("星空麗成｜HoshizoraRenaru NoEnderPearlDamage Plugin")
        logger.info("gamerule noEnderPearlDamage is now set to: true")
        server.pluginManager.registerEvents(Listener(this), this)
    }

    override fun onDisable() {
        logger.info("gamerule noEnderPearlDamage is now set to: false")
    }
}

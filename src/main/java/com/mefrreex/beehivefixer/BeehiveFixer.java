package com.mefrreex.beehivefixer;

import cn.nukkit.blockentity.BlockEntityBeehive;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.level.ChunkLoadEvent;
import cn.nukkit.plugin.PluginBase;

public class BeehiveFixer extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {        
        event.getLevel().getBlockEntities().values().forEach(entity -> {
            if (entity instanceof BlockEntityBeehive) {
                entity.close();
            }
        });
    }
}

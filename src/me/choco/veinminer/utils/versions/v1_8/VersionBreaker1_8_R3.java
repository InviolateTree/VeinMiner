package me.choco.veinminer.utils.versions.v1_8;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.choco.veinminer.utils.versions.VersionBreaker;
import net.minecraft.server.v1_8_R3.BlockPosition;

public class VersionBreaker1_8_R3 implements VersionBreaker {

	@Override
	public void breakBlock(Player player, Block block) {
		((CraftPlayer) player).getHandle().playerInteractManager.breakBlock(new BlockPosition(block.getX(), block.getY(), block.getZ()));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemStack getItemInHand(Player player) {
		return player.getItemInHand();
	}
}
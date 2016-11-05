package me.choco.veinminer.api;

import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import me.choco.veinminer.api.veinutils.VeinBlock;

/** Called when VeinMiner is activated for a specific set of blocks
 */
public class PlayerVeinMineEvent extends PlayerEvent implements Cancellable{
	public static HandlerList handlers = new HandlerList();
	private boolean cancelled = false;

	private final VeinBlock type;
	private final Set<Block> blocks;
	public PlayerVeinMineEvent(Player who, VeinBlock type, Set<Block> blocks) {
		super(who);
		this.type = type;
		this.blocks = blocks;
	}
	
	/** Get a list of all blocks affected by this event. 
	 * This list is mutable, you are able to modify it
	 * @return the blocks affected by this event
	 */
	public Set<Block> getBlocks(){
		return blocks;
	}
	
	/** Get the block affected by the VeinMiner action
	 * @return the block affected
	 */
	public VeinBlock getAffectedBlock() {
		return type;
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}
	
	@Override
	public void setCancelled(boolean cancel){
		this.cancelled = cancel;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}
}
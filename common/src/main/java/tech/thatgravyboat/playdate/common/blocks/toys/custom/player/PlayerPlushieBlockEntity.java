package tech.thatgravyboat.playdate.common.blocks.toys.custom.player;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.Locale;

public class PlayerPlushieBlockEntity extends PlushieBlockEntity {

    private final PlayerSkin defaultSkin;
    private PlayerSkin skin;

    public PlayerPlushieBlockEntity(PlayerSkin skin, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(PlushieItem.PLAYER, type, pos, state);
        this.defaultSkin = skin;
    }

    public PlayerSkin getDefaultSkin() {
        return this.defaultSkin;
    }

    public PlayerSkin getSkin() {
        if (this.skin == null && this.world != null) {
            var blockState = this.world.getBlockState(this.pos);
            if (blockState.contains(PlayerPlushieBlock.SKIN)) {
                skin = blockState.get(PlayerPlushieBlock.SKIN);
            }
        }
        return this.skin == null ? this.defaultSkin : this.skin;
    }
}

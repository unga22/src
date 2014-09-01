package Gravity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractPacket
{

    public AbstractPacket()
    {
    }

    public abstract void encodeInto(ChannelHandlerContext channelhandlercontext, ByteBuf bytebuf);

    public abstract void decodeInto(ChannelHandlerContext channelhandlercontext, ByteBuf bytebuf);

    public abstract void handleClientSide(EntityPlayer entityplayer);

    public abstract void handleServerSide(EntityPlayer entityplayer);
}

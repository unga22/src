package Gravity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.Attribute;
import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;

// Referenced classes of package grim3212.mc.core.packet:
//            AbstractPacket

public class PacketPipeline extends MessageToMessageCodec
{

    public PacketPipeline()
    {
    }

    public static boolean registerPacket(Class clazz)
    {
        if(packets.size() > 256)
            return false;
        if(packets.contains(clazz))
            return false;
        if(isPostInitialised)
        {
            return false;
        } else
        {
            packets.add(clazz);
            return true;
        }
    }

    protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, List out)
        throws Exception
    {
        ByteBuf buffer = Unpooled.buffer();
        Class clazz = msg.getClass();
        PacketPipeline _tmp = this;
        if(!packets.contains(msg.getClass()))
        {
            throw new NullPointerException((new StringBuilder()).append("No Packet Registered for: ").append(msg.getClass().getCanonicalName()).toString());
        } else
        {
            PacketPipeline _tmp1 = this;
            byte discriminator = (byte)packets.indexOf(clazz);
            buffer.writeByte(discriminator);
            msg.encodeInto(ctx, buffer);
            FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
            out.add(proxyPacket);
            return;
        }
    }

    protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List out)
        throws Exception
    {
        ByteBuf payload = msg.payload();
        byte discriminator = payload.readByte();
        PacketPipeline _tmp = this;
        Class clazz = (Class)packets.get(discriminator);
        if(clazz == null)
            throw new NullPointerException((new StringBuilder()).append("No packet registered for discriminator: ").append(discriminator).toString());
        AbstractPacket pkt = (AbstractPacket)clazz.newInstance();
        pkt.decodeInto(ctx, payload.slice());
        static class _cls2
        {

            static final int $SwitchMap$cpw$mods$fml$relauncher$Side[];

            static 
            {
                $SwitchMap$cpw$mods$fml$relauncher$Side = new int[Side.values().length];
                try
                {
                    $SwitchMap$cpw$mods$fml$relauncher$Side[Side.CLIENT.ordinal()] = 1;
                }
                catch(NoSuchFieldError ex) { }
                try
                {
                    $SwitchMap$cpw$mods$fml$relauncher$Side[Side.SERVER.ordinal()] = 2;
                }
                catch(NoSuchFieldError ex) { }
            }
        }

        switch(_cls2..SwitchMap.cpw.mods.fml.relauncher.Side[FMLCommonHandler.instance().getEffectiveSide().ordinal()])
        {
        case 1: // '\001'
        {
            EntityPlayer player = getClientPlayer();
            pkt.handleClientSide(player);
            break;
        }

        case 2: // '\002'
        {
            INetHandler netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
            EntityPlayer player = ((NetHandlerPlayServer)netHandler).field_147369_b;
            pkt.handleServerSide(player);
            break;
        }
        }
        out.add(pkt);
    }

    public void initialise()
    {
        PacketPipeline _tmp = this;
        channels = NetworkRegistry.INSTANCE.newChannel("GrimsMods", new ChannelHandler[] {
            this
        });
    }

    public void postInitialise()
    {
        PacketPipeline _tmp = this;
        if(isPostInitialised)
        {
            return;
        } else
        {
            PacketPipeline _tmp1 = this;
            isPostInitialised = true;
            PacketPipeline _tmp2 = this;
            Collections.sort(packets, new Comparator() {

                public int compare(Class clazz1, Class clazz2)
                {
                    int com = String.CASE_INSENSITIVE_ORDER.compare(clazz1.getCanonicalName(), clazz2.getCanonicalName());
                    if(com == 0)
                        com = clazz1.getCanonicalName().compareTo(clazz2.getCanonicalName());
                    return com;
                }

                public volatile int compare(Object x0, Object x1)
                {
                    return compare((Class)x0, (Class)x1);
                }

                final PacketPipeline this$0;

            
            {
                this$0 = PacketPipeline.this;
                super();
            }
            }
);
            return;
        }
    }

    private EntityPlayer getClientPlayer()
    {
        return Minecraft.func_71410_x().field_71439_g;
    }

    public void sendToAll(AbstractPacket message)
    {
        PacketPipeline _tmp = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget.ALL);
        PacketPipeline _tmp1 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
    }

    public void sendTo(AbstractPacket message, EntityPlayerMP player)
    {
        PacketPipeline _tmp = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget.PLAYER);
        PacketPipeline _tmp1 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        PacketPipeline _tmp2 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
    }

    public void sendToAllAround(AbstractPacket message, cpw.mods.fml.common.network.NetworkRegistry.TargetPoint point)
    {
        PacketPipeline _tmp = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        PacketPipeline _tmp1 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        PacketPipeline _tmp2 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
    }

    public void sendToDimension(AbstractPacket message, int dimensionId)
    {
        PacketPipeline _tmp = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget.DIMENSION);
        PacketPipeline _tmp1 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
        PacketPipeline _tmp2 = this;
        ((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
    }

    public static void sendToServer(AbstractPacket message)
    {
        ((FMLEmbeddedChannel)channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget.TOSERVER);
        ((FMLEmbeddedChannel)channels.get(Side.CLIENT)).writeAndFlush(message);
    }

    protected volatile void decode(ChannelHandlerContext x0, Object x1, List x2)
        throws Exception
    {
        decode(x0, (FMLProxyPacket)x1, x2);
    }

    protected volatile void encode(ChannelHandlerContext x0, Object x1, List x2)
        throws Exception
    {
        encode(x0, (AbstractPacket)x1, x2);
    }

    private static EnumMap channels;
    private static LinkedList packets = new LinkedList();
    private static boolean isPostInitialised = false;

}

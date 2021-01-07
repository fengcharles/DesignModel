package cc.fyp.design.socket.reactor;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author von
 * @description:
 * @date 2021/1/7 14:09
 */
public class SocketTest {


    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelHandler() {
                @Override
                public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                }

                @Override
                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                }

                @Override
                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                }
            });

            ChannelFuture sync = serverBootstrap.bind(8099).sync();
            System.out.println(">>>>>>>===========");
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

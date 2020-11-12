package com.netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyChatClient {

    public static void main(String[] args)throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .remoteAddress("localhost", 8899)
                    .handler(new MyChatClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect().sync();
            //标准输入
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            //自旋，不断读取客户端在控制台上的输入
            for(;;){
                channelFuture.channel().writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}

package com.message.pack.handler;

import com.message.pack.client.EchoClient;
import com.message.pack.entity.UserInfo;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {
    private final int sendNumber;
    public EchoClientHandler(int sendNumber){
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] infos = UserInfo();

        for(UserInfo infoE : infos){
            ctx.write(infoE);
        }
        ctx.flush();
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private UserInfo [] UserInfo() {
        UserInfo [] userInfos = new UserInfo[sendNumber];
        UserInfo userInfo  = null;
        for(int i = 0;i < sendNumber;i++){
            userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEFG---->"+i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }
}

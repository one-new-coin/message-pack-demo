package com.message.pack.demo;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args)throws Exception{
        List<String> datum = new ArrayList<>();

        datum.add("zhangsan");
        datum.add("lisi");
        datum.add("wangwu");
        datum.add("zhaoliu");

        MessagePack messagePack = new MessagePack();
        byte[] raws = messagePack.write(datum);
        for (byte raw : raws){
            System.out.print(raw);
        }

        System.out.println("******************");

        List<String>  datums = messagePack.read(raws, Templates.tList(Templates.TString));
        for(String str : datums){
            System.out.println(str);
        }

    }
}

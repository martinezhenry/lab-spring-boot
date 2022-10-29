package com.hvs.lab.spring.service;

import org.jpos.iso.*;
import org.jpos.iso.channel.PostChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

@Service
@EnableAsync
public class PostilionInterfaceSimulator {

    private long systemTrace;
    private final ISOPackager packager = new ISO87APackager();

    public void startProcess() throws IOException, ISOException {
        ISOChannel senderChannel = new PostChannel("d.isosender", 30009, packager);
        ISOChannel receiverChannel = new PostChannel("d.isoreceiver", 30011, packager);
        systemTrace++;


        ISOMsg msg = new ISOMsg();
        var date = new Date();
        msg.setPackager(packager);
        msg.setMTI("0800");
        msg.set(7, ISODate.getDateTime(date));
        msg.set(11, ISOUtil.padleft(String.valueOf(systemTrace), 6, '0'));
        msg.set(12, ISODate.getTime(date));
        msg.set(13, ISODate.getDate(date));
        msg.set(70, "001");

        senderChannel.connect();
        receiverChannel.connect();

        if (senderChannel.isConnected() && receiverChannel.isConnected()) {
            System.out.println("sockets connected");
            sendMsg(receiverChannel, msg);
            processResponses(senderChannel);
            while (senderChannel.isConnected() && receiverChannel.isConnected()) {
                System.out.println("init echo msg");
                ISOUtil.sleep(10000);
                msg.set(70, "301");
                incrementSystemTrace(msg);
                sendMsg(receiverChannel, msg);
            }

        }
    }

    public void processResponses(ISOChannel channel) throws ISOException, IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (channel.isConnected()) {
                    ISOMsg rsp = null;
                    try {
                        rsp = receiveMsg(channel);
                    } catch (ISOException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    rsp.dump(System.out, "");
                }
            }
        }).start();


    }


    public void incrementSystemTrace(ISOMsg msg) throws ISOException {
        systemTrace++;
        msg.set(11, ISOUtil.padleft(String.valueOf(systemTrace), 6, '0'));
    }


    public void sendMsg(ISOChannel channel, ISOMsg msg) throws ISOException, IOException {
        System.out.println(String.format("sending msg: %s", msg));
        channel.send(msg);

    }

    @Async
    public ISOMsg receiveMsg(ISOChannel channel) throws ISOException, IOException {
        ISOMsg msg = new ISOMsg();
        msg.setPackager(packager);
        msg = channel.receive();
        System.out.printf("received msg: %s%n", msg);
        return msg;

    }

}

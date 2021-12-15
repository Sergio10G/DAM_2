package com.campusfp.hitoftp.experimental;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TestSend extends Thread {

    Socket socket;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.socket = new Socket("127.0.0.1", 5111);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

            outStream.writeUTF("msg1");
            outStream.writeUTF("msg2");
            System.out.println("Finished sending");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}

package com.rexthk;

import java.io.IOException;
import java.net.Socket;

/**
 * @author rexthk
 */
public class Sockets {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket[] sockets = new Socket[5000];

        for (int i = 0; i < sockets.length; i++) {
            sockets[i] = new Socket("localhost", 1111);
        }

        Thread.sleep(1_000_000);
    }
}

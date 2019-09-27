package com.rexthk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1111);

        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            executorService.submit(() -> handle(socket));
        }
    }

    private static void handle(Socket socket) {
        System.out.println("connected :" + socket);
        try (
                socket;
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
        ) {
            in.transferTo(out);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } finally {
            System.out.println("disconnected :" + socket);
        }

    }


}

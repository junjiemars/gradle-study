package org.tao.svr;

import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.tao.api.Hello;

import static java.lang.System.out;

/**
 * Created by junjie on 11/19/14.
 */

public class Server {

    public static void main(String[] args) {
        out.println("#starting the Server:8181 ...");
        try {
            processor = new Hello.Processor(handler);

            Runnable simple = new Runnable() {
                @Override
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void simple(Hello.Processor p) {
        try {
            TServerTransport serverTransport = new TServerSocket(8181);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            // Use this for a multithreaded svr
            // TServer svr = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            out.println("Starting the simple server ...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ProcessHandler implements Hello.Iface {
        @Override
        public void ping() throws TException {
            out.println("#ok, pong");
        }

        @Override
        public int add(int x, int y) throws TException {
            return x+y;
        }

        @Override
        public void say() throws TException {
            out.println("#ok, said");
        }
    }

    public static ProcessHandler handler;
    public static Hello.Processor<ProcessHandler> processor;
}

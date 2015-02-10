package org.tao.clt;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.tao.api.Hello;

import static java.lang.System.out;

/**
 * Created by junjie on 11/20/14.
 */
public final class Client {
    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 8181);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            call(client);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void call(Hello.Client client) throws TException {
//        client.ping();
//        out.println("ping()");

        int sum = client.add(1, 2);
        out.println("1+2=" + sum);
    }

}

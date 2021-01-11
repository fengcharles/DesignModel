package cc.fyp.design.nio.socket;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author von
 * @description:
 * @date 2021/1/8 17:22
 */
public class Client {

    public static void main(String[] args)throws Exception {
        new Client().connetion();
    }

    private void connetion() throws Exception{

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));
        socketChannel.configureBlocking(false);
        socketChannel.write(
                Charset.forName("UTF-8")
                        .encode("client" + " : " + "hello"));

    }
}

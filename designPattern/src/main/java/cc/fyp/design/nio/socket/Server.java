package cc.fyp.design.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 学习socket 变成第二阶段  NIO
 * 了解Java 提供的NIO 类库的各个特性
 * 完成一个聊天工具
 *
 * @author von
 * @description:
 * @date 2021/1/8 16:58
 */
public class Server {

    public static void main(String[] args) throws Exception {
        new Server().start();
    }

    private void start() throws Exception {

        Selector selector = Selector.open();

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(9090));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功！");

        for (; ; ) {

            int readyChannels = selector.select(2000);

            if (readyChannels == 0) {
                continue;
            }

            System.out.println("获取到准备好的渠道");

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            System.out.println(selectionKeys);

            Iterator iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                /**
                 * selectionKey实例
                 */
                SelectionKey selectionKey = (SelectionKey) iterator.next();

                /**
                 * 7. 根据就绪状态，调用对应方法处理业务逻辑
                 */
                /**
                 * 如果是 接入事件
                 */
                if (selectionKey.isAcceptable()) {

                    SocketChannel newChannel = socketChannel.accept();
                    //把这个渠道注册到selector里面，并告诉selector 想监听读事件，看看他给我们发送些什么东西
                    newChannel.configureBlocking(false);
                    newChannel.register(selector,SelectionKey.OP_READ);

                    System.out.println(selectionKey +  "是可接收的");
                }

                /**
                 * 如果是 可读事件
                 */
                if (selectionKey.isReadable()) {
                    System.out.println(selectionKey + "是可读的");
                    readData(selectionKey);
                }


                /**
                 * **移除Set中的当前selectionKey**
                 */
                iterator.remove();
            }


        }

    }


    /**
     *  读取客户端消息
     * @param key
     */
    private void readData(SelectionKey key){
        // 定义一个SocketChannel
        SocketChannel channel = null;
        try {
            // 得到channel
            channel = (SocketChannel) key.channel();

            // 创建缓冲buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            // 根据count的值做处理
            if (count > 0){
                // 把缓冲区数据转为字符串并输出
                String msg = new String(buffer.array());
                // 输出该消息
                System.out.println("from Client: " + msg);

            }
            channel.close();
        } catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress() + " is offline");
                // 取消注册
                key.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}



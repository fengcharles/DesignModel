package cc.fyp.design.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 一阶段编程
 * 主要是为了熟悉 java.io socket 与客户端连接相关知识
 * 单客户端，单服务器模式
 *
 * @author von
 * @description:
 * @date 2021/1/7 14:47
 */
public class Server {


    public static void main(String[] args) throws Exception {

        String readline = null;
        String inTemp = null;
        final String client = "Client:";
        final String server = "Server:";

        int port = 4000;

        //首先直接创建serversocket
        ServerSocket serverSocket = new ServerSocket(port);

       //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
        System.out.println("服务器启动，等待客户端连接.....");
        Socket socket = serverSocket.accept();
        System.out.println("接收到客户端连接，客户端"+socket.getRemoteSocketAddress());

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while(!"bye".equals(readline)){

            inTemp = socketIn.readLine();
            System.out.println(client + "说：" + inTemp);
            readline = systemIn.readLine();

            socketOut.println(readline);
            socketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)
        }

        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();
        serverSocket.close();


    }

}

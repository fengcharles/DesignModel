package cc.fyp.design.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author von
 * @description:
 * @date 2021/1/7 14:57
 */
public class Client {


    public static void main(String[] args) throws Exception {
        // TODO 自动生成的方法存根

        String readline = null;
        String inTemp = null;
        final String server = "Server:";

        int port = 4000;
        byte ipAddressTemp[] = {127, 0, 0, 1};
        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

        //首先直接创建socket,端口号1~1023为系统保存，一般设在1023之外
        Socket socket = new Socket(ipAddress, port);

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while(!"bye".equals(readline)){

            readline = systemIn.readLine();
            socketOut.println(readline);
            socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

            inTemp = socketIn.readLine();

            System.out.println(server + "说：" + inTemp);

        }

        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();
    }

}

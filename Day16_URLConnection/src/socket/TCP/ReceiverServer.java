package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ReceiverServer {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8020);
        Socket socket = ss.accept();
        new Thread(new Runnable() {
            @Override
            public void run() {
                OutputStream os = null;
                try {
                    os = socket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String s = null;
                while (!(s = scanner.nextLine()).equals("quit")) {
                    try {
                        os.write(s.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.write(s.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        ss.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//            os.flush();
                }
            }
        }).start();
        InputStream is = socket.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff)) != -1) {
            sb.append(new String(buff, 0, len));
            System.out.println(sb.toString());
            if (sb.toString().equals("quit")){
               ss.close();
            }
            sb.setLength(0);
        }
        ss.close();
    }
}

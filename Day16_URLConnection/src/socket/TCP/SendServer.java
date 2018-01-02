package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SendServer {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.151",8020);
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is = null;
                try {
                    is = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] buff = new byte[1024];
                int l = 0;
                StringBuffer sb = new StringBuffer();
                try {
                    while ((l = is.read(buff)) != -1) {
                        sb.append(new String(buff, 0, l));
                        System.out.println(sb.toString());
                        if (sb.toString().equals("quit")){
                            socket.close();
                        }
                        sb.setLength(0);
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        OutputStream os = socket.getOutputStream();
        String s = null;
        while (!(s = scanner.nextLine()).equals("quit")) {
            os.write(s.getBytes());
//            os.flush();
        }
        os.write(s.getBytes());
        socket.close();
    }
}

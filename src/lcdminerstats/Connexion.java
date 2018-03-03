package lcdminerstats;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geckoflume
 */
public class Connexion {

    private String ip;
    private int port;

    public Connexion(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String request() {
        try {
            Socket sock = new Socket(this.ip, this.port);
            String request = "{\"id\":0,\"jsonrpc\":\"2.0\",\"method\":\"miner_getstat1\"}\r\n";

            BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
            bos.write(request.getBytes());
            bos.flush();

            BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
            String content = "";
            int stream;
            byte[] b = new byte[1024];
            while ((stream = bis.read(b)) != -1) {
                content += new String(b, 0, stream);
            }

            sock.close();

            return content;
        } catch (IOException ex) {
            Logger.getLogger(LCDMining.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

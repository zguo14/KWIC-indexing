import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketInput implements Input {
    private List<String> lines;
    private int PORT;

    public SocketInput(int port) {
        this.PORT = port;
    }

    @Override
    public List<String> readLines() throws IOException {
        lines = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                lines.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

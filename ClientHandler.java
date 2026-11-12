
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream()
        ) {
// İstemciden (Browser) gelen HTTP İsteğinin (Request) İlk Satırını Oku
            String requestLine = in.readLine();
            if (requestLine == null) return;

// Oluşturulan HTML İçeriğini Al
            String htmlBody = HtmlResponseBuilder.buildHtmlPage();
            byte[] bodyBytes = htmlBody.getBytes("UTF-8");

// HTTP Yanıt Başlıklarını (Header) Hazırla
            String httpResponseHeader = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + bodyBytes.length + "\r\n" +
                    "Connection: close\r\n" +
                    "\r\n";

// Header ve Body'yi Tarayıcıya Gönder
            out.write(httpResponseHeader.getBytes("UTF-8"));
            out.write(bodyBytes);
            out.flush();

        } catch (IOException e) {
            System.err.println("İstemci işleme hatası: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Soket kapatılamadı: " + e.getMessage());
            }
        }
    }
}
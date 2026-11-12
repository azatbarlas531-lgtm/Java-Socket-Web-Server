

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
    private static final int PORT = 1989;

    public static void main(String[] args) {
        System.out.println("HTTP Sunucu " + PORT + " portunda başlatılıyor...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu hazır! Bağlantılar bekleniyor...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
// Her gelen istemci (browser) talebini ayrı bir iş parçacığında ele alıyoruz.
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu hatası: " + e.getMessage());
        }
    }
}
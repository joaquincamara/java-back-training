package com.mycompany.app;

//import static com.mycompany.app.ApiUtils.splitQuery;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
//import java.util.List;
//import java.util.Map;

import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/capitan", (exchange -> {
            String respText = "Hello capitan!";

            if ("POST".equals(exchange.getRequestMethod())) {
                // Map<String, List<String>> params =
                // splitQuery(exchange.getRequestURI().getRawQuery());
                // String noNameText = "Anonymous";
                // String name = params.getOrDefault("name",
                // List.of(noNameText)).stream().findFirst().orElse(noNameText);
                // String respText = String.format("Hello capitan %s!", name);
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}

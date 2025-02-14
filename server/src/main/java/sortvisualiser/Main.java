package sortvisualiser;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    private static HttpServer start() {
        final ResourceConfig resourceConfig = new ResourceConfig().packages("sortvisualiser");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = start();
        System.in.read();
        server.shutdownNow();
    }
}



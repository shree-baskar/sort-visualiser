package sortvisualiser;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class WebResourceConfig extends ResourceConfig {
    public WebResourceConfig() {
        packages("sortvisualiser");
    }
}


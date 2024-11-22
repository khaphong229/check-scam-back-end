package java_backend.check_scammer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        final Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dqca5ltt9");
        config.put("api_key", "941722891293466");
        config.put("api_secret", "wlhEL6enfutAAeJjdoALj_6JbSM");
        return new Cloudinary(config);
    }
}

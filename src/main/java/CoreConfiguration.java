import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = {"java", "bean_post_processors","bean_factory_post_processors","services","models"})
public class CoreConfiguration {
    @Bean
    @Scope("periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(250),random.nextInt(250),random.nextInt(250));
    }
}

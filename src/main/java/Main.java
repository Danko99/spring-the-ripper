import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ColorFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.MessageService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoreConfiguration.class);
//        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
//        Object messageService = applicationContext.getBean("messageService");
//        System.out.println(messageService);
//
//        ColorFrame colorFrame = applicationContext.getBean(ColorFrame.class);
//        colorFrame.showOnRandomPlace();
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
}

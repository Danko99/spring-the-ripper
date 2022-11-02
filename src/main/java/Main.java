import models.ColorFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.MessageService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoreConfiguration.class);
        System.out.println(applicationContext.getBeanDefinitionNames());
        MessageService messageService = applicationContext.getBean(MessageService.class);
        System.out.println(messageService.toString());

        ColorFrame colorFrame = applicationContext.getBean(ColorFrame.class);
        colorFrame.showOnRandomPlace();
    }
}

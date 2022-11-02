package bean_factory_post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    private List<String> beanNames;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        beanNames = Arrays.asList(beanDefinitionNames);
        System.out.println("Кандидаты на добавление в контекст: "+beanNames);
    }
    public List<String> getBeanNames() {
        return beanNames;
    }
}

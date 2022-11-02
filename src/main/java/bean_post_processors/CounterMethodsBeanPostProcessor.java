package bean_post_processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class CounterMethodsBeanPostProcessor implements BeanPostProcessor {
    Map<String, Class> originalBeansMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("Класс " + aClass.getSimpleName() + " содержит " + declaredMethods.length + " метод(ов) в postProcessBeforeInitialization");
        originalBeansMap.put(beanName, bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = originalBeansMap.get(beanName);
        if(beanClass!=null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("toString")) {
                        return new ObjectMapper().writeValueAsString(bean);
                    }
                    return method.invoke(bean,args);
                }
            });
        }
        return bean;
    }
}

package scopes;

import org.javers.common.collections.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

public class PeriodicalScopeConfigurer implements Scope {
    Map<String, Pair<LocalTime,Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Pair<LocalTime, Object> pair = map.get(name);
        if(pair!=null){
            int secondsSinceLastRequest = now().getSecond()-pair.left().getSecond();
            if(secondsSinceLastRequest>3){
                map.put(name,new Pair<>(now(),objectFactory.getObject()));
            }
        }
        else {
            map.put(name,new Pair<>(now(),objectFactory.getObject()));
        }
        return map.get(name).right();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

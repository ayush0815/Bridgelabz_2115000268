package Reflection;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class ServiceA {
    public void serve() {
        System.out.println("ServiceA is serving...");
    }
}

class Client {
    @Inject
    private ServiceA serviceA;

    public void doWork() {
        serviceA.serve();
    }
}

class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public DIContainer() {
       
        instances.put(ServiceA.class, new ServiceA());
    }

    public void injectDependencies(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                try {
                    field.set(object, instances.get(field.getType()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        Client client = new Client();
        DIContainer container = new DIContainer();
        container.injectDependencies(client);
        client.doWork();
    }
}
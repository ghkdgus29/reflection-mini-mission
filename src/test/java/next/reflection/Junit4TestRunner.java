package next.reflection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Junit4TestRunner {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;
        Object object = clazz.getDeclaredConstructor().newInstance();
        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                long startTime = System.currentTimeMillis();
                method.invoke(object);
                long endTime = System.currentTimeMillis();
                logger.debug("테스트 수행시간 = {}ms", endTime - startTime);
            }

        }
    }
}

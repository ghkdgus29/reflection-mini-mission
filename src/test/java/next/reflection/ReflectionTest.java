package next.reflection;

import next.optional.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;

        // 클래스의 모든 필드, 생성자, 메소드 정보를 출력
        logger.debug("class name = {}", clazz.getName());
        logger.debug("fields = {}", (Object) clazz.getDeclaredFields());
        logger.debug("constructor = {}", (Object) clazz.getConstructors());
        logger.debug("method = {}", (Object) clazz.getDeclaredMethods());
    }

    @Test
    @SuppressWarnings("rawtypes")
    public void constructor() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("paramer length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }

    @Test
    public void privateFieldAccess() throws NoSuchFieldException, IllegalAccessException {
        Class clazz = Student.class;
        Student student = new Student();

        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(student, "hyun");

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(student, 27);

        logger.debug("Student 객체 = {}", student);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            logger.debug("필드명 = {}, 필드값 = {}",field.getName(), field.get(student));
        }
    }


    @Test
    public void constructorHyun() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = User.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        User user = (User) constructor.newInstance("hyun", 27);

        logger.debug("{}", user);
    }

}

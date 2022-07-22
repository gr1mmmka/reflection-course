package exircise.di;

import static java.lang.String.format;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DependencyInjection {

  public static <T> T createObjectRecursively(Class<T> clazz)
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    Constructor<?> constructor = getFirstConstructor(clazz);
    List<Object> constructorArgs = new ArrayList<>();

    for (Class<?> argType : constructor.getParameterTypes()) {
      Object argValue = createObjectRecursively(argType);
      constructorArgs.add(argValue);
    }
    constructor.setAccessible(true);
    return (T) constructor.newInstance(constructorArgs.toArray());
  }

  private static Constructor<?> getFirstConstructor(Class<?> clazz) {
    Constructor<?>[] constructors = clazz.getDeclaredConstructors();
    if (constructors.length == 0) {
      throw new IllegalStateException(format("no constructor has been found for class %s", clazz.getName()));
    }
    return constructors[0];
  }
}

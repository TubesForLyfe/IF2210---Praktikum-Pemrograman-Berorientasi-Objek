import java.lang.reflect.*;
import java.util.*;

public class Injector {
  private HashMap<Class, Object> map = new HashMap<>();

  void addDependencies(Object object) {
      this.map.put(object.getClass(), object);
  }
  
  void inject(Object object) throws Exception {
      Field[] fields = object.getClass().getDeclaredFields();
      for (Field field : fields) {
          try {
              field.setAccessible(true);
              if (this.map.containsKey(field.getType())) {
                  Class<?> ft = field.getType();
                  field.set(object, ft.cast(this.map.get(ft)));
              }
          } catch (Exception e) {}
      }
  }
}
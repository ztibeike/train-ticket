package ustb.scce.microservice.zuul.cache;

import java.util.List;
import java.util.Map;


public interface ZuulMessageCache<T> {

    boolean set(String key, T o);

    boolean set(String key, T o, long timeout);

    T get(String key);

    Map<String, T> getByPattern(String pattern);

}

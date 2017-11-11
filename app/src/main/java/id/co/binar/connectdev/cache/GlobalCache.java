package id.co.binar.connectdev.cache;

/**
 * Created by rioswarawan on 6/11/17.
 */

public class GlobalCache {

    private static final String CACHE_NAME = GlobalCache.class.getName();

    private static CacheManager cacheManager;

    private static CacheManager getInstance() {
        if (cacheManager == null)
            cacheManager = new CacheManager(CACHE_NAME);
        return cacheManager;
    }

    public static synchronized <T> T read(String key, Class<T> tClass) {
        return getInstance().read(key, tClass);
    }

    public static synchronized <T> void write(String key, T value, Class<T> tClass) {
        getInstance().write(key, value, tClass);
    }

    public static synchronized void clear() {
        getInstance().clear();
    }
}

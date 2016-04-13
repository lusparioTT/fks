package org.nutz.plugins.cache.dao.api;

/**
 * 缓存序列化器, 实现类必须是线程安全的
 * @author wendal(wendal1985@gmail.com)
 *
 */
public interface CacheSerializer {
    
    /**
     * 如果对象无法序列化,返回null
     */
    Object from(Object obj);
    
    /**
     * 要求: 如果对象无法还原,返回null, 如果缓存的是null, 那么返回CacheResult.NULL
     */
    Object back(Object obj);

}

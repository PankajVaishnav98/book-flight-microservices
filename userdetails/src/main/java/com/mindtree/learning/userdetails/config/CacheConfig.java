//
//  package com.mindtree.learning.userdetails.config;
//  
//  import org.springframework.cache.CacheManager; import
//  org.springframework.cache.annotation.EnableCaching; import
//  org.springframework.cache.ehcache.EhCacheCacheManager; import
//  org.springframework.cache.jcache.config.JCacheConfigurerSupport; import
//  org.springframework.context.annotation.Bean; import
//  org.springframework.context.annotation.Configuration;
//  
//  import net.sf.ehcache.config.CacheConfiguration;
//  
//  @Configuration //-------------Using Configuration annotation, so to notify
//  spring that this will generate beans
//  
//  @EnableCaching //----------------Enabling caching public class CacheConfig
//  extends JCacheConfigurerSupport {
//  
//  @Bean public net.sf.ehcache.CacheManager ehCacheManager() {
//  //--------------making bean for ehcachemanager
//  
//  CacheConfiguration cache = new CacheConfiguration();
//  cache.setName("user-Id-cache"); //-------------setting the cache name
//  cache.setMemoryStoreEvictionPolicy("LRU"); //------------specifying the
//  Algorithim to be used cache.setMaxEntriesLocalHeap(1000);
//  //------------Setting maximum entries for this cache
//  cache.setTimeToLiveSeconds(20); //-----------Living time for cache in seconds
//  
//  net.sf.ehcache.config.Configuration config = new
//  net.sf.ehcache.config.Configuration(); config.addCache(cache); return
//  net.sf.ehcache.CacheManager.newInstance(config); }
//  
//  @Bean
//  
//  @Override public CacheManager cacheManager() { // Using spring cache manager
//  interface as return type for bean return new
//  EhCacheCacheManager(ehCacheManager()); // and returning the ehcache bean
//  created above }
//  
//  }
// 
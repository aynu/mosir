// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
/**
 * キャッシュサービス
 * @param <K> キー型
 * @param <V> バリュー型
 * @author nilcy
 */
public final class CacheService<K, V> {
    /** キャッシュマネージャ */
    private final CacheManager manager;
    /**
     * コンストラクタ
     */
    public CacheService() {
        manager = Caching.getCacheManager();
    }
    /**
     * コンストラクタ
     * @param area キャッシュエリア
     */
    public CacheService(final CacheArea area) {
        manager = Caching.getCacheManager(area.name().toLowerCase());
    }
    /**
     * キャッシュの取得
     * @param name キャッシュ名
     * @return キャッシュ
     */
    public Cache<K, V> getCache(final String name) {
        return manager.getCache(name);
    }
    /**
     * キャッシュの作成
     * @param name キャッシュ名
     * @return キャッシュ
     */
    public Cache<K, V> createCache(final String name) {
        return manager.<K, V> createCacheBuilder(name).build();
    }
}

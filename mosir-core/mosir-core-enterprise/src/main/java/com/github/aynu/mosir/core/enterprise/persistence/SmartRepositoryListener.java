// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 * 先進リポジトリリスナーI/F
 * @param <R> 基点エンティティ型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public interface SmartRepositoryListener<R extends Persistable, F> {
    /**
     * クエリーの作成
     * @param builder クライテリアビルダー
     * @param query クライテリアクエリー
     * @param root クエリールート
     * @param filter 検索条件オブジェクト
     * @return クエリー
     */
    CriteriaQuery<R> query(CriteriaBuilder builder, CriteriaQuery<R> query, Root<R> root, F filter);
}

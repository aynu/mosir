// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
/**
 * (基底)先進リポジトリリスナー
 * @param <R> 基点エンティティ型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public abstract class AbstractSmartRepositoryListener<R extends Persistable, F> implements
SmartRepositoryListener<R, F> {
    /**
     * ソート条件の作成
     * @param builder クライテリアビルダー
     * @param root クエリールート
     * @param filter 検索条件オブジェクト
     * @return クエリー
     */
    public final List<Order> createOrders(final CriteriaBuilder builder, final Root<R> root,
        final SortableFilter filter) {
        final List<Order> orders = new ArrayList<>();
        for (final String order : filter.getOrders()) {
            final String[] vars = order.split(" ");
            final Path<R> path = root.get(vars[0].toLowerCase());
            Order o;
            if ((vars.length < 2) || "asc".equals(vars[1].toLowerCase())) {
                o = builder.asc(path);
            } else {
                o = builder.desc(path);
            }
            orders.add(o);
        }
        return orders;
    }
}

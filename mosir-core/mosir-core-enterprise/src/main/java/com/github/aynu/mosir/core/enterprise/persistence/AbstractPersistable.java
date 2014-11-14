// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.aynu.mosir.core.standard.lang.AbstractDataObject;
import com.github.aynu.mosir.core.standard.lang.ReferenceObject;
/**
 * (永続可能)エンティティ
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>{@link ReferenceObject 参照オブジェクトI/F} と {@link Persistable 永続可能エンティティI/F} が実装されること。</li>
 * <li>前提としてJPAが永続化するために識別子(ID)が必要である。(IDによる同一性の確認ができる)</li>
 * <li>まず、参照オブジェクトを永続化するときは概念上の識別子と一致するため問題はない。</li>
 * <li>いっぽう、値オブジェクトを永続化するときは値による同一性の確認が一般的である。</li>
 * <li>(永続化する)値オブジェクトの識別子(ID)はJPA永続化に必要だが、アプリケーションが使用すべきものではない。</li>
 * <li>なお、永続管理の状態設定は {@link #setPersisted()} を参照すること。</li>
 * </ol>
 * </dl>
 * @param <P> 永続可能エンティティ型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractPersistable<P extends AbstractPersistable<P>> extends
AbstractDataObject<P> implements ReferenceObject<P>, Persistable {
    /** 識別番号 */
    private static final long serialVersionUID = 1365773187648802997L;
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractPersistable.class);
    /** 識別子(ID) */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    private BigDecimal id;
    /** 永続管理FG (TRUE:管理中,FALSE:未管理) */
    @Transient
    private boolean persisted;
    /** コンストラクタ */
    public AbstractPersistable() {
    }
    /**
     * {@link #id} の取得
     * @return {@link #id}
     */
    public final BigDecimal getId() {
        return id;
    }
    /**
     * {@link #id} の設定
     * @param id {@link #id}
     */
    public final void setId(final BigDecimal id) {
        this.id = id;
    }
    /** {@inheritDoc} */
    @Override
    public final BigDecimal identity() {
        return id;
    }
    /** {@inheritDoc} */
    @Override
    public final boolean isPersisted() {
        return persisted;
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>比較対象オブジェクトが非NULLかつ識別子(ID)が同一かチェックされること。
     * </dl>
     */
    @Override
    public final boolean sameIdentityAs(final P other) {
        return (other != null)
            && new EqualsBuilder().append(identity(), other.identity()).isEquals();
    }
    /**
     * {@link #persisted} の設定
     * <dl>
     * <dt>使用条件
     * <dd>
     * <ol>
     * <li>該当データのライフサイクルコールバック(以下)で、永続管理FGがTRUEに更新されること。</li>
     * <li>データ登録後(@PostPersist),データ更新後(@PostUpdate),データ取得後(@PostLoad)</li>
     * </ol>
     * </dl>
     */
    @PostPersist
    @PostUpdate
    @PostLoad
    private void setPersisted() {
        LOG.debug("persistend-flag is ON.");
        persisted = true;
    }
}

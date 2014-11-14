// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
/**
 * 版管理エンティティ
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>{@link Versionable 版管理エンティティI/F} が実装されること。</li>
 * <li>版数をもとにJPAの楽観ロックが実装されること。</li>
 * <li>楽観ロックとは検索時の版数を更新時の条件として版数を加算することで、更新件数で他者の更新がないかを確認する。</li>
 * <li>他者の更新を検出したとき {@link javax.persistence.OptimisticLockException} が返却されること。</li>
 * </ol>
 * </dl>
 * @param <VE> 版管理エンティティ型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractVersionable<VE extends AbstractVersionable<VE>> extends
AbstractPersistable<VE> implements Versionable {
    /** 識別番号 */
    private static final long serialVersionUID = 3662224470361465232L;
    /** 版数 */
    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    private Long version;
    /** コンストラクタ */
    public AbstractVersionable() {
    }
    /**
     * {@link #version} の取得
     * @return {@link #version}
     */
    @Override
    public final Long getVersion() {
        return this.version;
    }
    /**
     * {@link #version} の設定
     * @param version {@link #version}
     */
    @Override
    public final void setVersion(final Long version) {
        this.version = version;
    }
}

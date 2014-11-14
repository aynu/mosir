// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * テストエンティティ
 * @author nilcy
 */
@Entity
@Table(name = "Testee", indexes = { @Index(columnList = "code"), @Index(columnList = "name") }, uniqueConstraints = {
    @UniqueConstraint(columnNames = { "code" }), @UniqueConstraint(columnNames = { "name" }) })
public class Testee extends AbstractPersistable<Testee> {
    /** 識別番号 */
    private static final long serialVersionUID = 4506075597459118931L;
    /** コード */
    @Column(name = "code", nullable = false, insertable = true, updatable = true)
    private String code;
    /** なまえ */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** コンストラクタ */
    public Testee() {
    }
    /**
     * コンストラクタ
     * @param code {@link #code コード}
     * @param name {@link #name なまえ}
     */
    public Testee(final String code, final String name) {
        this.code = code;
        this.name = name;
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public String getCode() {
        return code;
    }
    /**
     * {@link #code} の設定
     * @param code {@link #code}
     */
    public void setCode(final String code) {
        this.code = code;
    }
    /**
     * {@link #name} の取得
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }
    /**
     * {@link #name} の設定
     * @param name {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }
}

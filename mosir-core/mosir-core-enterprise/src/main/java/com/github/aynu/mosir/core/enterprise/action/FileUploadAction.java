// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.action;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
/**
 * ファイル送信アクション
 * <dl>
 * <dt>使用条件
 * <dd>コンポーネント名は"fileUploadAction"。コンテキストは会話スコープ。
 * </dl>
 * @author nilcy
 */
@Named
@ConversationScoped
public class FileUploadAction implements Action {
    /** クラス識別番号 */
    private static final long serialVersionUID = -3633583333612278789L;
    /** 送信ファイル */
    private Part file;
    /** コンストラクタ */
    public FileUploadAction() {
    }
    /**
     * {@link #file} の取得
     * @return {@link #file}
     */
    public Part getFile() {
        return file;
    }
    /**
     * {@link #file} の設定
     * @param file {@link #file}
     */
    public void setFile(final Part file) {
        this.file = file;
    }
}

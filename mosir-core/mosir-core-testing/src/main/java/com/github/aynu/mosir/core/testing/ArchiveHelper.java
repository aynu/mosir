// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import java.util.Iterator;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePath;
/**
 * アーカイブヘルパー
 * <dl>
 * <dt>使用条件
 * <dd>インテグレーションテスト(Arquillian)のアーカイブ操作に使用すること。
 * </dl>
 * @author nilcy
 */
public final class ArchiveHelper {
    /** 非公開コンストラクタ */
    private ArchiveHelper() {
    }
    /**
     * アーカイブのトレース
     * <dl>
     * <dt>使用条件
     * <dd>アーカイブ中のパスをログ出力するために使用すること。
     * </dl>
     * @param archive アーカイブ
     * @return アーカイブ中のパス
     */
    public static String trace(final Archive<?> archive) {
        final Iterator<ArchivePath> iter = archive.getContent().keySet().iterator();
        final StringBuilder builder = new StringBuilder();
        while (iter.hasNext()) {
            final ArchivePath path = iter.next();
            builder.append(String.format("%s\n", path.get()));
        }
        return builder.toString();
    }
}

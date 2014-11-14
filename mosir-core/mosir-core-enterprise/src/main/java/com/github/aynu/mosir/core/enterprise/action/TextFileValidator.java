// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.action;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
/**
 * テキストファイル検証
 * <dl>
 * <dt>使用条件
 * <dd>コンポーネント名は"TextFileValidator"。
 * </dl>
 * @see #validate(FacesContext, UIComponent, Object)
 * @author nilcy
 */
@FacesValidator(value = "TextFileValidator")
public class TextFileValidator implements Validator {
    /** コンストラクタ */
    public TextFileValidator() {
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>受信ファイル中にテキスト値がないとき検証例外を発出する。
     * </dl>
     */
    @Override
    public void validate(final FacesContext context, final UIComponent component, final Object value) {
        try (final InputStream is = ((Part) value).getInputStream();) {
            new Scanner(is).useDelimiter("\\A").next();
        } catch (final IOException | NoSuchElementException | IllegalStateException e) {
            throw new ValidatorException(new FacesMessage("Invalid file"), e);
        }
    }
}

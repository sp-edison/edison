/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.multiboard.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the BoardDiv service. Represents a row in the &quot;EDCON_BoardDiv&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.multiboard.model.impl.BoardDivImpl}.
 * </p>
 *
 * @author mhkang
 * @see BoardDiv
 * @see org.kisti.edison.multiboard.model.impl.BoardDivImpl
 * @see org.kisti.edison.multiboard.model.impl.BoardDivModelImpl
 * @generated
 */
public interface BoardDivModel extends BaseModel<BoardDiv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a board div model instance should use the {@link BoardDiv} interface instead.
	 */

	/**
	 * Returns the primary key of this board div.
	 *
	 * @return the primary key of this board div
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this board div.
	 *
	 * @param primaryKey the primary key of this board div
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the div cd of this board div.
	 *
	 * @return the div cd of this board div
	 */
	public long getDivCd();

	/**
	 * Sets the div cd of this board div.
	 *
	 * @param divCd the div cd of this board div
	 */
	public void setDivCd(long divCd);

	/**
	 * Returns the title nm of this board div.
	 *
	 * @return the title nm of this board div
	 */
	public String getTitleNm();

	/**
	 * Returns the localized title nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title nm of this board div
	 */
	@AutoEscape
	public String getTitleNm(Locale locale);

	/**
	 * Returns the localized title nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title nm of this board div. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitleNm(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title nm of this board div
	 */
	@AutoEscape
	public String getTitleNm(String languageId);

	/**
	 * Returns the localized title nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title nm of this board div
	 */
	@AutoEscape
	public String getTitleNm(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleNmCurrentLanguageId();

	@AutoEscape
	public String getTitleNmCurrentValue();

	/**
	 * Returns a map of the locales and localized title nms of this board div.
	 *
	 * @return the locales and localized title nms of this board div
	 */
	public Map<Locale, String> getTitleNmMap();

	/**
	 * Sets the title nm of this board div.
	 *
	 * @param titleNm the title nm of this board div
	 */
	public void setTitleNm(String titleNm);

	/**
	 * Sets the localized title nm of this board div in the language.
	 *
	 * @param titleNm the localized title nm of this board div
	 * @param locale the locale of the language
	 */
	public void setTitleNm(String titleNm, Locale locale);

	/**
	 * Sets the localized title nm of this board div in the language, and sets the default locale.
	 *
	 * @param titleNm the localized title nm of this board div
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitleNm(String titleNm, Locale locale, Locale defaultLocale);

	public void setTitleNmCurrentLanguageId(String languageId);

	/**
	 * Sets the localized title nms of this board div from the map of locales and localized title nms.
	 *
	 * @param titleNmMap the locales and localized title nms of this board div
	 */
	public void setTitleNmMap(Map<Locale, String> titleNmMap);

	/**
	 * Sets the localized title nms of this board div from the map of locales and localized title nms, and sets the default locale.
	 *
	 * @param titleNmMap the locales and localized title nms of this board div
	 * @param defaultLocale the default locale
	 */
	public void setTitleNmMap(Map<Locale, String> titleNmMap,
		Locale defaultLocale);

	/**
	 * Returns the content nm of this board div.
	 *
	 * @return the content nm of this board div
	 */
	public String getContentNm();

	/**
	 * Returns the localized content nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized content nm of this board div
	 */
	@AutoEscape
	public String getContentNm(Locale locale);

	/**
	 * Returns the localized content nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content nm of this board div. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getContentNm(Locale locale, boolean useDefault);

	/**
	 * Returns the localized content nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized content nm of this board div
	 */
	@AutoEscape
	public String getContentNm(String languageId);

	/**
	 * Returns the localized content nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content nm of this board div
	 */
	@AutoEscape
	public String getContentNm(String languageId, boolean useDefault);

	@AutoEscape
	public String getContentNmCurrentLanguageId();

	@AutoEscape
	public String getContentNmCurrentValue();

	/**
	 * Returns a map of the locales and localized content nms of this board div.
	 *
	 * @return the locales and localized content nms of this board div
	 */
	public Map<Locale, String> getContentNmMap();

	/**
	 * Sets the content nm of this board div.
	 *
	 * @param ContentNm the content nm of this board div
	 */
	public void setContentNm(String ContentNm);

	/**
	 * Sets the localized content nm of this board div in the language.
	 *
	 * @param ContentNm the localized content nm of this board div
	 * @param locale the locale of the language
	 */
	public void setContentNm(String ContentNm, Locale locale);

	/**
	 * Sets the localized content nm of this board div in the language, and sets the default locale.
	 *
	 * @param ContentNm the localized content nm of this board div
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setContentNm(String ContentNm, Locale locale,
		Locale defaultLocale);

	public void setContentNmCurrentLanguageId(String languageId);

	/**
	 * Sets the localized content nms of this board div from the map of locales and localized content nms.
	 *
	 * @param ContentNmMap the locales and localized content nms of this board div
	 */
	public void setContentNmMap(Map<Locale, String> ContentNmMap);

	/**
	 * Sets the localized content nms of this board div from the map of locales and localized content nms, and sets the default locale.
	 *
	 * @param ContentNmMap the locales and localized content nms of this board div
	 * @param defaultLocale the default locale
	 */
	public void setContentNmMap(Map<Locale, String> ContentNmMap,
		Locale defaultLocale);

	/**
	 * Returns the div nm of this board div.
	 *
	 * @return the div nm of this board div
	 */
	@AutoEscape
	public String getDivNm();

	/**
	 * Sets the div nm of this board div.
	 *
	 * @param divNm the div nm of this board div
	 */
	public void setDivNm(String divNm);

	/**
	 * Returns the file up load use yn of this board div.
	 *
	 * @return the file up load use yn of this board div
	 */
	public boolean getFileUpLoadUseYn();

	/**
	 * Returns <code>true</code> if this board div is file up load use yn.
	 *
	 * @return <code>true</code> if this board div is file up load use yn; <code>false</code> otherwise
	 */
	public boolean isFileUpLoadUseYn();

	/**
	 * Sets whether this board div is file up load use yn.
	 *
	 * @param fileUpLoadUseYn the file up load use yn of this board div
	 */
	public void setFileUpLoadUseYn(boolean fileUpLoadUseYn);

	/**
	 * Returns the popup yn of this board div.
	 *
	 * @return the popup yn of this board div
	 */
	public boolean getPopupYn();

	/**
	 * Returns <code>true</code> if this board div is popup yn.
	 *
	 * @return <code>true</code> if this board div is popup yn; <code>false</code> otherwise
	 */
	public boolean isPopupYn();

	/**
	 * Sets whether this board div is popup yn.
	 *
	 * @param popupYn the popup yn of this board div
	 */
	public void setPopupYn(boolean popupYn);

	/**
	 * Returns the reply yn of this board div.
	 *
	 * @return the reply yn of this board div
	 */
	public boolean getReplyYn();

	/**
	 * Returns <code>true</code> if this board div is reply yn.
	 *
	 * @return <code>true</code> if this board div is reply yn; <code>false</code> otherwise
	 */
	public boolean isReplyYn();

	/**
	 * Sets whether this board div is reply yn.
	 *
	 * @param replyYn the reply yn of this board div
	 */
	public void setReplyYn(boolean replyYn);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(org.kisti.edison.multiboard.model.BoardDiv boardDiv);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.multiboard.model.BoardDiv> toCacheModel();

	@Override
	public org.kisti.edison.multiboard.model.BoardDiv toEscapedModel();

	@Override
	public org.kisti.edison.multiboard.model.BoardDiv toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
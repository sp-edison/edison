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

package org.kisti.edison.virtuallaboratory.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the VirtualLabClass service. Represents a row in the &quot;EDVIR_VirtualLabClass&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClass
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl
 * @generated
 */
public interface VirtualLabClassModel extends BaseModel<VirtualLabClass> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a virtual lab class model instance should use the {@link VirtualLabClass} interface instead.
	 */

	/**
	 * Returns the primary key of this virtual lab class.
	 *
	 * @return the primary key of this virtual lab class
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this virtual lab class.
	 *
	 * @param primaryKey the primary key of this virtual lab class
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the class ID of this virtual lab class.
	 *
	 * @return the class ID of this virtual lab class
	 */
	public long getClassId();

	/**
	 * Sets the class ID of this virtual lab class.
	 *
	 * @param classId the class ID of this virtual lab class
	 */
	public void setClassId(long classId);

	/**
	 * Returns the class title of this virtual lab class.
	 *
	 * @return the class title of this virtual lab class
	 */
	public String getClassTitle();

	/**
	 * Returns the localized class title of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized class title of this virtual lab class
	 */
	@AutoEscape
	public String getClassTitle(Locale locale);

	/**
	 * Returns the localized class title of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class title of this virtual lab class. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getClassTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized class title of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized class title of this virtual lab class
	 */
	@AutoEscape
	public String getClassTitle(String languageId);

	/**
	 * Returns the localized class title of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class title of this virtual lab class
	 */
	@AutoEscape
	public String getClassTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getClassTitleCurrentLanguageId();

	@AutoEscape
	public String getClassTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized class titles of this virtual lab class.
	 *
	 * @return the locales and localized class titles of this virtual lab class
	 */
	public Map<Locale, String> getClassTitleMap();

	/**
	 * Sets the class title of this virtual lab class.
	 *
	 * @param classTitle the class title of this virtual lab class
	 */
	public void setClassTitle(String classTitle);

	/**
	 * Sets the localized class title of this virtual lab class in the language.
	 *
	 * @param classTitle the localized class title of this virtual lab class
	 * @param locale the locale of the language
	 */
	public void setClassTitle(String classTitle, Locale locale);

	/**
	 * Sets the localized class title of this virtual lab class in the language, and sets the default locale.
	 *
	 * @param classTitle the localized class title of this virtual lab class
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setClassTitle(String classTitle, Locale locale,
		Locale defaultLocale);

	public void setClassTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized class titles of this virtual lab class from the map of locales and localized class titles.
	 *
	 * @param classTitleMap the locales and localized class titles of this virtual lab class
	 */
	public void setClassTitleMap(Map<Locale, String> classTitleMap);

	/**
	 * Sets the localized class titles of this virtual lab class from the map of locales and localized class titles, and sets the default locale.
	 *
	 * @param classTitleMap the locales and localized class titles of this virtual lab class
	 * @param defaultLocale the default locale
	 */
	public void setClassTitleMap(Map<Locale, String> classTitleMap,
		Locale defaultLocale);

	/**
	 * Returns the class start dt of this virtual lab class.
	 *
	 * @return the class start dt of this virtual lab class
	 */
	@AutoEscape
	public String getClassStartDt();

	/**
	 * Sets the class start dt of this virtual lab class.
	 *
	 * @param classStartDt the class start dt of this virtual lab class
	 */
	public void setClassStartDt(String classStartDt);

	/**
	 * Returns the class end dt of this virtual lab class.
	 *
	 * @return the class end dt of this virtual lab class
	 */
	@AutoEscape
	public String getClassEndDt();

	/**
	 * Sets the class end dt of this virtual lab class.
	 *
	 * @param classEndDt the class end dt of this virtual lab class
	 */
	public void setClassEndDt(String classEndDt);

	/**
	 * Returns the class use yn of this virtual lab class.
	 *
	 * @return the class use yn of this virtual lab class
	 */
	@AutoEscape
	public String getClassUseYn();

	/**
	 * Sets the class use yn of this virtual lab class.
	 *
	 * @param classUseYn the class use yn of this virtual lab class
	 */
	public void setClassUseYn(String classUseYn);

	/**
	 * Returns the class description of this virtual lab class.
	 *
	 * @return the class description of this virtual lab class
	 */
	public String getClassDescription();

	/**
	 * Returns the localized class description of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized class description of this virtual lab class
	 */
	@AutoEscape
	public String getClassDescription(Locale locale);

	/**
	 * Returns the localized class description of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class description of this virtual lab class. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getClassDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized class description of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized class description of this virtual lab class
	 */
	@AutoEscape
	public String getClassDescription(String languageId);

	/**
	 * Returns the localized class description of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class description of this virtual lab class
	 */
	@AutoEscape
	public String getClassDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getClassDescriptionCurrentLanguageId();

	@AutoEscape
	public String getClassDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized class descriptions of this virtual lab class.
	 *
	 * @return the locales and localized class descriptions of this virtual lab class
	 */
	public Map<Locale, String> getClassDescriptionMap();

	/**
	 * Sets the class description of this virtual lab class.
	 *
	 * @param classDescription the class description of this virtual lab class
	 */
	public void setClassDescription(String classDescription);

	/**
	 * Sets the localized class description of this virtual lab class in the language.
	 *
	 * @param classDescription the localized class description of this virtual lab class
	 * @param locale the locale of the language
	 */
	public void setClassDescription(String classDescription, Locale locale);

	/**
	 * Sets the localized class description of this virtual lab class in the language, and sets the default locale.
	 *
	 * @param classDescription the localized class description of this virtual lab class
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setClassDescription(String classDescription, Locale locale,
		Locale defaultLocale);

	public void setClassDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized class descriptions of this virtual lab class from the map of locales and localized class descriptions.
	 *
	 * @param classDescriptionMap the locales and localized class descriptions of this virtual lab class
	 */
	public void setClassDescriptionMap(Map<Locale, String> classDescriptionMap);

	/**
	 * Sets the localized class descriptions of this virtual lab class from the map of locales and localized class descriptions, and sets the default locale.
	 *
	 * @param classDescriptionMap the locales and localized class descriptions of this virtual lab class
	 * @param defaultLocale the default locale
	 */
	public void setClassDescriptionMap(
		Map<Locale, String> classDescriptionMap, Locale defaultLocale);

	/**
	 * Returns the class personnel of this virtual lab class.
	 *
	 * @return the class personnel of this virtual lab class
	 */
	public int getClassPersonnel();

	/**
	 * Sets the class personnel of this virtual lab class.
	 *
	 * @param classPersonnel the class personnel of this virtual lab class
	 */
	public void setClassPersonnel(int classPersonnel);

	/**
	 * Returns the class create dt of this virtual lab class.
	 *
	 * @return the class create dt of this virtual lab class
	 */
	public Date getClassCreateDt();

	/**
	 * Sets the class create dt of this virtual lab class.
	 *
	 * @param classCreateDt the class create dt of this virtual lab class
	 */
	public void setClassCreateDt(Date classCreateDt);

	/**
	 * Returns the class update dt of this virtual lab class.
	 *
	 * @return the class update dt of this virtual lab class
	 */
	public Date getClassUpdateDt();

	/**
	 * Sets the class update dt of this virtual lab class.
	 *
	 * @param classUpdateDt the class update dt of this virtual lab class
	 */
	public void setClassUpdateDt(Date classUpdateDt);

	/**
	 * Returns the virtual class cd of this virtual lab class.
	 *
	 * @return the virtual class cd of this virtual lab class
	 */
	@AutoEscape
	public String getVirtualClassCd();

	/**
	 * Sets the virtual class cd of this virtual lab class.
	 *
	 * @param virtualClassCd the virtual class cd of this virtual lab class
	 */
	public void setVirtualClassCd(String virtualClassCd);

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
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> toCacheModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass toEscapedModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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

package org.kisti.edison.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.WorkflowModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the Workflow service. Represents a row in the &quot;EDWF_Workflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.model.WorkflowModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowImpl}.
 * </p>
 *
 * @author EDISON
 * @see WorkflowImpl
 * @see org.kisti.edison.model.Workflow
 * @see org.kisti.edison.model.WorkflowModel
 * @generated
 */
public class WorkflowModelImpl extends BaseModelImpl<Workflow>
	implements WorkflowModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow model instance should use the {@link org.kisti.edison.model.Workflow} interface instead.
	 */
	public static final String TABLE_NAME = "EDWF_Workflow";
	public static final Object[][] TABLE_COLUMNS = {
			{ "workflowId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "isPublic", Types.BOOLEAN },
			{ "parentWorkflowId", Types.BIGINT },
			{ "screenLogic", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table EDWF_Workflow (workflowId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,title STRING null,description STRING null,isPublic BOOLEAN,parentWorkflowId LONG,screenLogic TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table EDWF_Workflow";
	public static final String ORDER_BY_JPQL = " ORDER BY workflow.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EDWF_Workflow.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.model.Workflow"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.model.Workflow"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.model.Workflow"),
			true);
	public static long ISPUBLIC_COLUMN_BITMASK = 1L;
	public static long TITLE_COLUMN_BITMASK = 2L;
	public static long CREATEDATE_COLUMN_BITMASK = 4L;
	public static final String MAPPING_TABLE_EDWF_WORKFLOW_WORKFLOWINSTANCE_NAME =
		"EDWF_Workflow_WorkflowInstance";
	public static final Object[][] MAPPING_TABLE_EDWF_WORKFLOW_WORKFLOWINSTANCE_COLUMNS =
		{
			{ "workflowId", Types.BIGINT },
			{ "workflowInstanceId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_EDWF_WORKFLOW_WORKFLOWINSTANCE_SQL_CREATE =
		"create table EDWF_Workflow_WorkflowInstance (workflowId LONG not null,workflowInstanceId LONG not null,primary key (workflowId, workflowInstanceId))";
	public static final boolean FINDER_CACHE_ENABLED_EDWF_WORKFLOW_WORKFLOWINSTANCE =
		GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.EDWF_Workflow_WorkflowInstance"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.model.Workflow"));

	public WorkflowModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workflowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Workflow.class;
	}

	@Override
	public String getModelClassName() {
		return Workflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowId", getWorkflowId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("isPublic", getIsPublic());
		attributes.put("parentWorkflowId", getParentWorkflowId());
		attributes.put("screenLogic", getScreenLogic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Long parentWorkflowId = (Long)attributes.get("parentWorkflowId");

		if (parentWorkflowId != null) {
			setParentWorkflowId(parentWorkflowId);
		}

		String screenLogic = (String)attributes.get("screenLogic");

		if (screenLogic != null) {
			setScreenLogic(screenLogic);
		}
	}

	@Override
	public long getWorkflowId() {
		return _workflowId;
	}

	@Override
	public void setWorkflowId(long workflowId) {
		_workflowId = workflowId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		setDescription(LocalizationUtil.updateLocalization(descriptionMap,
				getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public boolean getIsPublic() {
		return _isPublic;
	}

	@Override
	public boolean isIsPublic() {
		return _isPublic;
	}

	@Override
	public void setIsPublic(boolean isPublic) {
		_columnBitmask |= ISPUBLIC_COLUMN_BITMASK;

		if (!_setOriginalIsPublic) {
			_setOriginalIsPublic = true;

			_originalIsPublic = _isPublic;
		}

		_isPublic = isPublic;
	}

	public boolean getOriginalIsPublic() {
		return _originalIsPublic;
	}

	@Override
	public long getParentWorkflowId() {
		return _parentWorkflowId;
	}

	@Override
	public void setParentWorkflowId(long parentWorkflowId) {
		_parentWorkflowId = parentWorkflowId;
	}

	@Override
	public String getScreenLogic() {
		if (_screenLogic == null) {
			return StringPool.BLANK;
		}
		else {
			return _screenLogic;
		}
	}

	@Override
	public void setScreenLogic(String screenLogic) {
		_screenLogic = screenLogic;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Workflow.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Workflow toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Workflow)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkflowImpl workflowImpl = new WorkflowImpl();

		workflowImpl.setWorkflowId(getWorkflowId());
		workflowImpl.setCompanyId(getCompanyId());
		workflowImpl.setUserId(getUserId());
		workflowImpl.setCreateDate(getCreateDate());
		workflowImpl.setModifiedDate(getModifiedDate());
		workflowImpl.setTitle(getTitle());
		workflowImpl.setDescription(getDescription());
		workflowImpl.setIsPublic(getIsPublic());
		workflowImpl.setParentWorkflowId(getParentWorkflowId());
		workflowImpl.setScreenLogic(getScreenLogic());

		workflowImpl.resetOriginalValues();

		return workflowImpl;
	}

	@Override
	public int compareTo(Workflow workflow) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), workflow.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Workflow)) {
			return false;
		}

		Workflow workflow = (Workflow)obj;

		long primaryKey = workflow.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		WorkflowModelImpl workflowModelImpl = this;

		workflowModelImpl._originalTitle = workflowModelImpl._title;

		workflowModelImpl._originalIsPublic = workflowModelImpl._isPublic;

		workflowModelImpl._setOriginalIsPublic = false;

		workflowModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Workflow> toCacheModel() {
		WorkflowCacheModel workflowCacheModel = new WorkflowCacheModel();

		workflowCacheModel.workflowId = getWorkflowId();

		workflowCacheModel.companyId = getCompanyId();

		workflowCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			workflowCacheModel.createDate = createDate.getTime();
		}
		else {
			workflowCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			workflowCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			workflowCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		workflowCacheModel.title = getTitle();

		String title = workflowCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			workflowCacheModel.title = null;
		}

		workflowCacheModel.description = getDescription();

		String description = workflowCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			workflowCacheModel.description = null;
		}

		workflowCacheModel.isPublic = getIsPublic();

		workflowCacheModel.parentWorkflowId = getParentWorkflowId();

		workflowCacheModel.screenLogic = getScreenLogic();

		String screenLogic = workflowCacheModel.screenLogic;

		if ((screenLogic != null) && (screenLogic.length() == 0)) {
			workflowCacheModel.screenLogic = null;
		}

		return workflowCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{workflowId=");
		sb.append(getWorkflowId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isPublic=");
		sb.append(getIsPublic());
		sb.append(", parentWorkflowId=");
		sb.append(getParentWorkflowId());
		sb.append(", screenLogic=");
		sb.append(getScreenLogic());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.model.Workflow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublic</column-name><column-value><![CDATA[");
		sb.append(getIsPublic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getParentWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenLogic</column-name><column-value><![CDATA[");
		sb.append(getScreenLogic());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Workflow.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Workflow.class
		};
	private long _workflowId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _originalTitle;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private boolean _isPublic;
	private boolean _originalIsPublic;
	private boolean _setOriginalIsPublic;
	private long _parentWorkflowId;
	private String _screenLogic;
	private long _columnBitmask;
	private Workflow _escapedModel;
}
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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTempModel;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTempSoap;
import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VirtualLabUserTemp service. Represents a row in the &quot;EDVIR_VirtualLabUserTemp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.virtuallaboratory.model.VirtualLabUserTempModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VirtualLabUserTempImpl}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTempImpl
 * @see org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp
 * @see org.kisti.edison.virtuallaboratory.model.VirtualLabUserTempModel
 * @generated
 */
@JSON(strict = true)
public class VirtualLabUserTempModelImpl extends BaseModelImpl<VirtualLabUserTemp>
	implements VirtualLabUserTempModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a virtual lab user temp model instance should use the {@link org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp} interface instead.
	 */
	public static final String TABLE_NAME = "EDVIR_VirtualLabUserTemp";
	public static final Object[][] TABLE_COLUMNS = {
			{ "seqNo", Types.BIGINT },
			{ "virtualLabId", Types.BIGINT },
			{ "classId", Types.BIGINT },
			{ "userStudentNumber", Types.VARCHAR },
			{ "userName", Types.VARCHAR },
			{ "status", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table EDVIR_VirtualLabUserTemp (seqNo LONG not null,virtualLabId LONG not null,classId LONG not null,userStudentNumber VARCHAR(75) null,userName VARCHAR(75) null,status BOOLEAN,primary key (seqNo, virtualLabId, classId))";
	public static final String TABLE_SQL_DROP = "drop table EDVIR_VirtualLabUserTemp";
	public static final String ORDER_BY_JPQL = " ORDER BY virtualLabUserTemp.userName DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EDVIR_VirtualLabUserTemp.userName DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp"),
			true);
	public static long CLASSID_COLUMN_BITMASK = 1L;
	public static long VIRTUALLABID_COLUMN_BITMASK = 2L;
	public static long USERNAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VirtualLabUserTemp toModel(VirtualLabUserTempSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VirtualLabUserTemp model = new VirtualLabUserTempImpl();

		model.setSeqNo(soapModel.getSeqNo());
		model.setVirtualLabId(soapModel.getVirtualLabId());
		model.setClassId(soapModel.getClassId());
		model.setUserStudentNumber(soapModel.getUserStudentNumber());
		model.setUserName(soapModel.getUserName());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VirtualLabUserTemp> toModels(
		VirtualLabUserTempSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VirtualLabUserTemp> models = new ArrayList<VirtualLabUserTemp>(soapModels.length);

		for (VirtualLabUserTempSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp"));

	public VirtualLabUserTempModelImpl() {
	}

	@Override
	public VirtualLabUserTempPK getPrimaryKey() {
		return new VirtualLabUserTempPK(_seqNo, _virtualLabId, _classId);
	}

	@Override
	public void setPrimaryKey(VirtualLabUserTempPK primaryKey) {
		setSeqNo(primaryKey.seqNo);
		setVirtualLabId(primaryKey.virtualLabId);
		setClassId(primaryKey.classId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VirtualLabUserTempPK(_seqNo, _virtualLabId, _classId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VirtualLabUserTempPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLabUserTemp.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLabUserTemp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seqNo", getSeqNo());
		attributes.put("virtualLabId", getVirtualLabId());
		attributes.put("classId", getClassId());
		attributes.put("userStudentNumber", getUserStudentNumber());
		attributes.put("userName", getUserName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long virtualLabId = (Long)attributes.get("virtualLabId");

		if (virtualLabId != null) {
			setVirtualLabId(virtualLabId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String userStudentNumber = (String)attributes.get("userStudentNumber");

		if (userStudentNumber != null) {
			setUserStudentNumber(userStudentNumber);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;
	}

	@JSON
	@Override
	public long getVirtualLabId() {
		return _virtualLabId;
	}

	@Override
	public void setVirtualLabId(long virtualLabId) {
		_columnBitmask |= VIRTUALLABID_COLUMN_BITMASK;

		if (!_setOriginalVirtualLabId) {
			_setOriginalVirtualLabId = true;

			_originalVirtualLabId = _virtualLabId;
		}

		_virtualLabId = virtualLabId;
	}

	public long getOriginalVirtualLabId() {
		return _originalVirtualLabId;
	}

	@JSON
	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_columnBitmask |= CLASSID_COLUMN_BITMASK;

		if (!_setOriginalClassId) {
			_setOriginalClassId = true;

			_originalClassId = _classId;
		}

		_classId = classId;
	}

	public long getOriginalClassId() {
		return _originalClassId;
	}

	@JSON
	@Override
	public String getUserStudentNumber() {
		if (_userStudentNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _userStudentNumber;
		}
	}

	@Override
	public void setUserStudentNumber(String userStudentNumber) {
		_userStudentNumber = userStudentNumber;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_columnBitmask = -1L;

		_userName = userName;
	}

	@JSON
	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public VirtualLabUserTemp toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VirtualLabUserTemp)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VirtualLabUserTempImpl virtualLabUserTempImpl = new VirtualLabUserTempImpl();

		virtualLabUserTempImpl.setSeqNo(getSeqNo());
		virtualLabUserTempImpl.setVirtualLabId(getVirtualLabId());
		virtualLabUserTempImpl.setClassId(getClassId());
		virtualLabUserTempImpl.setUserStudentNumber(getUserStudentNumber());
		virtualLabUserTempImpl.setUserName(getUserName());
		virtualLabUserTempImpl.setStatus(getStatus());

		virtualLabUserTempImpl.resetOriginalValues();

		return virtualLabUserTempImpl;
	}

	@Override
	public int compareTo(VirtualLabUserTemp virtualLabUserTemp) {
		int value = 0;

		value = getUserName().compareTo(virtualLabUserTemp.getUserName());

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

		if (!(obj instanceof VirtualLabUserTemp)) {
			return false;
		}

		VirtualLabUserTemp virtualLabUserTemp = (VirtualLabUserTemp)obj;

		VirtualLabUserTempPK primaryKey = virtualLabUserTemp.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		VirtualLabUserTempModelImpl virtualLabUserTempModelImpl = this;

		virtualLabUserTempModelImpl._originalVirtualLabId = virtualLabUserTempModelImpl._virtualLabId;

		virtualLabUserTempModelImpl._setOriginalVirtualLabId = false;

		virtualLabUserTempModelImpl._originalClassId = virtualLabUserTempModelImpl._classId;

		virtualLabUserTempModelImpl._setOriginalClassId = false;

		virtualLabUserTempModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VirtualLabUserTemp> toCacheModel() {
		VirtualLabUserTempCacheModel virtualLabUserTempCacheModel = new VirtualLabUserTempCacheModel();

		virtualLabUserTempCacheModel.seqNo = getSeqNo();

		virtualLabUserTempCacheModel.virtualLabId = getVirtualLabId();

		virtualLabUserTempCacheModel.classId = getClassId();

		virtualLabUserTempCacheModel.userStudentNumber = getUserStudentNumber();

		String userStudentNumber = virtualLabUserTempCacheModel.userStudentNumber;

		if ((userStudentNumber != null) && (userStudentNumber.length() == 0)) {
			virtualLabUserTempCacheModel.userStudentNumber = null;
		}

		virtualLabUserTempCacheModel.userName = getUserName();

		String userName = virtualLabUserTempCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			virtualLabUserTempCacheModel.userName = null;
		}

		virtualLabUserTempCacheModel.status = getStatus();

		return virtualLabUserTempCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{seqNo=");
		sb.append(getSeqNo());
		sb.append(", virtualLabId=");
		sb.append(getVirtualLabId());
		sb.append(", classId=");
		sb.append(getClassId());
		sb.append(", userStudentNumber=");
		sb.append(getUserStudentNumber());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabId</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userStudentNumber</column-name><column-value><![CDATA[");
		sb.append(getUserStudentNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VirtualLabUserTemp.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VirtualLabUserTemp.class
		};
	private long _seqNo;
	private long _virtualLabId;
	private long _originalVirtualLabId;
	private boolean _setOriginalVirtualLabId;
	private long _classId;
	private long _originalClassId;
	private boolean _setOriginalClassId;
	private String _userStudentNumber;
	private String _userName;
	private boolean _status;
	private long _columnBitmask;
	private VirtualLabUserTemp _escapedModel;
}
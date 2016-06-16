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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK;

import java.io.Serializable;

/**
 * The base model interface for the VirtualLabUserTemp service. Represents a row in the &quot;EDVIR_VirtualLabUserTemp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempImpl}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTemp
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempImpl
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl
 * @generated
 */
public interface VirtualLabUserTempModel extends BaseModel<VirtualLabUserTemp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a virtual lab user temp model instance should use the {@link VirtualLabUserTemp} interface instead.
	 */

	/**
	 * Returns the primary key of this virtual lab user temp.
	 *
	 * @return the primary key of this virtual lab user temp
	 */
	public VirtualLabUserTempPK getPrimaryKey();

	/**
	 * Sets the primary key of this virtual lab user temp.
	 *
	 * @param primaryKey the primary key of this virtual lab user temp
	 */
	public void setPrimaryKey(VirtualLabUserTempPK primaryKey);

	/**
	 * Returns the seq no of this virtual lab user temp.
	 *
	 * @return the seq no of this virtual lab user temp
	 */
	public long getSeqNo();

	/**
	 * Sets the seq no of this virtual lab user temp.
	 *
	 * @param seqNo the seq no of this virtual lab user temp
	 */
	public void setSeqNo(long seqNo);

	/**
	 * Returns the virtual lab ID of this virtual lab user temp.
	 *
	 * @return the virtual lab ID of this virtual lab user temp
	 */
	public long getVirtualLabId();

	/**
	 * Sets the virtual lab ID of this virtual lab user temp.
	 *
	 * @param virtualLabId the virtual lab ID of this virtual lab user temp
	 */
	public void setVirtualLabId(long virtualLabId);

	/**
	 * Returns the class ID of this virtual lab user temp.
	 *
	 * @return the class ID of this virtual lab user temp
	 */
	public long getClassId();

	/**
	 * Sets the class ID of this virtual lab user temp.
	 *
	 * @param classId the class ID of this virtual lab user temp
	 */
	public void setClassId(long classId);

	/**
	 * Returns the user student number of this virtual lab user temp.
	 *
	 * @return the user student number of this virtual lab user temp
	 */
	@AutoEscape
	public String getUserStudentNumber();

	/**
	 * Sets the user student number of this virtual lab user temp.
	 *
	 * @param userStudentNumber the user student number of this virtual lab user temp
	 */
	public void setUserStudentNumber(String userStudentNumber);

	/**
	 * Returns the user name of this virtual lab user temp.
	 *
	 * @return the user name of this virtual lab user temp
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this virtual lab user temp.
	 *
	 * @param userName the user name of this virtual lab user temp
	 */
	public void setUserName(String userName);

	/**
	 * Returns the status of this virtual lab user temp.
	 *
	 * @return the status of this virtual lab user temp
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this virtual lab user temp is status.
	 *
	 * @return <code>true</code> if this virtual lab user temp is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this virtual lab user temp is status.
	 *
	 * @param status the status of this virtual lab user temp
	 */
	public void setStatus(boolean status);

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

	@Override
	public Object clone();

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> toCacheModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp toEscapedModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
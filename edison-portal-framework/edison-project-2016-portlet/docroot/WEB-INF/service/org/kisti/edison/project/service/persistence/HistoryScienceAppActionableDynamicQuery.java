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

package org.kisti.edison.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.project.model.HistoryScienceApp;
import org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class HistoryScienceAppActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public HistoryScienceAppActionableDynamicQuery() throws SystemException {
		setBaseLocalService(HistoryScienceAppLocalServiceUtil.getService());
		setClass(HistoryScienceApp.class);

		setClassLoader(org.kisti.edison.project.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.scienceAppId");

		setGroupIdPropertyName("primaryKey.groupId");
	}
}
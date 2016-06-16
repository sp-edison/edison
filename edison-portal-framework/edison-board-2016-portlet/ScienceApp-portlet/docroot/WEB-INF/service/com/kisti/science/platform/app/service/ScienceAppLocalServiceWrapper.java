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

package com.kisti.science.platform.app.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScienceAppLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppLocalService
 * @generated
 */
public class ScienceAppLocalServiceWrapper implements ScienceAppLocalService,
	ServiceWrapper<ScienceAppLocalService> {
	public ScienceAppLocalServiceWrapper(
		ScienceAppLocalService scienceAppLocalService) {
		_scienceAppLocalService = scienceAppLocalService;
	}

	/**
	* Adds the science app to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp addScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.addScienceApp(scienceApp);
	}

	/**
	* Creates a new science app with the primary key. Does not add the science app to the database.
	*
	* @param scienceAppId the primary key for the new science app
	* @return the new science app
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp createScienceApp(
		long scienceAppId) {
		return _scienceAppLocalService.createScienceApp(scienceAppId);
	}

	/**
	* Deletes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app that was removed
	* @throws PortalException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp deleteScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.deleteScienceApp(scienceAppId);
	}

	/**
	* Deletes the science app from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp deleteScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.deleteScienceApp(scienceApp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scienceAppLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.fetchScienceApp(scienceAppId);
	}

	/**
	* Returns the science app with the matching UUID and company.
	*
	* @param uuid the science app's UUID
	* @param companyId the primary key of the company
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.fetchScienceAppByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the science app matching the UUID and group.
	*
	* @param uuid the science app's UUID
	* @param groupId the primary key of the group
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.fetchScienceAppByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the science app with the primary key.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app
	* @throws PortalException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceApp(scienceAppId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the science app with the matching UUID and company.
	*
	* @param uuid the science app's UUID
	* @param companyId the primary key of the company
	* @return the matching science app
	* @throws PortalException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the science app matching the UUID and group.
	*
	* @param uuid the science app's UUID
	* @param groupId the primary key of the group
	* @return the matching science app
	* @throws PortalException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of science apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceApps(start, end);
	}

	/**
	* Returns the number of science apps.
	*
	* @return the number of science apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScienceAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppsCount();
	}

	/**
	* Updates the science app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp updateScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.updateScienceApp(scienceApp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Creates a ScienceApp instance with specified name and version.
	* The new instance created is not yet saved in the database.
	* Use addScienceApp() to save the instance.
	*
	* @param appName: ScienceApp name to be created
	* @param appVersion: ScienceApp version to be created
	* @param sc: ServiceContext instance for ScienceApp
	* @return If appName is not follows naming rules or already exists in the database, returns null.
	If appVersion is not follows versioning rules, returns null.
	Otherwise returns a ScienceApp instance with initialized data.
	
	Some attributes of the returned instance are set initial value as followings:
	-stage: ScienceAppConstants.EMPTY
	-authorId: current user id of service context instance
	-createDate: date created of service context instance
	-modifiedDate: date created of service context instance
	-userId: current user id of service context instance
	-recentModifierId: current user id of service context instance
	-groupId: scope group id of service context instance
	-companyId: company id of service context instance
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#createScienceApp(java.lang.String, java.lang.String, com.liferay.portal.service.ServiceContext)
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp createScienceApp(
		java.lang.String appName, java.lang.String appVersion,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.createScienceApp(appName, appVersion, sc);
	}

	/**
	* Copies ScienceApp instance to another.
	* The instance is not yet saved in the database.
	* Use addScienceApp() to save the instance.
	*
	* @param scienceAppId: original ScienceApp id to be copied
	* @param sc: service context for ScienceApp
	* @return new ScienceApp instance.
	Each attribute of the returned instance has exactly same value with original instance
	except some attributes.
	
	Some attributes of the returned instance are initialized as followings:
	-stage: ScienceAppConstants.EMPTY
	-createDate: date created of service context instance
	-modifiedDate: date created of service context instance
	-userId: current user id of service context instance
	-recentModifierId: current user id of service context instance
	-groupId: scope group id of service context instance
	-companyId: company id of service context instance
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#copyScienceApp(long, com.liferay.portal.service.ServiceContext)
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp copyScienceApp(
		long scienceAppId, com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.copyScienceApp(scienceAppId, sc);
	}

	/**
	* Saves the specified ScienceApp instance to database.
	*
	* @param scienceApp: ScienceApp instance to be saved.
	* @param sc: service context of the ScienceApp class
	* @return ScienceApp instance saved.
	* @throws SystemException
	* @throws PortalException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#addScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp addScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.addScienceApp(scienceApp, sc);
	}

	@Override
	public void setScienceAppInputPorts(long scienceAppId,
		java.lang.String inputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.setScienceAppInputPorts(scienceAppId, inputPorts);
	}

	@Override
	public java.lang.String getScienceAppInputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppInputPorts(scienceAppId);
	}

	@Override
	public void setScienceAppOutputPorts(long scienceAppId,
		java.lang.String outputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.setScienceAppOutputPorts(scienceAppId,
			outputPorts);
	}

	@Override
	public java.lang.String getScienceAppOutputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppOutputPorts(scienceAppId);
	}

	/**
	* Verifies ScienceApp name if the name follows specified naming rules and there is no science app
	* in the database already.
	*
	* @param appName: science app name to be tesed.
	* @return true if the name follows naming rules and brand new.
	false, Otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#verifyScienceAppName(java.lang.String, long)
	*/
	@Override
	public boolean verifyScienceAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.verifyScienceAppName(appName);
	}

	/**
	* Test if there is a science app name in the database already.
	*
	* @param appName: science app name to be tesed.
	* @return true if the app name already exist in the database,
	false, otherwise
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#existAppName(java.lang.String)
	*/
	@Override
	public boolean existAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.existAppName(appName);
	}

	/**
	* Test if there is an science app with the specified name and version in the database.
	*
	* @param appName: science app name to be tesed.
	* @param appVersion: science app version to be tesed.
	* @return true if a science app with the name and the version already exist in the database,
	false, otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#existApp(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean existApp(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.existApp(appName, appVersion);
	}

	/**
	* Get the science app's latest version
	*
	* @param appName: science app name
	* @return the latest version science app instance.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#getLatestVersion(java.lang.String)
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp getLatestVersion(
		java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getLatestVersion(appName);
	}

	/**
	* Verify version number of a science app.
	* Version number of a science app should be consisted of 3 sections, {major}.{sub}.{minor}.
	* Major section number should be increased when a science app changes or added its architecture or major functions.
	* Sub section number should be increased when the science app changes functionality.
	* Minor section number should be increased when the science app fixes errors.
	* Each section must be integer and be lager than before.
	*
	* @param appName: science app name to be verified.
	* @param appVersion: science app version to be verified.
	* @return true if the version number follows naming rules and valid.
	false, Otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#verifyVersionNumber(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean verifyVersionNumber(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.verifyVersionNumber(appName, appVersion);
	}

	@Override
	public void deleteAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.deleteAllScienceApps();
	}

	/**
	* Update a science app
	*
	* @param scienceApp: science app instance to be updated.
	* @param sc: ServiceContext instance for the ScienceApp class.
	* @return ScienceApp instance updated.
	* @throws SystemException
	* @throws PortalException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#updateScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceApp updateScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.updateScienceApp(scienceApp, sc);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getAll();
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countAll();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getAll(targetLang);
	}

	@Override
	public int countAll(java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countAll(targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getAll(start, end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		int start, int end, java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getAll(start, end, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByStatus(status);
	}

	@Override
	public int countScienceAppsByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByStatus(status);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStage(
		java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByStage(stage);
	}

	@Override
	public int countScienceAppsByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByStage(stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStage(
		java.lang.String stage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByStage(stage, start,
			end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAuthorIdAppType(authorId,
			appType);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAppType(appType);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAppType(appType,
			start, end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAppType(appType,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, int start, int end,
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAppType(appType,
			start, end, targetLang);
	}

	@Override
	public int countScienceAppsByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByAppType(appType);
	}

	@Override
	public int countScienceAppsByAppType(java.lang.String appType,
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByAppType(appType,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appClass, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAuthorIdAppType(authorId,
			appClass, start, end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAuthorId(authorId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByAuthorId(authorId,
			start, end);
	}

	@Override
	public int countScienceAppsByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByAuthorId(authorId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByOpenLevel(openLevel);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByOpenLevel(openLevel,
			start, end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByManagerId(
		long managerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByManagerId(managerId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByManagerId(
		long managerId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByManagerId(managerId,
			start, end);
	}

	@Override
	public int countScienceAppsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppsByManagerId(managerId);
	}

	@Override
	public long[] getScienceAppManagerIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppManagerIds(scienceAppId);
	}

	@Override
	public long[] getScienceAppManagerIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppManagerIds(scienceAppId,
			start, end);
	}

	@Override
	public int countScienceAppManagers(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppManagers(scienceAppId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByCategoryId(categoryId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppListByCategoryId(categoryId,
			start, end);
	}

	@Override
	public long[] getScienceAppCategoryIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppCategoryIds(scienceAppId);
	}

	@Override
	public long[] getScienceAppCategoryIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppCategoryIds(scienceAppId,
			start, end);
	}

	@Override
	public int countScienceAppCategories(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countScienceAppCategories(scienceAppId);
	}

	@Override
	public void assignScienceAppToCategories(long scienceAppId,
		long[] categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.assignScienceAppToCategories(scienceAppId,
			categoryIds);
	}

	@Override
	public void assignScienceAppToCategory(long scienceAppId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.assignScienceAppToCategory(scienceAppId,
			categoryId);
	}

	@Override
	public void assignManagersToScienceApp(long scienceAppId, long[] managerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.assignManagersToScienceApp(scienceAppId,
			managerIds);
	}

	@Override
	public void assignManagerToScienceApp(long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppLocalService.assignManagerToScienceApp(scienceAppId,
			managerId);
	}

	/**
	* Get path of the executable binary file.
	* The full path can be obtained by adding base directory for science apps.
	*
	* @param scienceAppId
	* @return String of the path.
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.lang.String getScienceAppBinPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppBinPath(scienceAppId);
	}

	/**
	* Get path of the source file.
	* The full path can be obtained by adding base directory for science apps.
	*
	* @param scienceAppId
	* @return String of the path.
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.lang.String getScienceAppSrcPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.getScienceAppSrcPath(scienceAppId);
	}

	/**
	* Counts all science apps in the database.
	*
	* @return int - count
	*/
	@Override
	public int countAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppLocalService.countAllScienceApps();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm,
			start, end);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return _scienceAppLocalService.countScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage, start, end);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenName(searchTerm,
			start, end);
	}

	@Override
	public int countScienceAppsOnScreenName(java.lang.String searchTerm) {
		return _scienceAppLocalService.countScienceAppsOnScreenName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByStage(searchTerm,
			stage, start, end);
	}

	@Override
	public int countScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.countScienceAppsOnScreenNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByTarget(searchTerm,
			targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnScreenNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationName(searchTerm,
			start, end);
	}

	@Override
	public int countScienceAppsOnAffiliationName(java.lang.String searchTerm) {
		return _scienceAppLocalService.countScienceAppsOnAffiliationName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationName(searchTerm);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByStage(searchTerm,
			stage, start, end);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.countScienceAppsOnAffiliationNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByStage(searchTerm,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyId(vocabularyId,
			start, end);
	}

	@Override
	public int countScienceAppsByVocabularyId(long vocabularyId) {
		return _scienceAppLocalService.countScienceAppsByVocabularyId(vocabularyId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyId(vocabularyId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdStage(vocabularyId,
			stage, start, end);
	}

	@Override
	public int countScienceAppsByVocabularyIdStage(long vocabularyId,
		java.lang.String stage) {
		return _scienceAppLocalService.countScienceAppsByVocabularyIdStage(vocabularyId,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdStage(vocabularyId,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang, start, end);
	}

	@Override
	public int countScienceAppsByVocabularyIdTarget(long vocabularyId,
		java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang, start, end);
	}

	@Override
	public int countScienceAppsByVocabularyIdStageTarget(long vocabularyId,
		java.lang.String stage, java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryId(categoryId,
			start, end);
	}

	@Override
	public int countScienceAppsByCategoryId(long categoryId) {
		return _scienceAppLocalService.countScienceAppsByCategoryId(categoryId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryId(categoryId);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdStage(categoryId,
			stage, start, end);
	}

	@Override
	public int countScienceAppsByCategoryIdStage(long categoryId,
		java.lang.String stage) {
		return _scienceAppLocalService.countScienceAppsByCategoryIdStage(categoryId,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdStage(categoryId,
			stage);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang, int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdTarget(categoryId,
			targetLang, start, end);
	}

	@Override
	public int countScienceAppsByCategoryIdTarget(long categoryId,
		java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsByCategoryIdTarget(categoryId,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdTarget(categoryId,
			targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdStageTarget(categoryId,
			stage, targetLang, start, end);
	}

	@Override
	public int countScienceAppsByCategoryIdStageTarget(long categoryId,
		java.lang.String stage, java.lang.String targetLang) {
		return _scienceAppLocalService.countScienceAppsByCategoryIdStageTarget(categoryId,
			stage, targetLang);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang) {
		return _scienceAppLocalService.retrieveScienceAppsByCategoryIdStageTarget(categoryId,
			stage, targetLang);
	}

	@Override
	public boolean existScienceAppPath(java.lang.String targetPath)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		return _scienceAppLocalService.existScienceAppPath(targetPath);
	}

	@Override
	public void deleteScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		_scienceAppLocalService.deleteScienceAppDir(targetDir);
	}

	@Override
	public void makeScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		_scienceAppLocalService.makeScienceAppDir(targetDir);
	}

	/**
	* Save uploaded file to new location
	*
	* @param uploadedInputStream
	* @return
	* @throws InterruptedException
	* @throws IOException
	* @throws SystemException
	*/
	@Override
	public java.io.File saveToScienceAppStorage(java.lang.String targetDir,
		java.lang.String fileName, java.io.InputStream uploadedInputStream)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		return _scienceAppLocalService.saveToScienceAppStorage(targetDir,
			fileName, uploadedInputStream);
	}

	/**
	* Unzip an uploaded file into a specified directory.
	*
	* @param strUnzipDirPath the directory into which unzipped files go.
	* @param zipFile zip file
	* @return process output message
	* @throws SystemException system exception
	* @throws IOException io exception
	* @throws InterruptedException interrupted exception
	*/
	@Override
	public void unzipScienceAppZipFile(java.lang.String sourcePath,
		java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		_scienceAppLocalService.unzipScienceAppZipFile(sourcePath, targetDir);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppLocalService getWrappedScienceAppLocalService() {
		return _scienceAppLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppLocalService(
		ScienceAppLocalService scienceAppLocalService) {
		_scienceAppLocalService = scienceAppLocalService;
	}

	@Override
	public ScienceAppLocalService getWrappedService() {
		return _scienceAppLocalService;
	}

	@Override
	public void setWrappedService(ScienceAppLocalService scienceAppLocalService) {
		_scienceAppLocalService = scienceAppLocalService;
	}

	private ScienceAppLocalService _scienceAppLocalService;
}
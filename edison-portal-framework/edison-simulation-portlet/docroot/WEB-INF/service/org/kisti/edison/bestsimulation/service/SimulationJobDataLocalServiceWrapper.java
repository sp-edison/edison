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

package org.kisti.edison.bestsimulation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationJobDataLocalService}.
 *
 * @author EDISON
 * @see SimulationJobDataLocalService
 * @generated
 */
public class SimulationJobDataLocalServiceWrapper
	implements SimulationJobDataLocalService,
		ServiceWrapper<SimulationJobDataLocalService> {
	public SimulationJobDataLocalServiceWrapper(
		SimulationJobDataLocalService simulationJobDataLocalService) {
		_simulationJobDataLocalService = simulationJobDataLocalService;
	}

	/**
	* Adds the simulation job data to the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobData the simulation job data
	* @return the simulation job data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData addSimulationJobData(
		org.kisti.edison.bestsimulation.model.SimulationJobData simulationJobData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.addSimulationJobData(simulationJobData);
	}

	/**
	* Creates a new simulation job data with the primary key. Does not add the simulation job data to the database.
	*
	* @param jobUuid the primary key for the new simulation job data
	* @return the new simulation job data
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData createSimulationJobData(
		java.lang.String jobUuid) {
		return _simulationJobDataLocalService.createSimulationJobData(jobUuid);
	}

	/**
	* Deletes the simulation job data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobUuid the primary key of the simulation job data
	* @return the simulation job data that was removed
	* @throws PortalException if a simulation job data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData deleteSimulationJobData(
		java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.deleteSimulationJobData(jobUuid);
	}

	/**
	* Deletes the simulation job data from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobData the simulation job data
	* @return the simulation job data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData deleteSimulationJobData(
		org.kisti.edison.bestsimulation.model.SimulationJobData simulationJobData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.deleteSimulationJobData(simulationJobData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _simulationJobDataLocalService.dynamicQuery();
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
		return _simulationJobDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _simulationJobDataLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _simulationJobDataLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _simulationJobDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _simulationJobDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData fetchSimulationJobData(
		java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.fetchSimulationJobData(jobUuid);
	}

	/**
	* Returns the simulation job data with the primary key.
	*
	* @param jobUuid the primary key of the simulation job data
	* @return the simulation job data
	* @throws PortalException if a simulation job data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData getSimulationJobData(
		java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.getSimulationJobData(jobUuid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the simulation job datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulation job datas
	* @param end the upper bound of the range of simulation job datas (not inclusive)
	* @return the range of simulation job datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobData> getSimulationJobDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.getSimulationJobDatas(start, end);
	}

	/**
	* Returns the number of simulation job datas.
	*
	* @return the number of simulation job datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSimulationJobDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.getSimulationJobDatasCount();
	}

	/**
	* Updates the simulation job data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulationJobData the simulation job data
	* @return the simulation job data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData updateSimulationJobData(
		org.kisti.edison.bestsimulation.model.SimulationJobData simulationJobData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobDataLocalService.updateSimulationJobData(simulationJobData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _simulationJobDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_simulationJobDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _simulationJobDataLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SimulationJobDataLocalService getWrappedSimulationJobDataLocalService() {
		return _simulationJobDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSimulationJobDataLocalService(
		SimulationJobDataLocalService simulationJobDataLocalService) {
		_simulationJobDataLocalService = simulationJobDataLocalService;
	}

	@Override
	public SimulationJobDataLocalService getWrappedService() {
		return _simulationJobDataLocalService;
	}

	@Override
	public void setWrappedService(
		SimulationJobDataLocalService simulationJobDataLocalService) {
		_simulationJobDataLocalService = simulationJobDataLocalService;
	}

	private SimulationJobDataLocalService _simulationJobDataLocalService;
}
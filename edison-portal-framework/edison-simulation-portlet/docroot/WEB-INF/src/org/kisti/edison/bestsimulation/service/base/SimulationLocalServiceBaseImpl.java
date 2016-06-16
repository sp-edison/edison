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

package org.kisti.edison.bestsimulation.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.kisti.edison.bestsimulation.model.Simulation;
import org.kisti.edison.bestsimulation.service.SimulationLocalService;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobDataPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobFinder;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the simulation local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl}.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil
 * @generated
 */
public abstract class SimulationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SimulationLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil} to access the simulation local service.
	 */

	/**
	 * Adds the simulation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulation the simulation
	 * @return the simulation that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Simulation addSimulation(Simulation simulation)
		throws SystemException {
		simulation.setNew(true);

		return simulationPersistence.update(simulation);
	}

	/**
	 * Creates a new simulation with the primary key. Does not add the simulation to the database.
	 *
	 * @param simulationPK the primary key for the new simulation
	 * @return the new simulation
	 */
	@Override
	public Simulation createSimulation(SimulationPK simulationPK) {
		return simulationPersistence.create(simulationPK);
	}

	/**
	 * Deletes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulationPK the primary key of the simulation
	 * @return the simulation that was removed
	 * @throws PortalException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Simulation deleteSimulation(SimulationPK simulationPK)
		throws PortalException, SystemException {
		return simulationPersistence.remove(simulationPK);
	}

	/**
	 * Deletes the simulation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulation the simulation
	 * @return the simulation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Simulation deleteSimulation(Simulation simulation)
		throws SystemException {
		return simulationPersistence.remove(simulation);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Simulation.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return simulationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return simulationPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return simulationPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return simulationPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return simulationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Simulation fetchSimulation(SimulationPK simulationPK)
		throws SystemException {
		return simulationPersistence.fetchByPrimaryKey(simulationPK);
	}

	/**
	 * Returns the simulation with the primary key.
	 *
	 * @param simulationPK the primary key of the simulation
	 * @return the simulation
	 * @throws PortalException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation getSimulation(SimulationPK simulationPK)
		throws PortalException, SystemException {
		return simulationPersistence.findByPrimaryKey(simulationPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return simulationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the simulations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulations
	 * @param end the upper bound of the range of simulations (not inclusive)
	 * @return the range of simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Simulation> getSimulations(int start, int end)
		throws SystemException {
		return simulationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of simulations.
	 *
	 * @return the number of simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSimulationsCount() throws SystemException {
		return simulationPersistence.countAll();
	}

	/**
	 * Updates the simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param simulation the simulation
	 * @return the simulation that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Simulation updateSimulation(Simulation simulation)
		throws SystemException {
		return simulationPersistence.update(simulation);
	}

	/**
	 * Returns the simulation local service.
	 *
	 * @return the simulation local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationLocalService getSimulationLocalService() {
		return simulationLocalService;
	}

	/**
	 * Sets the simulation local service.
	 *
	 * @param simulationLocalService the simulation local service
	 */
	public void setSimulationLocalService(
		org.kisti.edison.bestsimulation.service.SimulationLocalService simulationLocalService) {
		this.simulationLocalService = simulationLocalService;
	}

	/**
	 * Returns the simulation remote service.
	 *
	 * @return the simulation remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationService getSimulationService() {
		return simulationService;
	}

	/**
	 * Sets the simulation remote service.
	 *
	 * @param simulationService the simulation remote service
	 */
	public void setSimulationService(
		org.kisti.edison.bestsimulation.service.SimulationService simulationService) {
		this.simulationService = simulationService;
	}

	/**
	 * Returns the simulation persistence.
	 *
	 * @return the simulation persistence
	 */
	public SimulationPersistence getSimulationPersistence() {
		return simulationPersistence;
	}

	/**
	 * Sets the simulation persistence.
	 *
	 * @param simulationPersistence the simulation persistence
	 */
	public void setSimulationPersistence(
		SimulationPersistence simulationPersistence) {
		this.simulationPersistence = simulationPersistence;
	}

	/**
	 * Returns the simulation job local service.
	 *
	 * @return the simulation job local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobLocalService getSimulationJobLocalService() {
		return simulationJobLocalService;
	}

	/**
	 * Sets the simulation job local service.
	 *
	 * @param simulationJobLocalService the simulation job local service
	 */
	public void setSimulationJobLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobLocalService simulationJobLocalService) {
		this.simulationJobLocalService = simulationJobLocalService;
	}

	/**
	 * Returns the simulation job remote service.
	 *
	 * @return the simulation job remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobService getSimulationJobService() {
		return simulationJobService;
	}

	/**
	 * Sets the simulation job remote service.
	 *
	 * @param simulationJobService the simulation job remote service
	 */
	public void setSimulationJobService(
		org.kisti.edison.bestsimulation.service.SimulationJobService simulationJobService) {
		this.simulationJobService = simulationJobService;
	}

	/**
	 * Returns the simulation job persistence.
	 *
	 * @return the simulation job persistence
	 */
	public SimulationJobPersistence getSimulationJobPersistence() {
		return simulationJobPersistence;
	}

	/**
	 * Sets the simulation job persistence.
	 *
	 * @param simulationJobPersistence the simulation job persistence
	 */
	public void setSimulationJobPersistence(
		SimulationJobPersistence simulationJobPersistence) {
		this.simulationJobPersistence = simulationJobPersistence;
	}

	/**
	 * Returns the simulation job finder.
	 *
	 * @return the simulation job finder
	 */
	public SimulationJobFinder getSimulationJobFinder() {
		return simulationJobFinder;
	}

	/**
	 * Sets the simulation job finder.
	 *
	 * @param simulationJobFinder the simulation job finder
	 */
	public void setSimulationJobFinder(SimulationJobFinder simulationJobFinder) {
		this.simulationJobFinder = simulationJobFinder;
	}

	/**
	 * Returns the simulation job data local service.
	 *
	 * @return the simulation job data local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService getSimulationJobDataLocalService() {
		return simulationJobDataLocalService;
	}

	/**
	 * Sets the simulation job data local service.
	 *
	 * @param simulationJobDataLocalService the simulation job data local service
	 */
	public void setSimulationJobDataLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService simulationJobDataLocalService) {
		this.simulationJobDataLocalService = simulationJobDataLocalService;
	}

	/**
	 * Returns the simulation job data remote service.
	 *
	 * @return the simulation job data remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobDataService getSimulationJobDataService() {
		return simulationJobDataService;
	}

	/**
	 * Sets the simulation job data remote service.
	 *
	 * @param simulationJobDataService the simulation job data remote service
	 */
	public void setSimulationJobDataService(
		org.kisti.edison.bestsimulation.service.SimulationJobDataService simulationJobDataService) {
		this.simulationJobDataService = simulationJobDataService;
	}

	/**
	 * Returns the simulation job data persistence.
	 *
	 * @return the simulation job data persistence
	 */
	public SimulationJobDataPersistence getSimulationJobDataPersistence() {
		return simulationJobDataPersistence;
	}

	/**
	 * Sets the simulation job data persistence.
	 *
	 * @param simulationJobDataPersistence the simulation job data persistence
	 */
	public void setSimulationJobDataPersistence(
		SimulationJobDataPersistence simulationJobDataPersistence) {
		this.simulationJobDataPersistence = simulationJobDataPersistence;
	}

	/**
	 * Returns the simulation job status local service.
	 *
	 * @return the simulation job status local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService getSimulationJobStatusLocalService() {
		return simulationJobStatusLocalService;
	}

	/**
	 * Sets the simulation job status local service.
	 *
	 * @param simulationJobStatusLocalService the simulation job status local service
	 */
	public void setSimulationJobStatusLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService simulationJobStatusLocalService) {
		this.simulationJobStatusLocalService = simulationJobStatusLocalService;
	}

	/**
	 * Returns the simulation job status remote service.
	 *
	 * @return the simulation job status remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobStatusService getSimulationJobStatusService() {
		return simulationJobStatusService;
	}

	/**
	 * Sets the simulation job status remote service.
	 *
	 * @param simulationJobStatusService the simulation job status remote service
	 */
	public void setSimulationJobStatusService(
		org.kisti.edison.bestsimulation.service.SimulationJobStatusService simulationJobStatusService) {
		this.simulationJobStatusService = simulationJobStatusService;
	}

	/**
	 * Returns the simulation job status persistence.
	 *
	 * @return the simulation job status persistence
	 */
	public SimulationJobStatusPersistence getSimulationJobStatusPersistence() {
		return simulationJobStatusPersistence;
	}

	/**
	 * Sets the simulation job status persistence.
	 *
	 * @param simulationJobStatusPersistence the simulation job status persistence
	 */
	public void setSimulationJobStatusPersistence(
		SimulationJobStatusPersistence simulationJobStatusPersistence) {
		this.simulationJobStatusPersistence = simulationJobStatusPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.kisti.edison.bestsimulation.model.Simulation",
			simulationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.kisti.edison.bestsimulation.model.Simulation");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Simulation.class;
	}

	protected String getModelClassName() {
		return Simulation.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = simulationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationLocalService simulationLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationService simulationService;
	@BeanReference(type = SimulationPersistence.class)
	protected SimulationPersistence simulationPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobLocalService simulationJobLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobService simulationJobService;
	@BeanReference(type = SimulationJobPersistence.class)
	protected SimulationJobPersistence simulationJobPersistence;
	@BeanReference(type = SimulationJobFinder.class)
	protected SimulationJobFinder simulationJobFinder;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService simulationJobDataLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobDataService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobDataService simulationJobDataService;
	@BeanReference(type = SimulationJobDataPersistence.class)
	protected SimulationJobDataPersistence simulationJobDataPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService simulationJobStatusLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobStatusService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobStatusService simulationJobStatusService;
	@BeanReference(type = SimulationJobStatusPersistence.class)
	protected SimulationJobStatusPersistence simulationJobStatusPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SimulationLocalServiceClpInvoker _clpInvoker = new SimulationLocalServiceClpInvoker();
}
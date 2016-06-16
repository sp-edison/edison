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

package org.kisti.edison.service.base;

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

import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.service.SendMailContentLocalService;
import org.kisti.edison.service.persistence.SendMailContentFinder;
import org.kisti.edison.service.persistence.SendMailContentPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the send mail content local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.kisti.edison.service.impl.SendMailContentLocalServiceImpl}.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.service.impl.SendMailContentLocalServiceImpl
 * @see org.kisti.edison.service.SendMailContentLocalServiceUtil
 * @generated
 */
public abstract class SendMailContentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SendMailContentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.kisti.edison.service.SendMailContentLocalServiceUtil} to access the send mail content local service.
	 */

	/**
	 * Adds the send mail content to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendMailContent the send mail content
	 * @return the send mail content that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SendMailContent addSendMailContent(SendMailContent sendMailContent)
		throws SystemException {
		sendMailContent.setNew(true);

		return sendMailContentPersistence.update(sendMailContent);
	}

	/**
	 * Creates a new send mail content with the primary key. Does not add the send mail content to the database.
	 *
	 * @param sendMailId the primary key for the new send mail content
	 * @return the new send mail content
	 */
	@Override
	public SendMailContent createSendMailContent(long sendMailId) {
		return sendMailContentPersistence.create(sendMailId);
	}

	/**
	 * Deletes the send mail content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendMailId the primary key of the send mail content
	 * @return the send mail content that was removed
	 * @throws PortalException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SendMailContent deleteSendMailContent(long sendMailId)
		throws PortalException, SystemException {
		return sendMailContentPersistence.remove(sendMailId);
	}

	/**
	 * Deletes the send mail content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendMailContent the send mail content
	 * @return the send mail content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SendMailContent deleteSendMailContent(
		SendMailContent sendMailContent) throws SystemException {
		return sendMailContentPersistence.remove(sendMailContent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SendMailContent.class,
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
		return sendMailContentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SendMailContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return sendMailContentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SendMailContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return sendMailContentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return sendMailContentPersistence.countWithDynamicQuery(dynamicQuery);
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
		return sendMailContentPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SendMailContent fetchSendMailContent(long sendMailId)
		throws SystemException {
		return sendMailContentPersistence.fetchByPrimaryKey(sendMailId);
	}

	/**
	 * Returns the send mail content with the primary key.
	 *
	 * @param sendMailId the primary key of the send mail content
	 * @return the send mail content
	 * @throws PortalException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent getSendMailContent(long sendMailId)
		throws PortalException, SystemException {
		return sendMailContentPersistence.findByPrimaryKey(sendMailId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return sendMailContentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the send mail contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SendMailContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of send mail contents
	 * @param end the upper bound of the range of send mail contents (not inclusive)
	 * @return the range of send mail contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SendMailContent> getSendMailContents(int start, int end)
		throws SystemException {
		return sendMailContentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of send mail contents.
	 *
	 * @return the number of send mail contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSendMailContentsCount() throws SystemException {
		return sendMailContentPersistence.countAll();
	}

	/**
	 * Updates the send mail content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sendMailContent the send mail content
	 * @return the send mail content that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SendMailContent updateSendMailContent(
		SendMailContent sendMailContent) throws SystemException {
		return sendMailContentPersistence.update(sendMailContent);
	}

	/**
	 * Returns the send mail content local service.
	 *
	 * @return the send mail content local service
	 */
	public org.kisti.edison.service.SendMailContentLocalService getSendMailContentLocalService() {
		return sendMailContentLocalService;
	}

	/**
	 * Sets the send mail content local service.
	 *
	 * @param sendMailContentLocalService the send mail content local service
	 */
	public void setSendMailContentLocalService(
		org.kisti.edison.service.SendMailContentLocalService sendMailContentLocalService) {
		this.sendMailContentLocalService = sendMailContentLocalService;
	}

	/**
	 * Returns the send mail content remote service.
	 *
	 * @return the send mail content remote service
	 */
	public org.kisti.edison.service.SendMailContentService getSendMailContentService() {
		return sendMailContentService;
	}

	/**
	 * Sets the send mail content remote service.
	 *
	 * @param sendMailContentService the send mail content remote service
	 */
	public void setSendMailContentService(
		org.kisti.edison.service.SendMailContentService sendMailContentService) {
		this.sendMailContentService = sendMailContentService;
	}

	/**
	 * Returns the send mail content persistence.
	 *
	 * @return the send mail content persistence
	 */
	public SendMailContentPersistence getSendMailContentPersistence() {
		return sendMailContentPersistence;
	}

	/**
	 * Sets the send mail content persistence.
	 *
	 * @param sendMailContentPersistence the send mail content persistence
	 */
	public void setSendMailContentPersistence(
		SendMailContentPersistence sendMailContentPersistence) {
		this.sendMailContentPersistence = sendMailContentPersistence;
	}

	/**
	 * Returns the send mail content finder.
	 *
	 * @return the send mail content finder
	 */
	public SendMailContentFinder getSendMailContentFinder() {
		return sendMailContentFinder;
	}

	/**
	 * Sets the send mail content finder.
	 *
	 * @param sendMailContentFinder the send mail content finder
	 */
	public void setSendMailContentFinder(
		SendMailContentFinder sendMailContentFinder) {
		this.sendMailContentFinder = sendMailContentFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("org.kisti.edison.model.SendMailContent",
			sendMailContentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.kisti.edison.model.SendMailContent");
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
		return SendMailContent.class;
	}

	protected String getModelClassName() {
		return SendMailContent.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = sendMailContentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.kisti.edison.service.SendMailContentLocalService.class)
	protected org.kisti.edison.service.SendMailContentLocalService sendMailContentLocalService;
	@BeanReference(type = org.kisti.edison.service.SendMailContentService.class)
	protected org.kisti.edison.service.SendMailContentService sendMailContentService;
	@BeanReference(type = SendMailContentPersistence.class)
	protected SendMailContentPersistence sendMailContentPersistence;
	@BeanReference(type = SendMailContentFinder.class)
	protected SendMailContentFinder sendMailContentFinder;
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
	private SendMailContentLocalServiceClpInvoker _clpInvoker = new SendMailContentLocalServiceClpInvoker();
}
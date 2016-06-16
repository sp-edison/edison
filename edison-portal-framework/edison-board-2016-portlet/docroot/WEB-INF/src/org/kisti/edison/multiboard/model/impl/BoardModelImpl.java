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

package org.kisti.edison.multiboard.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
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

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.model.BoardModel;
import org.kisti.edison.multiboard.model.BoardSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the Board service. Represents a row in the &quot;EDCON_Board&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.multiboard.model.BoardModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BoardImpl}.
 * </p>
 *
 * @author mhkang
 * @see BoardImpl
 * @see org.kisti.edison.multiboard.model.Board
 * @see org.kisti.edison.multiboard.model.BoardModel
 * @generated
 */
@JSON(strict = true)
public class BoardModelImpl extends BaseModelImpl<Board> implements BoardModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a board model instance should use the {@link org.kisti.edison.multiboard.model.Board} interface instead.
	 */
	public static final String TABLE_NAME = "EDCON_Board";
	public static final Object[][] TABLE_COLUMNS = {
			{ "boardSeq", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "customId", Types.VARCHAR },
			{ "writerId", Types.BIGINT },
			{ "writerDate", Types.TIMESTAMP },
			{ "readCnt", Types.INTEGER },
			{ "groupBoardSeq", Types.INTEGER },
			{ "groupBoardTurn", Types.INTEGER },
			{ "replyDepth", Types.INTEGER },
			{ "siteGroup", Types.VARCHAR },
			{ "popupYn", Types.BOOLEAN },
			{ "popupStartDt", Types.TIMESTAMP },
			{ "popupEndDt", Types.TIMESTAMP },
			{ "insertId", Types.BIGINT },
			{ "insertDt", Types.TIMESTAMP },
			{ "updateId", Types.BIGINT },
			{ "updateDt", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table EDCON_Board (boardSeq LONG not null primary key,title STRING null,content STRING null,groupId LONG,customId VARCHAR(75) null,writerId LONG,writerDate DATE null,readCnt INTEGER,groupBoardSeq INTEGER,groupBoardTurn INTEGER,replyDepth INTEGER,siteGroup VARCHAR(75) null,popupYn BOOLEAN,popupStartDt DATE null,popupEndDt DATE null,insertId LONG,insertDt DATE null,updateId LONG,updateDt DATE null)";
	public static final String TABLE_SQL_DROP = "drop table EDCON_Board";
	public static final String ORDER_BY_JPQL = " ORDER BY board.writerDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDCON_Board.writerDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "true";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.multiboard.model.Board"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.multiboard.model.Board"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Board toModel(BoardSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Board model = new BoardImpl();

		model.setBoardSeq(soapModel.getBoardSeq());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());
		model.setGroupId(soapModel.getGroupId());
		model.setCustomId(soapModel.getCustomId());
		model.setWriterId(soapModel.getWriterId());
		model.setWriterDate(soapModel.getWriterDate());
		model.setReadCnt(soapModel.getReadCnt());
		model.setGroupBoardSeq(soapModel.getGroupBoardSeq());
		model.setGroupBoardTurn(soapModel.getGroupBoardTurn());
		model.setReplyDepth(soapModel.getReplyDepth());
		model.setSiteGroup(soapModel.getSiteGroup());
		model.setPopupYn(soapModel.getPopupYn());
		model.setPopupStartDt(soapModel.getPopupStartDt());
		model.setPopupEndDt(soapModel.getPopupEndDt());
		model.setInsertId(soapModel.getInsertId());
		model.setInsertDt(soapModel.getInsertDt());
		model.setUpdateId(soapModel.getUpdateId());
		model.setUpdateDt(soapModel.getUpdateDt());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Board> toModels(BoardSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Board> models = new ArrayList<Board>(soapModels.length);

		for (BoardSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_EDCON_BOARDDIV_BOARD_NAME = "EDCON_BoardDiv_Board";
	public static final Object[][] MAPPING_TABLE_EDCON_BOARDDIV_BOARD_COLUMNS = {
			{ "boardSeq", Types.BIGINT },
			{ "divCd", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_EDCON_BOARDDIV_BOARD_SQL_CREATE = "create table EDCON_BoardDiv_Board (boardSeq LONG not null,divCd LONG not null,primary key (boardSeq, divCd))";
	public static final boolean FINDER_CACHE_ENABLED_EDCON_BOARDDIV_BOARD = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.EDCON_BoardDiv_Board"), true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.multiboard.model.Board"));

	public BoardModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _boardSeq;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBoardSeq(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _boardSeq;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Board.class;
	}

	@Override
	public String getModelClassName() {
		return Board.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("boardSeq", getBoardSeq());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("groupId", getGroupId());
		attributes.put("customId", getCustomId());
		attributes.put("writerId", getWriterId());
		attributes.put("writerDate", getWriterDate());
		attributes.put("readCnt", getReadCnt());
		attributes.put("groupBoardSeq", getGroupBoardSeq());
		attributes.put("groupBoardTurn", getGroupBoardTurn());
		attributes.put("replyDepth", getReplyDepth());
		attributes.put("siteGroup", getSiteGroup());
		attributes.put("popupYn", getPopupYn());
		attributes.put("popupStartDt", getPopupStartDt());
		attributes.put("popupEndDt", getPopupEndDt());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDt", getInsertDt());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDt", getUpdateDt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long boardSeq = (Long)attributes.get("boardSeq");

		if (boardSeq != null) {
			setBoardSeq(boardSeq);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String customId = (String)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		Long writerId = (Long)attributes.get("writerId");

		if (writerId != null) {
			setWriterId(writerId);
		}

		Date writerDate = (Date)attributes.get("writerDate");

		if (writerDate != null) {
			setWriterDate(writerDate);
		}

		Integer readCnt = (Integer)attributes.get("readCnt");

		if (readCnt != null) {
			setReadCnt(readCnt);
		}

		Integer groupBoardSeq = (Integer)attributes.get("groupBoardSeq");

		if (groupBoardSeq != null) {
			setGroupBoardSeq(groupBoardSeq);
		}

		Integer groupBoardTurn = (Integer)attributes.get("groupBoardTurn");

		if (groupBoardTurn != null) {
			setGroupBoardTurn(groupBoardTurn);
		}

		Integer replyDepth = (Integer)attributes.get("replyDepth");

		if (replyDepth != null) {
			setReplyDepth(replyDepth);
		}

		String siteGroup = (String)attributes.get("siteGroup");

		if (siteGroup != null) {
			setSiteGroup(siteGroup);
		}

		Boolean popupYn = (Boolean)attributes.get("popupYn");

		if (popupYn != null) {
			setPopupYn(popupYn);
		}

		Date popupStartDt = (Date)attributes.get("popupStartDt");

		if (popupStartDt != null) {
			setPopupStartDt(popupStartDt);
		}

		Date popupEndDt = (Date)attributes.get("popupEndDt");

		if (popupEndDt != null) {
			setPopupEndDt(popupEndDt);
		}

		Long insertId = (Long)attributes.get("insertId");

		if (insertId != null) {
			setInsertId(insertId);
		}

		Date insertDt = (Date)attributes.get("insertDt");

		if (insertDt != null) {
			setInsertDt(insertDt);
		}

		Long updateId = (Long)attributes.get("updateId");

		if (updateId != null) {
			setUpdateId(updateId);
		}

		Date updateDt = (Date)attributes.get("updateDt");

		if (updateDt != null) {
			setUpdateDt(updateDt);
		}
	}

	@JSON
	@Override
	public long getBoardSeq() {
		return _boardSeq;
	}

	@Override
	public void setBoardSeq(long boardSeq) {
		_boardSeq = boardSeq;
	}

	@JSON
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

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public String getContent(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId);
	}

	@Override
	public String getContent(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId, useDefault);
	}

	@Override
	public String getContent(String languageId) {
		return LocalizationUtil.getLocalization(getContent(), languageId);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getContent(), languageId,
			useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return _contentCurrentLanguageId;
	}

	@JSON
	@Override
	public String getContentCurrentValue() {
		Locale locale = getLocale(_contentCurrentLanguageId);

		return getContent(locale);
	}

	@Override
	public Map<Locale, String> getContentMap() {
		return LocalizationUtil.getLocalizationMap(getContent());
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public void setContent(String content, Locale locale) {
		setContent(content, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContent(String content, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(content)) {
			setContent(LocalizationUtil.updateLocalization(getContent(),
					"Content", content, languageId, defaultLanguageId));
		}
		else {
			setContent(LocalizationUtil.removeLocalization(getContent(),
					"Content", languageId));
		}
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		_contentCurrentLanguageId = languageId;
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap) {
		setContentMap(contentMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap,
		Locale defaultLocale) {
		if (contentMap == null) {
			return;
		}

		setContent(LocalizationUtil.updateLocalization(contentMap,
				getContent(), "Content", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public String getCustomId() {
		if (_customId == null) {
			return StringPool.BLANK;
		}
		else {
			return _customId;
		}
	}

	@Override
	public void setCustomId(String customId) {
		_customId = customId;
	}

	@JSON
	@Override
	public long getWriterId() {
		return _writerId;
	}

	@Override
	public void setWriterId(long writerId) {
		_writerId = writerId;
	}

	@JSON
	@Override
	public Date getWriterDate() {
		return _writerDate;
	}

	@Override
	public void setWriterDate(Date writerDate) {
		_writerDate = writerDate;
	}

	@JSON
	@Override
	public int getReadCnt() {
		return _readCnt;
	}

	@Override
	public void setReadCnt(int readCnt) {
		_readCnt = readCnt;
	}

	@JSON
	@Override
	public int getGroupBoardSeq() {
		return _groupBoardSeq;
	}

	@Override
	public void setGroupBoardSeq(int groupBoardSeq) {
		_groupBoardSeq = groupBoardSeq;
	}

	@JSON
	@Override
	public int getGroupBoardTurn() {
		return _groupBoardTurn;
	}

	@Override
	public void setGroupBoardTurn(int groupBoardTurn) {
		_groupBoardTurn = groupBoardTurn;
	}

	@JSON
	@Override
	public int getReplyDepth() {
		return _replyDepth;
	}

	@Override
	public void setReplyDepth(int replyDepth) {
		_replyDepth = replyDepth;
	}

	@JSON
	@Override
	public String getSiteGroup() {
		if (_siteGroup == null) {
			return StringPool.BLANK;
		}
		else {
			return _siteGroup;
		}
	}

	@Override
	public void setSiteGroup(String siteGroup) {
		_siteGroup = siteGroup;
	}

	@JSON
	@Override
	public boolean getPopupYn() {
		return _popupYn;
	}

	@Override
	public boolean isPopupYn() {
		return _popupYn;
	}

	@Override
	public void setPopupYn(boolean popupYn) {
		_popupYn = popupYn;
	}

	@JSON
	@Override
	public Date getPopupStartDt() {
		return _popupStartDt;
	}

	@Override
	public void setPopupStartDt(Date popupStartDt) {
		_popupStartDt = popupStartDt;
	}

	@JSON
	@Override
	public Date getPopupEndDt() {
		return _popupEndDt;
	}

	@Override
	public void setPopupEndDt(Date popupEndDt) {
		_popupEndDt = popupEndDt;
	}

	@JSON
	@Override
	public long getInsertId() {
		return _insertId;
	}

	@Override
	public void setInsertId(long insertId) {
		_insertId = insertId;
	}

	@JSON
	@Override
	public Date getInsertDt() {
		return _insertDt;
	}

	@Override
	public void setInsertDt(Date insertDt) {
		_insertDt = insertDt;
	}

	@JSON
	@Override
	public long getUpdateId() {
		return _updateId;
	}

	@Override
	public void setUpdateId(long updateId) {
		_updateId = updateId;
	}

	@JSON
	@Override
	public Date getUpdateDt() {
		return _updateDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Board.class.getName(), getPrimaryKey());
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

		Map<Locale, String> contentMap = getContentMap();

		for (Map.Entry<Locale, String> entry : contentMap.entrySet()) {
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

		String content = getContent(defaultLocale);

		if (Validator.isNull(content)) {
			setContent(getContent(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContent(getContent(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Board toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Board)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BoardImpl boardImpl = new BoardImpl();

		boardImpl.setBoardSeq(getBoardSeq());
		boardImpl.setTitle(getTitle());
		boardImpl.setContent(getContent());
		boardImpl.setGroupId(getGroupId());
		boardImpl.setCustomId(getCustomId());
		boardImpl.setWriterId(getWriterId());
		boardImpl.setWriterDate(getWriterDate());
		boardImpl.setReadCnt(getReadCnt());
		boardImpl.setGroupBoardSeq(getGroupBoardSeq());
		boardImpl.setGroupBoardTurn(getGroupBoardTurn());
		boardImpl.setReplyDepth(getReplyDepth());
		boardImpl.setSiteGroup(getSiteGroup());
		boardImpl.setPopupYn(getPopupYn());
		boardImpl.setPopupStartDt(getPopupStartDt());
		boardImpl.setPopupEndDt(getPopupEndDt());
		boardImpl.setInsertId(getInsertId());
		boardImpl.setInsertDt(getInsertDt());
		boardImpl.setUpdateId(getUpdateId());
		boardImpl.setUpdateDt(getUpdateDt());

		boardImpl.resetOriginalValues();

		return boardImpl;
	}

	@Override
	public int compareTo(Board board) {
		int value = 0;

		value = DateUtil.compareTo(getWriterDate(), board.getWriterDate());

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

		if (!(obj instanceof Board)) {
			return false;
		}

		Board board = (Board)obj;

		long primaryKey = board.getPrimaryKey();

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
	}

	@Override
	public CacheModel<Board> toCacheModel() {
		BoardCacheModel boardCacheModel = new BoardCacheModel();

		boardCacheModel.boardSeq = getBoardSeq();

		boardCacheModel.title = getTitle();

		String title = boardCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			boardCacheModel.title = null;
		}

		boardCacheModel.content = getContent();

		String content = boardCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			boardCacheModel.content = null;
		}

		boardCacheModel.groupId = getGroupId();

		boardCacheModel.customId = getCustomId();

		String customId = boardCacheModel.customId;

		if ((customId != null) && (customId.length() == 0)) {
			boardCacheModel.customId = null;
		}

		boardCacheModel.writerId = getWriterId();

		Date writerDate = getWriterDate();

		if (writerDate != null) {
			boardCacheModel.writerDate = writerDate.getTime();
		}
		else {
			boardCacheModel.writerDate = Long.MIN_VALUE;
		}

		boardCacheModel.readCnt = getReadCnt();

		boardCacheModel.groupBoardSeq = getGroupBoardSeq();

		boardCacheModel.groupBoardTurn = getGroupBoardTurn();

		boardCacheModel.replyDepth = getReplyDepth();

		boardCacheModel.siteGroup = getSiteGroup();

		String siteGroup = boardCacheModel.siteGroup;

		if ((siteGroup != null) && (siteGroup.length() == 0)) {
			boardCacheModel.siteGroup = null;
		}

		boardCacheModel.popupYn = getPopupYn();

		Date popupStartDt = getPopupStartDt();

		if (popupStartDt != null) {
			boardCacheModel.popupStartDt = popupStartDt.getTime();
		}
		else {
			boardCacheModel.popupStartDt = Long.MIN_VALUE;
		}

		Date popupEndDt = getPopupEndDt();

		if (popupEndDt != null) {
			boardCacheModel.popupEndDt = popupEndDt.getTime();
		}
		else {
			boardCacheModel.popupEndDt = Long.MIN_VALUE;
		}

		boardCacheModel.insertId = getInsertId();

		Date insertDt = getInsertDt();

		if (insertDt != null) {
			boardCacheModel.insertDt = insertDt.getTime();
		}
		else {
			boardCacheModel.insertDt = Long.MIN_VALUE;
		}

		boardCacheModel.updateId = getUpdateId();

		Date updateDt = getUpdateDt();

		if (updateDt != null) {
			boardCacheModel.updateDt = updateDt.getTime();
		}
		else {
			boardCacheModel.updateDt = Long.MIN_VALUE;
		}

		return boardCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{boardSeq=");
		sb.append(getBoardSeq());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", customId=");
		sb.append(getCustomId());
		sb.append(", writerId=");
		sb.append(getWriterId());
		sb.append(", writerDate=");
		sb.append(getWriterDate());
		sb.append(", readCnt=");
		sb.append(getReadCnt());
		sb.append(", groupBoardSeq=");
		sb.append(getGroupBoardSeq());
		sb.append(", groupBoardTurn=");
		sb.append(getGroupBoardTurn());
		sb.append(", replyDepth=");
		sb.append(getReplyDepth());
		sb.append(", siteGroup=");
		sb.append(getSiteGroup());
		sb.append(", popupYn=");
		sb.append(getPopupYn());
		sb.append(", popupStartDt=");
		sb.append(getPopupStartDt());
		sb.append(", popupEndDt=");
		sb.append(getPopupEndDt());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDt=");
		sb.append(getInsertDt());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDt=");
		sb.append(getUpdateDt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.multiboard.model.Board");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>boardSeq</column-name><column-value><![CDATA[");
		sb.append(getBoardSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customId</column-name><column-value><![CDATA[");
		sb.append(getCustomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerId</column-name><column-value><![CDATA[");
		sb.append(getWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerDate</column-name><column-value><![CDATA[");
		sb.append(getWriterDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readCnt</column-name><column-value><![CDATA[");
		sb.append(getReadCnt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupBoardSeq</column-name><column-value><![CDATA[");
		sb.append(getGroupBoardSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupBoardTurn</column-name><column-value><![CDATA[");
		sb.append(getGroupBoardTurn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replyDepth</column-name><column-value><![CDATA[");
		sb.append(getReplyDepth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteGroup</column-name><column-value><![CDATA[");
		sb.append(getSiteGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupYn</column-name><column-value><![CDATA[");
		sb.append(getPopupYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupStartDt</column-name><column-value><![CDATA[");
		sb.append(getPopupStartDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupEndDt</column-name><column-value><![CDATA[");
		sb.append(getPopupEndDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDt</column-name><column-value><![CDATA[");
		sb.append(getInsertDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDt</column-name><column-value><![CDATA[");
		sb.append(getUpdateDt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Board.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Board.class };
	private long _boardSeq;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _content;
	private String _contentCurrentLanguageId;
	private long _groupId;
	private String _customId;
	private long _writerId;
	private Date _writerDate;
	private int _readCnt;
	private int _groupBoardSeq;
	private int _groupBoardTurn;
	private int _replyDepth;
	private String _siteGroup;
	private boolean _popupYn;
	private Date _popupStartDt;
	private Date _popupEndDt;
	private long _insertId;
	private Date _insertDt;
	private long _updateId;
	private Date _updateDt;
	private Board _escapedModel;
}
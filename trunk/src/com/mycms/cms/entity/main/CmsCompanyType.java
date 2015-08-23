package com.mycms.cms.entity.main;

import java.util.Collection;
import java.util.Date;

import com.mycms.cms.entity.main.base.BaseCmsCompanyType;
import com.mycms.common.hibernate3.PriorityInterface;

public class CmsCompanyType extends BaseCmsCompanyType implements PriorityInterface {
	private static final long serialVersionUID = 1L;


	public static Integer[] fetchIds(Collection<CmsCompanyType> users) {
		if (users == null) {
			return null;
		}
		Integer[] ids = new Integer[users.size()];
		int i = 0;
		for (CmsCompanyType u : users) {
			ids[i++] = u.getId();
		}
		return ids;
	}

	/**
	 * 用于排列顺序。此处优先级为0，则按ID升序排。
	 */
	public Number getPriority() {
		return 0;
	}

	/**
	 * 是否是今天。根据System.currentTimeMillis() / 1000 / 60 / 60 / 24计算。
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		long day = date.getTime() / 1000 / 60 / 60 / 24;
		long currentDay = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
		return day == currentDay;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsCompanyType() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsCompanyType(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsCompanyType(java.lang.Integer id,
			java.lang.Integer parent,
			java.lang.String name,
			java.lang.String memo,
			java.lang.Integer code) {

		super(id, 
				parent,
				name,
				memo,
				code);
	}

	/* [CONSTRUCTOR MARKER END] */

}
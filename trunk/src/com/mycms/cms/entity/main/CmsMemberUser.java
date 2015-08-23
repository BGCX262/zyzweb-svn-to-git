package com.mycms.cms.entity.main;

import java.util.Collection;
import java.util.Date;

import com.mycms.cms.entity.main.base.BaseCmsMemberUser;
import com.mycms.common.hibernate3.PriorityInterface;

public class CmsMemberUser extends BaseCmsMemberUser implements PriorityInterface {
	private static final long serialVersionUID = 1L;


	public static Integer[] fetchIds(Collection<CmsMemberUser> users) {
		if (users == null) {
			return null;
		}
		Integer[] ids = new Integer[users.size()];
		int i = 0;
		for (CmsMemberUser u : users) {
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
	public CmsMemberUser() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMemberUser(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMemberUser(java.lang.Integer id,
			java.lang.String userMobile,
			java.lang.String mimsi,
			java.lang.String userName,
			java.lang.Integer userType,
			java.lang.String password,
			java.lang.Integer userGender,
			java.lang.String userEmail,
			java.lang.String userAddress,
			java.lang.String otherPhone,
			java.lang.String identifier,
			java.lang.String carType,
			java.lang.String validBeginDate,
			java.lang.String validPeriod,
			java.lang.String carNumber,
			java.lang.String suffixNum,
			java.lang.String carRegisterTime,
			java.lang.String userRegisterChannelId,
			java.lang.String userRegisterCpServiceId,
			java.util.Date registerTime,
			java.util.Date updateTime,
			java.lang.Integer userStatus,
			java.lang.String lastUpdateBy,
			java.util.Date lastUpdateTime,
			java.lang.String memo) {

		super(id, 
				userMobile,
				mimsi,
				userName,
				userType,
				password,
				userGender,
				userEmail,
				userAddress,
				otherPhone,
				identifier,
				carType,
				validBeginDate,
				validPeriod,
				carNumber,
				suffixNum,
				carRegisterTime,
				userRegisterChannelId,
				userRegisterCpServiceId,
				registerTime,
				updateTime,
				userStatus,
				lastUpdateBy,
				lastUpdateTime,
				memo);
	}

	/* [CONSTRUCTOR MARKER END] */

}
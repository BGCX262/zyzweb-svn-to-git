package com.mycms.cms.entity.main;

import java.util.Collection;
import java.util.Date;

import com.mycms.cms.entity.main.base.BaseMerchantMarking;
import com.mycms.common.hibernate3.PriorityInterface;

public class MerchantMarking extends BaseMerchantMarking implements PriorityInterface {
	private static final long serialVersionUID = 1L;


	public static Integer[] fetchIds(Collection<MerchantMarking> users) {
		if (users == null) {
			return null;
		}
		Integer[] ids = new Integer[users.size()];
		int i = 0;
		for (MerchantMarking u : users) {
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
	public MerchantMarking() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MerchantMarking(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MerchantMarking(
			java.lang.Integer id,
			java.lang.Integer merchantId,
			java.lang.String mtype,
			java.lang.Integer mdTopic,
			java.lang.String mcontent,
			java.lang.String mbTopic,
			java.lang.String mintroduction,
			java.lang.String mbPic,
			java.lang.String mdPic,
			java.util.Date opDate,
			java.lang.String operId,
			java.lang.String status) {

		super(id,
				merchantId,
				mtype,
				mdTopic,
				mcontent,
				mbTopic,
				mintroduction,
				mbPic,
				mdPic,
				opDate,
				operId,
				status);
	}

	/* [CONSTRUCTOR MARKER END] */

}
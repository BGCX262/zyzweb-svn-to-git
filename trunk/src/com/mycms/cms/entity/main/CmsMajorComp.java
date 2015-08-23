package com.mycms.cms.entity.main;

import java.util.Collection;
import java.util.Date;

import com.mycms.cms.entity.main.base.BaseCmsMajorComp;
import com.mycms.common.hibernate3.PriorityInterface;

public class CmsMajorComp extends BaseCmsMajorComp implements PriorityInterface {
	private static final long serialVersionUID = 1L;


	public static Integer[] fetchIds(Collection<CmsMajorComp> users) {
		if (users == null) {
			return null;
		}
		Integer[] ids = new Integer[users.size()];
		int i = 0;
		for (CmsMajorComp u : users) {
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
	public CmsMajorComp() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMajorComp(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMajorComp(
			java.lang.Integer id,
			java.lang.String name,
			java.lang.String typeid,
			java.lang.Integer recommand,
			java.lang.String province,
			java.lang.String city,
			java.lang.String country,
			java.lang.String pcode,
			java.lang.String address,
			java.lang.String telephone,
			java.lang.String fax,
			java.lang.String chief,
			java.lang.String chiefTelephone,
			java.lang.Integer isalliance,
			java.lang.Integer allianceid,
			java.lang.String auditBy,
			java.util.Date auditTime,
			java.lang.String createBy,
			java.util.Date createTime,
			java.lang.String image,
			java.lang.String guidepic,
			java.lang.Integer compLevel,
			java.lang.String tag,
			java.lang.String lng,
			java.lang.String lat,
			java.lang.Integer isoffset,
			java.lang.String sonId,
			java.lang.String content,
			java.lang.String proname,
			java.lang.String normalPrice,
			java.lang.String holddayPrice,
			java.lang.String mtype,
			java.lang.Integer mtrust,
			java.lang.Integer mdevice,
			java.lang.String mcontent,
			java.lang.Integer isact,
			java.lang.String actContent) {

		super(id,
				name,
				typeid,
				recommand,
				province,
				city,
				country,
				pcode,
				address,
				telephone,
				fax,
				chief,
				chiefTelephone,
				isalliance,
				allianceid,
				auditBy,
				auditTime,
				createBy,
				createTime,
				image,
				guidepic,
				compLevel,
				tag,
				lng,
				lat,
				isoffset,
				sonId,
				content,
				proname,
				normalPrice,
				holddayPrice,
				mtype,
				mtrust,
				mdevice,
				mcontent,
				isact,
				actContent);
	}

	/* [CONSTRUCTOR MARKER END] */

}
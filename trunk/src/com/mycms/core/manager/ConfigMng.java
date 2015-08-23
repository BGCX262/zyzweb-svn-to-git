package com.mycms.core.manager;

import java.util.Map;

import com.mycms.common.email.EmailSender;
import com.mycms.common.email.MessageTemplate;
import com.mycms.core.entity.Config;
import com.mycms.core.entity.Config.ConfigLogin;

public interface ConfigMng {
	public Map<String, String> getMap();

	public ConfigLogin getConfigLogin();

	public EmailSender getEmailSender();

	public MessageTemplate getMessageTemplate();

	public String getValue(String id);

	public void updateOrSave(Map<String, String> map);

	public Config updateOrSave(String key, String value);

	public Config deleteById(String id);

	public Config[] deleteByIds(String[] ids);
}
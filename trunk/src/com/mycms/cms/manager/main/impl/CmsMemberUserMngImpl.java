package com.mycms.cms.manager.main.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycms.cms.dao.main.CmsMemberUserDao;
import com.mycms.cms.entity.main.CmsMemberUser;
import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.cms.manager.main.CmsMemberUserMng;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;
import com.mycms.common.security.encoder.PwdEncoder;
import com.mycms.core.manager.UnifiedUserMng;

@Service
@Transactional
public class CmsMemberUserMngImpl implements CmsMemberUserMng {
	@Transactional(readOnly = true)
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize) {
		Pagination page = dao.getPage(username, email, siteId, groupId,
				disabled, admin, rank, pageNo, pageSize);
		return page;
	}

	public CmsMemberUser save(CmsMemberUser bean) {
		if(bean != null && bean.getPassword() != null && !"".equals(bean.getPassword()))
		{
			bean.setPassword(MD5(bean.getPassword()));
		}
		if(bean != null && (bean.getUserStatus() == null || "".equals(bean.getUserStatus())))
		{
			bean.setUserStatus(1);
		}
		dao.save(bean);
		return bean;
	}
	@Transactional(readOnly = true)
	public List<CmsMemberUser> getAdminList(Integer siteId, Boolean allChannel,
			Boolean disabled, Integer rank) {
		return dao.getAdminList(siteId, allChannel, disabled, rank);
	}

	@Transactional(readOnly = true)
	public CmsMemberUser findById(Integer id) {
		CmsMemberUser entity = dao.findById(id);
		return entity;
	}

	public CmsMemberUser getByUsernamePsw(String username,String password)
	{
		if(password != null && !"".equals(password))
		{
			password = MD5(password);
		}
		return dao.getByUsernamePsw(username,password);		
	}
	public CmsMemberUser getByUsernameEmail(String username,String email)
	{
		return dao.getByUsernameEmail(username,email);		
	}
	
	@Transactional(readOnly = true)
	public CmsMemberUser findByUsername(String username) {
		CmsMemberUser entity = dao.findByUsername(username);
		return entity;
	}


	public boolean isPasswordValid(Integer id, String password) {
		return unifiedUserMng.isPasswordValid(id, password);
	}


	public void sendEmail(String username,String email)
	{
       try {
            
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);

            InternetAddress toList[] = InternetAddress.parse(email, false);
            msg.addRecipients(MimeMessage.RecipientType.TO, toList);

            msg.setSentDate(new Date());

            msg.setSubject("您好，悦行100登录密码！");


            final String resumeURL = "您好，您的密码为123456，请务必尽快修改密码";
            msg.setDataHandler(new DataHandler(new DataSource() {
                public InputStream getInputStream() throws java.io.IOException {
                    //return (new URL(resumeURL)).openStream();
                return new ByteArrayInputStream(resumeURL.getBytes());
                }

                public OutputStream getOutputStream() throws java.io.IOException {
                    throw new IOException("it does not support this method now!");
                }

                public java.lang.String getContentType() {
                    return "text/html; charset=GBK";
                }

                public java.lang.String getName() {
                    return "test";
                }
            }));

            msg.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.sendMessage(msg, toList);
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	

	public CmsMemberUser updateMember(Integer id, CmsMemberUser bean,String email, String password,
			Boolean isDisabled, CmsUserExt ext, Integer groupId) {
		if(bean != null && bean.getPassword() != null && !"".equals(bean.getPassword()))
		{
			bean.setPassword(MD5(bean.getPassword()));
		}
		Updater<CmsMemberUser> updater = new Updater<CmsMemberUser>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsMemberUser deleteById(Integer id) {
		unifiedUserMng.deleteById(id);
		CmsMemberUser bean = dao.deleteById(id);
		return bean;
	}

	public CmsMemberUser[] deleteByIds(Integer[] ids) {
		CmsMemberUser[] beans = new CmsMemberUser[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	public boolean usernameNotExist(String username) {
		return dao.countByUsername(username) <= 0;
	}

	public boolean emailNotExist(String email) {
		return dao.countByEmail(email) <= 0;
	}

	private UnifiedUserMng unifiedUserMng;
	private CmsMemberUserDao dao;

	private PwdEncoder pwdEncoder;
	@Autowired
	public void setUnifiedUserMng(UnifiedUserMng unifiedUserMng) {
		this.unifiedUserMng = unifiedUserMng;
	}


	@Autowired
	public void setDao(CmsMemberUserDao dao) {
		this.dao = dao;
	}


	public void setPwdEncoder(PwdEncoder pwdEncoder) {
		this.pwdEncoder = pwdEncoder;
	}

	// MD5加码。32位 
	public String MD5(String inStr) { 
	  MessageDigest md5 = null; 
	  try { 
	   md5 = MessageDigest.getInstance("MD5"); 
	  } catch (Exception e) { 
	   System.out.println(e.toString()); 
	   e.printStackTrace(); 
	   return ""; 
	  } 
	  char[] charArray = inStr.toCharArray(); 
	  byte[] byteArray = new byte[charArray.length]; 

	  for (int i = 0; i < charArray.length; i++) 
	   byteArray[i] = (byte) charArray[i]; 

	  byte[] md5Bytes = md5.digest(byteArray); 

	  StringBuffer hexValue = new StringBuffer(); 

	  for (int i = 0; i < md5Bytes.length; i++) { 
	   int val = ((int) md5Bytes[i]) & 0xff; 
	   if (val < 16) 
	    hexValue.append("0"); 
	   hexValue.append(Integer.toHexString(val)); 
	  } 

	  return hexValue.toString(); 
	} 

}
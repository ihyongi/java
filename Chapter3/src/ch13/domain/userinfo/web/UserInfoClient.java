package ch13.domain.userinfo.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ch13.domain.userinfo.UserInfo;
import ch13.domain.userinfo.dao.UserInfoDAO;
import ch13.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import ch13.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class UserInfoClient {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("db.properties"); //파일 읽기
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String dbType = prop.getProperty("DBTYPE");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPasswd("!@#$%");
		userInfo.setUserName("이순신");
		
		
		UserInfoDAO userInfoDao = null;
		
		if(dbType.equals("ORACLE")){
			userInfoDao = new UserInfoOracleDao();
		}
		else if(dbType.endsWith("MYSQL")){
			userInfoDao = new UserInfoMySqlDao();
		}
		else{
			System.out.println("db support error");
			return;
		}
		
		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInf(userInfo);

	}

}

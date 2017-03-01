/**
 * @(#)ConnectDB.java
 *
 *
 * @author tao cheng hong
 * @version 1.00 2009/11/26
 */


package iuser.com.db;

import java.sql.*;

public class ConDB
{
	//数据库用户名
	String userName=DBinfo.USERNAME;
	//数据库密码
	String userPassword=DBinfo.PASSWORD;
	//数据库的URL，包括连接数据库所使用的编码格式
	String url=DBinfo.URL+"?useUnicode=true&characterEncoding=UTF-8";
	//定义一个连接对象
	Connection dbConn;
	//错误信息串
	String errMes;

   	public ConDB()
   	{
   		//初始化操作
		errMes="";
   		dbConn=null;
   	}

	//连接数据库
   	public Connection getConn()
   	{
	   	try
	   	{
			//声明所用的类包
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库的连接对象
			dbConn= DriverManager.getConnection(url,userName,userPassword);
	   	}
	   	catch(Exception e)
	   	{
	   		dbConn = null;
	   		errMes=e.toString();
	   	}
	   	return dbConn;
   }

   //获取错误信息
   public String getErrMes()
   {
   		return errMes;
   }
}

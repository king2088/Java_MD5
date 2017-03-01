/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuser.com.db;

import java.sql.*;

/**
 *
 * @author 深夜徘徊
 */
public class User extends ExeDB{
    //定义类成员变量
    public String uname;
    private String pwd;
    public String sex;
    public String address;
    public String email;
    public String tel;
    private String strSql;
    //构造函数，对成员变量进行初始化赋值
	public User()
	{
		super();
		this.uname="";
		this.pwd="";
		this.sex="";
                this.address="";
		this.email="";
		this.tel="";
		this.strSql="";
	}
        //添加新用户，往users数据表中添加一条新记录
	public boolean add()
	{
            //
            this.strSql="INSERT INTO user";
            this.strSql=this.strSql + "(uname,pwd,sex,address,email,tel) ";//这里必须有空格
            this.strSql=this.strSql + "VALUES('" + this.uname + "','" + this.pwd + "','" + this.sex + "','" + this.address + "','" + this.email + "','" + this.tel + "')";
            boolean isAdd = super.exeSql(this.strSql);
            return isAdd;
	}

        //验证用户名和密码是否正确
	public boolean valid()
	{
		this.strSql="select * from `user` ";
		this.strSql=this.strSql + " where uname='" + this.uname + "'";
		this.strSql=this.strSql + "  and pwd='"+ this.pwd + "'";
		System.out.println(this.strSql);

		try
		{
			ResultSet rs = super.exeQuery(this.strSql);
			if (rs.next())
			{
				
				this.uname=rs.getString("uname");
                                this.sex=rs.getString("sex");
                                this.address=rs.getString("address");
                                this.email=rs.getString("email");
                                this.tel=rs.getString("tel");
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			return false;
		}
	}
        


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStrSql() {
        return strSql;
    }

    public void setStrSql(String strSql) {
        this.strSql = strSql;
    }

       
       
        
}

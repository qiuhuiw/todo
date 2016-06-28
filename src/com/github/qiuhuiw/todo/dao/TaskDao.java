package com.github.qiuhuiw.todo.dao;

import com.github.qiuhuiw.todo.model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by emily on 16-6-28.
 */
public class TaskDao {
    static String driver;
    static String url;
    static String username;
    static String password;

    public TaskDao(){
        try{
            Properties pro=new Properties();
            pro.load(this.getClass().getResourceAsStream("db.properties"));
            driver=pro.getProperty("driver");
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public List getTaskList(){

        List list=new ArrayList();
        try{
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url, username, password);
            Statement stat=conn.createStatement();
            stat.executeQuery("select * from task;");
            ResultSet rs= stat.getResultSet();
            while(rs.next()){
                Task task=new Task();
                task.setId(rs.getInt("id"));
                task.setTname(rs.getString("tname"));
                task.setDescription(rs.getString("description"));
                list.add(task);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

}

package cn.wscode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author wangSheng
 * @title: ImpalaExample
 * @projectName DMP
 * @description: TODO 连接impala
 * @date 2022/3/17 16:48
 */
public class ImpalaExample {
    public static void main(String[] args) throws Exception {
        //默认连接default库
        String connectionUrl = "jdbc:impala://39.97.236.248:21050/shanqian_fact";
        //使用4.1版本
        String jdbcDriverName = "com.cloudera.impala.jdbc.Driver";
        //String jdbcDriverName = "org.apache.hive.jdbc.HiveDriver";
        //简单的一个查询语句
        String sqlStatement = "show tables;";

        //加载驱动
        Class.forName(jdbcDriverName);
        Connection con = DriverManager.getConnection(connectionUrl);
        try {
            //查询
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatement);
            System.out.println("---begin query---");

            //打印输出
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println("---end query---");
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.close();
    }
}

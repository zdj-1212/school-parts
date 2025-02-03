package cn.cslg.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlsessionUtil {
    static SqlSessionFactory factory;
    static {
        String file="mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(file);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSs(){
        return factory.openSession();
    }
}

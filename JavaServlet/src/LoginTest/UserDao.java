package LoginTest;

import CookieSession.Page;
import org.junit.Test;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDao
{
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    //登录方法
    public User login(User loginUser)
    {

        try
        {
            String sql = "select * from user where Number = ? and Password = ? ";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getNumber(), loginUser.getPassword());
            return user;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    //查询方法
    public List<User> findAll()
    {
        try
        {
            String sql = "select * from user ";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(User user)
    {
        try
        {
            String sql = "insert into user values (?,?,?,?)";
            template.update(sql, user.getNumber(), user.getPassword(), user.getName(), user.getAge());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void del(String[] uids)
    {
        for (String username : uids)
        {
            this.delete(username);
        }
    }

    public void delete(String s)
    {

        try
        {
            String sql = "delete from user where Number = ?";
            template.update(sql, s);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void update(User user)
    {
        try
        {
            String sql = "UPDATE user set Password=?,Name=?,Age=? where Number=?";
            template.update(sql, user.getPassword(), user.getName(), user.getAge(), user.getNumber());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public User find(String number)
    {
        try
        {
            String sql = "select * from user where Number=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), number);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findPage(int start, int rows, Map<String, String[]> map)
    {
        try
        {
            String sql = "select * from user where Name like ? and Age >= ? and Age <= ? limit ? ,?";
            String _name = map.get("name")[0];
            String age1 = map.get("age1")[0];
            String age2 = map.get("age2")[0];
            if ((age1 == null || "".equals(age1)) && (age2 == null || "".equals(age2)))
            {
                age1 = "0";
                age2 = "130";
            }
            if ((age1 == null || "".equals(age1)) & (age2 != null))
            {
                age1 = "0";
                age2 = map.get("age2")[0];
            }
            else
            {
                age1 = map.get("age1")[0];
                age2 = "130";

            }

            String name = "%" + _name + "%";
            return template.query(sql, new BeanPropertyRowMapper<User>(User.class), name, age1, age2, start, rows);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findPage(int start, int rows)
    {
        try
        {
            String sql = "select * from user limit ? ,?";
            return template.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public int findTotalCount(Map<String, String[]> map)
    {
        try
        {
            String sql = "select count(*) from user where Name like ? and Age >= ? and Age <= ?";
            String _name = map.get("name")[0];
            String age1 = map.get("age1")[0];
            String age2 = map.get("age2")[0];
            if ((age1 == null || "".equals(age1)) && (age2 == null || "".equals(age2)))
            {
                age1 = "0";
                age2 = "130";
            }
            if ((age1 == null || "".equals(age1)) & (age2 != null))
            {
                age1 = "0";
                age2 = map.get("age2")[0];
            }
            else
            {
                age1 = map.get("age1")[0];
                age2 = "130";

            }
            String name = "%" + _name + "%";
            return template.queryForObject(sql, Integer.class, name, age1, age2);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int findTotalCount()
    {
        try
        {
            String sql = "select count(*) from user ";
//            StringBuilder sb=new StringBuilder(sql);   条件组合查询
//            Set<String> keySet = map.keySet();
//            //定义参数集合
//            List<Object> params=new ArrayList<Object>();
//            for (String key:keySet)
//            {
//                //排除分页和行数
//                if("currentPage".equals(key)||"rows".equals(key))
//                {
//                    continue;
//                }
//                String value = map.get(key)[0];
//                if(value!=null &&"".equals(value))
//                {
//                    sb.append(" and " +key+ " like ? ");
//                    params.add("%"+value+"%");//?条件的值
//                }
//            }
            return template.queryForObject(sql, Integer.class);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

//    @Test
//    public void test()
//    {
//        User loginUser=new User();
//        loginUser.setNumber("1001");
//        loginUser.setPassword("123456");
//        UserDao doUser=new UserDao();
//        User user = doUser.login(loginUser);
//        System.out.println(user);
//    }

}

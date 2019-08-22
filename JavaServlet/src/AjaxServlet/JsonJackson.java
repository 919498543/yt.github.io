package AjaxServlet;


import LoginTest.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/*
* java对象转换为json对象
*
* */
public class JsonJackson
{
    @Test
    public void test() throws Exception
    {
        //创建user对象
        User u=new User();
        u.setName("张三");
        u.setAge(18);
        //创建jackson的核心对象
        ObjectMapper mapper =new ObjectMapper();
        //转换
        //转换方法:
        /*  writeValue(参数1，obj):
                    参数1:
                        File:将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream:将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
            writeValueAsString(obj) :将对象转为json字符串
         */
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

    }
}

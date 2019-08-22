package LoginTest;

public class User
{
    private String number;
    private String password;
    private String name;
    private Integer age;


    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        if (age > 0 && age < 130)
        {
            this.age = age;
        }
        else
        {
            this.age = 0;
        }
    }

    @Override
    public String toString()
    {
        return "User{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

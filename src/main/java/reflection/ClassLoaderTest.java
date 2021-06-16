package reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {

    @Test
    public void test() throws IOException {

        Properties pros = new Properties();
        //方式1：
//        FileInputStream fis = new FileInputStream("jdbc1.properties");
//        pros.load(fis);
        //
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name+password);

    }
}

package jsonplaceholder.tests;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@Listeners({ExtentITestListenerAdapter.class})
public class BaseTest {
    public void loadProperties(){
        Properties prop = System.getProperties();
        try {
            prop.load(new FileInputStream("src/test/resources/EndPoints.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

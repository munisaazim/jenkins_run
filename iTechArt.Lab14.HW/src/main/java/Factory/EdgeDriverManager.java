package Factory;


import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
    public EdgeDriverManager(){
        driver = new EdgeDriver();
    }
}

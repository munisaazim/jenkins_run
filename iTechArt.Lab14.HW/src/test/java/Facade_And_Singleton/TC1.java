package Facade_And_Singleton;

import org.testng.annotations.Test;

public class TC1 {
    FacadeStructure facadeStructure;
    @Test
    public void runTests(){
        facadeStructure = new FacadeStructure();
        facadeStructure.FacadeStructureRun();
    }
}

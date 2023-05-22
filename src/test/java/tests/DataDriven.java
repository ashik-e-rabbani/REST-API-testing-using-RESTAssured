package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {

    /*
    Below method is a TestNG data provider that generates test data for the test method dataGeneration.
    the generateUserData method now returns an Object[][] array that contains the test data. Each row in
    the array represents a set of test data.
     */
    @DataProvider(name = "userData")
    public Object[][] generateUserData() {
        return new Object[][]{
                {"Ashik"},
                {"Rabbani"}
        };
    }

    /*
    If we run the dataGeneration() test, It will bring the data from generateUserData
    then pass it as a param to dataGeneration method.
     */
    @Test(dataProvider = "userData")
    public void dataGeneration(String name){

        System.out.println(name);

    }
}

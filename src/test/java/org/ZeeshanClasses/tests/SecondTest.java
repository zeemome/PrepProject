package org.ZeeshanClasses.tests;


import org.ZeeshanClasses.base.PrepBases;
import org.ZeeshanClasses.customs.PrepProj;
import org.testng.annotations.Test;


public class SecondTest extends PrepBases {

    @Test
    @PrepProj(id = "TC02", description = "Another test here", createdBy = "Zeeshan")
    public void doMore(){
        driver.navigate().to("https://www.facebook.com");
    }
}

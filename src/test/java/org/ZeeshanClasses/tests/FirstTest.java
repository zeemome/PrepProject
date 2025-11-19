package org.ZeeshanClasses.tests;

import org.ZeeshanClasses.base.PrepBases;
import org.ZeeshanClasses.customs.PrepProj;
import org.testng.annotations.Test;


public class FirstTest extends PrepBases {

    @Test
    @PrepProj(id = "TC_001", description = "First attempt", createdBy = "Zeeshan")
    public void loginIntoPage(){
        driver.get("https://www.google.com");


    }
}

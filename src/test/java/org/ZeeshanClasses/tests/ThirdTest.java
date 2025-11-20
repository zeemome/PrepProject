package org.ZeeshanClasses.tests;

import org.ZeeshanClasses.base.PrepBases;
import org.ZeeshanClasses.customs.PrepProj;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThirdTest extends PrepBases {
    @Test
    @PrepProj(id="TC004", description = "Another test to test webhooks", createdBy = "Zeeshan")
    public void letsCallThisMethod() throws InterruptedException{
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Messenger")).click();
        Thread.sleep(10000);
        System.out.println("Addition of a line");
    }
}

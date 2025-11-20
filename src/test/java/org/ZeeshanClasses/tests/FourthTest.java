package org.ZeeshanClasses.tests;

import org.ZeeshanClasses.base.PrepBases;
import org.ZeeshanClasses.customs.PrepProj;
import org.testng.annotations.Test;

public class FourthTest extends PrepBases {

    @Test
    @PrepProj(id="TC_005", description = "trial of branches", createdBy = "Zeeshan")
    public void runThisToo(){
        System.out.println("This is to test branch and webhook work");
    }

}

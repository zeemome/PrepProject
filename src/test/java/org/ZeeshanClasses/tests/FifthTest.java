package org.ZeeshanClasses.tests;

import org.ZeeshanClasses.customs.PrepProj;
import org.testng.annotations.Test;

public class FifthTest {
    @Test
    @PrepProj(id="TC_006", description = "This is from another user", createdBy = "Zeeshan Azad")
    public void anotherUserMethodHere(){
        System.out.println("This is the end");
        System.out.println("I am done and drowning");
    }
}

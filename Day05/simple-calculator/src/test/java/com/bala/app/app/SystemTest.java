package com.bala.app.app;

import com.bala.app.Calculator;
import org.junit.Test;

public class SystemTest {

    @Test
    public void test() {
        Calculator calculator = new Calculator();
        double a=calculator.addition(10,5);
        assert a==15;
    }
}

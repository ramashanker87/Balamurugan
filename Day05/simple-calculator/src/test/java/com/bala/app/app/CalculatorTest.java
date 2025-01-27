package com.bala.app.app;

import com.bala.app.Calculator;
import org.junit.Test;

import java.util.Calendar;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calc = new Calculator();
    double a= calc.addition(5,5);
    assert a == 10.0;
  }
  @Test
  public void testDivide() {
    Calculator calc = new Calculator();
    double d=calc.divide(10,2);
  assert d == 5.0;
  }

  }



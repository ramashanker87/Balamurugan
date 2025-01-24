package com.rama.app.customexception;

public class SalaryDetails {
    public static void main(String[] args) {
    SalaryDetails obj = new SalaryDetails();
    try{
        int salary=5000;
        if(salary<45000){
        throw new SalaryValidation("Salary must be 50000 and above");
        }
    }catch (SalaryValidation e){
        e.printStackTrace();
        System.out.println(e.getMessage());
    }finally {
        System.out.println("Tax salary validation completed");
    }
    }
}

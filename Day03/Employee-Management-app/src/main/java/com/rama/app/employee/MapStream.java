package com.rama.app.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {
    String Name;
    int Age;
    String Company;
    String ID;
    Integer Salary;
    public MapStream(String name, String ID, int age, String company, Integer salary) {
        this.Name = name;
        this.Age = age;
        this.Company = company;
        this.ID = ID;
        this.Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public static void main(String[] args) {
        List<MapStream> emp =new ArrayList<>();
        emp.add(new MapStream("Sunil","456",30,"XYZ",50000));
        emp.add(new MapStream("Bala","123",20,"ABC",15000));
        emp.add(new MapStream("Vijay","2829",23,"RD",20000));
        emp.add(new MapStream("Arun","4325",40,"Notex",35000));

        Map<String,Integer> FilterSalary = emp.stream().filter(emp1 -> emp1.getSalary()<40000).collect(Collectors.toMap(MapStream::getName, MapStream::getSalary));

        System.out.println(FilterSalary);

        Map<String,Integer> FilterAge = emp.stream().filter(emp1 -> emp1.getAge()>25).collect(Collectors.toMap(MapStream::getName, MapStream::getAge));
        System.out.println(FilterAge);



    }



}

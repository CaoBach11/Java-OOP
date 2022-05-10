package asm3.HumanResourecs;

import java.text.DecimalFormat;
import java.util.Date;

public class Employee extends Staff implements ICalculator{
    //    Khai báo biến overTime cho nhân viên
    private float overTime;

    public Employee(int idStaff, String nameStaff, int ageStaff, float coefficientSalary, String dateBegin,
                    Department department, int annualDays, float overTime) {

        super(idStaff, nameStaff, ageStaff, coefficientSalary, dateBegin, department, annualDays);
        this.overTime = overTime;
    }

    public float getOverTime() {
        return overTime;
    }

    public void setOverTime(float overTime) {
        this.overTime = overTime;
    }

    @Override
    public float salaryCalculator() {

        return super.getCoefficientSalary() * 3000000 + overTime * 200000;
    }

    //Dùng hàm displayInformation để hiện thị thông tin chung của nhân viên
    public void displayInformation() {
        String format = "%-6s %-20s %-6s %-19s %-15s %-15s %-15s %-18s\n";

        System.out.printf(format,super.getIdStaff(),super.getNameStaff(),super.getAgeStaff(),super.getCoefficientSalary()
                ,super.getDateBegin(),super.getDepartment().getNameDeparment(),super.getAnnualDays(),getOverTime());


    }

}

package asm3.HumanResourecs;

import java.text.DecimalFormat;
import java.util.Date;

public class Manager extends Staff implements ICalculator{
    private String position;

    public Manager(int idStaff, String nameStaff, int ageStaff, float coefficientSalary, String dateBegin,
                   Department department, int annualDays, String position) {

        super(idStaff, nameStaff, ageStaff, coefficientSalary, dateBegin, department, annualDays);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public float salaryCalculator() {
        float basicSalary = super.getCoefficientSalary() * 5000000;

        if (position.equals("Business leader")) {
            basicSalary +=  8000000;

        } else if(position.equals("Technical Leader")){
            basicSalary +=  6000000;

        }else{
            basicSalary +=  5000000;
        }

        return basicSalary;
    }

    public void displayInformation(){
        String format = "%-6s %-20s %-6s %-19s %-15s %-15s %-15s %-18s\n";
        System.out.printf(format,super.getIdStaff(),super.getNameStaff(),super.getAgeStaff(),super.getCoefficientSalary()
                ,super.getDateBegin(),super.getDepartment().getNameDeparment(),super.getAnnualDays(),getPosition());

    }
}

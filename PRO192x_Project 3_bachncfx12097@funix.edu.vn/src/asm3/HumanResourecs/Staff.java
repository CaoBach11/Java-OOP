package asm3.HumanResourecs;

import java.util.Date;

public abstract class Staff implements ICalculator {
//    Khai báo các biến thông tin chung cho nhân viên của công ty

    private int idStaff;
    private String nameStaff;
    private int ageStaff;
    private float coefficientSalary;
    private String dateBegin;
    private Department department;
    private int annualDays;
//     Tạo hàm constructor để lưu giá trị thông tin

    public Staff(int idStaff, String nameStaff, int ageStaff, float coefficientSalary, String dateBegin,
                 Department department, int annualDays) {

        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.coefficientSalary = coefficientSalary;
        this.dateBegin = dateBegin;
        this.department = department;
        this.annualDays = annualDays;
    }
// Tạo getter đọc dữ liệu từ các phần tử bên ngoài


    public int getIdStaff() {
        return idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public int getAgeStaff() {
        return ageStaff;
    }

    public float getCoefficientSalary() {
        return coefficientSalary;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public Department getDepartment() {
        return department;
    }

    public int getAnnualDays() {
        return annualDays;
    }

// Tạo setter để ghi dữ liệu của phần tử

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public void setAgeStaff(int ageStaff) {
        this.ageStaff = ageStaff;
    }

    public void setCoefficientSalary(float coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAnnualDays(int annualDays) {
        this.annualDays = annualDays;
    }

    public abstract void displayInformation();

    @Override
    public float salaryCalculator() {
        return 0;
    }
}

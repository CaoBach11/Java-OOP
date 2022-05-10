package asm3.HumanResourecs;

public class Department {
    private String idDepartment;
    private String nameDeparment;
    private int numEmployee = 0;

    public Department(String idDepartment, String nameDeparment) {
        this.idDepartment = idDepartment;
        this.nameDeparment = nameDeparment;
        this.numEmployee = 0;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDeparment() {
        return nameDeparment;
    }

    public void setNameDeparment(String nameDeparment) {
        this.nameDeparment = nameDeparment;
    }

    public int getNumEmployee() {
        return numEmployee;
    }

    public void setNumEmployee(int numEmployee) {
        this.numEmployee = numEmployee;
    }

    public void increaseNumEmployee() {
        this.numEmployee++;
    }

    @Override
    public String toString() {


        return String.format("|| ID = %s || Department = %10s || Employee = %4d people  ||",
                this.idDepartment, this.nameDeparment, this.numEmployee);
    }


}

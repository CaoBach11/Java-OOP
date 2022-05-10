package asm3.HumanResourecs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResources {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Staff> employeeList = new ArrayList<>();
    public static ArrayList<Department> departmentList = new ArrayList<>();

    public static void main(String[] args) {
        String answer;
        createDepartment();
        do {
            answer = "No";
            int num = input();
            activeFunction(num);
            if(num != 8){
                do {
                    System.out.println("Bạn có muốn tiếp tục(Yes/No): ");
                    answer = sc.next();

                }while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes") ||
                        answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No")));
            }

        } while (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes"));

    }
    //      Tạo hàm input để người dùng nhập các chức năng
    public static int input() {
        int numFunction;
        do {
            System.out.println("ỨNG DỤNG QUẢN LÝ NHÂN SỰ");
            System.out.println();
            System.out.println("VUI LÒNG CHỌN 1 TRONG CÁC THAO TÁC DƯỚI ĐÂY: ");
            System.out.println();
            System.out.println("1.Hiển thị danh sách nhân viên hiện có trong công ty.");
            System.out.println("2.Hiển thị các bộ phận trong công ty.");
            System.out.println("3.Hiển thị các nhân viên theo từng bộ phận.");
            System.out.println("4.Thêm nhân viên mới vào công ty.");
            System.out.println("5.Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
            System.out.println("6.Hiển thị bảng lương của nhân viên toàn công ty.");
            System.out.println("7.Hiển thị bảng lương của nhân viên theo thứ tự tăng hoặc giảm dần.");
            System.out.println("8.Kết thúc");
            System.out.print("Vui lòng nhập số từ 1 - 8: ");
            numFunction = sc.nextInt();

        } while ((numFunction < 1) || (numFunction > 8));
        return numFunction;
    }
    //  Tạo switch để chọn chức năng
    public static void activeFunction(int numFunction){
        switch (numFunction) {
            case 1:
                employee();
                break;
            case 2:
                department();
                break;
            case 3:
                printEmloyeeOfDepartment();
                break;
            case 4:
                addEmployee();
                break;
            case 5:
                searchEmployee();
                break;
            case 6:
                salaryList(employeeList);
                break;
            case 7:
                increaseOrDecreaseSalary();
                break;
        }
    }

    //  Tạo hàm employee để hiện thị danh sách nhân viên
    public static void employee() {
        System.out.println();
        System.out.println("HIỆN THỊ DANH SÁCH NHÂN VIÊN ");
        printHeader();
        for (int ii = 0; ii < employeeList.size(); ii++) {
            employeeList.get(ii).displayInformation();
        }
    }
    //  Tạo hàm employee để thêm nhân viên mới vào công ty bao gồm nhân viên thường và nhân viên cấp quản lý
    public static void addEmployee() {
        System.out.println();
        System.out.println("Thêm nhân viên mới vào công ty");
        System.out.println("Bao gồm 2 loại:");
        System.out.println("1.Thêm nhân viên thông thường.");
        System.out.println("2.Thêm nhân viên cấp quản lý(bao gồm chức vụ).");
        System.out.println("Vui lòng chọn (1/2)");
        int check;
        int addNum = sc.nextInt();
        int employeeCode = employeeList.size() + 1;
        sc.nextLine();

        System.out.print("Name: ");
        String employeeName = sc.nextLine();

        System.out.print("Age: ");
        int employeeAge = sc.nextInt();

        System.out.print("Coefficient Salary: ");
        float coefficientSalary = sc.nextFloat();

        System.out.print("Date begin: ");
        String dateBegin = sc.next();

        System.out.println("Department: ");
        //  Tạo hàm For lấy danh sách department sau khi nhập
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(i + 1 + ": " + departmentList.get(i).getNameDeparment());
        }
        check = sc.nextInt();

        //  Yêu cầu nhập lại nếu sai
        while (check - 1 >= departmentList.size() || check - 1 < 0) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            System.out.println("Department: ");

            for (int i = 0; i < departmentList.size(); i++) {
                System.out.println(i + 1 + ": " + departmentList.get(i).getNameDeparment());
            }
            check = sc.nextInt();
        }
        Department department = departmentList.get(check - 1);
        System.out.print("Days of annual leave: ");
        int leaveDays = sc.nextInt();

        do {

            if (addNum == 1) {
                System.out.print("Over time: ");
                float overTime = sc.nextFloat();
                Staff employee = new Employee(employeeCode, employeeName, employeeAge, coefficientSalary, dateBegin,
                        department, leaveDays, overTime);

                employeeList.add(employee);
                department.increaseNumEmployee();
            } else {
                System.out.print("Position: \n"
                        + "1. Business Leader\n"
                        + "2. Technical Leader\n"
                        + "3. Project Leader\n");
                int getIn = sc.nextInt();
                String position = "";
                while (getIn < 1 || getIn > 3 ) {
                    System.out.println("Vui lòng nhập mã hợp lệ!");
                    System.out.print("Position: \n"
                            + "1. Business Leader\n"
                            + "2. Technical Leader\n"
                            + "3. Project Leader\n");
                    getIn = sc.nextInt();
                }
                if (getIn == 1) {
                    position = "Business Leader";
                } else if (getIn == 2) {
                    position = "Technical Leader";
                } else {
                    position = "Project Leader";
                }
                Staff manager = new Manager(employeeCode, employeeName, employeeAge, coefficientSalary, dateBegin,
                        department, leaveDays, position);

                employeeList.add(manager);
                department.increaseNumEmployee();
            }
        } while (addNum != 1 && addNum != 2);
    }

    //  Tạo hàm employeeAndDepartment để hiện thị nhân viên theo từng bộ phận
    public static void printEmloyeeOfDepartment() {
        System.out.println("HIỂN THỊ NHÂN VIÊN THEO TỪNG BỘ PHẬN");
        for (int i = 0; i < departmentList.size(); i++) {
            int num = 0;
            System.out.println(departmentList.get(i));
            printHeader();
            for (int j = 0; j < employeeList.size(); j++) {
                if (employeeList.get(j).getDepartment().equals(departmentList.get(i))) {
                    num++;
                    employeeList.get(j).displayInformation();
                }
            }
        //  Thông báo nếu bộ phận không có nhân viên
            if (num == 0) {
                System.out.println("Bộ phận này chưa có nhân viên!");
            }
            System.out.println();
        }
    }

    //  Tạo hàm createDepartment để thêm phòng ban vào công ty
    public static void createDepartment(){
        Department department = new Department("BUS","Business");
        departmentList.add(department);
        department = new Department("TEC","Technical");
        departmentList.add(department);
        department = new Department("PRO","Project");
        departmentList.add(department);

    }

    //  Tạo hàm department để hiển thị thông tin bộ phận
    public static void department() {

        System.out.println();
        System.out.println("HIỂN THỊ BỘ PHẬN CÔNG TY");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i));
        }

    }

    //  Tạo hàm searchEmployee để tìm kiếm thông tin nhân viên theo mã hoặc tên
    public static void searchEmployee(){
        System.out.println("TÌM THÔNG TIN NHÂN VIÊN");
        System.out.println("1.Tìm theo mã: ");
        System.out.println("2.Tìm theo tên: ");
        int idEmployee = 0;
        String nameEmployee = "";
        int result = 0;
        int type = sc.nextInt();
        // Nếu user nhập sai thì yêu cầu nhập lại
        while (type != 1 && type != 2) {
            System.out.println("Vui lòng nhập 1 hoặc 2");
            type = sc.nextInt();
        }
        if (type == 1) {
            System.out.print("Mã nhân viên: ");
            idEmployee = sc.nextInt();
        } else {
            System.out.print("Tên nhân viên: ");
            sc.nextLine();
            nameEmployee = sc.nextLine();
        }
        System.out.println("Kết quả:");
        // Dùng vòng lặp for để hiển thị kết quả tìm kiếm
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdStaff() == idEmployee || employeeList.get(i).getNameStaff().equalsIgnoreCase(nameEmployee)) {
                result++;
                printHeader();
                employeeList.get(i).displayInformation();
            }
        }
        // Nếu nhân viên cần tìm không tồn tại thì thông báo
        if (result == 0) {
            System.out.println("Nhân viên cần tìm không tồn tại!");
        }
    }

    //      Tạo hàm salary để hiển thị bảng lương của nhân viên
    public static void salaryList(ArrayList<Staff>employeeList){
        System.out.println("BẢNG LƯƠNG NHÂN VIÊN CÔNG TY");
        String formatterHeader = "%-6s | %-20s | %-10s | %-10s\n";
        System.out.printf(formatterHeader, "ID", "Name", "Department", "Salary");
        String formatter = "%-6s | %-20s | %-10s | %10.2f%n";
        for (int i = 0 ; i < employeeList.size(); i++){
            Staff staff = employeeList.get(i);
            System.out.printf(formatter, staff.getIdStaff(),staff.getNameStaff(),
                    staff.getDepartment().getNameDeparment(),staff.salaryCalculator());
        }
    }

    //      Tạo hàm increaseOrDecreaseSalary để hiển thị bảng lương theo thứ tự tăng hoặc giảm dần của nhân viên
    public static void increaseOrDecreaseSalary(){
        System.out.println("Sắp xếp lương nhân viên (Nhập 1 hoặc 2)");
        System.out.println("1.Tăng dần");
        System.out.println("2.Giảm dần");
        int order = sc.nextInt();
        Comparator<Staff> payrollDescending = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o1.salaryCalculator() - o2.salaryCalculator());
            }
        };
        employeeList.sort(payrollDescending);
        if (order == 1) {
            Collections.reverse(employeeList);
        }
        salaryList(employeeList);
    }
    //    Tạo hàm printHeader để in tên của table
    public static void printHeader(){
        String format = "%-6s %-20s %-6s %-19s %-15s %-15s %-15s %-18s\n";
        System.out.printf(format,"ID","Name","Age","Coefficient Salary","Date Begin","Department","Annual Date","OT/Position");
    }
}


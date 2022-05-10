package assignment2.gradestudent.java;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeStudent {
    /**
     * Tạo các biến global để lưu giá trị.
     * @param totalpoint là tổng số điểm, bao gồm điểm ban đầu của người nhập
     * và số điểm được tăng thêm, điểm tối đa là 100.
     * @param weightScore là điểm tối đa dựa trên trọng số.
     * @param weightMid là trọng số của điêm thi giữa kỳ.
     * @param weightFinal là trọng số của điểm thi cuối kỳ.
     * @param weightHomework là trọng số của điểm bài tập về nhà.
     * @param sectionPoint là điểm chuyên cần của sinh viên.
     * @param numAssignment là số lượng bài tập.
     * @param scoresShifted là điểm có được tăng hay không.
     * @param shiftAmount là điểm cần tăng bao nhiêu.
     */
    public static Scanner sc = new Scanner(System.in);
    public static int totalPoint;
    public static double weightScore;
    public static int weightMid;
    public static int weightFinal;
    public static int weightHomework;
    public static int scoreEarned;
    public static int sectionPoints;
    public static int numAssignment;
    public static int scoresShifted;
    public static int shiftAmount;

    /**
     * Hàm main()có chứa tham số args  để điểu khiển chương trình, trong hàm sẽ gọi các hàm con như sau:
     * Hàm begin() để hiện thị thông điệp chào mừng
     * Hàm midTerm() để nhập và tính toán điểm thi giữa kỳ.
     * Hàm finalTerm() để nhập và tính toán điểm thi cuối kỳ.
     * Hàm homework() để nhập và tính toán điểm bài tập về nhà.
     * Hàm report() để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng.
     */
    public static void main(String[] args) {
        begin();
        double weightCheckMidterm = midTerm();
        double weightCheckFinalterm = finalTerm();
        double weightCheckHomework = homeWork();
        report(weightCheckMidterm, weightCheckFinalterm, weightCheckHomework);
    }


    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
        System.out.println();
    }

    /**
     *
     * @param s là chuỗi dùng chung cho 2 hàm midTerm và finalTerm.
     * @param limit để xác định trọng số nằm trong giới hạn đổ lại 100.
     * @return trả về giá trị trọng số.
     * @int weight là trọng số khi nhập dùng chung cho 2 hàm midTerm và finalTerm.
     * Dùng vòng lặp do/while để kiểm tra trọng số khi nhập có nằm trong khoảng từ 0 - 100 hay không
     * ,nếu không thỏa điều, người dùng phải nhập lại.
     */
    public static int term(String s, int limit ) {
        int weight;
        System.out.println(s);
        do {
            System.out.print("Weight(0-"+(100-limit)+")? ");
            if (sc.hasNextInt()) {
                weight = sc.nextInt();
            } else {
                sc.nextLine(); // để clear cái chuỗi vừa nhập
                weight = -1; // để vòng lặp được lặp lại, user nhập lại
            }
        } while (!((weight > 0) && (weight <= 100 - limit)));
        return weight;
    }

    /**
     *
     * @param limit để xác định trọng số nằm trong giới hạn đổ lại 100 của hàm homeWork.
     * @return trả về giá trị của trọng số homeWork.
     */
    public static int termHomework(int limit ) {
        int weight;
        System.out.println("Homework: ");
        do {
            System.out.print("Weight(" + (100 - limit) + ")? ");
            if (sc.hasNextInt()) {
                weight = sc.nextInt();
            } else {
                sc.nextLine();
                weight = -1;
            }
        } while (!(weight == 100 - limit));
        return weight;
    }

    /**
     * Tạo hàm earned để yêu cầu user nhập lại nếu sai cú pháp.
     * @return trá về giá trị scoreEarned.
     */
    public static int earned(){
        do {
            System.out.print("Score earned? ");
            try{
                scoreEarned = sc.nextInt();
            }catch (InputMismatchException e) {
                sc.nextLine();
                scoreEarned = -1;
            }
        }while ( scoreEarned < 0 || scoreEarned > 100);
        return scoreEarned;
    }
    /**
     *  @return trá về giá trị scoresShifted.
     */
    public static int shift(){
        try {
            System.out.print("Were score to shifted (1=yes, 2=no)? ");
            scoresShifted = sc.nextInt();
        }catch (InputMismatchException e) {
            sc.nextLine();
            scoresShifted = -1;
        }
        return scoresShifted;
    }
    /**
     * Tạo hàm amount là điểm cần tăng.
     *  @return trá về giá trị shiftAmount.
     */
    public static int amount(){
        do {
            try {
                System.out.print("Shift amount? ");
                shiftAmount = sc.nextInt();
                totalPoint = scoreEarned + shiftAmount;
                if (totalPoint > 100) {
                    totalPoint = 100;
                }
            }catch (InputMismatchException e){
                sc.nextLine();
                shiftAmount = -1;
            }
        }while (shiftAmount < 0 || shiftAmount > 100);
        return shiftAmount;
    }
    /**
     * Hàm smallterm để dùng chung cho hàm midTerm và finalTerm.
     * @return trả về giá trị weightScore tức là điểm số dựa trên trọng số.
     * scoresShifted là điểm mà bạn có được tặng hay không, chọn 1 nếu có tăng
     * , chọn 2 nếu không.
     *
     */
    public static double smallTerm(int weight){
        earned();
        do {
            shift();

            if (scoresShifted == 1) {
                amount();

            }else if (totalPoint < 100){
                totalPoint = scoreEarned;
            }

        }while (scoresShifted < 1 || scoresShifted > 2);
        System.out.println("Total points = " + totalPoint + " / 100");

        // Điểm weightScore sẽ làm tròn 1 chữ số
        weightScore = Math.round((double)totalPoint/100 * (double) weight);
        System.out.println("Weight score = " + weightScore + " / " + weight);
        System.out.println();
        System.out.println();
        return weightScore;
    }

    /**
     *
     * @return trả về giá trị trọng số điểm giữa kỳ
     * weightMid = weight để lấy trọng số riêng điểm giữa kỳ
     * dùng cho việc tìm totalWeight(100)
     */
    public static double midTerm() {
        int weight = term("Midterm: ",0);
        double result = smallTerm(weight);
        weightMid = weight;
        return result;
    }

    public static double finalTerm() {
        int weight = term("Finalterm: ", weightMid);
        double result = smallTerm(weight);
        weightFinal = weight;
        return result;
    }

    /**
     * @return trả về giá trị số bài tập
     */
    public static int assignment(){
        do{
            try{
                System.out.print("Number of assignments? ");
                numAssignment = sc.nextInt();
            }catch (InputMismatchException e){
                sc.nextLine();
                numAssignment = -1;
            }
        }while (numAssignment < 0 ||numAssignment > 100);
        return numAssignment;
    }
    /**
     *
     * @return
     * int weight = termHomework() để kiểm tra trọng số sau khi đã nhập weightMid
     * + weightFinal có đạt 100 hãy chưa, nếu quá 100 phải nhập lại.
     *
     * Dùng vòng lặp For để in ra số bài tập đã làm, kiểm tra số điểm bài tập đã làm
     * nếu vượt quá 150 thì vẫn tính là 150
     *
     * attend là số buối học sinh đã đi học và được điểm danh
     * sectionPoint là tổng điểm chuyên cần của học sinh, tối đa là 30 điểm
     */
    public static double homeWork() {
        int weight = termHomework(weightMid + weightFinal);
        int score = 0;
        int maxScore = 0;
        weightHomework = weight;
        assignment();
        int[][] assignment = new int[numAssignment][2];

        for ( int ii = 0; ii < assignment.length; ii++) {
            do{
                try{
                    System.out.print("Assignment " + (ii + 1) + " score and max:? ");
                    assignment[ii][0] = sc.nextInt();
                    assignment[ii][1] = sc.nextInt();

                    score += assignment[ii][0];
                    maxScore += assignment[ii][1];

                }catch(InputMismatchException e){

                    sc.nextLine();
                    assignment[ii][0] = -1;
                    assignment[ii][1] = -1;
                }

            }while( assignment[ii][0] < 0 || assignment[ii][0] > 100
                   || assignment[ii][1] < 0 || assignment[ii][1] > 100);

            if (score > 150) {
                score = 150;
            }
            if (maxScore > 150) {
                maxScore = 150;
            }
        }
        attendTimes();
        System.out.println("Section points = " + sectionPoints + " / 30");
        System.out.println("Total points = " + (score + sectionPoints) + " / " + (maxScore + 30));

        weightScore = Math.round((double) (score + sectionPoints) / (maxScore + 30) * (double) weight);

        double result = weightScore;

        System.out.println("Weight score = " + weightScore + " / " + weight);
        System.out.println();

        return result;
    }

    /**
     * Tạo hàm attendTimes để tính số buổi điểm danh
     * @return trả về giá trị attendTimes
     */
    public static int attendTimes(){
        System.out.print("How many sections did you attend? ");
        int attend = sc.nextInt();
         sectionPoints = attend * 5;

        if (sectionPoints > 30) {

            sectionPoints = 30;
        }
        return sectionPoints;

    }
    /**
     * Dùng if/else để kiểm tra totalWeight có = 100 không, nếu có in ra grade tức là tổng số điểm của cả 3 phần
     * midTerm, finalTerm và homeWork
     * Dùng if/else để kiểm tra GPA của học sinh dựa trên grade
     *
     * @param weightCheckMidterm điểm weightscore giữa kỳ đạt được.
     * @param weightCheckFinalterm điểm weightscore cuối kỳ đạt được.
     * @param weightCheckHomework điểm weightscore bài tập về nhà
     * @return trả về giá trị grade tổng số điểm của cả 3 phần tính theo thang điểm 100
     */
    public static double report(double weightCheckMidterm, double weightCheckFinalterm,double weightCheckHomework) {
        double grade;
        grade = weightCheckMidterm + weightCheckFinalterm + weightCheckHomework;
            System.out.println();
            System.out.printf("Overall percentage = %.1f ", grade);
            System.out.println();
            if (grade >= 85) {
                System.out.println("Your grade will be at least: 3.0");
            } else if (grade >= 75 && grade < 85) {
                System.out.println("Your grade will be at least: 2.0");
            } else if (grade >= 60 && grade < 75) {
                System.out.println("Your grade will be at least: 1.0");
            } else {
                System.out.println("Your grade will be at least: 0.0");
            }
        System.out.println("<< your custom grade message here >> ");
        return grade;
    }

}
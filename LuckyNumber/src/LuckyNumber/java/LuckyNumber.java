package LuckyNumber.java;

import java.util.Scanner;

public class LuckyNumber {
    //Khai báo các biến phương thức toàn cục để lưu các trị.
    public static Scanner sc = new Scanner(System.in);
    public static int totalGames = 0;
    public static int totalGuess = 0;
    public static int bestGame = 100;
    public static final int MAX = 100;

    // Hàm main để điều khiển luồng chính của chương trình
    public static void main(String[] args) {

        String answer; //Tạo biến answer để lưu chuỗi khi người dùng nhập từ bàn phím.

        //Dùng vòng lặp do/while để hỏi người chơi có muốn tiếp tục hay không,
        //nếu người dùng đồng ý sẽ gọi hàm play() và lặp lại trò chơi,
        //nếu không sẽ thoát khỏi vòng lặp và đồng thời in ra giá trị từ hàm report().
        do {
            playGame();
            System.out.println("Bạn có muốn chơi tiếp: ");
            answer = sc.next();

        } while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));

        report();

    }

    //Tạo hàm playGame() để người chơi nhập dự đoán số may mắn và kiểm trả dự đoán
    public static void playGame() {
        int luckNum = (int) Math.round(Math.random() * (MAX + 1)); //Sử dụng hàm ramdom() để tạo số ngẫu nhiên từ 0 đến 100.
        int guessCount = 0; //Tạo biến guessCount để lưu số lượt dự đoán
        int guessNum;   //Tạo biến guessCount để lưu số dự đoán từ người nhập.
        System.out.println("Hãy dự đoán số may mắn từ 0 đến " + MAX + " ?");
        //Sử dụng vòng lặp do/while để người chơi nhập lại nếu đoán sai.
        do {
            System.out.print("Nhập dự đoán: ");

            guessNum = sc.nextInt();

            if (luckNum < guessNum) {

                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            } else if (luckNum > guessNum) {

                System.out.println("Số may mắn lớn hơn số dự đoán của bạn");
            }
            guessCount++; //Số lần đoán tăng lên sau mỗi lượt đoán sai.

        } while (guessNum != luckNum);

        if (guessNum == luckNum) {
            System.out.println("Chúc mừng bạn đoán đúng con số may mắn sau " + guessCount + " lần dự đoán");
        }
        totalGuess += guessCount; //Gán guessCount cho totalGuess để lấy giá trị tổng số lượt đoán của tống số lần chơi
        totalGames++; // Số lượt chơi tăng lên sau mỗi lần đoán đúng số ngẫu nhiên.

        if (bestGame > guessCount) { //Xét điều kiện để tìm ra lượt chơi ít lượt đoán nhất

            bestGame = guessCount;

        }

    }

    //Tạo hàm report() để in ra kết quả khi không tiếp tục trò chơi
    public static void report() {

        System.out.println("Tổng kết:");
        System.out.println("Tổng số lần chơi là: " + totalGames);
        System.out.println("Tổng số lần đoán là: " + totalGuess);
        //Trung bình số lần dự đoán bằng tổng số lần dự đoán chia cho tổng số lượt chơi
        //Làm tròn 1 số thập phân.
        System.out.println("Tổng số lần dự đoán trung bình mỗi lượt = "
                + (double) Math.round((double) totalGuess / totalGames * 10) / 10);

        System.out.println("Lần chơi tốt nhất = " + bestGame);

    }

}

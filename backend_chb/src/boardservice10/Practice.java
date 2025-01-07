package boardservice10;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] seats = new char[10][10];

        // 초기 좌석 상태 설정
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = 'ㅁ';
            }
        }

        while (true) {
            // 현재 좌석 상태 출력
            System.out.println("현재 좌석 상태:");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(seats[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("좌석을 선택하세요 (1부터 100까지 입력):");
            int seatNumber = scanner.nextInt();

            // 입력값 유효성 검사
            if (seatNumber >= 1 && seatNumber <= 100) {
                // 좌석 번호를 행과 열로 변환
                int row = (seatNumber - 1) / 10; // 행 번호 계산
                int col = (seatNumber - 1) % 10; // 열 번호 계산

                if (seats[row][col] == '■') {
                    System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택하세요.");
                } else {
                    seats[row][col] = '■'; 
                    System.out.println("좌석이 예약되었습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 1부터 100 사이의 숫자를 입력하세요.");
            }
        }
    }
}

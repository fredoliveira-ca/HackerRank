import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QueensAtackBackup {

    // Complete the queensAttack function below.
    static int queensAttack(int chessSize, int qtdObstacles, int rowQueenPosition, int columnQueenPosition, int[][] obstacles) {

        int o1 = calcHorizontalAtachPositions(chessSize, rowQueenPosition, columnQueenPosition, qtdObstacles, obstacles);
        int o2 = calcVerticalAtachPositions(chessSize, rowQueenPosition, columnQueenPosition, qtdObstacles, obstacles);
        int o3 = calcDiagonalLeftAsAtachPositions(chessSize, rowQueenPosition, columnQueenPosition, obstacles);
        int o4 = calcDiagonalRightAsAtachPositions(chessSize, rowQueenPosition, columnQueenPosition, obstacles);

        return o1 + o2 + o3 + o4;

    }

    private static int calcHorizontalAtachPositions(int chessSize, int rowQueenPosition, int columnQueenPosition, int qtdObstacles, int[][] obstacles) {
        if(qtdObstacles > 0) {
            LinkedList<Integer> horizontalObstacles = Arrays.asList(obstacles)
                    .stream()
                    .filter(obstacle -> obstacle[0] == rowQueenPosition)
                    .mapToInt(i -> i[1])
                    .boxed().sorted()
                    .collect(Collectors.toCollection(LinkedList::new));

            if(horizontalObstacles.size() > 0) {
                int queensPosition = columnQueenPosition;
                int minSize = 1;
                int maxSize = chessSize;

                int first = horizontalObstacles.getFirst();
                int last = horizontalObstacles.getLast();

                if(first == last) {
                    int i = queensPosition > first ? maxSize - first : first - minSize;
                    return i - 1;
                } else {
                    return last - first - 2;
                }
            }
        }

        return chessSize - 1;
    }

    private static int calcVerticalAtachPositions(int chessSize, int rowQueenPosition, int columnQueenPosition, int qtdObstacles, int[][] obstacles) {
        if(qtdObstacles > 0) {
            LinkedList<Integer> verticalObstacles = Arrays.asList(obstacles)
                    .stream()
                    .filter(obstacle -> obstacle[1] == columnQueenPosition)
                    .mapToInt(i -> i[0])
                    .boxed().sorted()
                    .collect(Collectors.toCollection(LinkedList::new));

            if(verticalObstacles.size() > 0) {
                int queensPosition = columnQueenPosition;
                int minSize = 1;
                int maxSize = chessSize;

                Integer first = verticalObstacles.getFirst();
                Integer last = verticalObstacles.getLast();

                if(first.equals(last)) {
                    int i = queensPosition > first ? maxSize - first : first - minSize;
                    return i - 1;
                } else {
                    return last - first - 2;
                }
            }

        }

        return chessSize - 1;
    }

    private static int calcDiagonalLeftAsAtachPositions(int chessSize, int rowQueenPosition, int columnQueenPosition, int[][] obstacles) {
        int count = 0;

        List<int[]> towardsTopObstacle = Arrays.asList(obstacles)
                .stream()
                .filter(obstacle -> obstacle[0] > rowQueenPosition)
                .filter(obstacle -> obstacle[1] > columnQueenPosition)
                .collect(Collectors.toList());

        outer : for (int row = rowQueenPosition+1, column = columnQueenPosition+1; ; row++, column++) {
            if(row > chessSize || column > chessSize) break;

            if(towardsTopObstacle.size() > 0) {
                for(int[]i : towardsTopObstacle) {
                    if(row == i[0] && column == i[1]) break outer;
                }
            }

            count++;

            if(row == chessSize || column == chessSize) break;
        }

        List<int[]> towardsBottonObstacle = Arrays.asList(obstacles)
                .stream()
                .filter(obstacle -> obstacle[0] < rowQueenPosition)
                .filter(obstacle -> obstacle[1] < columnQueenPosition)
                .collect(Collectors.toList());

        outer : for (int row = rowQueenPosition-1, column = columnQueenPosition-1; ; row--, column--) {
            if(row < 1 || column < 1) break;

            if(towardsBottonObstacle.size() > 0) {
                for(int[]i : towardsBottonObstacle) {
                    if(row == i[0] && column == i[1]) break outer;
                }
            }

            count++;

            if(row == 1 || column == 1) break;
        }


        return count;
    }

    private static int calcDiagonalRightAsAtachPositions(int chessSize, int rowQueenPosition, int columnQueenPosition, int[][] obstacles) {
        int count = 0;

        List<int[]> obstaclesTowardBotton = Arrays.asList(obstacles)
                .stream()
                .filter(obstacle -> obstacle[0] < rowQueenPosition)
                .filter(obstacle -> obstacle[1] > columnQueenPosition)
                .collect(Collectors.toList());

        outer : for (int row = rowQueenPosition-1, column = columnQueenPosition+1; ; row--, column++) {
            if(row < 1 || column > chessSize) break;

            if(obstaclesTowardBotton.size() > 0) {
                for(int[]i : obstaclesTowardBotton) {
                    if(row == i[0] && column == i[1]) break outer;
                }
            }

            count++;

            if(row == 1 || column == chessSize) break;
        }

        List<int[]> obstaclesTowardTop = Arrays.asList(obstacles)
                .stream()
                .filter(obstacle -> obstacle[0] > rowQueenPosition)
                .filter(obstacle -> obstacle[1] < columnQueenPosition)
                .collect(Collectors.toList());

        outer : for (int row = rowQueenPosition+1, column = columnQueenPosition-1; ; row++, column--) {
            if(row > chessSize || column < 1) break;

            if(obstaclesTowardTop.size() > 0) {
                for(int[]i : obstaclesTowardTop) {
                    if(row == i[0] && column == i[1]) break outer;
                }
            }

            count++;

            if(row == chessSize || column == 1) break;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

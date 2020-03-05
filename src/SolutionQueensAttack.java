import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionQueensAttack {

    private static ExecutorService service = Executors.newFixedThreadPool(4);

    private static int queensAttack(
            int chessBoardSize, int qtdObstacles, int rowQueenPosition, int columnQueenPosition, int[][] obstacles
    ) throws InterruptedException, ExecutionException {
        //Future<Integer> horizontal = service.submit(() ->
        int i = calcHorizontalAttackablePositions(chessBoardSize, rowQueenPosition, columnQueenPosition, qtdObstacles, obstacles);
        //);

        //Future<Integer> vertical = service.submit(() ->
        int i1 = calcVerticalAttackablePositions(chessBoardSize, columnQueenPosition, qtdObstacles, obstacles);
        //);

        //Future<Integer> diagonalLeft = service.submit(() ->
        int i2 = calcDiagonalLeftAttackablePositions(chessBoardSize, rowQueenPosition, columnQueenPosition, qtdObstacles, obstacles);
        //);

        //Future<Integer> diagonalRight = service.submit(() ->
        int i3 = calcDiagonalRightAttackablePositions(chessBoardSize, rowQueenPosition, columnQueenPosition, qtdObstacles, obstacles);
        //);

        //int total = horizontal.get() + vertical.get() + diagonalLeft.get() + diagonalRight.get();
        return i+i1+i2+i3;
    }

    private static int calcHorizontalAttackablePositions(int chessBoardSize, int rowQueenPosition, int columnQueenPosition, int qtdObstacles, int[][] obstacles) {
        if(qtdObstacles > 0) {
            LinkedList<Integer> horizontalObstacles = Arrays.stream(obstacles)
                    .filter(obstacle -> obstacle[0] == rowQueenPosition)
                    .mapToInt(i -> i[1])
                    .boxed().sorted()
                    .collect(Collectors.toCollection(LinkedList::new));

            if(horizontalObstacles.size() > 0) {
                int minSize = 1;

                int first = horizontalObstacles.getFirst();
                int last = horizontalObstacles.getLast();

                if(first == last) {
                    int i = columnQueenPosition > first ? chessBoardSize - first : first - minSize;
                    return i - 1;
                } else {
                    return last - first - 2;
                }
            }
        }

        return chessBoardSize - 1;
    }

    private static int calcVerticalAttackablePositions(int chessBoardSize, int columnQueenPosition, int qtdObstacles, int[][] obstacles) {
        if(qtdObstacles > 0) {
            LinkedList<Integer> verticalObstacles = Arrays.stream(obstacles)
                    .filter(obstacle -> obstacle[1] == columnQueenPosition)
                    .mapToInt(i -> i[0])
                    .boxed().sorted()
                    .collect(Collectors.toCollection(LinkedList::new));

            if(verticalObstacles.size() > 0) {
                int minSize = 1;

                Integer first = verticalObstacles.getFirst();
                Integer last = verticalObstacles.getLast();

                if(first.equals(last)) {
                    int i = columnQueenPosition > first ? chessBoardSize - first : first - minSize;
                    return i - 1;
                } else {
                    return last - first - 2;
                }
            }

        }
        return chessBoardSize - 1;
    }

    private static int calcDiagonalLeftAttackablePositions(int chessBoardSize, int rowQueenPosition, int columnQueenPosition, int qtdObstacles, int[][] obstacles) throws ExecutionException, InterruptedException {
        Future<Integer> diagonalTop = service.submit(() -> {
            int count = 0;

            IntStream.iterate(rowQueenPosition, i -> i + 11).takeWhile(n -> n <= chessBoardSize);

            IntStream.iterate(columnQueenPosition, i -> i + 11).takeWhile(n -> n <= chessBoardSize);

            for (int row = rowQueenPosition + 1, column = columnQueenPosition + 1;
                 (row <= chessBoardSize || column <= chessBoardSize);
                 row++, column++) {

                //if (row > chessBoardSize || column > chessBoardSize) break;

                int finalRow = row;
                int finalColumn = column;

                Optional<int[]> any = Arrays.stream(obstacles)
                        .filter(obstacle -> finalRow == obstacle[0] && finalColumn == obstacle[1]).findAny();

                if (any.isPresent()) {
                    break;
                }

                count++;

                if (row == chessBoardSize || column == chessBoardSize) break;
            }

            return count;
        });

        Future<Integer> diagonalBottom = service.submit(() -> {
            int count = 0;

            for (int row = rowQueenPosition - 1, column = columnQueenPosition - 1; ; row--, column--) {
                if (row < 1 || column < 1) break;

                if (qtdObstacles > 0) {
                        int finalRow = row;
                        int finalColumn = column;

                        Optional<int[]> any = Arrays.stream(obstacles)
                                .filter(obstacle -> finalRow == obstacle[0] && finalColumn == obstacle[1]).findAny();

                        if (any.isPresent()) {
                            break;
                        }
                }

                count++;

                if (row == 1 || column == 1) break;
            }

            return count;
        });


        return diagonalTop.get() + diagonalBottom.get();
    }

    private static int calcDiagonalRightAttackablePositions(int chessBoardSize, int rowQueenPosition, int columnQueenPosition, int qtdObstacles, int[][] obstacles) throws ExecutionException, InterruptedException {
        Future<Integer> diagonalBotton = service.submit(() -> {
            int count = 0;

            for (int row = rowQueenPosition - 1, column = columnQueenPosition + 1; ; row--, column++) {
                if (row < 1 || column > chessBoardSize) break;

                    int finalRow = row;
                    int finalColumn = column;

                    Optional<int[]> any = Arrays.stream(obstacles)
                            .filter(obstacle -> finalRow == obstacle[0] && finalColumn == obstacle[1]).findAny();

                    if (any.isPresent()) {
                        break;
                    }

                count++;

                if (row == 1 || column == chessBoardSize) break;
            }

            return count;
        });

        Future<Integer> diagonalTop = service.submit(() -> {
            int count = 0;

            for (int row = rowQueenPosition + 1, column = columnQueenPosition - 1; ; row++, column--) {
                if (row > chessBoardSize || column < 1) break;

                    int finalRow = row;
                    int finalColumn = column;

                    Optional<int[]> any = Arrays.stream(obstacles)
                            .filter(obstacle -> finalRow == obstacle[0] && finalColumn == obstacle[1]).findAny();

                    if (any.isPresent()) {
                        break;
                    }

                count++;

                if (row == chessBoardSize || column == 1) break;
            }

            return count;
        });

        return diagonalTop.get() + diagonalBotton.get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = 0;//Integer.parseInt(StringUtils.trim(nk[1]));

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

            System.out.println(result);

            scanner.close();

            service.shutdown();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /*public static void main(String[] args) {

        try {

            long startAt = System.currentTimeMillis();

            Future<Integer> c1 = service.submit(() -> {

                System.out.println(Thread.currentThread());

                Thread.sleep(2000);

                return 10;

            });

            Future<Integer> c2 = service.submit(() -> {

                System.out.println(Thread.currentThread());

                Thread.sleep(1000);

                return 20;

            });

            Future<Integer> c3 = service.submit(() -> {

                System.out.println(Thread.currentThread());

                Thread.sleep(2000);

                return 30;

            });

            Future<Integer> c4 = service.submit(() -> {

                System.out.println(Thread.currentThread());

                Thread.sleep(1000);

                return 40;

            });

            int total = c1.get() + c2.get() + c3.get() + c4.get();

            *//*System.out.println(Thread.currentThread());

            Thread.sleep(2000);

            int o1 = 10;

            System.out.println(Thread.currentThread());

            Thread.sleep(1000);

            int o2 = 20;

            System.out.println(Thread.currentThread());

            Thread.sleep(2000);

            int o3 = 30;

            System.out.println(Thread.currentThread());

            Thread.sleep(1000);

            int o4 = 40;

            int total = o1 + o2 + o3 + o4;*//*

            long endAt = System.currentTimeMillis();

            System.out.println("total = "+ total);

            System.out.println("execution time = " + (endAt - startAt) + "ms");

            service.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}

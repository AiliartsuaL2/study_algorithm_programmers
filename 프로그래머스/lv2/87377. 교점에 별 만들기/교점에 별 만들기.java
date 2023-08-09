import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     1. 모든 직선 쌍에 대해 반복
        A. 교점 좌표 구하기
        B. 정수 좌표만 저장
     2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
     3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
     4. 2차원 배열에 별 표시
     5. 문자열 배열로 변환 후 반환
    */
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 교점을 구해서 반환하는 메서드
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 정수가 아니면 null 반환
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    // 가장 작은 좌표를 찾는 메서드
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    // 가장 큰 좌표를 찾는 메서드
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 1-A. 교점좌표 구하기
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                // 1-B. 정수만 저장
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 2. 저장된 정수들중 x,y 좌표의 최댓값, 최솟값 구하기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        // 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기를 결정한다.
        //  배열의 크기이므로 최댓값 - 최솟값 + 1
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        // 2차원 배열은 높이부터 접근
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 2차원 배열에 별을 표시한다.
        //    - 2차원 배열에서 (0,0)은 실제 교점의 0,0이 아닌 교점의 가장 작은 크기
        //    - 일반 좌표와 다르게 y축 방향이 반대고, minimum과 maximum으로 크기가 결정 
        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }

        // 5. 문자열 배열로 변환 후 반환
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
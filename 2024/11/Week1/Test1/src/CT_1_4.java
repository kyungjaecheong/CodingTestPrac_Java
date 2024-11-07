public class CT_1_4 {

    public int solution(int n, int i, int j) {
        return findValue(0,0, n, i, j, 1);
    }

    private int findValue(int X, int Y, int size,
                          int tarX, int tarY, int start) {
        if (size == 2) {
            if (X == tarX && Y + 1 == tarY) return start;
            if (X == tarX && Y == tarY) return start + 1;
            if (X + 1 == tarX && Y == tarY) return start + 2;
            if (X + 1 == tarX && Y + 1 == tarY) return start + 3;
        }

        int halfSize = size / 2;
        int areaSize = halfSize * halfSize;

        if (tarX < X + halfSize && tarY >= Y + halfSize) {
            return findValue(X, Y + halfSize, halfSize,
                    tarX, tarY, start);
        } else if (tarX < X + halfSize && tarY < Y + halfSize) {
            return findValue(X, Y, halfSize,
                    tarX, tarY, start + areaSize);
        } else if (tarX >= X + halfSize && tarY < Y + halfSize) {
            return findValue(X + halfSize, Y, halfSize,
                    tarX, tarY, start + 2 * areaSize);
        } else {
            return findValue(X + halfSize, Y + halfSize, halfSize,
                    tarX, tarY, start + 3 * areaSize);
        }
    }

    public static void main(String[] args) {
        CT_1_4 t = new CT_1_4();
        System.out.println(t.solution(4,1,3)); //4
    }
}

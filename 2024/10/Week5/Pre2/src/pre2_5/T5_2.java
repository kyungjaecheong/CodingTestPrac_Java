package pre2_5;

public class T5_2 {
    public int solution(int[] nums, int n) {
        if (nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        T5_2 t = new T5_2();
        System.out.println(t.solution(new int[] {1,3,5,3,2}, 3)); // 1
        System.out.println(t.solution(new int[] {2,5,8,0}, 3)); // -1
    }
}

package linkedlist.questions;

//202. Happy Number
public class HappyNumber {
    public static boolean isHappyNumber (int num) {
        int fast = num;
        int slow = num;

        do {
            slow = findSquare(slow);                //1x
            fast = findSquare(findSquare(fast));    //2x

            System.out.println("Slow : " + slow + ". Fast: " + fast);
        } while (fast != slow);

        return slow == 1;
    }

    public static int findSquare(int number) {
        int ans = 0;

        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }

        return  ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
        System.out.println("\n");
        System.out.println(isHappyNumber(20));
    }
}

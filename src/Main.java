import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numLines; i++){
            String line = scanner.nextLine();

            System.out.println(Arrays.toString(line.split(">")));
        }
    }

}
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Input a number:");
        LocalVolumeManager enter = new LocalVolumeManager();
        Scanner user = new Scanner(System.in);
        String input = user.next();
        while(!input.equals("exit"))
        {
            enter.Interface(input);
            System.out.println("Require input:");
            user = new Scanner(System.in);
            input = user.next();
        }
    }
}


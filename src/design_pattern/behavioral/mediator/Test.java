package design_pattern.behavioral.mediator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User quangphu = new UserImpl("B22DCCN621", chatMediator);
        User quangnam = new UserImpl("B22DCCN622", chatMediator);
        User quanghai = new UserImpl("B22DCCN623", chatMediator);
        chatMediator.addUser(quangnam);
        chatMediator.addUser(quangphu);
        chatMediator.addUser(quanghai);
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Choose the user can enter input: ");
            String username = input.nextLine();
            System.out.println("Can you please enter your message: ");
            String message = input.nextLine();
            switch (username) {
                case "B22DCCN621":
                    quangphu.send(message);
                    break;
                case "B22DCCN622":
                    quangnam.send(message);
                    break;
                case "B22DCCN623":
                    quanghai.send(message);
                    break;
            }
        }

    }
}

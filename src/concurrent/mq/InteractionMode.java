package concurrent.mq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class InteractionMode implements Runnable{
    private BusinessMessageProducer producer;

    public InteractionMode(BusinessMessageProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Interactive Task Manager ===");
        System.out.println("Commands:");
        System.out.println("1. order <content> <orderId> <customerId> <amount>");
        System.out.println("2. notification <content> <type> <message>");
        System.out.println("8. quit - exit interactive mode");
        System.out.println("Enter command: ");

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.equals("quit")) {
                    break;
                }

                processInteractiveCommand(input);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Interactive mode ended.");
    }

    private void processInteractiveCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 0) return;

        String command = parts[0].toLowerCase();

        switch (command) {
            case "order":
                if (parts.length >= 4) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("orderId", parts[2]);
                    data.put("customerId", parts[3]);
                    data.put("amount",parts[4]);
                    producer.addTask(BusinessType.ORDER_PROCESSING, parts[1], data);
                    System.out.println("✅ Order task added");
                } else {
                    System.out.println("Usage: order <orderId> <customerId> <amount>");
                }
                break;

            case "notification":
                if (parts.length >= 4) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("type", parts[2]);
                    data.put("message", parts[3]);
                    producer.addTask(BusinessType.NOTIFICATION, parts[1], data);
                    System.out.println("✅ Payment task added");
                } else {
                    System.out.println("Usage: notification <type> <message>");
                }
                break;


            default:
                System.out.println("Unknown command: " + command);
        }
    }
}

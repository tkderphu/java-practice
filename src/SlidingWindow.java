
import java.io.*;

class EmailTask implements Runnable {
    private String fromEmail;
    private String toEmail;

    private String pathFileAttach;

    public EmailTask(String pathFileAttach) {
        this.pathFileAttach = pathFileAttach;
    }
    public EmailTask(String fromEmail,
                     String toEmail,
                     String pathFileAttach) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.pathFileAttach = pathFileAttach;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getPathFileAttach() {
        return pathFileAttach;
    }

    public void setPathFileAttach(String pathFileAttach) {
        this.pathFileAttach = pathFileAttach;
    }

    @Override
    public void run() {
        String fileNameStorage = "DSA.pdf";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNameStorage);
            FileInputStream fileInputStream1 = new FileInputStream(pathFileAttach);
            System.out.println("System is writing file to path specific");
            Thread.sleep(5000);
            fileOutputStream.write(fileInputStream1.readAllBytes());
            System.out.println("System wrote file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SlidingWindow {

    public static int total(int x, int y)  {
        System.out.println(x + " " + y);
        return x + y;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println("I am receiving file that is name dsa.pdf");
            try {
                Thread.sleep(10000);
                System.out.println("I received file");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(r, "MessageTask");
        System.out.println(status());
        thread.start();
        totalNumberPositiveFirst();


    }

    public static String status() throws InterruptedException {
        Thread thread = new Thread(new EmailTask("D:\\WorkSpaceD\\TaiLieuCauTrucDulieu\\bookDSA.pdf"), "EmailTask");
        System.out.println(thread.getName() + " is running");
        thread.start();
        return "Send email successfully!!";
    }

    public static void totalNumberPositiveFirst() {
        Runnable r = () -> {
            System.out.println("Sum of 10 number positive first: ");
            int sum = 0;
            for(int i = 1; i <= 10; i++) {
                sum += i;
            }
            System.out.println(sum);
        };
        Thread thread = new Thread(r, "SumTask");
        System.out.println(thread.getName() + " is running");
        thread.start();

    }



}

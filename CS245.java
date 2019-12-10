public class CS245 {

    public static void main(String[] args) {

        if (args.length > 1 || args.length < 1) {
            System.out.println("Invalid Arguments");
            System.exit(0);
        }

        Test main = new Test(args[0]);
        main.start();
    }
}
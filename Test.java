import java.util.Scanner;

public class Test {
    public JSONR FR;
    public Graph graph;
    public Scanner inputDevice;

    public Test(String fileName){

        this.FR = new JSONR(fileName);
        //Reads data file to our graph
        this.graph = FR.read();
        //used for all the inputs in this programs aka user input device
        this.inputDevice = new Scanner(System.in);

    }

    public String getString(){

        String input = "";
        try{
            input = this.inputDevice.nextLine();

        }catch(Exception e){

            System.out.println("INVALID INPUT EXCEPTION \n Please Try Typing Input Again");
            getString();
        }

        return input;
    }

    public String getShortestPath(String source, String destination){

        return this.graph.find(source, destination);
    }


    public void start(){


        boolean done = true;

        System.out.println("WELCOME TO THE GOOGLE MAPS FOR ACTORS");


        while(done){

            System.out.println("Input Actor 1");

            String source = getString();

            System.out.println("Input Actor 2");

            String destination = getString();

            String path = getShortestPath(source, destination);


            if(path.equals("")){
                System.out.println("Could Not Find Path -> Bad Input");
            }else{
                System.out.println("\n\n\n\n" + path);
            }


            System.out.println("Do you want to continue? \n1.yes \n2.no\n");

            String input = getString();

            if(input.equals("no") || input.equals("2") || input.equals("nO") || input.equals("n") || input.equals("N") || input.equals("No") || input.equals("NO")) {
                done = false;
            }
        }
    }
}

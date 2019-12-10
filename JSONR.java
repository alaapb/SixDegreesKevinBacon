import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Exception;
import java.util.ArrayList;

public class JSONR {
    private BufferedReader br;
    public Graph graph;


    public JSONR(String fileName){
        graph = new Graph();

        try{
            this.br = new BufferedReader(new FileReader(fileName));

        }catch(Exception e){
            //Wrong file path or name
            System.out.println("Exception: File Not Found!");
            System.exit(0);
        }
        this.read();
    }


    public Graph read(){


        try{
            String line = "";
            while((line = br.readLine()) != null){

                String[] tokenize = line.split(",");
                boolean done = true;
                ArrayList<String> actors = new ArrayList<String>();

                for(String token : tokenize){
                    if(done) {

                        if(token.contains("department")) {
                            done = false;
                        }


                        if(token.contains("name")) {
                            actors.add(token.substring(13, token.charAt(token.length() - 1) == '}' ? token.length() - 3 : token.length() - 2).trim().toLowerCase());
                        }
                    }

                }


                for(int i = 0; i < actors.size()-1; i++) {
                    for (int x = i + 1; x < actors.size(); x++) {
                        graph.addEdge(actors.get(i), actors.get(x));
                    }
                }
            }
            System.out.println("Data successfully parsed\n");
        }catch(Exception e){

        }
        finally {
            try{
                this.br.close();
            }catch(Exception e){

            }
        }


        return graph;
    }
}

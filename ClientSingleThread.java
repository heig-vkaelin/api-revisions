import java.io.*;
import java.net. *;
import java.util.Scanner;
import java.util.logging.Logger;

public class ClientSingleThread{

    static final Logger LOG = Logger.getLogger("Client");

    public void sendMessage() throws IOException {

        try {
            Socket clientSocket = new Socket("194.182.161.159", 2028);

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

            String msg="yohann.paulus@heig-vd.ch";
            pw.println(msg);
            pw.flush();
            msg = br.readLine();
            System.out.println(msg);
            for ( int i = 0; i< 3; i++){
                 msg = br.readLine();
            }

            String op1 = msg.substring(0,3);
            String op2 = msg.substring(4,7);
            String op3 = msg.substring(8,11);


            int i = Integer.parseInt(op1);
            int j = Integer.parseInt(op2);
            int k = Integer.parseInt(op3);

            int result = ((i+j)*k)-i;
            String answer  = String.valueOf(result);


            pw.println(answer);
            pw.flush();

            msg = br.readLine();
            msg = br.readLine();

            System.out.println(msg);

            pw.close();
            br.close();
            clientSocket.close();

        } catch (IOException ex){

        }
    }

    public static void main(String[] args) throws IOException {
        ClientSingleThread client = new ClientSingleThread();
        client.sendMessage();

    }
}
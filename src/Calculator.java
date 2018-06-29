import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String args[]){
        boolean isContinue = true;
        ArrayList<Integer> workspace = new ArrayList<>();
        int i = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while(isContinue){
                System.out.print("> ");
                String command = br.readLine();
                if(command.equals("end")) isContinue = false;
                else if (command.equals("list")){
                    for(Iterator<Integer> it = workspace.iterator();it.hasNext();){
                        System.out.print(it.next() + ",");
                    }
                } else if(command.matches("add [0-9]*")){
                    Pattern p = Pattern.compile("[0-9]*");
                    Matcher m = p.matcher(command);
                    while (m.find()){
                        workspace.add(i++, Integer.parseInt(m.group()));
                    }
                } else if(command.matches("remove [0-9]*")){
                    Pattern p = Pattern.compile("[0-9]*");
                    Matcher m = p.matcher(command);
                    while (m.find()){
                        workspace.add(i++, Integer.parseInt(m.group()));
                    }
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

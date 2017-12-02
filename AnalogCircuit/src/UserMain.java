/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehesht
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UserMain {
         
       public static void main(String[] args) throws IOException {
         System.out.println("Input your circuits's elements per line");
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
         ArrayList<String> input;
         ArrayList<Object> Elements;
         Elements=new ArrayList <Object>();
         input=new ArrayList<String>();
         String line;
         
         int i=0;
         while ((line = stdin.readLine()) != null && !(line.matches("end"))) { 
            input.add(line);
            i++;
                    
          
          String element,node1,node2,value;
          Resistor a;
          Source b;
          int node1int,node2int;
          double valuedouble;
          String delims = "[ ]+";
          if (!(input.get(i-1).matches("spice"))){
          String[] tokens = input.get(i-1).split(delims);
           element=tokens[0];
           node1=tokens[1];
           node2=tokens[2];
           value=tokens[3];
           node1int= Integer.parseInt(node1);
           node2int= Integer.parseInt(node2);
           valuedouble=Double.parseDouble(value);
           if (Node.numberofnodes < node1int){
             new Node();
             }
           if (Node.numberofnodes < node2int){
             new Node();
             }
           if (element.matches("r")){
            a=new Resistor(node1int,node2int,valuedouble);   
             Elements.add(a);         }
           else{
            b=new Source(node1int,node2int,valuedouble);   
           Elements.add(b);
           }
          }
          else{
              for (int k=0;k<Elements.size();k++){
                  System.out.println(""+Elements.get(k).toString());
              }
          }
          
          }
         
            System.out.println("All Done");
            
}
}

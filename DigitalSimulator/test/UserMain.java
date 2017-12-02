/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehesht
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UserMain extends Object {
    static private Simulator simulator = Simulator.getInstance();       
        
       
       public static void main(String[] args) throws IOException {
         System.out.println("Input your circuits's Nands or inverters per line");
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
         String line;
         Node n1,n2,n3;
         Block nandblock;
         ArrayList<Node> nodearray;
         ArrayList<String> input;
         nodearray=new ArrayList <Node>();
         input=new ArrayList <String>();
         int i=0;
         while ((line = stdin.readLine()) != null && line.length()!= 0) { 
            input.add(line);
            i++;
         }           
          for (int j=0;j<input.size();j++)
          {if (input.get(j).contains("nand") )
          {String input1,input2,output,delay;
           input1=input.get(j).substring(6,9);
           input2=input.get(j).substring(10,13);
           output=input.get(j).substring(14,17);
           delay=input.get(j).substring(18,20);
        
          if (Node.getNodeForName(output)==null)
              { n3 = new Node(0, output);
              nodearray.add(n3);
              }
          else
              { n3=Node.getNodeForName(output);}
         
          if (Node.getNodeForName(input1)==null)
              { n1 = new Node(0, input1);
              nodearray.add(n1);}
          else
              { n1=Node.getNodeForName(input1);}
            
          if (Node.getNodeForName(input2)==null)
             { n2 = new Node(0, input2);
             nodearray.add(n2);}
          else
             { n2=Node.getNodeForName(input2);}
        
             Node [] insNand ={n1,n2};
        
            nandblock = new Nand(insNand, n3,  Integer.parseInt(delay));
        }
       
          if (input.get(j).contains("inv") )
            {String input1,output,delay;
            input1=input.get(j).substring(4,7);
            output=input.get(j).substring(8,11);
            delay=input.get(j).substring(12,14);
        
          if (Node.getNodeForName(output)==null)
            { n3 = new Node(0, output);
            nodearray.add(n3);}
          else
            { n3=Node.getNodeForName(output);}
         
          if (Node.getNodeForName(input1)==null)
            { n1 = new Node(0, input1);
            nodearray.add(n1);}
          else
            { n1=Node.getNodeForName(input1);}
           Node [] insNand = {n1};
        
           nandblock = new Nand(insNand, n3,  Integer.parseInt(delay));
           
           
          
        } 
          }
          
            simulator.addEvent(new Event(nodearray.get(1), 40, 0));
            simulator.addEvent(new Event(nodearray.get(2), 60, 1));
             simulator.addEvent(new Event(nodearray.get(1), 80, 1));
         Event e;
        int numEvents = 0;
        int maxNE = 100;
        for(; (e = simulator.deleteNextEvent()) != null && numEvents < maxNE;
        numEvents++) {
            System.out.println("Handling event setting Node \t" +
            e.getNode() +
            "\t to " + e.getValue() +
            " at " + e.getTime());
            
            // Inform Node
            Node node = e.getNode();
            node.setValue(e.getValue());
        }
        System.out.println("\nSIMULATION FINISHED");
        System.out.println(numEvents + " Events handled");
        if (numEvents >= maxNE)
            System.out.println("Simulation stopped because " +
        "max number of events met");   

}
}

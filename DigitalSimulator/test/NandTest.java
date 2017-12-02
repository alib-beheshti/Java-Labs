/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class NandTest {
    
    public NandTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testNand1input(){
        Node [] input;
        input=new Node [1];
        input[0]=new Node(1,"input");
        Node output=new Node(0,"output");
        Nand oneinputNand= new Nand(input,output,0);
        Event Event1;
        Event1=new Event(input[0],0,0);
        EventQ.getInstance().add(Event1);
        Simulator.getInstance().addEvent(Event1);
        System.out.println("one Input Nand Test");
        System.out.println("Handling event setting node \t"+Event1.getNode()+"\t to"+Event1.getValue()+"at"+Event1.getTime());
        Node node=Event1.getNode();
        node.setValue(Event1.getValue());
        int expresult=1;
        int result=oneinputNand.getUndelayedOutput();
        assertEquals(expresult,result);
     
    }
    
    @Test
    public void testNand2input(){
        Node [] input;
        input=new Node [2];
        input[0]=new Node(1,"input2");
        input[1]=new Node(0,"input3");
        Node output=new Node(0,"output2");
        Nand twoinputNand= new Nand(input,output,1);
        Event Event1;
        Event1=new Event(input[1],0,1);
        EventQ.getInstance().add(Event1);
        Simulator.getInstance().addEvent(Event1);
        System.out.println("two Input Nand Test");
        System.out.println("Handling event setting node \t"+Event1.getNode()+"\t to"+Event1.getValue()+"at"+Event1.getTime());
        Node node=Event1.getNode();
        node.setValue(Event1.getValue());
        int expresult=0;
        int result=twoinputNand.getUndelayedOutput();
        assertEquals(expresult,result);
     
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

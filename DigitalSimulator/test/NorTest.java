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
public class NorTest {
    
    public NorTest() {
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
    public void testNor2input(){
        Node [] input;
        input=new Node [2];
        input[0]=new Node(1,"input1");
        input[1]=new Node(0,"input2");
        Node output=new Node(0,"output1");
        Nor twoinputNor= new Nor(input,output,1);
        Event Event1;
        Event1=new Event(input[0],0,0);
        EventQ.getInstance().add(Event1);
        Simulator.getInstance().addEvent(Event1);
        System.out.println("two Input Xor Test");
        System.out.println("Handling event setting node \t"+Event1.getNode()+"\t to\t"+Event1.getValue()+"\t at\t"+Event1.getTime());
        Node node=Event1.getNode();
        node.setValue(Event1.getValue());
        int expresult=1;
        int result=twoinputNor.getUndelayedOutput();
        assertEquals(expresult,result);
     
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

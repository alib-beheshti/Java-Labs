class SimulateClockedDLatch extends Object {
    static private Simulator simulator = Simulator.getInstance();
    public static void main(String [] args) {
        
        // Create the nodes
        
        Node d = new Node(1, "D");
        Node dBar = new Node(0, "DBar");
        Node clk = new Node(0, "Clk");
        Node Sbar= new Node(1,"Sbar");
        Node Rbar= new Node(1,"Rbar");
        Node Q=new Node(0,"Q");
        Node Qbar=new Node(1,"Qbar");
   //TO DO: Create the rest of the nodes (done)
        
        // Create the Functional Units
        
        Node [] insNand5 = {d};
        Block nand5 = new Nand(insNand5, dBar, 5);
        
        Node [] insNand20 ={clk,d};
        Block nand20 = new Nand(insNand20,Sbar,20);
        
        Node [] insNand10 ={clk,dBar};
        Block nand10 = new Nand(insNand10,Rbar,10);
        
        Node [] insNand15 ={Sbar,Qbar};
        Block nand15 = new Nand(insNand15,Q,15);
        
        Node [] insNand25 ={Q,Rbar};
        Block nand25 = new Nand(insNand25,Qbar,25);
        
        
	//TO DO: Create the rest of the Blocks (done)
        
        // Add at least one Event to the Simulator
        simulator.addEvent(new Event(clk, 0, 1));
        // Uncomment the following line for second simulation
        simulator.addEvent(new Event(d, 24, 0));
        
        // Simulation loop:
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

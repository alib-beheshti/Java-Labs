import java.util.*;
/**
 * The Node object keeps track of its value and informs any dependent
 * Blocks of any changes.  (A Block is <em>dependent</em> if it uses
 * the Node as an input.)
 *
 */


public class Node {
    static private Hashtable<String, Node> nodeNames = new Hashtable<String, Node>();
    static private int serialNumber = 0;
    private String name;
    private int value;
    private Vector<Block> drives;
    private Vector<NodeChangeListener> nodeChangeListeners;
    private boolean initialized = false;
    /** Construct a Node specifying its initial value and name.
    *
    * <p>This constructor requires the parameters:
    * @param initialValue The initial value of the Node (1 or 0)
    * @param name The "user friendly" name for the Node.  The name
    *     must be unique. The name must begin with an alphabetic
    *     character (a-zA-Z) or an underscore (_).
    *     The remaining characters may be alphanumerics or
    *     the punctuation characters (_.-); however, the "."
    *     character may not occur at consecutive locations.
    *
    */
    public Node(int initialValue, String name)
    {
        checkValue(initialValue);
        if (nodeNames.containsKey(name)) {
             throw new IllegalArgumentException(
            "Node name " + name + " already used."
            );
        }
        checkNodeName(name); //May throw exception
        nodeNames.put(name, this); 
        this.name = name;
        value = initialValue;
        drives = new Vector<Block>();
        nodeChangeListeners = new Vector<NodeChangeListener>();
    }
    
    /** Construct a Node specifying its initial value.
    *   A unique name is assigned to the Node.
    *
    * <p>This constructor requires the parameters:
    * @param initialValue The initial value of the Node (1 or 0)
    */
    public Node(int initialValue)
    {
        this(initialValue, "_" + serialNumber++);
    }
    
    /** Set the value of a Node.
    *
    * @param newValue The value the Node is being set to (1 or 0).
    */
    public void setValue(int newValue)
    {
        checkValue(newValue);
        if (newValue != value) {
            value = newValue;
            for(Enumeration d = drives.elements(); d.hasMoreElements();) {
                Block drivenBlock = (Block) d.nextElement();
                drivenBlock.evaluate();
            }
            //Notify Listeners if change
            if (nodeChangeListeners.size() > 0 ) {
                NodeChangeEvent changeEvent = new NodeChangeEvent(this);
                for (Enumeration listeners = nodeChangeListeners.elements();
                                 listeners.hasMoreElements();) {
                    NodeChangeListener listener =
                       (NodeChangeListener) listeners.nextElement();
                    listener.nodeChanged(changeEvent);
                }
            }
        }
    }
    
    /** Get the current value of a Node.
    * @return The current value (1 or 0).
    */
    public int getValue()
    {
        return value;
    }
    
    /** Get the name of a Node.
    * @return The name.
    */
    public String getName()
    {
        return name;
    }
    /** Add a Block to the set of Blocks that use the value of
    this Node as an input.
    * @param block The Block to be added.
    */
    public void addDependentBlock(Block block)
    {
        drives.addElement(block);
    }
    
    /**
     * Returns the blocks using this Node as an input.
     *
     * @return 
     */
    public Object [] getDependentBlocks()
    {
        return  drives.toArray();
    }
    /** Creates a string representation of a Node consisting of its name.
     * @return 
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * Add a NodeChangedListener.
     * @param l 
     */
     
    public void addNodeChangeListener(NodeChangeListener l)
    {
        nodeChangeListeners.add(l);
    }
    
    
    /** Get the Node with a given qualified name. Creates a new node if
     * create is true
     * and named Node does not exist.
     * A "qualified name" is the "'actual name'=value".  This syntax
     * is only valid if the node does not yet exist.
     *
     * <b>Note:</b>
     * A qualified name must have no spaces around the "=".
     * A user interface may allow such spaces, but must eliminate
     * them before invoking this method.
     *
     * @param name
     * @param create
     * @return the Node or null IF create is false and Node does not exist.
     */
     
    public static Node getNodeForName(String name, boolean create)
    {
        Node n = (Node) nodeNames.get(name);
        if (create && (n == null)) {
            int value = 0;
            int eqAt = name.indexOf("=");
            if (eqAt != -1) {
                value = name.charAt(eqAt+1) - '0';
                name = name.substring(0, eqAt);
            }
            n = new Node(value, name);
        }
        return n;
    }
    
    /** Get the Node with a given name.
     *
     * @param name
     * @return the Node or null if none.
     */
     
    public static Node getNodeForName(String name)
    {
        return getNodeForName(name, false);
    }
    
    /**
    * Get all of the NodeNames.
     * @return 
     */
    
    public static String [] getNodeNames()
    {
        int size = nodeNames.size();
        String [] names = new String[size];
        Enumeration n = nodeNames.keys();
        for(int i = 0; n.hasMoreElements(); i++) {
            names[i] = (String) n.nextElement();
        }
        return names;
    }
    
    boolean isInitialized()
    {
        return initialized;
    }
    
    void setInitialized()
    {
        initialized = true;
    }
    
    void directSetValue(int v)
    {
        value = v;
    }
    
    private void checkValue(int v)
    {
        if ((v < 0) || (v > 1)) {
            throw new IllegalArgumentException(
            "Valid value: 0 or 1 only. " + v + " is invalid."
            );
        }
    }
    
    private void checkNodeName(String n)
    {
        char first = n.charAt(0);
        if (!(Character.isLetter(first) || (first == '_'))) {
            throw new IllegalArgumentException(
              "Node name starts with illegal char: " + first);
        }
        
    }
}

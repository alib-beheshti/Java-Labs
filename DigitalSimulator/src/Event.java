/** An Event is a simple immutable data structure containing the
 * relevant information about an Event.
 */
 
  
public class Event extends Object {
    Event next;
    private Node node;
    private long time;
    private int value;
    static private Simulator engine = Simulator.getInstance();
    /** Construct an Event describing a value change on a Node
    * at a given time. This constructor requires the parameters:
    * @param node The Node the event applies to.
    * @param time The time of the Event which must
    *   be &gt;= the current simulation time.
    * @param value The value the Node is to be set to.
    */
    public Event(Node node, long time, int value)
    {
        if (node == null) {
            throw new IllegalArgumentException(
                "Node cannot be null."
                );
        }
        
        if (time < 0) {
            throw new IllegalArgumentException(
                      "Time cannot be negative."
                      );
        }
        
        if (time < engine.getSimulationTime()) {
            throw new IllegalArgumentException(
                      "Time cannot be less than current simulation time."
                      );
        }
        
        if ((value < 0) || (value > 1)) {
            throw new IllegalArgumentException(
                      "Value must be 0 or 1."
                      );
        }
        
        this.node = node;
        this.time = time;
        this.value = value;
        next = null;
    }
    
    /** Get the Node set by the Event.
    * @return The Node set by the Event.
    */
    public Node getNode()
    {
        return node;
    }
    
    /** Get the time of the Event.
    * @return The time of the Event.
    */
    public long getTime()
    {
        return time;
    }
    
    /** Get the new value set by the Event.
    * @return The  new value set by the Event.
    */
    public int getValue()
    {
        return value;
    }
    
    /** Creates a string representation of an Event.
    * The format is:
    * <p>
    * <pre> Node: <em>theNode</em> at <em>time</em> to <em>value</em></pre></p>
     * @return 
     */
    public String toString()
    {
        return "Node: " + node +  " at " + time + " to " + value;
    }
}

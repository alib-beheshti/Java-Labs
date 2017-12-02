/**
 *  The <em>Simulator</em> performs the actual simulation
 * of a digital system composed of Blocks and Nodes.
 *
 * <p>
 *   It is a SINGLETON.
 * </p>
 */
public class Simulator {
    private EventQ eventQ = EventQ.getInstance();
    static private Simulator INSTANCE = null;
    private long nPendingEvents = 0;
    private long nHandledEvents = 0;
    
    /**
     * 
     * @return
     */
    static public Simulator getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new Simulator();
        }
        return INSTANCE;
    }
    
    private Simulator() {} //Ensure cannot be instantiated by others.
    
    
  /** Add an Event to the Simulator.  The single parameter is:
   * @param event The Event to add.
   */
    public void addEvent(Event event)
    {
        nPendingEvents++;
        eventQ.add(event);
    }
    
  /** Return the next Event and delete it from the Simulator.
   * @return The next Event or <tt> null</tt> if the no more Events.
   */
     public Event deleteNextEvent()
    {
        nPendingEvents--;
        nHandledEvents++;
        return eventQ.delete();
    }
    
    /**
    * Process the next pending Event.
    * @return processedEvent The Event processed (null if none).
    */
    public Event step()
    {
        Event gone = deleteNextEvent();
        if (gone != null) {
            Node eventNode = gone.getNode();
            eventNode.setValue(gone.getValue());
        }
        return gone;
    }
    
    /**
     * Get number of Events that are pending (not yet handled).
     * @return number of pending Events
     */
     public long getNumPendingEvents()
     {
         return nPendingEvents;
     }
     
     /**
      * Get number of Events that have been handled.
      * @return nuber events handled
      *
      */
     public long getNumHandledEvents()
     {
         return nHandledEvents;
     }
     
    /**
     * Sets the NodeChangeListener for the Simulator.
     *
      * @param listener 
      */
    public void setNodeChangeListener(NodeChangeListener listener)
    {
    }
     /**
      * Get the current time.
     * @return 
     */
     public long getSimulationTime()
     {
         return eventQ.getSimulationTime();
     }
     
     /**
     * Reset simulator. Set number Pending and Handled Events to zero
     * and empty the event queue.
     */
     public void reset()
     {
         nPendingEvents = 0;
         nHandledEvents = 0;
         eventQ.reset();
     }
}

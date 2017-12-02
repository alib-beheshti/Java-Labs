/** A Block is connected to at least one input Node and a one or more
 * output Nodes.
 * It can evaluate itself and add an <tt>Event</tt>
 * (see {@link Event}) to the simulation
 * if the evolution of the circuit may change.
 * @see Event
 * @see Node
 */
 
 
public interface Block {
   /** Make the Block evaluate itself.
   * When a Block receives an "evaluate" message, it calculates
   * its future outputs.
   * It MUST create an Event if any "future output"
   * will affect the system; however, it MAY generate extraneous
   * Events that do not modify the evolution of the system.
   *
   * <p>
   *   This method is usually invoked when an input has
   *   changed.
   * </p>
   */
    public void evaluate();
    
}





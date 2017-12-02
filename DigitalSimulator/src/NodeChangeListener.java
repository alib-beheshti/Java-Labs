/** A <tt>NodeChangeListener</tt> is used to listen for chnages
 * in a <tt>Node</tt> value.
 * 
 * <p>
 * The <i>user interface</i> is typically used to set up and
 * register these listeners.
 * </p>
 *
 * @see Node#addNodeChangeListener
 * @see NodeChangeEvent
 */
 
public interface NodeChangeListener extends java.util.EventListener {
    /**
     * Invoked when the target Node of the listener has changed.
     * @param changeEvent 
     */
     public void nodeChanged(NodeChangeEvent changeEvent);
    
}

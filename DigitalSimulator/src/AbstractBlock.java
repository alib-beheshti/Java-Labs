/** An <tt>AbstractBlock</tt> is a prototype implementation
* of a {@link Block} interface for single-output Blocks.. 
 * <p>
 * This abstract class must be subclassed to implement the
 * precise behavior of the Block being modeled.
 * </p>
 * <p>
 * The abstract method <tt>getUndelayedOutput()</tt>
 * must be instantiated in subclasses.  Typically, this is the
 * only method that distinguishes single-output <tt>Block</tt>s.
 *
 */
 
 
public abstract class AbstractBlock implements Block {
    /**
     * 
     */
    protected Node [] inputs;
  /**
   * 
   */
  protected Node output;
  private int delay;
  private int prevValue;
  private Simulator simulator = Simulator.getInstance();
  
  /** Construct a AbstractBlock specifying its input and output
   * <tt>Node</tt>s and its delay.  The constructor attempts
   * to obtain a consistent initial value
   * for its output <tt>Node</tt>.
   * If a consistent output is not possible, an <tt>Event</tt>
   * is added to the <tt>Simulator</tt> to make the output
   * consistent after <i>delay</i> time units.
   *
   * @param inputs An array of the Nodes that are inputs
   *      to the Block.
   * @param output The Node driven by the Block.
   * @param delay The propagation delay of the Block.
   *
   */
   public AbstractBlock(Node [] inputs, Node output, int delay)
   {
       if (inputs == null) {
           throw new IllegalArgumentException(
               "Parameter 'inputs' must be an array of Nodes.\n");
       }
       
       if (output == null) {
           throw new IllegalArgumentException(
               "Parameter 'output' must be a Node.\n");
       }
       
       if (delay < 0) {
           throw new IllegalArgumentException(
               "Parameter 'delay' must be non-negative.");
       }
       
       this.output = output;
       this.inputs = inputs;
       this.delay = delay;
       int consistentOutput = getUndelayedOutput();
       for(int i = 0; i < inputs.length; i++) {
           inputs[i].setInitialized();
           inputs[i].addDependentBlock(this);
       }
       if (consistentOutput != output.getValue()) {
           if (!output.isInitialized()) {
               output.directSetValue(consistentOutput);
               output.setInitialized();
           }
       }
       prevValue = output.getValue();
       this.evaluate();
   }
   
  public void evaluate()
   {
       int newValue = getUndelayedOutput();
       
       if (newValue != prevValue) {
           prevValue = newValue;
           Event e = new Event(output,
                               delay + simulator.getSimulationTime(),
                               newValue);
           simulator.addEvent(e);
       }
   }
   
   
   /** This abstract method must be instantiated in the subclass.  The
   * instantiated version calculates its output from the current value
   * of the input Nodes.  The <tt>getUndelayedOutput</tt> method
   * <it>does not</it> take into account propagation delays
   * (i.e. it "assumes" the propagation delay is 0).
   * @return 
   */
   public abstract int getUndelayedOutput();
   
}




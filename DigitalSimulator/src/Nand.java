/** Nand is an n-input nand gate. Note that a 1-input Nand gate
 * is an inverter.
 */
 
  
public class Nand extends AbstractBlock {

  /**  Construct a Nand gate  specifying its input and output Nodes
   * and its delay. This constructor requires the parameters:
   * @param inputs An array of the Nodes that are inputs
   *      to the Nand gate.  The size of the array determines
   *      the number of inputs, which can be as small as
   *      one (where a 1-input nand gate is an inverter).
   * @param output The Node driven by the nand gate.
   * @param delay The propagation delay of the nand gate
   */
  public Nand(Node[] inputs, Node output, int delay)
  {
    super(inputs, output, delay);
  }
  /** Calculates nand gate output from current inputs with NO delay.
   * @return The value the nand gate would output with zero propogation
   * delay with current inputs.
   */
  public int getUndelayedOutput()
  {
    // New output is 1 if any input is 0
    for(int i = 0; i < inputs.length; i++) {
      if (inputs[i].getValue() == 0) {
	return 1;
      }
    }
    return 0;
  }
}

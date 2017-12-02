/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehesht
 */
public class Resistor {
    int nodeid1;
    int nodeid2;
    double resistor;
    int id; 
    static int Rid = 1;

    public Resistor(int Nodeid1, int Nodeid2, double resistor) {
        this.nodeid1 = Nodeid1;
        this.nodeid2 = Nodeid2;
        this.resistor = resistor;
        id=Rid;
        Rid++; 
        }
    
   
    @Override
    public String toString() {
        return "R"+id +" "+nodeid1+" "+nodeid2+" "+resistor;
    }
}

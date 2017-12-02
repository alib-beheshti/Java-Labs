/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehesht
 */
public class Node {
    int id;
    static int numberofnodes = 0;

    public Node() {
       id = numberofnodes;
       numberofnodes++;
     }

    @Override
    public String toString() {
        return ""+id ;
    }
    
}

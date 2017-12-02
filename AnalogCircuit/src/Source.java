
/**
 *
 * @author mbehesht
 */
public class Source {
    int nodeid1;
    int nodeid2;
    double value;
    int id; 
    static int Rid = 1;

    public Source(int Nodeid1, int Nodeid2, double val) {
        this.nodeid1 = Nodeid1;
        this.nodeid2 = Nodeid2;
        this.value = val;
        id=Rid;
        Rid++; 
        }
    
   
    @Override
    public String toString() {
        return "V"+id +" "+nodeid1+" "+nodeid2+" DC "+value;
    }
}

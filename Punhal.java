
public class Punhal implements Ofensiva{

    private String n;
    public Punhal(String n){
        this.n = n;
    }
    private final int forca = 1;

    @Override
    public void printItem() {
        System.out.println(n + " causa " + atacar() + " de dano ao adversário");
    }

    @Override
    public int atacar() {
        return forca;
    }

    public int getForca() {
        return forca;
    }

    public String getNome() {
        return n;
    }
    
}

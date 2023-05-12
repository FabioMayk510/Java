
public class VelocidadeExtra implements Pocao {

    private final int forca = 2;
    private String n;
    public VelocidadeExtra(String n) {
        this.n = n;
    }

    
    
    @Override
    public void printItem() {
        System.out.println(n + "incrementa velocidade em " + incrementa());
    }

    @Override
    public int incrementa() {
        return forca;
    }

    public int getForca() {
        return forca;
    }

    public String getNome() {
        return n;
    }
}


public class VidaExtra implements Pocao {

    private final int forca = 10;
    private String n;
    public VidaExtra(String n) {
        this.n = n;
    }
    
    @Override
    public void printItem() {
        System.out.println(n + "incrementa a vida em " + incrementa());
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

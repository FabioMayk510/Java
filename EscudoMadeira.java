public class EscudoMadeira implements Defensiva {

    private final int forca = 1;
    private String n;
    public EscudoMadeira(String n){
        this.n = n;
    }

    @Override
    public void printItem() {
        System.out.println("ESCUDO MADEIRA defende com " + defender());
    }
    
    @Override
    public int defender() {
        return forca;
    }

    public int getForca() {
        return forca;
    }

    public String getNome() {
        return n;
    }
}

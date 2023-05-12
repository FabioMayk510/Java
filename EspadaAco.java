public class EspadaAco implements Ofensiva {

    private final int forca = 3;
    private String n;
    public EspadaAco(String n){
        this.n = n;
    }

    @Override
    public void printItem() {
        System.out.println("ESPADA DE AÇO ataca com " + atacar());
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

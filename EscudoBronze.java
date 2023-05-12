public class EscudoBronze implements Defensiva {

    private final int forca = 2;
    private String n;
    public EscudoBronze(String n){
        this.n = n;
    }
    
    @Override
    public void printItem() {
        System.out.println("ESCUDO BRONZE defende com " + defender());
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


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Personagem {

    public static final int PODERMAX = 30;
    private String nome;
    private String classe;
    private int vida;
    private int velocidade;
    private int defesa;
    private int ataque;
    private Queue<Inventariavel> itens;

    public Personagem(String nome, int classes, int vida, int velocidade, int defesa, int ataque) {
        if (classes == 1){
            this.classe = "Espadachim";
        } else {
            this.classe = "Ladino";
        }
        this.nome = nome;
        validaPersonagem(vida);
        this.vida = vida;
        validaPersonagem(velocidade);
        this.velocidade = velocidade;
        validaPersonagem(defesa);
        this.defesa = defesa;
        validaPersonagem(ataque);
        this.ataque = ataque;
        this.itens = new LinkedList<>();
    }

    public void validaPersonagem(int param) {
        if (param > PODERMAX) {
            System.out.println("Personagem inválido: vida maior que o Poder Máximo PODERMAX");
            throw new InstantiationError("");
        }
    }

    public void atualizaPersonagem(String param, int valor) {
        if(param == "Vel")
            velocidade += valor;
        else if (param == "Def")
            defesa += valor;
        else if (param == "Atq")
            ataque += valor;
    }

    public void tomaDano(int dano) throws InterruptedException {
        vida -= dano;
        if(vida <= 0){
            System.out.println("Você morreu!");
            Thread.sleep(2000);
            System.exit(0);
        }
    }

    /*
     *  na subclasse implementar percorrendo o array itens e chamar o addItem 
     *  veja subclasse Guerreiro
     */
    public abstract void addItens(Inventariavel... itens);

    public List<Inventariavel> getItens() {
        return Collections.unmodifiableList((List) itens);
    }

    public void rmItens(Inventariavel item){
        if(item instanceof VelocidadeExtra)
            velocidade += item.getForca();
        else if (item instanceof Ofensiva || item instanceof OfensivaExtra)
            ataque += item.getForca();
        else if (item instanceof Defensiva || item instanceof DefensivaExtra)
            defesa += item.getForca();
        else if (item instanceof VidaExtra)
            vida += item.getForca();
        itens.remove(item);
    }

    public final Inventariavel getNext() {
        return itens.poll();
    }

    public final void addItem(Inventariavel item) {
        boolean ehPocao = item instanceof Pocao;
        int poder = vida;
        if (ehPocao) {
            Pocao pocao = (Pocao) item;
            poder += pocao.incrementa();
            verificaPoderMaximo(poder, item);
        }
        boolean ehOfensiva = item instanceof Ofensiva;
        if (ehOfensiva) {
            Ofensiva ofensiva = (Ofensiva) item;
            poder += ofensiva.atacar();
            verificaPoderMaximo(poder, item);
        }
        boolean ehDefensiva = item instanceof Defensiva;
        if (ehDefensiva) {
            Defensiva defensiva = (Defensiva) item;
            poder += defensiva.defender();
            verificaPoderMaximo(poder, item);
        }
    }
    
    private void verificaPoderMaximo(int poder, Inventariavel item) {
        if (poder <= PODERMAX) {
            itens.add(item);
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVelocidade(){
        return velocidade;
    }

    public int getAtaque() {
        return ataque;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + 
        "\nClasse: " + classe + 
        "\nVida: " + vida + 
        "\nVelocidade: " + velocidade + 
        "\nDefesa: " + defesa + 
        "\nAtaque: " + ataque;
    }
    
    
    

}

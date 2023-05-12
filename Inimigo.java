import java.util.Random;

public class Inimigo {

    String[] nomeMonstros = {
        "Monstro do Pântano",
        "Zombie",
        "Caveira",
        "Bixo Papão"
    };
    Random r = new Random();
    private String nome;
    private int vida;
    private int velocidade;
    private int defesa;
    private int ataque;
    public Inimigo() {
        nome = nomeMonstros[r.nextInt(4)];
        vida = r.nextInt(30);
        velocidade = r.nextInt(30);
        defesa = r.nextInt(30);
        ataque = r.nextInt(30);
    }

    public int recebeDano(int dano) {
        vida -= dano;
        if (vida > 0){
            return 1;
        }
        else {
            return 0;
        }
    }

    public String getNome() {
        return nome;
    }
    public int getVida() {
        return vida;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public int getDefesa() {
        return defesa;
    }
    public int getAtaque() {
        return ataque;
    }
}

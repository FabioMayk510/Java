
public class Guerreiro extends Personagem{


    public Guerreiro(String nome, int classe, int vida, int velocidade, int defesa, int ataque) {
        super(nome, classe, vida, velocidade, defesa, ataque);
    }

    @Override
    public void addItens(Inventariavel... itens) {
        for (Inventariavel item : itens) {
            super.addItem(item);
        }
    }

    public void listaItens(Guerreiro player) {
        for(int i = 0; i < player.getItens().size(); i++){
            System.out.println((i+1) + " - " + player.getItens().get(i).getNome());
        }
    }

    public void usaItens(Guerreiro player, int item) {
        item -= 1;
        Inventariavel p = player.getItens().get(item);
        //System.out.println(p);
        player.rmItens(p);
    }

    public void recebeDano(int dano) throws InterruptedException{
        super.tomaDano(dano);
    }

}

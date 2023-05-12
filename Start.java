import java.util.Scanner;

import java.util.Random;


public class Start extends Guerreiro{

    public final static void clear()
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        //
    }
}

    public static void chance(Guerreiro player) {
        Random r = new Random();
        int op = r.nextInt(7);

        switch(op){
            case 0:
            Punhal punhal = new Punhal("Adaga");
            player.addItens(punhal);
            case 1:
            VelocidadeExtra pVel = new VelocidadeExtra("Poção de Velocidade");
            player.addItens(pVel);
            case 2:
            OfensivaExtra pAtq = new OfensivaExtra("Poção de Ataque");
            player.addItens(pAtq);
            case 3:
            EscudoBronze escB = new EscudoBronze("Escudo de Bronze");
            player.addItens(escB);
            case 4:
            EscudoMadeira escM = new EscudoMadeira("Escudo de Madeira");
            player.addItens(escM);
            case 5:
            EspadaAco espA = new EspadaAco("Espada de Aço");
            player.addItens(espA);
            case 6:
            VidaExtra pVid = new VidaExtra("Poção de Vida");
            player.addItens(pVid);
            case 7:
            System.out.println("");
            break;
            default:
            System.out.println("Você ganhou um " + player.getItens().get(player.getItens().size()-1));
        }
    }

    public Start(String nome, int classe, int vida, int velocidade, int defesa, int ataque) {
        super(nome, classe, vida, velocidade, defesa, ataque);
    }

    public static Guerreiro atributa(String nome, int classe){
        int vida;
        int velocidade;
        int defesa;
        int ataque;
        if(classe == 1){
            vida = 25;
            velocidade = 10;
            defesa = 10;
            ataque = 13;
        } else {
            vida = 20;
            velocidade = 17;
            defesa = 7;
            ataque = 10;
        }

        Guerreiro player = new Guerreiro(nome, classe, vida, velocidade, defesa, ataque);
        return player;
    }

    public static Guerreiro menu(){
        Scanner e = new Scanner(System.in);
        System.out.println("\t\tBem vindo Guerreiro");
        System.out.print("Crie um nome para seu personagem: ");
        String nome = e.next();
        System.out.print("\n1 - Espadachim\n2 - Ladino\nQual a classe de seu personagem? ");
        int classe = e.nextInt();

        Guerreiro player = atributa(nome, classe);
        return player;
    }

    public static void menuAtaque() {
        System.out.println("1- Consultar status\n2- Golpear com as mãos\n3- Usar um Item\n4- Fugir");
        System.out.println("Qual ação irá tomar?");
    }

    public static void cacar(Guerreiro player) throws InterruptedException{
        Random r = new Random();
        Scanner e = new Scanner(System.in);
        Inimigo inimigo = new Inimigo();
        System.out.println("Um inimigo apareceu à sua frente:\n");
        System.out.println("Nome: " + inimigo.getNome() + 
        "\nVida: " + inimigo.getVida() + 
        "\nVelocidade: " + inimigo.getVelocidade() + 
        "\nDefesa: " + inimigo.getDefesa() + 
        "\nAtaque: " + inimigo.getAtaque());
        while(player.getVida() > 0 || inimigo.getVida() > 0){
            int i = 1;
            System.out.println("Rodada " + i);
            if (player.getVelocidade() < inimigo.getVelocidade()){
                System.out.println(inimigo.getNome() + " agiu mais rapido");
                int dano = r.nextInt(inimigo.getAtaque());
                System.out.println(inimigo.getNome() + " golpeou você (" + dano + " de dano)");
                player.recebeDano(dano);

                menuAtaque();
                int opt = e.nextInt();
                if(opt == 1){
                    System.out.println(player.toString());
                    menuAtaque();
                    opt = e.nextInt();
                }
                    
                if(opt == 2)
                {
                    dano = r.nextInt(player.getAtaque());
                    System.out.println("Você golpeou o inimigo (" + dano + " de dano)");
                    int v = inimigo.recebeDano(dano);
                    if(v == 0){
                        System.out.println("Você matou " + inimigo.getNome());
                        chance(player);
                        break;
                    }
                }

                if(opt == 3){
                    if (player.getItens().size() != 0){
                        player.listaItens(player);
                        int item = e.nextInt();
                        Inventariavel p = player.getItens().get(item-1);
                        if(p instanceof Pocao || p instanceof Defensiva || p instanceof DefensivaExtra){
                            player.usaItens(player, item);
                        } else if (p instanceof Ofensiva || p instanceof OfensivaExtra){
                            player.usaItens(player, item);
                            dano = r.nextInt(player.getAtaque());
                            System.out.println("Você golpeou o inimigo (" + dano + " de dano)");
                            int v = inimigo.recebeDano(dano);
                            if(v == 0){
                                System.out.println("Você matou " + inimigo.getNome());
                                chance(player);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Você não possui itens");
                    }
                    
                }
                
                if(opt == 4){
                    break;
                }
                    
            } else {
                int dano = 0;
                menuAtaque();
                int opt = e.nextInt();
                if(opt == 1){
                    System.out.println(player.toString());
                    menuAtaque();
                    opt = e.nextInt();
                }
                if(opt == 2){
                    dano = r.nextInt(player.getAtaque());
                    System.out.println("Você golpeou o inimigo (" + dano + " de dano)");
                    int v = inimigo.recebeDano(dano);
                    if(v == 0){
                        System.out.println("Você matou " + inimigo.getNome());
                        chance(player);
                        break;
                    }
                }

                if(opt == 3){
                    if (player.getItens().size() != 0){
                        player.listaItens(player);
                        int item = e.nextInt();
                        Inventariavel p = player.getItens().get(item-1);
                        if(p instanceof Pocao || p instanceof Defensiva || p instanceof DefensivaExtra){
                            player.usaItens(player, item);
                        } else if (p instanceof Ofensiva || p instanceof OfensivaExtra){
                            player.usaItens(player, item);
                            dano = r.nextInt(player.getAtaque());
                            System.out.println("Você golpeou o inimigo (" + dano + " de dano)");
                            int v = inimigo.recebeDano(dano);
                            if(v == 0){
                                System.out.println("Você matou " + inimigo.getNome());
                                chance(player);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Você não possui itens");
                    }
                    
                }

                if(opt == 4){
                    break;
                }
                    
                    dano = r.nextInt(inimigo.getAtaque());
                    System.out.println(inimigo.getNome() + " golpeou você (" + dano + " de dano)");
                    player.recebeDano(dano);
            }
            
            i++;
            clear();
        }
    }

    public static void use(Guerreiro player) {
        Scanner e = new Scanner(System.in);
        System.out.print("Digite o indice do item que deseja usar: ");
        int i = e.nextInt();
        player.usaItens(player, i);
        
    }

    public static void main(String[] args) throws InterruptedException {
        Guerreiro player = menu();
        clear();
        Random r = new Random();

        while(true){
            Scanner e = new Scanner(System.in);
            System.out.println("\n1- Caçar\n2- Abrir a bolsa de itens\n3- Usar um item\n4- Ver Status");
            System.out.println("O que deseja fazer?");
            int opt = e.nextInt();

            switch(opt){
                case 1:
                Thread.sleep(r.nextInt(6)*1000);
                cacar(player);
                break;
                case 2:
                if (player.getItens().size() != 0){
                    player.listaItens(player);
                }
                else{
                    System.out.println("Você não possui itens");
                    Thread.sleep(1000);
                }  
                break;
                case 3:
                if (player.getItens().size() != 0)
                    use(player);
                else
                    System.out.println("Você não possui itens");
                    Thread.sleep(1000);
                break;
                case 4:
                System.out.println(player.toString());
            }

        }
    }
}
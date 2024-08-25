package Campeonato;

public class Clube {
    String nome;
    int pontos;
    int saldoGols;

    public Clube (String nome) { //Criando parâmetros do Constructor
        this.nome = nome;
    }

    //Criando métodos
    public void ganhar (int saldoGols) {
        this.pontos += 3;
        this.saldoGols += saldoGols;
    }

    public void perder (int saldoGols) {
        this.saldoGols -= saldoGols;
    }

    public void empatar () {
        this.pontos += 1;
    }
}

package Campeonato;

import java.util.Random;

public class Campeonato {
    
    Clube[]clubes = new Clube[4]; //Criando o array que vai armazenar as infomações de cada clube
    int contadorClubes = 0;

    public Campeonato (Clube[] clubes) {
        this.clubes = clubes;
    }
    
    public void jogarCampeonato () {
        for (int i = 0; i < clubes.length; i++) {
            for (int j = i + 1; j < clubes.length; j++) { // j = i + 1 garante que o clube[i] não seja igual ao clube[j]
                jogarPartida (clubes[i], clubes[j]);
                jogarPartida (clubes[j], clubes[i]); //Partida de volta
            }
        }
    }
    
    private void jogarPartida (Clube a, Clube b) {
        Random random = new Random();
        int golsdeA = random.nextInt(6);
        int golsdeB = random.nextInt(6);
        String clubeVencedor; //String criada para ser utilizada na tabela de informações de cada rodada, onde ela recebe o nome do clube vencedor de cada rodada
        
        if (golsdeA < golsdeB) {
            b.ganhar (golsdeB - golsdeA); 
            a.perder (golsdeB - golsdeA);
            clubeVencedor = b.nome;
        }
        else if (golsdeA > golsdeB ) {
            a.ganhar (golsdeA - golsdeB);
            b.perder (golsdeA - golsdeB);
            clubeVencedor = a.nome;
        }
        else {
            a.empatar ();
            b.empatar ();
            clubeVencedor = "Empate";
        }
        
        //Exibindo informações de cada rodada:
        System.out.println("=====================");
        System.out.println("Time 1: " + a.nome);
        System.out.println("Gols: " + golsdeA);
        System.out.println("Time 2: " + b.nome);
        System.out.println("Gols: " + golsdeB);
        System.out.println("Placar: " + golsdeA + "x" + golsdeB);
        System.out.println("Time vencedor: " + clubeVencedor);
        System.out.println("Pontos marcados por o time 1: " + a.pontos);
        System.out.println("Pontos marcados por o time 2: " + b.pontos);
        System.out.println("=====================");
    }


    //Criando a tabela                
    public String getClassificacao () {
        for (int i = 0; i < clubes.length - 1; i++) {
            for (int j = 0; j < clubes.length - 1 - i; j++) {
                if (clubes[j].pontos < clubes[j + 1].pontos) { //Ordenando o vetor, onde o melhor time fica na posição clubes[0], o segundo melhor na clubes[1] e assim por diante
                    Clube temp = clubes[j];
                    clubes[j] = clubes[j + 1];
                    clubes[j + 1] = temp;
                }
                else if ((clubes[j].pontos == clubes[j + 1].pontos) && (clubes[j].saldoGols < clubes[j + 1].saldoGols)) { //Critério de desempate (Saldo de gols)
                    Clube temp = clubes[j];
                    clubes[j] = clubes[j + 1];
                    clubes[j + 1] = temp;
                }
            }
        }

        String tabelaClassificacao = "";
        for (int i = 0; i < clubes.length; i++) { //Tabela que exibe a posição de cada clube, do melhor para o pior
            tabelaClassificacao += "===================== \n"; //Concatenando a string tabelaClassificacao a cada loop do for
            tabelaClassificacao += clubes[i].nome + "\n";
            tabelaClassificacao += clubes[i].pontos + "\n";
            tabelaClassificacao += clubes[i].saldoGols + "\n";
            tabelaClassificacao += "===================== \n";
        }
        return tabelaClassificacao;
    }

    public void getCampeao () {
        System.out.println("O GRANDE CAMPEÃO É: " + clubes[0].nome); 
    }
}

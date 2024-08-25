package Campeonato;

import java.util.Scanner;

public class Teste {

    Clube[]clubes = new Clube[4]; //Criando o array que vai armazenar as infomações de cada clube
    int contadorClubes = 0;
    public void times (String nomeDoClube) {  
        if (contadorClubes < clubes.length) { //Verifica se ainda há espaço no array
            clubes[contadorClubes] = new Clube (nomeDoClube); //Adiciona cada clube na sua posição do array
            contadorClubes++;
        }
        else {
            System.out.println("Todos os clubes já foram adicionados!");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        Teste teste = new Teste(); // Instância da própria classe Teste

        // Criação do campeonato com os clubes
        Campeonato campeonato = new Campeonato(teste.clubes);
        
        //Recebendo os times
        String nome;
        for (int i = 0; i < 4; i++) {
            System.out.println("Digite o nome do clube: ");
            nome = scan.nextLine();
            teste.times(nome);
        }

        // Jogar o campeonato (todos contra todos)
        campeonato.jogarCampeonato();

        // Exibir a classificação final
        System.out.println(campeonato.getClassificacao());    

        // Exibir o campeão
        campeonato.getCampeao();

        scan.close();
    }
}


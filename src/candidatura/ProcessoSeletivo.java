package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {


    static void main(String[] args) {

        String [] candidatos = {"Rodrigo", "André", "Mariana", "Felipe", "Guilherme", "Lucia", "Fabiana", "João", "Patrícia", "Larissa"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {

        int tentaivasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            //elas precisarão sofrer alterações para que o código funcione corretamente
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentaivasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");
            }
        }while(continuarTentando && tentaivasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com o candidato "+candidato+" na tentativa nº "+tentaivasRealizadas+"\n");
        }else {
            System.out.println("Não conseguimos contato com o candidato "+candidato+", numero máximo de tentativas "+tentaivasRealizadas+"\n");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(){

        String [] candidatos = {"Rodrigo", "André", "Mariana", "Felipe", "Guilherme", "Lucia", "Fabiana", "João", "Patrícia", "Larissa"};
        System.out.println("Impirmindo a lista de candidatos informando o índice do elemento");

        for(int i = 0; i < candidatos.length; i++){
            System.out.println("O candidato de nº "+(i+1)+" é o "+candidatos[i]);
        }
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi "+candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Rodrigo", "André", "Mariana", "Felipe", "Guilherme", "Lucia", "Fabiana", "João", "Patrícia", "Larissa"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+candidato+" solicitou este valor de salário: R$ "+salarioPretendido);
            if(salarioPretendido <= salarioBase){
                System.out.println("O candidato "+candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return Math.round(ThreadLocalRandom.current().nextDouble(1800, 2200) * 100.0) / 100.0;
    }


    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("LIgar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}

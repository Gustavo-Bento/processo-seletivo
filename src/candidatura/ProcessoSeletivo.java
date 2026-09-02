package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simula um processo seletivo de candidatos, cobrindo três etapas:
 * <ol>
 *     <li>Tentativa de contato telefônico com cada candidato (com número
 *     máximo de tentativas);</li>
 *     <li>Seleção de candidatos com base no salário pretendido em comparação
 *     a um salário base;</li>
 *     <li>Impressão da lista de candidatos.</li>
 * </ol>
 * <p>
 * Esta classe tem finalidade didática, exercitando estruturas de repetição
 * ({@code for}, {@code while}, {@code do-while}), estruturas condicionais e
 * manipulação de arrays em Java.
 * </p>
 *
 * @author Seu Nome
 * @version 1.0
 * @since 2024
 */
public class ProcessoSeletivo {

    /**
     * Método principal responsável por iniciar a simulação do processo
     * seletivo, percorrendo a lista de candidatos e tentando entrar em
     * contato com cada um deles.
     *
     * @param args argumentos de linha de comando (não utilizados neste programa)
     */
    static void main(String[] args) {

        String [] candidatos = {"Rodrigo", "André", "Mariana", "Felipe", "Guilherme", "Lucia", "Fabiana", "João", "Patrícia", "Larissa"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    /**
     * Tenta entrar em contato com o candidato informado, realizando até 3
     * tentativas. A cada tentativa, o resultado é simulado pelo método
     * {@link #atender()}. O laço é interrompido assim que o contato for
     * bem-sucedido ou quando o número máximo de tentativas for atingido.
     *
     * @param candidato nome do candidato com quem se está tentando contato
     */
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

    /**
     * Simula o atendimento (ou não) de uma ligação telefônica, retornando um
     * resultado aleatório.
     *
     * @return {@code true} se a ligação foi "atendida" nesta simulação,
     *         {@code false} caso contrário
     */
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    /**
     * Imprime a lista completa de candidatos de duas formas: primeiro
     * numerada (informando o índice de cada elemento no array) e, em
     * seguida, utilizando um laço {@code for-each}.
     */
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

    /**
     * Percorre a lista de candidatos selecionando até 5 deles, com base na
     * comparação entre o salário pretendido (simulado por
     * {@link #valorPretendido()}) e um salário base fixo de R$ 2000,00. O
     * candidato é selecionado somente se o valor pretendido for menor ou
     * igual ao salário base.
     */
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

    /**
     * Simula o valor de salário pretendido por um candidato, gerando um
     * número aleatório entre 1800,00 e 2200,00, arredondado para duas casas
     * decimais.
     *
     * @return o valor de salário pretendido simulado
     */
    static double valorPretendido(){
        return Math.round(ThreadLocalRandom.current().nextDouble(1800, 2200) * 100.0) / 100.0;
    }

    /**
     * Compara o salário pretendido informado com o salário base da vaga e
     * imprime a orientação correspondente: ligar para o candidato, ligar com
     * contraproposta, ou aguardar o resultado dos demais candidatos.
     *
     * @param salarioPretendido valor de salário pretendido pelo candidato,
     *                          a ser comparado com o salário base
     */
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
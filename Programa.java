import java.util.Scanner;

public class Programa {

   /**
   
    private static String fechamentoDetalhado(double []caixa, int contadorCaixa) {
        String fechamento=" ";
        for (int i = 0; i > contadorCaixa; i++){
            fechamento += ""+caixa[i] + "\n";
        }
        return fechamento;
    }

    private static String fechamentoResumido (double []caixa, int contadorCaixa) {
        String fechamento=" ";
        double valorTotal=0;
        for (int i = 0; i > contadorCaixa; i++){
            valorTotal += caixa[i];
        }
        fechamento = "" + valorTotal;
        return fechamento;
    }
    */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Estacionamento ifrs [] = new Estacionamento [10];

        int boxEscolha = 0;
        boolean continuaPrograma=true;
        String placa="";
        String porte = "";
        String aux = "abc";
        double entrada = 0;
        boolean ocupado = false;
        String escolhaES = "";
        String placaSaida="";
        boolean placaCerta = false;
        int posicaoPlaca=0;
        double horaSaida=0;
        double caixa [] = new double [100];
        int contadorCaixa=0;



        while (continuaPrograma) { //condição para continuar o programa
            
            do {
            System.out.println("Escolha: `E` = ENTRADA | `S` = SAIDA");
            escolhaES = in.next();
            } while (escolhaES.length() > 1); // tratamento para a condição aceitar apenas uma String de 1 caracter
            
            if (escolhaES.equals("E")){ // condição para entrada
                while (boxEscolha > 10 || boxEscolha < 1){ //condição para o numero maximo de boxes no estacionamento
                    System.out.println("DIGITE O SEU BOX DE ESCOLHA:");
                    System.out.println("BOX de [1 ... 10 ]");
                    boxEscolha = in.nextInt();
                    if (ifrs[boxEscolha-1] != null ) { // caso o valor digitado seja em uma vaga que ja esta ocupada não será permitido
                        System.out.println("VAGA OCUPADA");
                        boxEscolha=0;
                    }
                }

                System.out.println("DIGITE A PLACA: ");
                placa = in.next();

                do {
                    System.out.println("DIGITE O PORTE DO VEICULO: ");
                    System.out.println("(Ex: `P` = PEQUENO | `M` = MEDIO | `G` = GRANDE)");
                    aux = in.next();
                } while (aux.length() > 1);
                porte = aux;

                System.out.println("DIGITE A HORA DE ENTRADA DO VEICULO: ");
                entrada = in.nextDouble();

                ocupado = true;
                ifrs[boxEscolha-1] = new Estacionamento(boxEscolha, placa, porte, entrada, ocupado);// atribuo a classe do estacionamento um novo carro estacionado
            }else if (escolhaES.equals("S")){ // condição para saida/retirada de veiculo do estacioanmento
                do { // repita até
                    System.out.println("DIGITE A PLACA DO VEICULO");
                    placaSaida = in.next();
                    for (int i=0;i < ifrs.length; i++){ //repetição para testar a placa e verificar se ela existe no estacionamento
                        if ( ifrs[i] != null) { // só ira comparar caso senha algum carro estacionado no box
                            placaCerta = placaSaida.equals(ifrs[i].getPlaca()) ? true : false;  //operador ternario para comparar a placa, caso exista irá para a repetição e seguir o programa
                            posicaoPlaca = i; // variavel será utilizada para saber o luga no vetor onde esta a placa
                            if (placaCerta) i=ifrs.length;   //determino o valor de i para o tamanho maximo para não se repetir mais                        
                        }
                    }
                }while (!placaCerta); // repita-até placa certa for TRUE/verdadeiro

                System.out.println("INFORME A HORA DE SAIDA");
                horaSaida = in.nextDouble();

                ifrs[posicaoPlaca].setSaida(horaSaida);//seto a hora de saida do veiculo
                System.out.println(" VALOR A PAGAR = R$ "+ifrs[posicaoPlaca].valorEstacionamento()); //pergunto a classe qual o valor do estacioanmento
                caixa[contadorCaixa] = ifrs[posicaoPlaca].valorEstacionamento();// informo o valor que deu para o caixa
                contadorCaixa++; // complemento o contador do caixa para o proximo valor ocupar outra posição no vetor

                ifrs[posicaoPlaca] = null; // apago todas as informações do veiculo no estacionamento

            }

            for (int i = 0; i< ifrs.length; i++){ //impressão de todos os BOXES
                if (ifrs[i] != null) {
                    System.out.println(" BOX " + (ifrs[i].getBox()) + " - Veiculo Estacionado " + ifrs[i]); 
                }else {
                    System.out.println(" BOX " + (i+1) + " - LIVRE");
                }

            }        

            System.out.println("CONTINUAR NO SISTEMA?");
            System.out.println("`C` = CONTINUAR | `F` =  Fechar");
            do {
                aux = in.next();
            } while (aux.length() > 1);
           
            if (aux.equals("F")) // comparação para saber se quer fechar o programa
                continuaPrograma = false; //atribuo falso para a condição de continuar o programa falhar 

            aux = "abc"; // tratamento de erros
            boxEscolha = 0; //tratamento de erros
            escolhaES = "abc"; //tratamento de erros
            
        }

        int escolhaCaixa = 0;
        double totalCaixa = 0;

        //criado 2 modos de exibição do fechamanto do caixa
        System.out.println("Escolha o modo de fechamaento do Caixa do dia:");
        System.out.println("   1 : DETALHADO");
        System.out.println("   2 : SIMPLIFICADO");
        escolhaCaixa = in.nextInt();

        if(escolhaCaixa == 1){
            System.out.println("FECHAMENTO DETALHADO:");
        }else {
            if(escolhaCaixa != 2) { //caso o valor colocado seja diferente da escolha valida, será mostrado apenas o fechamanto simplificado
                System.out.println("ESCOLHA INVALIDA. MOSTRANDO FECHAMENTO SIMPLIFICADO");
            }
            System.out.println("FECHAMENTO SIMPLIFICADO:");
        }
        for (int i = 0; i < contadorCaixa; i++){ //repetição para mostrar as informações sobre o fechamento
            if (escolhaCaixa==1) { // descubro qual foi a escolha para mostrar o detalhe
            System.out.println(" VALOR : R$ "+ caixa[i]);
            }
            totalCaixa+=caixa[i]; // somo todos os valores do caixa
        }

        System.out.println("\n VALOR TOTAL RECEBIDO: R$ "+totalCaixa);
            
    }
}















/** 



            System.out.println("DIGITE O SEU BOX DE ESCOLHA:");
            boxEscolha = in.nextInt();
            if (boxEscolha == 0){
                System.out.println("FECHANDO O SISTEMA");
            }else if( boxEscolha <= 10 ){
                System.out.println("BOX VALIDO");
            }

        ;


        for (int i = 0; i< ifrs.length; i++){
            System.out.println(ifrs[i]); 
        }

        for (int i = 0; i< ifrs.length; i++){
            System.out.println(ifrs[i]); 
        }
        

        
    }
    
}
*/
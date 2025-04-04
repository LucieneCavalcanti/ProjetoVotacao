import java.util.ArrayList;
import java.util.Scanner;

import entity.Voto;
import repository.VotoRepository;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Sistema de Votação");
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        Voto objVoto = new Voto();
        ArrayList<Voto> listaVotos = new ArrayList<>();
        VotoRepository DAO = new VotoRepository();
        do{
            try{
                System.out.println("--- menu ---");
                System.out.println("1 - votar");
                System.out.println("2 - listar votos");
                System.out.println("3 - resultado parcial");
                System.out.println("4 - validar voto");
                System.out.println("5 - Sair");
                System.out.println("Digite uma opção:");
                opcao = ler.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite seu voto:");
                        objVoto.setVoto(ler.nextInt());
                        if(DAO.incluir(objVoto)) 
                            System.out.println("Voto salvo com sucesso!");
                        else
                            System.out.println("Erro ao salvar voto");
                        break;
                    case 3:
                        ArrayList resultados = DAO.mostrarResultados();
                        for (int i=0; i< resultados.size();i++) {
                            if(i%2==0)
                                System.out.print("---- Candidato:");
                            else
                                System.out.print("Votos:");
                            System.out.println(resultados.get(i));
                        }
                    break;
                
                    default:
                        break;
                }
            }catch(Exception erro){
                System.out.println("Erro:" + erro.getMessage());
            }
        }while(opcao!=5);
    }
}

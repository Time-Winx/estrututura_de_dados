package arvoreGenerica.painelAvoreGenerica;

import java.util.ArrayList;
import java.util.Scanner;

import arvoreGenerica.implementacao.interfaces.Position;
import arvoreGenerica.implementacao.interfaces.TreePosition;
import arvoreGenerica.implementacao.tad_lista_de_nodos.NodePositionList;
import arvoreGenerica.implementacao.tad_lista_de_nodos.PositionList;
import arvoreGenerica.implementacao.tree.LinkedTree;
import arvoreGenerica.implementacao.tree.TreeNode;
import painel.Menu;

public class PainelArvoreGenerica {
    static TreePosition<String> raiz;
    static Position<Position<String>> p, s;
    static PositionList<Position<String>> filhos;
    //static LinkedTree<String> T = criarArvoreT();
    static LinkedTree<String> T = null;
    static ArrayList<String> aux = new ArrayList<String>();
    static ArrayList<Position<String>> posicao = new ArrayList<Position<String>>();
    static Scanner enter = new Scanner(System.in);
    static boolean arvoreCriada = false;

    public static void apresentacao(){
        System.out.println("\n==========================================================");
        System.out.println("|                TAD - Árvore Genérica                   |");
        System.out.println("==========================================================");
    }

    // Retorna todas as posicoes e as coloca em um ArrayList
	public static ArrayList<Position<String>> listaDePosicoes() {
		Iterable<Position<String>> positions = T.positions();
		posicao.clear();
		for (Position<String> pos : positions){
			posicao.add(pos);
		}
		// elements.addLast(pos.element());
		return posicao;
	}

    private static void iniciandoArvore() {
        System.out.println(" -----------------------------------------");
        System.out.println("|      Iníciando uma Àrvore Genérica      |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 1. Vazia                                |");
        System.out.println("| 2. Com elementos                        |");
        System.out.println("|_________________________________________|");

        System.out.print("Informa a forma da árvore inícial: ");
        int entrada = enter.nextInt();

        if(entrada == 1){
            T = new LinkedTree<String>();
        }else if(entrada == 2){
            T = criarArvoreT();
        }else{
            System.out.println("Opção invalida, tente novamente!");
            iniciandoArvore();
        }
        arvoreCriada = true;
    }

    public static void menuArvoreGenerica(){
        apresentacao();

        if(arvoreCriada == false){
            iniciandoArvore();
        }

        aux.clear();
        for(Position<String> p : listaDePosicoes()){
            aux.add(p.element());
        }
        
        System.out.println(" -----------------------------------------");
        System.out.println("|                 Métodos                 |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 1. ParentheticRepresentation            |");
        System.out.println("| 2. ToStringPostorder                    |");
        System.out.println("| 3. IsEmpty                              |");
        System.out.println("| 4. Height1                              |");
        System.out.println("| 5. Height2                              |");
        System.out.println("| 6. Root                                 |");
        System.out.println("| 7. isExternal                           |");
        System.out.println("| 8. isRoot                               |");
        System.out.println("| 9. parent                               |");
        System.out.println("| 10. children                            |");
        System.out.println("| 11. replace                             |");
        System.out.println("| 12. addRoot                             |");
        System.out.println("| 13. swapElements                        |");
        System.out.println("| 14. createFilho                         |");
        System.out.println("|_________________________________________|");
        System.out.println("| 15. Voltar                               |");
        System.out.println("|_________________________________________|");

        System.out.print("Informa o número do método que deseja testar: ");
        int entrada = enter.nextInt();

        switch (entrada) {
            case 1:
                testaParentheticRepresentation();
                break;
            case 2:
                testaToStringPostorder();
                break;
            case 3:
                testaIsEmpty();
                break;
            case 4:
                testaHeight1();
                break;
            case 5:
                testaHeight2(pegaPosicao());
                break;
            case 6:
                testaRoot();
                break;
            case 7:
                testeIsExternal(pegaPosicao());
                break;
            case 8:
                testeIsRoot(pegaPosicao());
                break;
            case 9:
                testeParent(pegaPosicao()) ;
                break;
            case 10:
                testeChildren(pegaPosicao());
                break;
            case 11:
                testeReplace(pegaPosicao());
                break;
            case 12:
                testeAddRoot();
                break;
            case 13:
                testeSwapElements(pegaPosicao(), pegaPosicao());
                break;
            case 14:
                testeCriarFilho(pegaPosicao());
                break;
            case 15:
                Menu.painelGeral();
                break;
        }


        // Escolhendo a posição que deseja fazer determinada operação
        //pegaPosicao();
        

    }

    

    public static Position<String> pegaPosicao(){
        System.out.println(" -----------------------------------------");
        System.out.println("|                Posições                 |");
        System.out.println("|-----------------------------------------|");
        int item = 1;
        for(String e : aux){
            System.out.println("| " + item + ". " + e + "                                 |");
            item++;
            //if(item == aux.size()) break;
        }
        System.out.println("|_________________________________________|");

        System.out.print("Informa posição que deseja: ");
        int entrada = enter.nextInt();


        return posicao.get(entrada - 1);
    }


    public static void testaParentheticRepresentation(){
        System.out.println("=============================================================");
        System.out.println(T.parentheticRepresentation(T, T.root()));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testaToStringPostorder(){
        System.out.println("=============================================================");
        System.out.println(T.toStringPostorder(T, T.root()));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testaIsEmpty(){
        System.out.println("=============================================================");
        System.out.println("Está vazia? " + T.isEmpty()); 
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testaHeight1(){
        System.out.println("=============================================================");
        System.out.println("Altura da Árvore: " + T.height1(T));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testaHeight2(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Altura da Árvore: " + T.height2(T, p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testaRoot(){
        System.out.println("=============================================================");
        System.out.println("Raiz da Árvore Genérica: " + T.root().element());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeIsExternal(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É externo: " + T.isExternal(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeIsRoot(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É externo: " + T.isRoot(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeParent(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("O pai de " + p.element() + " é " + T.parent(p).element());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeChildren(Position<String> p){
        System.out.println("=============================================================");
        ArrayList<String> filhos = new ArrayList<String>();
        for(Position<String> w : T.children(p)){
			filhos.add(w.element());
		}
        System.out.println(filhos);
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeReplace(Position<String> p){
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("O elemento " + T.replace(p, elemento) + " foi substituido pelo " + elemento +".");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeAddRoot(){
        System.out.println("Informe o elemento: ");
        String elemento = enter.next();
        TreeNode<String> raiz;

        System.out.println("=============================================================");
        System.out.println("O elemento " +  T.addRoot(elemento).element() + " foi adicionado a raiz da árvore.");
        System.out.println("=============================================================");
        
		raiz = (TreeNode<String>) T.root();
		raiz.setChildren(new NodePositionList<Position<String>>());
        voltandoAoMenu();
    }

    public static void testeSwapElements(Position<String> p, Position<String> o){
        T.swapElements(p, o);
        System.out.println("=============================================================");
        System.out.println("| Os elementos " + p.element() + " e " + o.element() + " foram trocados");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeCriarFilho(Position<String> p){
        TreeNode<String> pai = (TreeNode<String>) p;
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("| " + criarFilho(pai, elemento).element() +" é o novo filho de " + pai.element() +".");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }   

    public static void voltandoAoMenu(){
        System.out.println("Voltando ao menu...");
        try{ Thread.sleep(2000); }catch(Exception error){}
        menuArvoreGenerica();
    }
    
    private static TreeNode<String> criarFilho(TreeNode<String> p, String n) {
        if(T.size() == 0){
            System.out.println("Árvore está vazia, crie prmeiro a raiz!");
            menuArvoreGenerica();
        }
		PositionList<Position<String>> filhos;
		TreeNode<String> aux;
		// Obtém os Filhos de p
		filhos = p.getChildren();
		// Cria um novo filho
		aux = new TreeNode<String>();
		aux.setElement(n);
		aux.setParent(p);
		aux.setChildren(new NodePositionList<Position<String>>());
		filhos.addLast(aux);
		return aux;
	}

	public static LinkedTree<String> criarArvoreT() {

		// LinkedTree<String> T = new LinkedTree<String>();
		TreeNode<String> raiz, v, m, i, u;
		T.addRoot("Eletronics R'Us");
		raiz = (TreeNode<String>) T.root();
		raiz.setChildren(new NodePositionList<Position<String>>());
	
		// Filhos da raiz: Eletronic R'Us
		criarFilho(raiz, "P&D");
		v = criarFilho(raiz, "Vendas");
		criarFilho(raiz, "Compras");
		m = criarFilho(raiz, "Manufatura");
	
		// Filhos de Vendas
		i = criarFilho(v, "Internacional");
		criarFilho(v, "Nacional");
	
		// Filhos de Internacional
		criarFilho(i, "Canadá");
		criarFilho(i, "América do Sul");
		u = criarFilho(i, "Ultramar");
	
		// Filhos de Ultramar
		criarFilho(u, "África");
		criarFilho(u, "Europa");
		criarFilho(u, "Ásia");
		criarFilho(u, "Austrália");
	
		// Filhos de Manufatura
		criarFilho(m, "TV");
		criarFilho(m, "CD");
		criarFilho(m, "Tuner");
		return T;

	}









}

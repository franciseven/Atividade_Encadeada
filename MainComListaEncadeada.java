public class MainComListaEncadeada {

	public static void main(String[] args) {

		//criando a lista vazia
		ListaEncadeada lista = new ListaEncadeada();
		
		//inserindo três valores na lista
		lista.insere(1,48);
		lista.insere(2,77);
		lista.insere(3,5);
		
		//imprimindo na tela todos os elementos da lista
		System.out.print("Lista: ");
		for(int i = 1 ; i <= lista.tamanho() ; i++) {	
			System.out.print(lista.elemento(i) + ", ");
		}
		
		System.out.println();
		
		//verificando se a lista está vazia
		if(lista.vazia() == true) {
			System.out.println("A lista está vazia");
		}
		else System.out.println("A lista não está vazia");

		//exibindo o tamanho da lista
		System.out.println("Tamanho da lista: " + lista.tamanho());
		
		//modificando um elemento da lista
		lista.modificaElemento(7, 3);
		System.out.print("Lista modificada: ");
		for(int i = 1 ; i <= lista.tamanho() ; i++) {	
			System.out.print(lista.elemento(i) + ", ");
		}
		
		//Removendo um elemento da lista
		lista.remove(1);
		System.out.print("\nLista com o elemento removido: ");
		for(int i = 1 ; i <= lista.tamanho() ; i++) {	
			System.out.print(lista.elemento(i) + ", ");
		}
	}
}

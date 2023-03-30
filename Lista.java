public interface Lista {

	//Retorna true se a lista estiver vazia e false se não estiver
	public boolean vazia();
	
	//Retorna true se a lita estiver cheia e false se não estiver
	public boolean cheia();
	
	//Retorna o tamanho da lista
	public int tamanho();
	
	//Mostra o elemento presente na posição inserida
	public int elemento(int pos);
	
	//Retorna a posição, na lista, do dado inserido
	public int posição(int dado);
	
	//Atribui o dado inserido na posição requisitada
	public boolean insere(int pos, int dado);
	
	//Remove o elemento da posição inserida
	public int remove(int pos);
}

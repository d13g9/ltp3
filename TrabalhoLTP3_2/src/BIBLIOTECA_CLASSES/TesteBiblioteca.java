package BIBLIOTECA_CLASSES;

import BIBLIOTECA_PESSOAL.Biblioteca;

public class TesteBiblioteca {

	public static void main(String[] args) {
	
		String cpf = "46546546545465";
		
		if(Biblioteca.validarCPF(cpf))
			System.out.println("It worked");
		

	}

}

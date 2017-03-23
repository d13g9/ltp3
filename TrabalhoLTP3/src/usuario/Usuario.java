package usuario;

import utilitarios.*;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import Cadastro.*;
import Dados.*;

public class Usuario {

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		int opt = 0;
		
		printMenu();
		opt = Console.readInt("");
		switch(opt){
		case 1:
			insertBook();
			printList();
			break;
		case 2:
			updateBook();
		}
	}

	private static void updateBook() {
		int id = 0;
		boolean flag = false;
		
		printList();
		id = readId();
		Livro book = CadLivros.searchById(id);
	   
	   if (book == null){
		   Console.printPrompt("Id not found");
	   }
	   else{
		   
		   
	   }
	   	
		
	}

	private static int readId() {
		int id = 0;
		boolean flag;
		
	   do{
		   try
		   {
			   id =  Console.readInt("Please type id of book: ");
			   flag = false;
		   }catch(Exception ex)
		   {
			   flag = true;
		   }
	   }while(flag);
	   
	   return id;
		
	}

	private static void printList() {
		Console.printPrompt("Pinting List\n");
		for(Livro livro: CadLivros.booksLibrary){
			Console.printPrompt(livro.toString());
			
		}
		
	}

	private static void insertBook() {
		String title = "", author = ""; 
		GregorianCalendar date_record = new GregorianCalendar();
		
		title    = readString("Type the title of "
							+ "	the book (cannot be empty)");
		author   = readString("Type the author of "
							+ " the book (cannot be empty)");
		
		Livro livro = new Livro(CadLivros.getMaxID(),
								title,
								author,
								date_record);
		CadLivros.addBooks(livro);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		//Console.printPrompt(sdf.format(date_record.getTime()));
		
					  
	}

	private static String readString(String message) {
		String variable = "";
				
		do{
			Console.printPrompt(message);
			variable = Console.readLine();
		}while(variable.equals(""));
		
		return variable;
		
	}

	private static void printMenu() {
		
		Console.printPrompt("What do you want to do ?\n");
		Console.printPrompt("1 to insert a new book\n");
		Console.printPrompt("2 to alter data of the book\n");
		Console.printPrompt("3 delete book\n");
		Console.printPrompt("4 search for book by code\n");
		Console.printPrompt("5 search for book by title\n");
		
	}

}

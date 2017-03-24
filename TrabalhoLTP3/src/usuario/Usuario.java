package usuario;

import utilitarios.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import Cadastro.*;
import Dados.*;

public class Usuario {

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		int opt = -1;
		do{
			printMenu();
			opt = Console.readInt("");
			switch(opt){
			case 1:
				insertBook();
				printList();
				break;
			case 2:
				updateBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				printBook();
				break;
			case 5:
				printBookByName();
				break;
		   }
		}while(opt != 0);
		
	}

	private static void printBookByName() {
		String title = "";
		ArrayList<Livro> resultSet = null;
		
		title     = readString("Type the title of book");
		resultSet = CadLivros.searchByName(title);
		
		if(resultSet != null){
			if(resultSet.size() > 0){
				for(Livro book : resultSet){
					Console.printPrompt(book.toString());
				}
			}
		}
	}

	private static void printBook() {
		Livro book = getBookById();
		Console.printPrompt(book.toString());
		
	}

	private static void deleteBook() {
		Livro book = getBookById();
		
		if(checkBook(book)){
			CadLivros.removeBook(book);
		}
		printList();
		
	}

	private static boolean checkBook(Livro book) {
		 if (book == null){
			 Console.printPrompt("Id not found");
			 return false;
		 }else
			 return true;
			 
		 	
	}

	private static void updateBook() {
		Livro book = getBookById();
		   
	   if (checkBook(book)){
		   book.setAuthor(readString("Type the new author name"));
		   book.setTitle(readString("Type the new title of book"));
		   book.setDate_record(readDate()));
	   }
	   printList();	
		
	}

	private static GregorianCalendar readDate() {
		boolean dateisValid;
		
		do{
			dateisValid = false;
			String date = Console.readLine("Type record date");
			if(LtpUtil.validarData(date)){
				dateisValid = true;
				Console.readLine("Typed Date is invalid");
			}
		}while(dateisValid);
		
		
		
	}

	private static Livro getBookById() {
		int id = 0;
		
		printList();
		id = readId();
		return CadLivros.searchById(id);
		
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
		Console.printPrompt("0 to leave\n");
		
	}

}

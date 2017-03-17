package Cadastro;
import java.util.ArrayList;
import Dados.*;

public class CadLivros {

	static public ArrayList<Livro> booksLibrary = 
									new ArrayList<Livro>();
	//add book
	static public void addBooks(Livro book){
		booksLibrary.add(book);		
	}
	//procura por ID
	static public Livro searchById(int id){
		for(Livro book : booksLibrary){
			if(book.getId() == id)
				return book;
		}
		return null;
		
	}
	//remove livro
	static public void removeBook(Livro books){
		booksLibrary.remove(books);		
	}
	
	static public ArrayList<Livro> searchByName(String name){
	    ArrayList<Livro> listfilter = new ArrayList<Livro>();
		
		for(Livro book : booksLibrary){
			if(book.getTitle().contains(name))
				listfilter.add(book);
		}
		return listfilter;
		
	}
	static public int getMaxID()
	{
		int max =0;
		
		if(booksLibrary.isEmpty())
		{
			return 1;
		}
		else
		{
			for(Livro book : booksLibrary)
			{
				if(book.getId() > max)
					max = book.getId();
			}
		}
		max++;
		return max;
	}
}

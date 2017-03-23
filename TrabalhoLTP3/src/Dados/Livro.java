package Dados;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Livro {
	
	private int id;
	private String title,author;
	private GregorianCalendar date_record;
	
	public Livro(int id,String title, String author, 
									GregorianCalendar date_record)
	{
		this.setId(id);
		this.setTitle(title);
		this.setAuthor(author);
		this.setDate_record(date_record);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GregorianCalendar getDate_record() {
		return date_record;
	}

	public void setDate_record(GregorianCalendar date_record) {
		this.date_record = date_record;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Id is "+this.id + "\n" +" Title is "+this.title +
				" \n Author is "+this.author +" \n Date of Record "+
				sdf.format(this.date_record.getTime()) + "\n";
					
	}

}

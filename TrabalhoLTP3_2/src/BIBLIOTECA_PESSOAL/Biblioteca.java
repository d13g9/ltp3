package BIBLIOTECA_PESSOAL;

public class Biblioteca {

	private static String cpfmatch = "\\d{9}-?\\d\\d";
	private static String cnpfmatch = "\\d{9}\\d\\d";
	
	public static boolean validarCPF(String cpf)
	{
		int x = 0, y = 0,T1 = 0,T2;
				
		if(cpf.matches(cpfmatch)){
			cpf = cpf.replace("-", "");
			if(cpf.length() == 11)
			{
				T1 = doCalculateCpfandCNJDigit(cpf,10);
				x = 11 - (T1 % 11);
				T2 = doCalculateCpfandCNJDigit(cpf,11);
				y  = 11 - (T2 % 11);
				
				if(x > 9){
					x = 0;
				}
				if(y > 9){
					y = 0;
				}
				if(x == Character.getNumericValue(cpf.charAt(9)) &&
				   y == Character.getNumericValue(cpf.charAt(10)))
				   return true;
			}
			else
			{
				return false;
			}
		}
		return false;
		
	}

	public static boolean validarCNPJ(String cpf)
	{
		int x = 0, y = 0,T1 = 0,T2;
				
		if(cpf.matches(cpfmatch)){
			cpf = cpf.replace("-", "");
			if(cpf.length() == 11)
			{
				T1 = doCalculateCpfandCNJDigit(cpf,10);
				x = 11 - (T1 % 11);
				T2 = doCalculateCpfandCNJDigit(cpf,11);
				y  = 11 - (T2 % 11);
				
				if(x > 9){
					x = 0;
				}
				if(y > 9){
					y = 0;
				}
				if(x == Character.getNumericValue(cpf.charAt(9)) &&
				   y == Character.getNumericValue(cpf.charAt(10)))
				   return true;
			}
			else
			{
				return false;
			}
		}
		return false;
		
	}
	private static int doCalculateCpfandCNJDigit(String cpf, int i) {
		int multiplier = i,sum = 0;
		
		for(char a : cpf.toCharArray()){
			sum += Character.getNumericValue(a) * multiplier;
			if (multiplier == 2)
				break;
			multiplier--;
		}
		
		return sum;
	}
	
}

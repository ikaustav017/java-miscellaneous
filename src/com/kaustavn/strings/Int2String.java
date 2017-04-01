package com.kaustavn.strings;

public class Int2String {
	
	/*371
	 * 371%10  =1
	 * 37%10 =7
	 * 3/10 =3
	 * 0
	 */
	public static final int MAX_DIGIT =10;
	public static String IntToString(int num) throws Exception{
			
		char[] temp= new char[MAX_DIGIT+1];
		int i=0;
		boolean negFlag=false;
		
		if( num<0){
			negFlag =true;
			num*=-1;
		}
		
		do{
			temp[i++]= (char) ((num%10)+'0');
			num=num/10;
		}while(num!=0);
		
		
		
		StringBuffer sb=  new StringBuffer();
		if( negFlag){
			 sb.append("-");
		}
		
		while(i>0){
			sb.append(temp[--i]);
		}
		return sb.toString();
		
		
	}
	
	public static void main(String args[]){
		
		try {
			System.out.println(IntToString(450));
			System.out.println(IntToString(-189));
			System.out.println(IntToString(0));
			System.out.println(IntToString(-1));
			System.out.println(IntToString(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
}


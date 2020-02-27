import java.util.Scanner;
import java.util.Arrays; 

public class Main {
	
	public static void main(String[] args) {
		int select,aux=2;
		Scanner read=new Scanner(System.in);
		do {
			menu();
			select = read.nextInt();
			
			switch(select) {
			case 1: mixto(); break;
			default: break;
			}
		}while(select!=0);
		
	}
    public static void mixto() {
    	Scanner read=new Scanner(System.in);
    	int xo,i = 0,aux=0,menos=0,mas=0,n1,n2;
    	int racha=1;
    	char []vs= {'+','-'};
    	vs[0]='+';
    	System.out.print("CANTIDAD DE NUMEROS QUE DESEA  GENERAR ");
		int n=read.nextInt();
		char vsig[]=new char[n+1];
    	double z,r,w[] = new double [n+1],waux[] = new double [n+1];
    	int v[] = new int [n+1];
    	
		System.out.print("Introduzca Xo: "); int s = read.nextInt();
		System.out.print("Introduzca a: "); int a=read.nextInt();
		System.out.print("Introduzca c: "); int c=read.nextInt();
		System.out.print("Introduzca m: "); int m=read.nextInt();
		

		if (s>0 && a>0 && c>0 && m>0) {
			System.out.println("     SOLUCION     ");
			for(i=1;i<=n;i++) {	
				xo=(a*s+c)%m;
				s=xo;
				r= (xo/(m-1.0));
				v[i]=xo;
				w[i]=redondear(r);
				waux[i]=redondear(r);
				
				
			}
			for(i=1;i<=n;i++) {
				System.out.println("xo= "+v[i]+" r("+i+")= " +w[i]);
				if(v[i]==v[1]) {
					if(v[i+1]==v[2]) {
						if(v[i+2]==v[3]) {
							aux++;
						}
					}
				}	
			}
			
			System.out.println("Los prieros 3 numeros se repiten = "+aux);
			System.out.println("                  -**-                   ");
			System.out.println();
			System.out.println("");
	    	Arrays.sort(waux);
	    	for(i=1;i<=n;i++) {
	    		System.out.print(w[i]+"  ");
	    	}
	    	System.out.println(" ");
	    	for(i=1;i<=n;i++) {
	    		if(w[i]<waux[n/2]) {
	    			vsig[i]='-'; menos=menos+1;			
	    		}else {
	    			vsig[i]='+'; mas=mas+1;
	    		}
	    		System.out.print("   "+ vsig[i] +"    ");
	    	}
	    	System.out.println(" ");
	    	/*
	    	System.out.println("LA CANTIDAD DE SIGNOS +  ="+mas);
	    	System.out.println("LA CANTIDAD DE SIGNOS -  ="+menos);
	    	*/
	    	if(mas>menos) { n1 = mas; n2 = menos;}
	    	else {n1 = menos; n2 = mas;}
	    	System.out.println("\n\n");
	    	System.out.println("EL VALOR MEDIO ES : " + waux[(n/2)]);
	    		for(i=2;i<=n;i++) {
	    			if(vsig[i]!=vsig[i-1]) {
	    				racha++;
	    			}
	    		}
	    	System.out.println("EL VALOR DE LA RACHA ES=   " + racha);
	    	System.out.println("EL VALOR DE n1= "+n1);
	    	System.out.println("EL VALOR DE n2= "+n2);
	    	
	    	double mu=((2*n1*n2)/(n))+1;
	    	
	    	//double desv=Math.sqrt(((2*n1*n2)*((2*n1*n2)-n))/(Math.pow(n, 2))*(n-1));
	    	
	    	double desv=Math.sqrt(((2*n1*n2)*((2*n1*n2)-n1-n2))/(Math.pow((n1+n2), 2)*(n1+n2-1)));
	    	
	    	System.out.println("EL VALOR DE MU= "+ mu);
	    	System.out.println("EL VALOR DE DESV= "+redondear(desv));
	    	
	    	z=(racha-mu)/desv;
	    	System.out.println("EL VALOR DE Z= "+redondear(z)+"\n");
	    	if(Math.abs(z)<1.96) {
	    	    System.out.println("AL 0.05 DE SIGNIFICANCIA--> 'Ho': no se rechaza por lo tanto se verifica la aleatoridad. \n\n");
	    	}
	    	else {
	    		System.out.println("AL 0.05 DE SIGNIFICANCIA--> 'Ho': se rechaza por lo tanto son numero aleatorios \n\n");
	    	}
	    	
		}
	}
    
    public static double redondear(double x) {
    	double res;
    	res=x*Math.pow(10, 4);
		res=Math.round(res);
		res=res/Math.pow(10,4);
    	return res;
    }
        
   public static void menu() {
		System.out.println("----------------------------------");
		System.out.println("--  GENERAR NUMEROS ALEATORIOS  --");
		System.out.println("----------------------------------");
		System.out.println("-   1) SI                        -");
		System.out.println("-   0) NO                        -");
		System.out.println("----------------------------------");
	}
}

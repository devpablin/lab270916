package lab270916;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	static int fa=0,fb=0;
	static int ca=0,cb=0;
	static int fc=0,cc=0;
	public static class nodo{
		int f,c,d;
		nodo sgte;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nodo a=null, b=null, c=null;
		
		int opcion;
		do{
			System.out.println("1. leer matriz \n2.listar\n3.sumar matrices \n"
					+ "4. Multiplicar\n5. Salir ");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				System.out.println("1. Matriz A\n2. Matriz B");
				switch(leer("su opcion")){
				case 1:
					do{
						fa=leer("filas?");
					}while(fa<=0);
					do{
						ca=leer("columnas?");
					}while(ca<=0);
					for (int i = 0; i < fa; i++) {
						for (int j = 0; j < ca; j++) {
							a=addcola(a, i, j);
						}
					}
					break;
				case 2:
					do{
						fb=leer("filas?");
					}while(fb<=0);
					do{
						cb=leer("columnas?");
					}while(cb<=0);
					for (int i = 0; i < fb; i++) {
						for (int j = 0; j < cb; j++) {
							b=addcola(b, i, j);
						}
					}
					break;
				}
				break;
			case 2:
				System.out.println("1. Matriz A\n2. Matriz B\n3. Matriz C");
				switch(leer("su opcion")){
				case 1:
					for (int i = 0; i < fa; i++) {
						for (int j = 0; j < ca; j++) {
							System.out.print(buscar(a,i,j)+"\t");
						}
						System.out.println();
					}
					break;
				case 2:
					for (int i = 0; i < fb; i++) {
						for (int j = 0; j < cb; j++) {
							System.out.print(buscar(b,i,j)+"\t");
						}
						System.out.println();
					}
					break;
				case 3:
					for (int i = 0; i < fc; i++) {
						for (int j = 0; j < cc; j++) {
							System.out.print(buscar(c,i,j)+"\t");
						}
						System.out.println();
					}
				}
				break;
			case 3:
				if(a!=null&&b!=null){
					if(fa==fb&&ca==cb){
						c=sumar(c,a,b);
						fc=fa;
						cc=ca;
					}
					
				}
				break;
			case 4:
				c=null;
				if(a!=null&&b!=null){
					if(ca==fb){
						fc=fa;
						cc=cb;
						c=multiplicar(c, a, b);
					}
					
				}
			}
		}while(opcion!=5);
		
	}
	public static nodo sumar(nodo c,nodo a,nodo b){
		for (int i = 0; i < fa; i++) {
			for (int j = 0; j < cb; j++) {
				c=addcola2(c, i, j, buscar(a,i,j)+buscar(b,i,j));
			}
		}
		System.out.println("matriz C creada!");
		return c;
	}
	public static nodo multiplicar(nodo c, nodo a, nodo b){
		
		for (int i = 0; i < fc; i++) {
			for (int j = 0; j < cc; j++) {
				int sf=0;
				for (int k = 0; k < ca; k++) {
					sf+=(buscar(a,i,k)*buscar(b,k,j));
				}
				c=addcola2(c,i,j,sf);
			}
		}
		return c;
	}
	public static int buscar(nodo z,int f, int c){
		nodo cp=z;
		int aux=0;
		while(cp!=null){
			if(cp.f==f&&cp.c==c){
				aux=cp.d;
			}
			cp=cp.sgte;
		}
		return aux;
	}
	public static nodo addcola (nodo x, int f, int c){
		nodo cp;
		nodo nuevo=new nodo();
		nuevo.d=leer("dato?");
		nuevo.f=f;
		nuevo.c=c;
		nuevo.sgte=null;
		if (x==null) {
			x=nuevo;
		}else{
			cp=x;
			while(cp.sgte!=null){
				cp=cp.sgte;
			}
			cp.sgte=nuevo;
		}
		return x;
	}
	public static nodo addcola2 (nodo x, int f, int c,int d){
		nodo cp;
		nodo nuevo=new nodo();
		nuevo.d=d;
		nuevo.f=f;
		nuevo.c=c;
		nuevo.sgte=null;
		if (x==null) {
			x=nuevo;
		}else{
			cp=x;
			while(cp.sgte!=null){
				cp=cp.sgte;
			}
			cp.sgte=nuevo;
		}
		return x;
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
	}
}

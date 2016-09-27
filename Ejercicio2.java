package lab270916;

import java.util.Scanner;

import lab270916.Ejercicio1.nodo;



public class Ejercicio2 {
	public static class nodo{
		int f,c,d;
		nodo sgte;
	}
	public static void main(String[] args) {
		int m=0;
		nodo a=null;
		do{
			m=leer("orden?");
		}while(m<=0);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				a=addcola(a, i, j);
			}
		}
		verificar(a,m);
	}
	public static void verificar(nodo a,int m){
		boolean diag=false;
		boolean esc=false;
		boolean id=false;
		boolean sup=false;
		boolean inf=false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(i!=j){
					if(buscar(a,i,j)==0){
						diag=true;
					}
					else{
						diag=false;
					}
				}
			}
		}
		for (int i = 0; i < m-1; i++) {
			if(buscar(a,i,i)==buscar(a,i+1,i+1)){
				esc=true;
			}else{
				esc=false;
				break;
			}
		}
		for (int i = 0; i < m-1; i++) {
			if(buscar(a,i,i)==buscar(a,i+1,i+1)&&buscar(a,i,i)==1&&buscar(a,i+1,i+1)==1){
				if(diag){
					id=true;
				}
			}else{
				id=false;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(i!=j){
					if(buscar(a,i,j)==0){
						diag=true;
					}
					else{
						diag=false;
					}
				}
			}
		}
		
		
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
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
	
}

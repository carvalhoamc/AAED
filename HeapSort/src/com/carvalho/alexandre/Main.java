package com.carvalho.alexandre;

public class Main {

    public static void main(String[] args) {

        int Arranjo[] ={0,4,1,3,2,16,9,10,14,8,7,33,3,63,21,109};

        int temporario[] = RadixCounting(Arranjo,4, 4);
        /*
        List<Registro> a = new LinkedList<>();

		Registro inicializa = new Registro();
		inicializa.setConteudo(0);
		a.add(inicializa);

        for(int i = 1; i < Arranjo.length; i++){
			Registro num = new Registro();
        	num.setConteudo(Arranjo[i]);
			a.add(num);
		}


		HeapOrdena ordenador = new HeapOrdena(a); */
    }


	public static int[] RadixCounting(int A[], int digitos, int base)
	{
		//garantindo que N^3 tenha no máximo digitos-1
		//ordena de forma decrescente

		int tamanho = A.length ;
		int Vaux[] = new int[tamanho] ;
		int div = 1 ;
		int troca[] ;
		int i ;
		while(digitos > 0)
		{
			int Xaux[] = new int[base] ;
			i = 0 ;
			while(i < tamanho)
			{
				Xaux[( A[i] / div ) % base]++ ;
				i++ ;
			}
			i = base ;
			while(i > 1)
			{
				i--;
				Xaux[i-1] += Xaux[i] ;
			}
			i = tamanho ;
			while(i > 0)
			{
				i-- ;
				Vaux[--Xaux[( A[i] / div ) % base]] = A[i];
			}
			troca = A;
			A = Vaux;
			Vaux = troca;
			div *= base;
			digitos--;
		}
		return A;
	}


}

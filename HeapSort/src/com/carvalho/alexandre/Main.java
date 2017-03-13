package com.carvalho.alexandre;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int Arranjo[] ={0,4,1,3,2,16,9,10,14,8,7,33,3,63,21,109};
		List<Registro> a = new LinkedList<>();

		Registro inicializa = new Registro();
		inicializa.setConteudo(0);
		a.add(inicializa);

        for(int i = 1; i < Arranjo.length; i++){
			Registro num = new Registro();
        	num.setConteudo(Arranjo[i]);
			a.add(num);
		}


		HeapOrdena ordenador = new HeapOrdena(a);










    }
}

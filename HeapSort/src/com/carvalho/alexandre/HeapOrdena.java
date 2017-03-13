package com.carvalho.alexandre;

/**
 * Created by Alexandre Miguel de Carvalho on 12/03/17, 12:17.
 * orcid.org/0000-0002-8801-4321
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import java.util.LinkedList;
import java.util.List;

/** Based on "Introduction to Algorithms, 3rd edition, 2009, by
 *  Cormen, Leiserson, Rivest and Stein.
 */

/** Heap d with d = 2.   */


public class HeapOrdena {

	private List<Registro> listElements = new LinkedList<>();
	private final int TAMANHOMAXIMO = 100;
	private int maior = 0;
	private int N = 0;
	private int ordenado[];

	public HeapOrdena(List<Registro> a) {
		listElements = a;
		ordenado = new int[TAMANHOMAXIMO];
		if(listElements.size() >= TAMANHOMAXIMO){
			System.out.println("Tamanho máximo exedido.");
			System.exit(1);
		}
		N = listElements.size()-1;
		System.out.println();
		System.out.println("Build Max Heap");
		BuildMaxHeap(N);
		for (int i = 1; i < listElements.size(); i++){
			System.out.print(listElements.get(i).getConteudo() + " ");
		}
		System.out.println();
		MaxdHeapInsert(52);
		N = listElements.size()-1;
		System.out.println();
		System.out.println("Build Max Heap + New Element");
		BuildMaxHeap(N);
		for (int i = 1; i < listElements.size(); i++){
			System.out.print(listElements.get(i).getConteudo() + " ");
		}
		System.out.println();


		System.out.println("Heap Sort");
		HeapSort(N);
		int i = 0;
		do{
			System.out.print(ordenado[i] + " ");
			i++;
		}while(i < N);
		System.out.println();
	}

	public int Pai(int i){
		return Math.floorDiv(i, 2);
	}

	public int Esquerda(int i){
		return 2*i;
	}

	public int Direita(int i){
		return (2*i) + 1;
	}

	public void Troca(int i, int j){
		Registro temp;
		temp = listElements.get(i);
		listElements.set(i,listElements.get(j));
		listElements.set(j,temp);
	}

	public void MaxHeapify(int i, int n){
		int l = Esquerda(i);
		int r = Direita(i);
		if((l <= n) && (listElements.get(l).getConteudo()> listElements.get(i).getConteudo())){
			maior = l;
		}else{
			maior = i;
		}
		if((r <= n) && (listElements.get(r).getConteudo() > listElements.get(maior).getConteudo())){
			maior = r;
		}
		if(maior != i){
			Troca(i, maior);
			MaxHeapify(maior,n);
		}
	}

	public void BuildMaxHeap(int n){
		for(int i = Math.floorDiv(n,2) ; i >= 1; i--){
			MaxHeapify(i,n);
		}
	}

	public void HeapSort(int n){
		BuildMaxHeap(n);
		for(int i = N; i >= 2; i--){
			Troca(1, i);
			ordenado[i-1] = listElements.get(i).getConteudo();
			listElements.remove(i);
			MaxHeapify(1, i - 1);
		}
		ordenado[0] = listElements.get(1).getConteudo();
	}

	public void MaxdHeapInsert(int valor) {

		Registro g = new Registro();
		int n = 0;
		g.setConteudo(valor);
		listElements.add(g);
		n = listElements.size()-1;
		BuildMaxHeap(n);
		System.out.println("Max Heap + New Element");
		for (int i = 1; i < listElements.size(); i++){
			System.out.print(listElements.get(i).getConteudo() + " ");
		}
		System.out.println();

	}
}

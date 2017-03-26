package com.carvalho.alexandre;

/**
 * Created by Alexandre Miguel de Carvalho on 14/03/17, 20:00.
 * orcid.org/0000-0002-8801-4321
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

/**Binary Search Tree
 * Based on "Introduction to Algorithms", 3rd Edition, CLRS */


public class BST  {

	private int totalNodeNumber;
	private RecordData root;
	RecordData y = null;

	public BST(RecordData r) {
		this.totalNodeNumber = 1;
		this.root = r;
	}

	public int getTotalNodeNumber() {
		return totalNodeNumber;
	}

	public RecordData getRoot() {
		return root;
	}

	public void treeInsert(RecordData z, int keyValue){
		if(z == null){
		//	z = new RecordData(keyValue);
		//	root = z;
		//	totalNodeNumber++;
		//	root.setRoot(true);
		}else{
			if(keyValue < z.getKey() && z.getLeft() == null){
				z.setLeft(new RecordData(keyValue));
				z.getLeft().setParent(z);
				totalNodeNumber++;
			}else{
				if(keyValue > z.getKey() && z.getRight() == null){
					z.setRight(new RecordData(keyValue));
					z.getRight().setParent(z);
					totalNodeNumber++;
				}else{
					if(keyValue < z.getKey()){
						treeInsert(z.getLeft(), keyValue);
					}else{
						treeInsert(z.getRight(),keyValue);
					}
				}
			}
		}
	}


	public void inOrderTreeWalk(RecordData x) {
		if(x != null){
			inOrderTreeWalk(x.getLeft());
			System.out.print(x.getKey() + " ");
			inOrderTreeWalk(x.getRight());
		}
	}

	public RecordData treeSearch(RecordData root, int keyValue) {
		if(root == null || keyValue == root.getKey()){
			return root;
		}
		if(keyValue < root.getKey()){
			return treeSearch(root.getLeft(),keyValue);
		}else{
			return treeSearch(root.getRight(),keyValue);
		}
	}


	public RecordData iterativeTreeSearch(RecordData root, int keyValue) {

		while(root != null && keyValue != root.getKey()){
			if(keyValue < root.getKey()){
				root = root.getLeft();
			}else{
				root = root.getRight();
			}
		}
		return root;
	}

	/** Returns Minimum based on root node x */
	public RecordData treeMinimum(RecordData x) {
		while(x.getLeft() != null){
			x = x.getLeft();
		}

		return x;
	}

	/** Returns Maximum based on root node x */
	public RecordData treeMaximum(RecordData x) {
		while(x.getRight() != null){
			x = x.getRight();
		}
		return x;
	}

	/** Returns the successor of a node x */
	public RecordData treeSuccessor( RecordData x) {
		if(x.getRight() != null){
			return treeMinimum(x.getRight());
		}
		y = x.getParent();
		while(y != null && x == y.getRight()){
			x = y;
			y = y.getParent();
		}
		return y;
	}

	/** Replaces one subtree as a child of its parent with another subtree*/
	public void treeTransplant(RecordData u, RecordData v) {
		if(u.getParent() == null) {
			root = v;
		}else{
			if(u == u.getParent().getLeft()){
				u.getParent().setLeft(v);
			}else{
				u.getParent().setRight(v);
			}
		}
		if(v != null){
			v.setParent(u.getParent());
		}
	}

	/** Delete Node z from BST */
	public void treeDelete(RecordData z) {
		if(z.getLeft() == null){
			treeTransplant(z,z.getRight());
		}else{
			if(z.getRight() == null){
				treeTransplant(z,z.getLeft());
			}else{
				y = treeMinimum(z.getRight());
				if(y.getRight() != z){
					treeTransplant(y, y.getRight());
					y.getRight().setRight(z.getRight());
					y.getRight().setParent(y);
				}
				treeTransplant(z,y);
				y.setLeft(z.getLeft());
				y.getLeft().setParent(y);
			}
		}
	}


	/**
	 *
 	 * @param a valor inicial da chave
	 * @param b valor final da chave
	 * @param x root da arvore
	 */
	void imprimeIntervalo_a_b(int a, int b, RecordData x) {
		if(x != null){
			imprimeIntervalo_a_b(a,b,x.getLeft());
			if((x.getKey() >= a) && (x.getKey() <=b)){
				System.out.print(x.getKey() + " ");
			}
			imprimeIntervalo_a_b(a,b,x.getRight());
		}





	}


}

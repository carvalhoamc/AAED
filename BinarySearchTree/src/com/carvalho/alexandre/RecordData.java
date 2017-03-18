package com.carvalho.alexandre;

/**
 * Created by Alexandre Miguel de Carvalho on 14/03/17, 19:55.
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
 * Based on "Introduction to Algorithms", 3rd Edition, CLRS*/

public class RecordData {

	private int key;
	private RecordData left;
	private RecordData right;
	private RecordData parent;
	private boolean root;



	public RecordData() {
		this.key = -100000000;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.root = false;
	}

	public RecordData(int keyValue) {
		this.key = keyValue;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.root = false;
	}



	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}


	public RecordData getLeft() {
		return left;
	}

	public void setLeft(RecordData left) {
		this.left = left;
	}

	public RecordData getRight() {
		return right;
	}

	public void setRight(RecordData right) {
		this.right = right;
	}

	public RecordData getParent() {
		return parent;
	}

	public void setParent(RecordData parent) {
		this.parent = parent;
	}

	public boolean isRoot() {
		if(this.root != false)
		{
			return true;
		}else {
			return false;
		}
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public boolean hasLeft(int node) {
		if(this.left != null)
		{
			return true;
		}else {
			return false;
		}

	}

	public boolean hasRight(int node) {
		if(this.right != null)
		{
			return true;
		}else {
			return false;
		}

	}

	public boolean hasParent(int node) {
		if(this.parent != null)
		{
			return true;
		}else {
			return false;
		}

	}
}

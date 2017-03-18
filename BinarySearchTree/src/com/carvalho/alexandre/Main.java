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

public class Main {

    public static void main(String[] args) {

        /** Create Root Node */
        RecordData data = new RecordData(1);
        data.setRoot(true);

        /** Create BST with Root Node */
        BST tree = new BST(data);


        tree.treeInsert(data,13);
        tree.treeInsert(data,9);
        tree.treeInsert(data,18);
        tree.treeInsert(data,17);
        tree.treeInsert(data,20);
        tree.treeInsert(data,6);
        tree.treeInsert(data,3);
        tree.treeInsert(data,2);
        tree.treeInsert(data,4);
        tree.treeInsert(data,7);



    }
}

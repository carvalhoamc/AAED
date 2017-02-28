/**
 * Created by Alexandre Miguel de Carvalho on 26/02/17, 12:12.
 * orcid.org/0000-0002-8801-4321
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package sparcematrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphBasic {


	private int totalVertexAmount;
	private int totalArcAmount;
	private GraphVertex[] vertexList;
	private LinkedList[] adjacencyList;
	private GraphArc[][] adjacencyMatrix;
	private static List<String> dataFromFile = new ArrayList<>();


	public GraphBasic() {
		totalVertexAmount = 0;
		totalArcAmount = 0;
	}




	public void imprimeNaTela() {
		//System.out.println("\nListas de Adjacencia:");
		for (int i = 0; i < totalVertexAmount; i++) {
			GraphVertex u = vertexList[i];
			System.out.print(u.getVertexName()+": ");
			Iterator it = adjacencyList[i].iterator();
			while (it.hasNext()) {
				GraphArc a = (GraphArc)it.next();
				GraphVertex v = a.getTarget();
				System.out.print(v.getVertexName()+", ");
			}
			System.out.println();
		}
		//System.out.println("\nMatriz de Adjacencia:");
		for (int i = 0; i < totalVertexAmount; i++) {
			for (int j = 0; j < totalVertexAmount; j++)
				if (adjacencyMatrix[i][j] != null)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			System.out.println();
		}

		System.out.println("Total de vertices: "+ totalVertexAmount);
		System.out.println("Total de arcos: "+ totalArcAmount);
	}



	public void buildGraph(File arquivo) throws IOException {
		/**
		 * 4,4         	Matrix dimentions
		 * 1,1,50.0		row,col,value
		 * 2,1,10.0
		 * 2,3,20.0
		 * 4,1,-30.0
		 * 4,3,-60.0
		 * 4,4,5.0
		 *
		 * In this case there are 6 vertex
		 */

		String s;
		try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){

			while((s = reader.readLine()) != null)
			{
				dataFromFile.add(s);
				totalVertexAmount++;
			}
		}
		totalVertexAmount--;
		int j = 1;
		int coma1Position = 0;
		int coma2Position = 0;
		int row = 0;
		int col = 0;
		double vAux = 0;
		String aux = null;
		vertexList = new GraphVertex[totalVertexAmount];
		adjacencyList = new LinkedList[totalVertexAmount];
		//totalArcAmount =


		for (int i = 0; i < totalVertexAmount; i++){
			s = dataFromFile.get(j);
			coma1Position = s.indexOf(',');
			aux = s.substring(0,coma1Position);
			row = Integer.parseInt(aux);
			coma2Position = s.indexOf(',',coma1Position+1);
			aux = s.substring(coma1Position+1,coma2Position);
			col = Integer.parseInt(aux);
			aux = s.substring(coma2Position+1);
			vAux = Double.parseDouble(aux);
			j++;

			GraphVertex v = new GraphVertex(i,vAux,String.valueOf(vAux),row,col);
			vertexList[i] = v;
			adjacencyList[i] = new LinkedList();












		}

	}




	public int getTotalVertexAmount() {
		return totalVertexAmount;
	}

	public void setTotalVertexAmount(int totalVertexAmount) {
		this.totalVertexAmount = totalVertexAmount;
	}

	public int getTotalArcAmount() {
		return totalArcAmount;
	}

	public void setTotalArcAmount(int totalArcAmount) {
		this.totalArcAmount = totalArcAmount;
	}

	public GraphVertex[] getVertexList() {
		return vertexList;
	}

	public void setVertexList(GraphVertex[] vertexList) {
		this.vertexList = vertexList;
	}

	public LinkedList[] getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(LinkedList[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public GraphArc[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(GraphArc[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
}

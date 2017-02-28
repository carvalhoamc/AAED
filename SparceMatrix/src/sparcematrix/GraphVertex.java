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


public class GraphVertex {

	private int indexId;
	private String vertexName;
	private double matrixValue;
	private int row;
	private int col;
	private GraphVertex backVertex;
	private GraphVertex baseVertex;


	public GraphVertex(int i, double keyValue,String name, int r, int c) {
		indexId = i;
		vertexName = name;
		matrixValue = keyValue;
		row = r;
		col = c;
		backVertex = null;
		baseVertex = null;
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getVertexName() {
		return vertexName;
	}

	public void setVertexName(String vertexName) {
		this.vertexName = vertexName;
	}

	public double getMatrixValue() {
		return matrixValue;
	}

	public void setMatrixValue(double matrixValue) {
		this.matrixValue = matrixValue;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public GraphVertex getBackVertex() {
		return backVertex;
	}

	public void setBackVertex(GraphVertex backVertex) {
		this.backVertex = backVertex;
	}

	public GraphVertex getBaseVertex() {
		return baseVertex;
	}

	public void setBaseVertex(GraphVertex baseVertex) {
		this.baseVertex = baseVertex;
	}
}


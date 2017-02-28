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


public class GraphArc {

	private GraphVertex source;
	private GraphVertex target;
	private int arcValue;
	private int outflowValue;


	public GraphArc(GraphVertex s, GraphVertex t) {
		source = s; target = t;
		arcValue = 0; outflowValue = 0;
	}

	public GraphArc(GraphVertex s, GraphVertex t, int initialArcValue) {
		this(s, t);
		arcValue = initialArcValue;
	}

	public GraphVertex getSource() {
		return source;
	}

	public void setSource(GraphVertex source) {
		this.source = source;
	}

	public GraphVertex getTarget() {
		return target;
	}

	public void setTarget(GraphVertex target) {
		this.target = target;
	}

	public int getArcValue() {
		return arcValue;
	}

	public void setArcValue(int arcValue) {
		this.arcValue = arcValue;
	}

	public int getOutflowValue() {
		return outflowValue;
	}

	public void setOutflowValue(int outflowValue) {
		this.outflowValue = outflowValue;
	}
}

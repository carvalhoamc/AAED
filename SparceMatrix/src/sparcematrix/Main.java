/**
 * Created by Alexandre Miguel de Carvalho on 26/02/17, 13:46.
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

import java.io.File;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		GraphBasic operador = new GraphBasic();
		File source = new File("/home/amc/DATAFILES/matriz1.txt");
		try {
			operador.buildGraph(source);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}

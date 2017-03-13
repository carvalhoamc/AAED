/**
 * Created by Alexandre Miguel de Carvalho on 19/02/17.
 * <p>
 * Roboticando BioInspired Computation
 * Copyright (c) 2016 Alexandre Miguel de Carvalho
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import org.junit.jupiter.api.Assertions;

class MainTest {
	@org.junit.jupiter.api.Test
	public void main() {


	//	"(4+8)*(6-5)/((3-2)*(2+2))"
	//	"48+65-*32-22+*/"

	//	"a-b^c^(d-(e+f*g))*h"
	//	"abc^defg*+-^h*-"

		Main teste = new Main();
		String resultado = teste.transforma("a-b^c^(d-(e+f*g))*h");
		Assertions.assertEquals(resultado,"abc^defg*+-^h*-");
	}

}
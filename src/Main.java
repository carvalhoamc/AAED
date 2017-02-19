import java.util.Scanner;
import java.util.Stack;

public class Main {

	private final int CASOSMAXIMOS = 1000;
	private int N = 0;
	private  String formulaInfixa;
	private  String formulaPosfixa;

	Main(){

		formulaInfixa = "";
		formulaPosfixa = "";
		Scanner leDadoTeclado = new Scanner(System.in);
		N = leDadoTeclado.nextInt();
		leDadoTeclado.nextLine();

		if((N > 0) && (N < CASOSMAXIMOS))
		{
			for(int i = 1; i <= N; i++ )
			{
				formulaInfixa = leDadoTeclado.nextLine();
				formulaPosfixa = transforma(formulaInfixa);
				System.out.println(formulaPosfixa);

			}
		}
	}


    public static void main(String[] args) {

		Main exercicio1 = new Main();

    }

    public String transforma(String expressaoInfixa) {

		Stack<Character> pilha = new Stack<>();
        String expressaoPosFixada = "";
		Character atual = '\0';
		int tamanho = expressaoInfixa.length();

        LOOP_PRINCIPAL:for (int i = 0; i < tamanho; i++) {

			atual = expressaoInfixa.charAt(i);

			if (testaOperando(atual)) {
				expressaoPosFixada += atual;
				continue LOOP_PRINCIPAL;
			}

			if (parentesisAberto(atual)) {
				pilha.push(atual);
				continue LOOP_PRINCIPAL;
			}

			if (parentesisFechado(atual)) {
				Character aux = '\0';
				do {
					if(!pilha.isEmpty()){
						aux = pilha.pop();
						//pilha.pop();
						if (aux != '(') {
							expressaoPosFixada += aux;
						}
					}
				} while (aux != '(');
				continue LOOP_PRINCIPAL;
			}

			if (testaOperador(atual)) {
				Character aux = '\0';
				if(!pilha.isEmpty()){
					aux = pilha.peek();
					if(aux == '('){
						pilha.push(atual);
						continue LOOP_PRINCIPAL;
					}
					if (verificaPrecedencia(aux,atual)) {
						expressaoPosFixada += pilha.pop();
						pilha.push(atual);
					} else {
						pilha.push(atual);
						continue LOOP_PRINCIPAL;
					}
				}else{
					pilha.push(atual);
					continue LOOP_PRINCIPAL;
				}
			}

		}

		while (!pilha.empty()) {
			expressaoPosFixada += pilha.pop();
		}

        return expressaoPosFixada;
    }

    private boolean testaOperador(char C) {
        boolean verificador = true;
		switch (C) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				verificador = true;
				break;
			default:
				verificador = false;
		}
		return verificador;
    }

    private boolean parentesisAberto(char C){
    	boolean verificador = true;
		if(C == '('){
    		return verificador;
		}
		verificador = false;
		return verificador;
	}

	private boolean parentesisFechado(char C){
		boolean verificador = true;
		if(C == ')'){
			return verificador;
		}
		verificador = false;
		return verificador;
	}

    private boolean testaOperando(char C) {
        boolean verificador = true;
		switch (C) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				verificador = true;
				break;
			default:
				verificador = false;
		}
		return verificador;
    }

    private boolean verificaPrecedencia(char operador1, char operador2) {
        int pesoOperador1 = verificaPesoOperador(operador1);
        int pesoOperador2 = verificaPesoOperador(operador2);
        if (pesoOperador1 == pesoOperador2) {
            return true;
        }
        return (pesoOperador1 > pesoOperador2) ? true : false;
    }

    private int verificaPesoOperador(char operador) {
        int peso = 0;
        switch (operador) {
            case '+':
            case '-':
                peso = 1;
                break;
            case '*':
            case '/':
                peso = 2;
                break;
            case '^':
                peso = 3;
        }
        return peso;
    }
}

//	"(4+8)*(6-5)/((3-2)*(2+2))"
//	"48+65-*32-22+*/"

//	"a-b^c^(d-(e+f*g))*h"
//	"abc^defg*+-^h*-"

//	"A*(B+C)"
//  "ABC+*"

//	"(X*Y+Z)"
//  "XY*Z+"

//  "4^2*3-3+8/4/(1+1)"
//  "42^3*3-84/11+/+"

//	"((((((1+2)+3)+4)+5)+6)+7)"
//	"12+3+4+5+6+7+"

//	"(3*(4+5))"
//	"345+*"
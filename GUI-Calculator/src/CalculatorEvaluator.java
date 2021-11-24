/*
 * Class: CalculatorEvaluator
 * Function: Handle the Evaluation part of the expression passed by the calculator textField.
*/
public class CalculatorEvaluator{
	
	/*
	 * Function: eval
	 * 			 The main function of this class and do the all evaluations according to the 
	 * 			 math rules.
	*/
	public static double eval(String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        double parse() {
	            nextChar();
	            double x = parseExpression();
	            
	            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
	            return x;
	        }

	         /*
	          * Explanation:
			         expression = term | expression `+` term | expression `-` term
			         term = factor | term `*` factor | term `/` factor
			         factor = `+` factor | `-` factor | `(` expression `)`
			         | number | functionName factor | factor `^` factor
	         */

	        double parseExpression() {
	            double x = parseTerm();
	            for (;;) {
	                if      (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else return x;
	            }
	        }

	        double parseTerm() {
	            double x = parseFactor();
	            for (;;) {
	                if      (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else if (eat('%')) x %= parseFactor();
	                else return x;
	            }
	        }

	        double parseFactor() {
	            if (eat('+')) return parseFactor(); // unary plus
	            if (eat('-')) return -parseFactor(); // unary minus

	            double x;
	            int startPos = this.pos;
	            
	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                eat(')');
	            } 
	            else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            } 
	            else if (ch >= 'a' && ch <= 'z') { // functions
	                while (ch >= 'a' && ch <= 'z') nextChar();
	                
	                String func = str.substring(startPos, this.pos);
	                x = parseFactor();
	                if (func.equals("sqrt")) x = Math.sqrt(x);
	                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
	                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
	                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
	                else if (func.equals("asin")) x = (Math.asin(x)*180)/Math.PI;
	                else if (func.equals("acos")) x = (Math.acos(x)*180)/Math.PI;
	                else if (func.equals("atan")) x = (Math.atan(x)*180)/Math.PI;
	                else throw new RuntimeException("Unknown function: " + func);
	            } 
	            else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }

	            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

	            return x;
	        }
	    }.parse();
	}
}

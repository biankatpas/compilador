/* Generated By:JavaCC: Do not edit this line. ParserConstants.java */
package br.univali.compiladores.lexico;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int CONSTANTE_NUM_INTEIRA = 12;
  /** RegularExpression Id. */
  int CONSTANTE_NUM_REAL = 13;
  /** RegularExpression Id. */
  int DIGIT = 14;
  /** RegularExpression Id. */
  int DO = 15;
  /** RegularExpression Id. */
  int THIS = 16;
  /** RegularExpression Id. */
  int BODY = 17;
  /** RegularExpression Id. */
  int DESCRIPTION = 18;
  /** RegularExpression Id. */
  int DECLARATION = 19;
  /** RegularExpression Id. */
  int TYPE = 20;
  /** RegularExpression Id. */
  int IS = 21;
  /** RegularExpression Id. */
  int CONSTANT = 22;
  /** RegularExpression Id. */
  int AND = 23;
  /** RegularExpression Id. */
  int VARIABLE = 24;
  /** RegularExpression Id. */
  int AS = 25;
  /** RegularExpression Id. */
  int INTEGER = 26;
  /** RegularExpression Id. */
  int REAL = 27;
  /** RegularExpression Id. */
  int STRING = 28;
  /** RegularExpression Id. */
  int LOGIC = 29;
  /** RegularExpression Id. */
  int DESIGNATE = 30;
  /** RegularExpression Id. */
  int TO = 31;
  /** RegularExpression Id. */
  int READ = 32;
  /** RegularExpression Id. */
  int WRITE = 33;
  /** RegularExpression Id. */
  int ALL = 34;
  /** RegularExpression Id. */
  int REPEAT = 35;
  /** RegularExpression Id. */
  int TRUE = 36;
  /** RegularExpression Id. */
  int UNTRUE = 37;
  /** RegularExpression Id. */
  int DOT = 38;
  /** RegularExpression Id. */
  int OPENBRACKET = 39;
  /** RegularExpression Id. */
  int CLOSEBRACKET = 40;
  /** RegularExpression Id. */
  int COMMA = 41;
  /** RegularExpression Id. */
  int OPENBRACE = 42;
  /** RegularExpression Id. */
  int CLOSEBRACE = 43;
  /** RegularExpression Id. */
  int PLUS = 44;
  /** RegularExpression Id. */
  int MINUS = 45;
  /** RegularExpression Id. */
  int MULTIPLY = 46;
  /** RegularExpression Id. */
  int FRACTION = 47;
  /** RegularExpression Id. */
  int PERCENT = 48;
  /** RegularExpression Id. */
  int EQUALS = 49;
  /** RegularExpression Id. */
  int EXCLAMATION = 50;
  /** RegularExpression Id. */
  int GREATER = 51;
  /** RegularExpression Id. */
  int GREATEREQUAL = 52;
  /** RegularExpression Id. */
  int LESS = 53;
  /** RegularExpression Id. */
  int LESSEQUAL = 54;
  /** RegularExpression Id. */
  int AMPERSAND = 55;
  /** RegularExpression Id. */
  int DIFFERENT = 56;
  /** RegularExpression Id. */
  int MOD = 57;
  /** RegularExpression Id. */
  int PIPE = 58;
  /** RegularExpression Id. */
  int OPENPARENTHESIS = 59;
  /** RegularExpression Id. */
  int CLOSEPARENTHESIS = 60;
  /** RegularExpression Id. */
  int LETTER_ID = 61;
  /** RegularExpression Id. */
  int LETTER_UPPER = 62;
  /** RegularExpression Id. */
  int LETTER_LOWER = 63;
  /** RegularExpression Id. */
  int DIGIT_ID = 64;
  /** RegularExpression Id. */
  int SYMBOL_UND = 65;
  /** RegularExpression Id. */
  int IDENTIFICADOR = 66;
  /** RegularExpression Id. */
  int IDENTIFICADOR_INVALIDO = 67;
  /** RegularExpression Id. */
  int STRING_DUPLA = 68;
  /** RegularExpression Id. */
  int STRING_SIMPLES = 69;
  /** RegularExpression Id. */
  int SIMBOLO_INVALIDO = 70;
  /** RegularExpression Id. */
  int CONSTANTE_NUM_INTEIRA_INVALIDA = 71;
  /** RegularExpression Id. */
  int CONSTANTE_NUM_REAL_INVALIDA = 72;
  /** RegularExpression Id. */
  int STRING_INVALIDA = 73;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int multilinecomment = 1;
  /** Lexical state. */
  int singlelinecomment = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"/*\"",
    "\"//\"",
    "\"*/\"",
    "<token of kind 9>",
    "<token of kind 10>",
    "<token of kind 11>",
    "<CONSTANTE_NUM_INTEIRA>",
    "<CONSTANTE_NUM_REAL>",
    "<DIGIT>",
    "\"do\"",
    "\"this\"",
    "\"body\"",
    "\"description\"",
    "\"declaration\"",
    "\"type\"",
    "\"is\"",
    "\"constant\"",
    "\"and\"",
    "\"variable\"",
    "\"as\"",
    "\"integer\"",
    "\"real\"",
    "\"string\"",
    "\"logic\"",
    "\"designate\"",
    "\"to\"",
    "\"read\"",
    "\"write\"",
    "\"all\"",
    "\"repeat\"",
    "\"true\"",
    "\"untrue\"",
    "\".\"",
    "\"[\"",
    "\"]\"",
    "\",\"",
    "\"{\"",
    "\"}\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"=\"",
    "\"!\"",
    "\">\"",
    "\">=\"",
    "\"<\"",
    "\"<=\"",
    "\"&\"",
    "\"!=\"",
    "\"%%\"",
    "\"|\"",
    "\"(\"",
    "\")\"",
    "<LETTER_ID>",
    "<LETTER_UPPER>",
    "<LETTER_LOWER>",
    "<DIGIT_ID>",
    "<SYMBOL_UND>",
    "<IDENTIFICADOR>",
    "<IDENTIFICADOR_INVALIDO>",
    "<STRING_DUPLA>",
    "<STRING_SIMPLES>",
    "<SIMBOLO_INVALIDO>",
    "<CONSTANTE_NUM_INTEIRA_INVALIDA>",
    "<CONSTANTE_NUM_REAL_INVALIDA>",
    "<STRING_INVALIDA>",
  };

}

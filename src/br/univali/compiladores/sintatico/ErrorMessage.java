/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.compiladores.sintatico;

/**
 *
 * @author biankatpas
 */

public class ErrorMessage
{
    public static String getErrorMessage(ParseException e) {
        if (e.currentToken.next.kind >= ParserConstants.PURPOSE && e.currentToken.next.kind <= ParserConstants.UNTRUE) {
            e.tokenImage[e.currentToken.next.kind] = "<PALAVRAS_RESERVADAS>";
        } else if (e.currentToken.next.kind >= ParserConstants.DOT && e.currentToken.next.kind <= ParserConstants.CLOSEPARENTHESIS) {
            e.tokenImage[e.currentToken.next.kind] = "<SIMBOLOS_ESPECIAIS>";
        }

        String error = "Encontrado " + e.tokenImage[e.currentToken.next.kind] + " \"" + e.currentToken.next.image + "\"" + " na linha: " + e.currentToken.next.beginLine + ", coluna: " + e.currentToken.next.beginColumn + ".\n";
        String eol = System.getProperty("line.separator", "\n");
        StringBuffer expected = new StringBuffer();
        int maxSize = 0;
        int[][] expectedTokenSequences = e.expectedTokenSequences;

        if(expectedTokenSequences.length > 1){
            error += "Estava esperando uma das opcoes: \n";
        } else {
            error += "Estava esperando: \n";
        }    
            
        for (int i = 0; i < expectedTokenSequences.length; i++) {
            if (maxSize < expectedTokenSequences[i].length) {
                maxSize = expectedTokenSequences[i].length;
            }
            for (int j = 0; j < expectedTokenSequences[i].length; j++) {
                expected.append(e.tokenImage[expectedTokenSequences[i][j]]).append(' ');
            }
            expected.append(eol);
        }
        return error + expected.toString();
    }
}

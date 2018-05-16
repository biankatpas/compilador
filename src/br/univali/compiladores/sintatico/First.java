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
public class First
{

    static public final RecoverySet program = new RecoverySet();
    static public final RecoverySet body = new RecoverySet();
    static public final RecoverySet end_of_file = new RecoverySet();
    static public final RecoverySet lista_comandos = new RecoverySet();
    static public final RecoverySet comando_selecao_ = new RecoverySet();


    static
    {


        body.add(Parser.BODY);


        lista_comandos.add(Parser.DESIGNATE);
        lista_comandos.add(Parser.READ);
        lista_comandos.add(Parser.WRITE);
        lista_comandos.add(Parser.AVALIATE);
        lista_comandos.add(Parser.REPEAT);


        end_of_file.add(Parser.EOF);


        comando_selecao_.add(Parser.TRUE);
        comando_selecao_.add(Parser.UNTRUE);


//        type.add(ParserConstants.INT);
//        type.add(langX.REAL);
//        type.add(ParserConstants.CHAR);
//        type.add(ParserConstants.BOOLEAN);

//        cmd.add(ParserConstants.SET);
//        cmd.add(ParserConstants.PUT);
//        cmd.add(ParserConstants.GET);
//        cmd.add(ParserConstants.INSPECT);
//        cmd.add(ParserConstants.WHILE);
//        cmd.add(ParserConstants.LOOP);

    }
}

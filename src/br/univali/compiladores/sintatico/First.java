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

    static public final RecoverySet begin_program = new RecoverySet();
    static public final RecoverySet program_body = new RecoverySet();
    static public final RecoverySet program = new RecoverySet();
    static public final RecoverySet cmd = new RecoverySet();
    static public final RecoverySet type = new RecoverySet();

    static
    {
//        type.add(ParserConstants.INT);
        type.add(ParserConstants.REAL);
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

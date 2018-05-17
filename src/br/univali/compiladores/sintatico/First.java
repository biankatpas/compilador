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

   static public final RecoverySet programa_ = new RecoverySet();
    static public final RecoverySet body = new RecoverySet();
    static public final RecoverySet end_of_file = new RecoverySet();
    static public final RecoverySet lista_comandos = new RecoverySet();
    static public final RecoverySet comando_selecao_ = new RecoverySet();
    static public final RecoverySet declaracao_de_tipo_enumerado_ = new RecoverySet();


    static
    {


        programa_.add(Parser.DECLARATION);
        programa_.add(Parser.BODY);

        body.add(Parser.BODY);


        lista_comandos.add(Parser.DESIGNATE);
        lista_comandos.add(Parser.READ);
        lista_comandos.add(Parser.WRITE);
        lista_comandos.add(Parser.REPEAT);
        lista_comandos.add(Parser.AVALIATE);


        end_of_file.add(Parser.EOF);


        comando_selecao_.add(Parser.TRUE);
        comando_selecao_.add(Parser.UNTRUE);

        declaracao_de_tipo_enumerado_.add(Parser.DECLARATION);


    }
}

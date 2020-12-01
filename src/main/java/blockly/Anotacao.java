package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Anotacao {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Anotacoes
public static Var ListarAnotacoes() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Anotacao"),Var.valueOf("select a from Anotacao a where a.user.id = :userId"),Var.valueOf("userId",
    blockly.UserManager.ObterIdUsuario()));
    return lista;
   }
 }.call();
}

/**
 *
 * @param listaAnotacoes
 */
// Descreva esta função...
public static void Gerenciar(Var listaAnotacoes) throws Exception {
  new Callable<Var>() {

   private Var anotacao = Var.VAR_NULL;
   private Var contemId = Var.VAR_NULL;
   private Var contemExcluir = Var.VAR_NULL;

   public Var call() throws Exception {

    for (Iterator it_anotacao =
    cronapi.json.Operations.toJson(listaAnotacoes).iterator(); it_anotacao.hasNext();) {
        anotacao = Var.valueOf(it_anotacao.next());

        contemId =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.getJsonOrMapField(anotacao,
        Var.valueOf("id")));

        contemExcluir =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.getJsonOrMapField(anotacao,
        Var.valueOf("exclusao")));

        if (
        Var.valueOf(contemId.getObjectAsBoolean() && contemExcluir.getObjectAsBoolean()).getObjectAsBoolean()) {

            cronapi.database.Operations.insert(Var.valueOf("app.entity.Anotacao"),Var.valueOf("nome",
            cronapi.json.Operations.getJsonOrMapField(anotacao,
            Var.valueOf("nome"))),Var.valueOf("user",
            blockly.UserManager.ObterIdUsuario()));
        } else if (
        Var.valueOf(
        contemId.negate().getObjectAsBoolean() &&
        contemExcluir.negate().getObjectAsBoolean()).getObjectAsBoolean()) {

            cronapi.database.Operations.remove(Var.valueOf("app.entity.Anotacao"),anotacao);
        }
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

}


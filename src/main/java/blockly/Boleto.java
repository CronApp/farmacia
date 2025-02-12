package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Boleto {

public static final int TIMEOUT = 300;

/**
 *
 * Descreva esta função...
 *
 * @param vendaId
 *
 * @author Alan Moraes Souza
 * @since 12/02/2025, 16:07:27
 *
 */
public static Var consultarDadosVenda(@ParamMetaData(description = "vendaId", id = "484fe18a") @RequestBody(required = false) Var vendaId) throws Exception {
 return new Callable<Var>() {

   private Var mapa = Var.VAR_NULL;
   private Var result = Var.VAR_NULL;

   public Var call() throws Exception {
    mapa =
    cronapi.map.Operations.createObjectMap();
    result =
    cronapi.database.Operations.query(Var.valueOf("farmacia.entity.ClienteVenda"),Var.valueOf("select c.cliente, c.venda from ClienteVenda c where c.venda.id = :vendaId"),Var.valueOf("vendaId",vendaId));
    cronapi.map.Operations.setMapField(mapa,
    Var.valueOf("cliente"),
    cronapi.database.Operations.getField(result,
    Var.valueOf("this[0]")));
    cronapi.map.Operations.setMapField(mapa,
    Var.valueOf("venda"),
    cronapi.database.Operations.getField(result,
    Var.valueOf("this[1]")));
    return mapa;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param status<farmacia.entity.StatusVenda>
 *
 * @author Alan Moraes Souza
 * @since 12/02/2025, 16:07:27
 *
 */
public static Var validar(@ParamMetaData(description = "status", id = "989276a4") @RequestBody(required = false) Var status) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {
    retorno =
    Var.VAR_NULL;
    if (
    Var.valueOf(!
    cronapi.object.Operations.getObjectField(status, Var.valueOf("id")).equals(
    Var.valueOf(2))).getObjectAsBoolean()) {
        retorno =
        cronapi.object.Operations.getObjectField(status, Var.valueOf("descricao"));
    }
    return retorno;
   }
 }.call();
}

}


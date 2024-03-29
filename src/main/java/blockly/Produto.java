package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Produto {

public static final int TIMEOUT = 300;

/**
 *
 * Produto
 *
 * @param codigo
 *
 * @author Igor Andrade
 * @since 28/09/2023, 15:57:56
 *
 */
public static Var consultar(@ParamMetaData(description = "codigo", id = "79fce586") Var codigo) throws Exception {
 return new Callable<Var>() {

   private Var exception = Var.VAR_NULL;
   private Var produto = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         produto =
        cronapi.list.Operations.getLast((
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p where p.codigo = :codigo"),Var.valueOf("codigo",codigo))));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        Var.valueOf("Erro ao buscar produto"), Var.VAR_NULL);
        produto =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("msg",
        Var.valueOf("Erro ao buscar produto")));
     }
    return produto;
   }
 }.call();
}

/**
 *
 * @param codigoProduto
 *
 * @author Igor Andrade
 * @since 28/09/2023, 15:57:56
 *
 */
public static void downloadQRCodeProduto(@ParamMetaData(description = "codigoProduto", id = "10bedb5d") Var codigoProduto) throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(codigoProduto)
    .negate().getObjectAsBoolean()) {
        cronapi.io.Operations.startDownload(
        cronapi.qrcode.QRCode.gerarQRCode(codigoProduto,
        Var.valueOf("PNG"),
        Var.valueOf(500),
        Var.valueOf(500)),
        Var.valueOf(
        Var.valueOf("produto-").getObjectAsString() +
        codigoProduto.getObjectAsString() +
        Var.valueOf(".png").getObjectAsString()));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Erro ao baixar QR Code do produto."));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @author Igor Andrade
 * @since 28/09/2023, 15:57:56
 *
 */
public static Var listarProdutos() throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var produtos = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    resposta =
    Var.VAR_NULL;
    try {
         resposta =
        Var.valueOf(montarTemplate());
        produtos =
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p"));
        for (Iterator it_i = produtos.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            if (
            Var.valueOf(!resposta.equals(
            Var.VAR_NULL)).getObjectAsBoolean()) {
                resposta =
                Var.valueOf(
                resposta.getObjectAsString() +
                Var.valueOf(
                Var.valueOf("<tr><td>").getObjectAsString() +
                Var.valueOf(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("codigo")).getObjectAsString() +
                Var.valueOf("</td><td>").getObjectAsString()).getObjectAsString() +
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("nome")).getObjectAsString() +
                Var.valueOf(
                Var.valueOf("</td><td>R$").getObjectAsString() +
                Var.valueOf(blockly.custom.Custom.formatRealValue(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("precoVenda")))).getObjectAsString() +
                Var.valueOf("</td></tr>").getObjectAsString()).getObjectAsString()).getObjectAsString());
            } else {
              {}
            }
        } // end for
        resposta =
        Var.valueOf(
        resposta.getObjectAsString() +
        Var.valueOf("</table>").getObjectAsString());
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        Var.valueOf("Erro ao listar os produtos"), Var.VAR_NULL);
     }
    return resposta;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @author Igor Andrade
 * @since 28/09/2023, 15:57:56
 *
 */
public static Var montarTemplate() throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var produtos = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    return
Var.valueOf("<table>\n  <tr>\n    <th>Código</th>\n    <th>Produto</th> \n    <th>Preço</th>\n  </tr>");
   }
 }.call();
}

}


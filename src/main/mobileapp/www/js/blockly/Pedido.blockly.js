window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pedido = window.blockly.js.blockly.Pedido || {};

/**
 * @function finalizar
 *
 * Pedido
 *
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.finalizarArgs = [];
window.blockly.js.blockly.Pedido.finalizar = async function() {
 var produto, quantidade, item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Pedido:salvarItens', async function(sender_resposta) {
      resposta = sender_resposta;
    //
    if (resposta) {
      //
      this.cronapi.screen.changeView("#/app/logged/venda",[  ]);
    }
  }.bind(this), this.cronapi.screen.getScopeVariable('listaItensPedido'), this.cronapi.screen.getScopeVariable('cliente'), null);
}

/**
 * @function limparVariaveis
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.limparVariaveisArgs = [];
window.blockly.js.blockly.Pedido.limparVariaveis = async function() {
 var produto, quantidade, item;
  //
  this.cronapi.screen.changeValueOfField("vars.produto", null);
  //
  this.cronapi.screen.changeValueOfField("vars.quantidade", null);
}

/**
 * @function criarLista
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.criarListaArgs = [];
window.blockly.js.blockly.Pedido.criarLista = async function() {
 var produto, quantidade, item;
  //
  this.cronapi.screen.createScopeVariable('listaItensPedido', []);
  //
  this.cronapi.screen.createScopeVariable('valorTotal', 0);
}

/**
 * @function excluir
 *
 * Descreva esta função...
 *
 * @param index
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.excluirArgs = [{ description: 'index', id: '7e18cdf1' }];
window.blockly.js.blockly.Pedido.excluir = async function(index) {
 var produto, quantidade;
  //
  this.cronapi.screen.getScopeVariable('listaItensPedido').splice((index - 1), 1);
  //
  (await this.cronapi.client('blockly.js.blockly.Pedido.calcularTotal').run());
}

/**
 * @function inserir
 *
 * Descreva esta função...
 *
 * @param produto
 * @param quantidade
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.inserirArgs = [{ description: 'produto', id: 'a45db1d1' }, { description: 'quantidade', id: '2fdcf9d7' }];
window.blockly.js.blockly.Pedido.inserir = async function(produto, quantidade) {
 var item;
  //
  console.log('abc');
  //
  console.log(this.cronapi.screen.getScopeVariable('listaItensPedido'));
  //
  console.log('abc');
  //
  if (!this.cronapi.logic.isNullOrEmpty(produto) && !this.cronapi.logic.isNullOrEmpty(quantidade)) {
    //
    if (quantidade > 0) {
      //
      item = this.cronapi.object.newObject();
      //
      this.cronapi.object.setProperty(item, 'produto', produto);
      //
      this.cronapi.object.setProperty(item, 'quantidade', quantidade);
      //
      this.cronapi.screen.getScopeVariable('listaItensPedido').push(item);
      //
      (await this.cronapi.client('blockly.js.blockly.Pedido.limparVariaveis').run());
      //
      (await this.cronapi.client('blockly.js.blockly.Pedido.calcularTotal').run());
    } else {
      //
      this.cronapi.screen.notify('warning','Quantidade tem que ser maior que 0');
    }
  }
}

/**
 * @function calcularTotal
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.calcularTotalArgs = [];
window.blockly.js.blockly.Pedido.calcularTotal = async function() {
 var produto, quantidade, item;
  //
  this.cronapi.screen.changeValueOfField("vars.valorTotal", 0);
  //
  var produto_list = this.cronapi.screen.getScopeVariable('listaItensPedido');
  for (var produto_index in produto_list) {
    produto = produto_list[produto_index];
    //
    totalItem = (this.cronapi.object.getProperty(produto, 'produto.precoVenda') * this.cronapi.object.getProperty(produto, 'quantidade'));
    //
    this.cronapi.screen.changeValueOfField("vars.valorTotal", (this.cronapi.screen.getValueOfField("vars.valorTotal") + totalItem));
  }
}

/**
 * @function lerCodigoBarras
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 25/09/2023, 23:19:42
 *
 */
window.blockly.js.blockly.Pedido.lerCodigoBarrasArgs = [];
window.blockly.js.blockly.Pedido.lerCodigoBarras = async function() {
 var produto, quantidade, item;
  //
  this.cronapi.cordova.camera.qrCodeScanner('CODE_39', 'Consultar o preço do produto', async function(sender_codigo) {
      codigo = sender_codigo;
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Produto:consultar', async function(sender_item) {
        item = sender_item;
      //
      if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.object.getProperty(item, 'msg'))) {
        //
        this.cronapi.screen.notify('error',this.cronapi.object.getProperty(item, 'msg'));
      } else {
        //
        this.cronapi.screen.notify('info',[this.cronapi.object.getProperty(item, 'nome'),' - ',this.cronapi.object.getProperty(item, 'precoCusto')].join(''));
      }
    }.bind(this), codigo);
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error',item);
  }.bind(this));
}

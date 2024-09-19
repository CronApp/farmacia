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
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.finalizarArgs = [];
window.blockly.js.blockly.Pedido.finalizar = async function() {
 var codigo, item;
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
 * @function criarLista
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.criarListaArgs = [];
window.blockly.js.blockly.Pedido.criarLista = async function() {
 var codigo, item;
  //
  this.cronapi.screen.createScopeVariable('listaItensPedido', []);
  //
  this.cronapi.screen.createScopeVariable('valorTotal', 0);
}

/**
 * @function limparVariaveis
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.limparVariaveisArgs = [];
window.blockly.js.blockly.Pedido.limparVariaveis = async function() {
 var codigo, item;
  //
  this.cronapi.screen.changeValueOfField("vars.produto", null);
  //
  this.cronapi.screen.changeValueOfField("vars.quantidade", null);
}

/**
 * @function excluir
 *
 * Descreva esta função...
 *
 * @param index
 *
 * @author Igor Andrade
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.excluirArgs = [{ description: 'index', id: '7e18cdf1' }];
window.blockly.js.blockly.Pedido.excluir = async function(index) {
 var codigo;
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
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.inserirArgs = [{ description: 'produto', id: 'a45db1d1' }, { description: 'quantidade', id: '2fdcf9d7' }];
window.blockly.js.blockly.Pedido.inserir = async function(produtoId, quantidade) {
  // 
  var produtos = angular.element(document.querySelector('button[ng-click*="Pedido.inserir"]')).scope().data.Produto.data
  //
  var produtoSelecionado = produtos.find(function(produto) {
    return produto.id === produtoId;
  });
  // 
  if (produtoSelecionado && quantidade > 0) {
    //
    let item = this.cronapi.object.newObject();
    //
    this.cronapi.object.setProperty(item, 'produto', produtoSelecionado);
    //
    this.cronapi.object.setProperty(item, 'quantidade', quantidade);
    //
    this.cronapi.screen.getScopeVariable('listaItensPedido').push(item);
    //
    await this.cronapi.client('blockly.js.blockly.Pedido.limparVariaveis').run();
    await this.cronapi.client('blockly.js.blockly.Pedido.calcularTotal').run();
  } else {
   //
    if (!produtoSelecionado) {
      this.cronapi.screen.notify('error', 'Produto não encontrado');
    } else {
     //
      this.cronapi.screen.notify('warning', 'Quantidade tem que ser maior que 0');
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
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.calcularTotalArgs = [];
window.blockly.js.blockly.Pedido.calcularTotal = async function() {
 var codigo, item;
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
 * @since 27/09/2023, 16:57:45
 *
 */
window.blockly.js.blockly.Pedido.lerCodigoBarrasArgs = [];
window.blockly.js.blockly.Pedido.lerCodigoBarras = async function() {
 var codigo, item;
  //
  this.cronapi.cordova.camera.qrCodeScanner('QR_CODE', 'Consultar o preço do produto', async function(sender_codigo) {
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
        this.cronapi.screen.changeValueOfField("vars.produto", this.cronapi.object.getObjectField(item, 'id'));
      }
    }.bind(this), codigo);
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error',item);
  }.bind(this));
}

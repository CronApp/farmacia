window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Anotacao = window.blockly.js.blockly.Anotacao || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.ObterAnotacoesDoBancoLocal = async function() {
 var item, anotacoes, i, lista, anotacao, nome, banco;
  this.cronapi.pouchdb.getAllDoc(await this.blockly.js.blockly.Anotacao.CriarBancoLocal(), this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao obter as anotações!');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.AlimentarListaDoEscopo(this.cronapi.json.getProperty(item, 'rows'));
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.SincroniaBancoRemotoParaBancoLocal = async function() {
 var item, anotacoes, i, lista, anotacao, nome, banco;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Anotacao:ListarAnotacoes', async function(sender_anotacoes) {
      anotacoes = sender_anotacoes;
    this.cronapi.pouchdb.createDocLote(await this.blockly.js.blockly.Anotacao.CriarBancoLocal(), anotacoes, null, async function(sender_item) {
        item = sender_item;
      this.cronapi.screen.notify('error','Erro ao sincronizar banco local!');
    }.bind(this), async function(sender_item) {
        item = sender_item;
      await this.blockly.js.blockly.Anotacao.ObterAnotacoesDoBancoLocal();
    }.bind(this));
  }.bind(this));
}

/**
 * Anotacoes
 */
window.blockly.js.blockly.Anotacao.CriarBancoLocal = async function() {
 var item, anotacoes, i, lista, anotacao, nome, banco;
  this.cronapi.screen.createScopeVariable('listaAnotacoes', []);
  return this.cronapi.pouchdb.createLocalDatabase('anotacoes', 'idb');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.AlimentarListaDoEscopo = async function(lista) {
 var item, anotacoes, i, anotacao, nome, banco;
  this.cronapi.screen.changeValueOfField('listaAnotacoes', []);
  for (var i_index in lista) {
    i = lista[i_index];
    this.cronapi.screen.getScopeVariable('listaAnotacoes').push(this.cronapi.json.getProperty(i, 'doc'));
  }
  this.cronapi.screen.changeValueOfField("vars.nome", null);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.InserirAnotacaoBancoLocal = async function(nome) {
 var item, anotacoes, i, lista, anotacao, banco;
  if (!this.cronapi.logic.isNullOrEmpty(nome)) {
    anotacao = this.cronapi.object.newObject({name: 'nome', value: nome});
    this.cronapi.pouchdb.createDoc(await this.blockly.js.blockly.Anotacao.CriarBancoLocal(), anotacao, null, async function(sender_item) {
        item = sender_item;
      this.cronapi.screen.notify('error','Erro ao inserir anotação!');
    }.bind(this), async function(sender_item) {
        item = sender_item;
      await this.blockly.js.blockly.Anotacao.ObterAnotacoesDoBancoLocal();
    }.bind(this));
    this.cronapi.screen.changeValueOfField("vars.nome", null);
  } else {
    this.cronapi.screen.notify('info','Informe um conteúdo antes de inserir');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.DeletarAnotacoesBancoLocal = async function(banco) {
 var item, anotacoes, i, lista, anotacao, nome;
  this.cronapi.pouchdb.getAllDoc(banco, this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao obter as anotações!');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    var anotacao_list = this.cronapi.json.getProperty(item, 'rows');
    for (var anotacao_index in anotacao_list) {
      anotacao = anotacao_list[anotacao_index];
      this.cronapi.pouchdb.deleteByIdDoc(banco, this.cronapi.json.getProperty(anotacao, 'id'), this.cronapi.json.getProperty(anotacao, 'value.rev'), null, async function(sender_item) {
          item = sender_item;
        this.cronapi.screen.notify('error','Erro ao excluir anotação!');
      }.bind(this), async function(sender_item) {
          item = sender_item;
      }.bind(this));
    }
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.ExcluirAnotacaoBancoLocal = async function(anotacao) {
 var item, anotacoes, i, lista, nome, banco;
  this.cronapi.json.setProperty(anotacao, 'exclusao', true);
  this.cronapi.pouchdb.updateDoc(await this.blockly.js.blockly.Anotacao.CriarBancoLocal(), anotacao, null, async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao excluir anotação!');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.ObterAnotacoesDoBancoLocal();
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.Inicializar = async function() {
 var item, anotacoes, i, lista, anotacao, nome, banco;
  this.cronapi.screen.createScopeVariable('listaAnotacoes', []);
  await this.blockly.js.blockly.Anotacao.SincroniaBancoLocalParaBancoRemoto();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.SincroniaBancoLocalParaBancoRemoto = async function() {
 var item, anotacoes, i, lista, anotacao, nome, banco;
  this.cronapi.pouchdb.getAllDoc(await this.blockly.js.blockly.Anotacao.CriarBancoLocal(), this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao sincronizar banco remoto!');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.AlimentarListaDoEscopo(this.cronapi.json.getProperty(item, 'rows'));
    await this.cronapi.util.callServerBlocklyNoReturn('blockly.Anotacao:Gerenciar', this.cronapi.screen.getScopeVariable('listaAnotacoes'));
    await this.blockly.js.blockly.Anotacao.DeletarAnotacoesBancoLocal(await this.blockly.js.blockly.Anotacao.CriarBancoLocal());
    await this.blockly.js.blockly.Anotacao.SincroniaBancoRemotoParaBancoLocal();
  }.bind(this));
}

window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Cliente = window.blockly.js.blockly.Cliente || {};

/**
 * @function getCep
 *
 * Cliente
 *
 * @param cep
 *
 * @author Fernando Santos
 * @since 14/09/2023, 10:48:31
 *
 */
window.blockly.js.blockly.Cliente.getCepArgs = [{ description: 'cep', id: '25bb5fa4' }];
window.blockly.js.blockly.Cliente.getCep = async function(cep) {
 var resposta;
  //
  this.cronapi.util.getCEP(cep, async function(sender_resposta) {
      resposta = sender_resposta;
    //
    if (!this.cronapi.object.getObjectField(resposta, 'erro')) {
      //
      this.cronapi.screen.changeValueOfField("Cliente.active.bairro", this.cronapi.object.getObjectField(resposta, 'bairro'));
      //
      this.cronapi.screen.changeValueOfField("Cliente.active.cidade", this.cronapi.object.getObjectField(resposta, 'localidade'));
      //
      this.cronapi.screen.changeValueOfField("Cliente.active.uf", this.cronapi.object.getObjectField(resposta, 'uf'));
      //
      this.cronapi.screen.changeValueOfField("Cliente.active.endereco", this.cronapi.object.getObjectField(resposta, 'logradouro'));
    }
  }.bind(this));
}

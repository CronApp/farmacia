window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Chat = window.blockly.js.blockly.Chat || {};

/**
 * @function IniciarChat
 *
 *
 *
 *
 * @author Igor Andrade
 * @since 22/09/2023, 20:13:07
 *
 */
window.blockly.js.blockly.Chat.IniciarChatArgs = [];
window.blockly.js.blockly.Chat.IniciarChat = async function() {
 var mensagem, resposta, item;
  //
  this.cronapi.chat.renderChatMessage("testchat", 'Olá!', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.chat.renderChatMessage("testchat", 'Eu sou uma assistente virtual. Por favor, informe o seu nome.', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
        item = sender_item;
    }.bind(this), async function(sender_item) {
        item = sender_item;
    }.bind(this));
  }.bind(this), async function(sender_item) {
      item = sender_item;
  }.bind(this));
}

/**
 * @function ResponderUsuario
 *
 *
 *
 * @param mensagem
 *
 * @author Igor Andrade
 * @since 22/09/2023, 20:13:07
 *
 */
window.blockly.js.blockly.Chat.ResponderUsuarioArgs = [{ description: 'mensagem', id: '7537559c' }];
window.blockly.js.blockly.Chat.ResponderUsuario = async function(mensagem) {
 var resposta, item;
  //
  resposta = this.cronapi.object.getProperty(mensagem, 'text').trim();
  //
  if (!this.cronapi.logic.isNullOrEmpty(resposta)) {
    //
    this.cronapi.chat.renderChatMessage("testchat", String(resposta) + String(', essa é uma demonstração do componente visual Cronapp Chat.'), this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
        item = sender_item;
      //
      this.cronapi.chat.renderChatMessage("testchat", 'Até mais! :)', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
          item = sender_item;
      }.bind(this), async function(sender_item) {
          item = sender_item;
      }.bind(this));
    }.bind(this), async function(sender_item) {
        item = sender_item;
    }.bind(this));
  } else {
    //
    this.cronapi.chat.renderChatMessage("testchat", 'Por favor, informe um nome válido.', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
        item = sender_item;
    }.bind(this), async function(sender_item) {
        item = sender_item;
    }.bind(this));
  }
}

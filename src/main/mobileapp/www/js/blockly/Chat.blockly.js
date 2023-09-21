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
 * @author Fernando Santos
 * @since 18/09/2023, 16:23:08
 *
 */
window.blockly.js.blockly.Chat.IniciarChatArgs = [];
window.blockly.js.blockly.Chat.IniciarChat = async function() {
 var retorna, mensagem, item;
  //
  this.cronapi.chat.renderChatMessage("testchat", 'Para iniciar o chat digite 1', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
      item = sender_item;
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
 * @author Fernando Santos
 * @since 18/09/2023, 16:23:08
 *
 */
window.blockly.js.blockly.Chat.ResponderUsuarioArgs = [{ description: 'mensagem', id: '7537559c' }];
window.blockly.js.blockly.Chat.ResponderUsuario = async function(mensagem) {
 var retorna, item;
  //
  if (this.cronapi.object.getProperty(mensagem, 'text') == 1) {
    //
    this.cronapi.chat.renderChatMessage("testchat", 'Esse é um chat para demonstração. Assim que pudermos iniciaremos seu atendimento.', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
        item = sender_item;
    }.bind(this), async function(sender_item) {
        item = sender_item;
    }.bind(this));
  }
  //
  if (this.cronapi.object.getProperty(mensagem, 'text') == -1) {
    //
    this.cronapi.chat.renderChatMessage("crn-kendo-chat-845773", 'Esse é um chat para demonstração. Assim que pudermos iniciaremos seu atendimento.', this.cronapi.chat.chatUserObj('Cronapp', 'Cronapp', 'https://s3.amazonaws.com//beta-img.b2bstack.net/uploads/production/product/product_image/614/cronapp-nuvem.png'), async function(sender_item) {
        item = sender_item;
    }.bind(this), async function(sender_item) {
        item = sender_item;
    }.bind(this));
  }
  //
  console.log(mensagem);
}

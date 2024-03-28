window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.Login = window.blockly.js.blockly.auth.Login || {};

/**
 * @function login
 *
 * Login
 *
 * @param login
 * @param password
 * @param options
 *
 * @author Igor Andrade
 * @since 29/09/2023, 16:51:11
 *
 */
window.blockly.js.blockly.auth.Login.loginArgs = [{ description: 'login', id: '0d5a70ab' }, { description: 'password', id: '1b7d6238' }, { description: 'options', id: '98e8711e' }];
window.blockly.js.blockly.auth.Login.login = async function(login, password, options) {
 var item;
  //
  if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getHostapp())) {
    //
    if (this.cronapi.logic.isNullOrEmpty(login) || this.cronapi.logic.isNullOrEmpty(password)) {
      //
      this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.invalidPassword",[  ]));
    } else {
      //
      this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', String(this.cronapi.screen.getHostapp()) + String('auth'), this.cronapi.object.createObjectLoginFromString(login, password), null, async function(sender_item) {
          item = sender_item;
        //
        this.cronapi.util.setLocalStorage('_u', this.cronapi.object.serializeObject(item));
        //
        this.cronapi.screen.changeView("#/app/logged/home",[  ]);
      }.bind(this), async function(sender_item) {
          item = sender_item;
        //
        if (this.cronapi.object.getProperty(item, 'status') == '403' || this.cronapi.object.getProperty(item, 'status') == '401') {
          //
          this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.invalidPassword",[  ]));
        } else if (this.cronapi.object.getProperty(item, 'status') == '502') {
          //
          this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.ServerOff",[  ]));
        } else if (this.cronapi.object.getProperty(item, 'status') == '404') {
          //
          this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.HostAppOff",[  ]));
        } else if (this.cronapi.object.getProperty(item, 'status') == '0') {
          //
          this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Admin.server.out",[  ]));
        } else {
          //
          this.cronapi.screen.notify('error',this.cronapi.object.getProperty(item, 'responseJSON.message'));
        }
      }.bind(this));
    }
  } else {
    //
    this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.HostAppOff",[  ]));
  }
}

/**
 * @function login2
 *
 *
 *
 * @param login
 * @param password
 * @param options
 *
 * @author Igor Andrade
 * @since 29/09/2023, 16:51:11
 *
 */
window.blockly.js.blockly.auth.Login.login2Args = [{ description: 'login', id: 'ee597738' }, { description: 'password', id: '1bc3daf6' }, { description: 'options', id: 'aaa176fa' }];
window.blockly.js.blockly.auth.Login.login2 = async function(login, password, options) {
 var item;
  //
  this.cronapi.authentication.login(login, password, options);
}

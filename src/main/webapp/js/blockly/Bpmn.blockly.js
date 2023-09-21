window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Bpmn = window.blockly.js.blockly.Bpmn || {};

/**
 * @function abrir
 *
 * Bpmn
 *
 *
 * @author Fernando Santos
 * @since 21/09/2023, 12:20:52
 *
 */
window.blockly.js.blockly.Bpmn.abrirArgs = [];
window.blockly.js.blockly.Bpmn.abrir = async function() {

  //
  this.cronapi.screen.openUrl(String(this.cronapi.util.getBaseUrl()) + String('/app/welcome/default/'), true, 0, 0);
}

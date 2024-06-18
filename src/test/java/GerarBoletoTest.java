import cronapi.Var;
import org.junit.Before;
import org.junit.Test;
import paymentslip.PaymentSlip;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GerarBoletoTest {

    private GerarBoletoTest geradorBoleto;

    private Var dataAtual = Var.VAR_NULL;
    private Var mapa = Var.VAR_NULL;
    private Var cliente = Var.VAR_NULL;


    @Before
    public void setUp() throws Exception {
        geradorBoleto = new GerarBoletoTest();
    }

    @Test
    public void testBoletoBancoBrasil() throws Exception {
        // Inicializando os dados necessários manualmente
        dataAtual = cronapi.dateTime.Operations.getNowNoHour();
        mapa = Var.valueOf("{\"cliente\":{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"},\"venda\":{\"id\":\"622b77cf-9033-4172-98ef-707fdba0c3f4\",\"valor\":12.27,\"data\":\"Jun 13, 2024, 2:56:33 PM\",\"statusVenda\":{\"id\":2,\"descricao\":\"Aprovado\"}}}");
        cliente = Var.valueOf("{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"}");

        // Configure os valores esperados para os métodos utilizados
        geradorBoleto.setDataAtual(dataAtual);
        geradorBoleto.setMapa(mapa);

        // Configurando o nome do arquivo
        Var nomeArquivo = Var.valueOf("boleto_" + System.currentTimeMillis());
        Var arquivoBoleto = geradorBoleto.gerarBoletoBBrasil();

        // Simular o início do download
        cronapi.io.Operations.startDownload(arquivoBoleto, (Var.valueOf(nomeArquivo + ".pdf")));

        // Verificações
        assertNotNull("O conteúdo do boleto não deve ser nulo", arquivoBoleto);
        assertTrue("O nome do arquivo deve começar com 'boleto_'", nomeArquivo.getObjectAsString().startsWith("boleto_"));
    }

    @Test
    public void testBoletoBancoBradesco() throws Exception {
        // Inicializando os dados necessários manualmente
        dataAtual = cronapi.dateTime.Operations.getNowNoHour();
        mapa = Var.valueOf("{\"cliente\":{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"},\"venda\":{\"id\":\"622b77cf-9033-4172-98ef-707fdba0c3f4\",\"valor\":12.27,\"data\":\"Jun 13, 2024, 2:56:33 PM\",\"statusVenda\":{\"id\":2,\"descricao\":\"Aprovado\"}}}");
        cliente = Var.valueOf("{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"}");

        // Configure os valores esperados para os métodos utilizados
        geradorBoleto.setDataAtual(dataAtual);
        geradorBoleto.setMapa(mapa);

        // Configurando o nome do arquivo
        Var nomeArquivo = Var.valueOf("boleto_" + System.currentTimeMillis());
        Var arquivoBoleto = geradorBoleto.gerarBoletoBradesco();

        // Simular o início do download ou outra lógica que gera um arquivo com o nome configurado
        cronapi.io.Operations.startDownload(arquivoBoleto, (Var.valueOf(nomeArquivo + ".pdf")));

        // Verificações
        assertNotNull("O conteúdo do boleto não deve ser nulo", arquivoBoleto);
        assertTrue("O nome do arquivo deve começar com 'boleto_'", nomeArquivo.getObjectAsString().startsWith("boleto_"));
    }

    @Test
    public void testBoletoBancoITAU() throws Exception {
        // Inicializando os dados necessários manualmente
        dataAtual = cronapi.dateTime.Operations.getNowNoHour();
        mapa = Var.valueOf("{\"cliente\":{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"},\"venda\":{\"id\":\"622b77cf-9033-4172-98ef-707fdba0c3f4\",\"valor\":12.27,\"data\":\"Jun 13, 2024, 2:56:33 PM\",\"statusVenda\":{\"id\":2,\"descricao\":\"Aprovado\"}}}");
        cliente = Var.valueOf("{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"}");

        // Configure os valores esperados para os métodos utilizados
        geradorBoleto.setDataAtual(dataAtual);
        geradorBoleto.setMapa(mapa);

        // Configurando o nome do arquivo
        Var nomeArquivo = Var.valueOf("boleto_" + System.currentTimeMillis());
        Var arquivoBoleto = geradorBoleto.gerarBoletoITAU();

        // Simular o início do download ou outra lógica que gera um arquivo com o nome configurado
        cronapi.io.Operations.startDownload(arquivoBoleto, (Var.valueOf(nomeArquivo + ".pdf")));

        // Verificações
        assertNotNull("O conteúdo do boleto não deve ser nulo", arquivoBoleto);
        assertTrue("O nome do arquivo deve começar com 'boleto_'", nomeArquivo.getObjectAsString().startsWith("boleto_"));
    }

    @Test
    public void testBoletoCAIXA() throws Exception {
        // Inicializando os dados necessários manualmente
        dataAtual = cronapi.dateTime.Operations.getNowNoHour();
        mapa = Var.valueOf("{\"cliente\":{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"},\"venda\":{\"id\":\"622b77cf-9033-4172-98ef-707fdba0c3f4\",\"valor\":12.27,\"data\":\"Jun 13, 2024, 2:56:33 PM\",\"statusVenda\":{\"id\":2,\"descricao\":\"Aprovado\"}}}");
        cliente = Var.valueOf("{\"id\":\"B58B770E-157E-4B6B-A2FC-4A9D76931E78\",\"nome\":\"José da Silva\",\"cpf\":\"8641583351\",\"telefone\":\"16616161616\",\"email\":\"jose@cronapp.io\",\"cep\":\"41830495\",\"endereco\":\"Rua Professor Leopoldo Amaral\",\"complemento\":\" Edf. Empresarial Alto do Parque, 366\",\"bairro\":\"Pituba\",\"cidade\":\"Salvador\",\"uf\":\"BA\"}");

        // Configure os valores esperados para os métodos utilizados
        geradorBoleto.setDataAtual(dataAtual);
        geradorBoleto.setMapa(mapa);

        // Configurando o nome do arquivo
        Var nomeArquivo = Var.valueOf("boleto_" + System.currentTimeMillis());
        Var arquivoBoleto = geradorBoleto.gerarBoletoCAIXA();

        // Simular o início do download ou outra lógica que gera um arquivo com o nome configurado
        cronapi.io.Operations.startDownload(arquivoBoleto, (Var.valueOf(nomeArquivo + ".pdf")));

        // Verificações
        assertNotNull("O conteúdo do boleto não deve ser nulo", arquivoBoleto);
        assertTrue("O nome do arquivo deve começar com 'boleto_'", nomeArquivo.getObjectAsString().startsWith("boleto_"));
    }

    private Var gerarBoletoBBrasil() throws Exception {
        return PaymentSlip.generatePaymentSlipByteArray(
                PaymentSlip.createInstanceOfPaymentSlip(
                        PaymentSlip.chooseBank(
                                Var.valueOf("BANCO_DO_BRASIL")),
                        PaymentSlip.defineDatesOfPaymentSlip(
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip()),
                        montabeneficiarioBBrasil(),
                        getPayer(),
                        Var.valueOf(12.27),
                        Var.valueOf("1234"),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Efetuar o pagamento até a data do vencimento"),
                                Var.valueOf("Após o vencimento multa de 0.05 ao mês")),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Somente no Cronapp Bank"))),
                Var.valueOf("PDF"));
    }

    private Var gerarBoletoBradesco() throws Exception {
        return PaymentSlip.generatePaymentSlipByteArray(
                PaymentSlip.createInstanceOfPaymentSlip(
                        PaymentSlip.chooseBank(
                                Var.valueOf("BRADESCO")),
                        PaymentSlip.defineDatesOfPaymentSlip(
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip()),
                        montaBeneficiarioOutrosBancos(),
                        getPayer(),
                        Var.valueOf(12.27),
                        Var.valueOf("1234"),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Efetuar o pagamento até a data do vencimento"),
                                Var.valueOf("Após o vencimento multa de 0.05 ao mês")),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Somente no Cronapp Bank"))),
                Var.valueOf("PDF"));
    }

    private Var gerarBoletoITAU() throws Exception {
        return PaymentSlip.generatePaymentSlipByteArray(
                PaymentSlip.createInstanceOfPaymentSlip(
                        PaymentSlip.chooseBank(
                                Var.valueOf("ITAU")),
                        PaymentSlip.defineDatesOfPaymentSlip(
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip()),
                        montaBeneficiarioOutrosBancos(),
                        getPayer(),
                        Var.valueOf(12.27),
                        Var.valueOf("1234"),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Efetuar o pagamento até a data do vencimento"),
                                Var.valueOf("Após o vencimento multa de 0.05 ao mês")),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Somente no Cronapp Bank"))),
                Var.valueOf("PDF"));
    }


    private Var gerarBoletoCAIXA() throws Exception {
        return PaymentSlip.generatePaymentSlipByteArray(
                PaymentSlip.createInstanceOfPaymentSlip(
                        PaymentSlip.chooseBank(
                                Var.valueOf("BRADESCO")),
                        PaymentSlip.defineDatesOfPaymentSlip(
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip(),
                                getDatesOfPaymentSlip()),
                        montaBeneficiarioOutrosBancos(),
                        getPayer(),
                        Var.valueOf(12.27),
                        Var.valueOf("1234"),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Efetuar o pagamento até a data do vencimento"),
                                Var.valueOf("Após o vencimento multa de 0.05 ao mês")),
                        cronapi.list.Operations.newList(
                                Var.valueOf("Somente no Cronapp Bank"))),
                Var.valueOf("PDF"));
    }

    private Var getDatesOfPaymentSlip() throws Exception {
        return PaymentSlip.createDatesOfPaymentSlip(
                cronapi.dateTime.Operations.getDay(cronapi.dateTime.Operations.getNowNoHour()),
                cronapi.dateTime.Operations.getMonth(cronapi.dateTime.Operations.getNowNoHour()),
                cronapi.dateTime.Operations.getYear(cronapi.dateTime.Operations.getNowNoHour()));
    }

    private Var montabeneficiarioBBrasil() {
        String nossoNumeroBB = blockly.Boleto.gerarNossoNumero("BANCO_DO_BRASIL", "1207113", 900206L, "", "", "");
        return PaymentSlip.createFavored(
                Var.valueOf("Cronapp"),
                Var.valueOf("1824"),
                Var.valueOf("4"),
                Var.valueOf("76000"),
                Var.valueOf("5"),
                Var.valueOf("1207113"),
                Var.valueOf("18"),
                PaymentSlip.createAddress(
                        Var.valueOf("Avenida Roque Petroni Jr, 999, 13º andar"),
                        Var.valueOf("Jardim das Acácias"),
                        Var.valueOf("CEP: 04707-910"),
                        Var.valueOf("São Paulo"),
                        Var.valueOf("SP")),
                Var.valueOf(Var.valueOf(nossoNumeroBB))
        );
    }

    private Var montaBeneficiarioOutrosBancos() {
        return PaymentSlip.createFavored(
                Var.valueOf("Cronapp"),
                Var.valueOf("1824"),
                Var.valueOf("4"),
                Var.valueOf("76000"),
                Var.valueOf("5"),
                Var.valueOf("123"),
                Var.valueOf("18"),
                PaymentSlip.createAddress(
                        Var.valueOf("Avenida Roque Petroni Jr, 999, 13º andar"),
                        Var.valueOf("Jardim das Acácias"),
                        Var.valueOf("CEP: 04707-910"),
                        Var.valueOf("São Paulo"),
                        Var.valueOf("SP")),
                Var.valueOf(blockly.Boleto.gerarNossoNumero("BRADESCO", "1207113", 900206L, "1824", "4", "18")));
    }

    private Var getPayer() throws Exception {
        return PaymentSlip.createPayer(
                cronapi.object.Operations.getObjectField(cliente, Var.valueOf("nome")),
                cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cpf")),
                PaymentSlip.createAddress(
                        cronapi.object.Operations.getObjectField(cliente, Var.valueOf("endereco")),
                        cronapi.object.Operations.getObjectField(cliente, Var.valueOf("bairro")),
                        cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cep")),
                        cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cidade")),
                        cronapi.object.Operations.getObjectField(cliente, Var.valueOf("uf"))));
    }


    public Var getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Var dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Var getMapa() {
        return mapa;
    }

    public void setMapa(Var mapa) {
        this.mapa = mapa;
    }

    public Var getCliente() {
        return cliente;
    }

    public void setCliente(Var cliente) {
        this.cliente = cliente;
    }
}

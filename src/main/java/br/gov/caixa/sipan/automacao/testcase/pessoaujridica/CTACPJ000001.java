package br.gov.caixa.sipan.automacao.testcase.pessoaujridica;

import org.junit.Test;

import br.gov.caixa.sipan.automacao.annotation.Page;
import br.gov.caixa.sipan.automacao.core.BaseIntegrationTest;
import br.gov.caixa.sipan.automacao.core.ReadJSON;
import br.gov.caixa.sipan.automacao.page.common.LoginPage;
import br.gov.caixa.sipan.automacao.page.common.MenuPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.BuscaPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.ComposicaoPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.ComunicacaoPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.DadosCadastraisPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.EnderecosPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.FaturamentoFiscalPage;
import br.gov.caixa.sipan.automacao.page.pessoaujridica.PerfilPage;

/**
* @see [CTACPJ000001]: Classe de Teste (CT), fluxo de Cadastro (C) Pessoa Juridica (PJ).
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class CTACPJ000001 extends BaseIntegrationTest {	

	static {
		ReadJSON.fileName("CTACPJ000001");
	}	
	private String usuario = ReadJSON.lerMassa("usuario");
	private String senha = ReadJSON.lerMassa("senha");
	private String cnpj = ReadJSON.lerMassa("cnpj");
	private String regimeTributario = ReadJSON.lerMassa("regimeTributario");
	private String finalidadeEmpresa = ReadJSON.lerMassa("finalidadeEmpresa");
	private String franquia = ReadJSON.lerMassa("franquia");
	private String caracterizacaoAnual = ReadJSON.lerMassa("caracterizacaoAnual");
	private String receitaAnual = ReadJSON.lerMassa("receitaAnual");
	private String anoReferencia = ReadJSON.lerMassa("anoReferencia");
	private String caracterizacaoDozeMeses = ReadJSON.lerMassa("caracterizacaoDozeMeses");
	private String receitaDozeMeses = ReadJSON.lerMassa("receitaDozeMeses");
	private String quantidadeMeses = ReadJSON.lerMassa("quantidadeMeses");
	private String segmento = ReadJSON.lerMassa("segmento");
	private String gerenteResponsavel = ReadJSON.lerMassa("gerenteResponsavel");
	private String cep = ReadJSON.lerMassa("cep");
	private String tipologradouro = ReadJSON.lerMassa("tipologradouro");
	private String numero = ReadJSON.lerMassa("numero");
	private String complemento = ReadJSON.lerMassa("complemento");
	private String tipoImovel = ReadJSON.lerMassa("tipoImovel");
	private String referencia = ReadJSON.lerMassa("referencia");
	private String finalidadeImovel = ReadJSON.lerMassa("finalidadeImovel");
	private String ultimaAlteracao = ReadJSON.lerMassa("ultimaAlteracao");
	private String tipoPessoa = ReadJSON.lerMassa("tipoPessoa");
	private String cpfOuCnpj = ReadJSON.lerMassa("cpfOuCnpj");
	private String tipoVinculo = ReadJSON.lerMassa("tipoVinculo");
	private String porcentagem = ReadJSON.lerMassa("porcentagem");
	private String meioDeComunicacao = ReadJSON.lerMassa("meioDeComunicacao");
	private String telefone = ReadJSON.lerMassa("telefone");
		
	@Page
	private LoginPage loginPage;	
	@Page
	private MenuPage menuPage;	
	@Page
	private BuscaPage buscaPage;	
	@Page
	private DadosCadastraisPage dadosCadastraisPage;	
	@Page
	private FaturamentoFiscalPage faturamentoFiscalpage;	
	@Page
	private PerfilPage perfilPage;	
	@Page
	private EnderecosPage enderecosPage;	
	@Page
	private ComposicaoPage composicaoPage;	
	@Page
	private ComunicacaoPage comunicacaoPage;
	
	@Test
	public void cadastroDeContaSimplesPJ() throws Throwable {
		try {	
			
			logInfo("[Step 1]: Realizar Login");
			loginPage.logar(usuario, senha);
			
			logInfo("[Step 2]: Acessar o Menu de pessoa Juridica");
			menuPage.menuPessoaJuridica();
			
			logInfo("[Step 3]: Buscar pelo CNPJ");
			buscaPage.buscarCnpj(cnpj);
			
			logInfo("[Step 4]: Preencher Dados Cadastrais");
			dadosCadastraisPage.preencherDadosCadastrias(regimeTributario, finalidadeEmpresa, franquia);			
			
			logInfo("[Step 5]: Preencher Faturamento Fiscal");
			faturamentoFiscalpage.preencherFaturamentoAnual(caracterizacaoAnual, receitaAnual, anoReferencia);			
			faturamentoFiscalpage.preencherFaturamentoDozeMeses(caracterizacaoDozeMeses, receitaDozeMeses, quantidadeMeses);	
			
			logInfo("[Step 6]: Preencher Perfil");
			perfilPage.preencherPerfil(segmento, gerenteResponsavel);			
			
			logInfo("[Step 7]: Preencher Endereco");
			enderecosPage.preencherEndereco(cep, tipologradouro, numero, complemento, tipoImovel, referencia, finalidadeImovel);	
			
			logInfo("[Step 8]: Preencher Composicao");
			composicaoPage.preencherComposicao(ultimaAlteracao, tipoPessoa, cpfOuCnpj, tipoVinculo, porcentagem);
			
			logInfo("[Step 9]: Preencher Meio de Comunicacao");
			comunicacaoPage.preencherComunicacao(meioDeComunicacao, telefone, "O cadastro do cliente foi realizado com sucesso.");
		
		} catch (Throwable e) {
			logError("ERRO: "+ e.getMessage());
			throw e;	
		}

	}

}

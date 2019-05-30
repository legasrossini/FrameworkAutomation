package br.gov.caixa.sipan.automacao.testcase.pessoafisica;

import org.junit.Test;

import br.gov.caixa.sipan.automacao.annotation.Page;
import br.gov.caixa.sipan.automacao.core.BaseIntegrationTest;
import br.gov.caixa.sipan.automacao.core.ReadJSON;
import br.gov.caixa.sipan.automacao.page.common.LoginPage;
import br.gov.caixa.sipan.automacao.page.common.MenuPage;
import br.gov.caixa.sipan.automacao.page.pessoafisica.BuscaPage;
import br.gov.caixa.sipan.automacao.page.pessoafisica.DadosCadastraisPage;
import br.gov.caixa.sipan.automacao.page.pessoafisica.EnderecosPage;
import br.gov.caixa.sipan.automacao.page.pessoafisica.PerfilPage;
import br.gov.caixa.sipan.automacao.page.pessoafisica.RendasPage;

/**
* @see [CTACPJ000001]: Classe de Teste (CT), fluxo de Cadastro (C) Pessoa Fisica (PF).
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class CTACPF000001 extends BaseIntegrationTest {	

	static {
		ReadJSON.fileName("CTACPF000001");
	}	
	private String usuario = ReadJSON.lerMassa("usuario");
	private String senha = ReadJSON.lerMassa("senha");
	private String cpf = ReadJSON.lerMassa("cpf");	
	private String sexo = ReadJSON.lerMassa("sexo");
	private String naturalidade = ReadJSON.lerMassa("naturalidade");
	private String municipio = ReadJSON.lerMassa("municipio");
	private String grauIntrucao = ReadJSON.lerMassa("grauIntrucao");
	private String tipoOcupacao = ReadJSON.lerMassa("tipoOcupacao");
	private String principalOcupacao = ReadJSON.lerMassa("principalOcupacao");
	private String documentoIdentificacao = ReadJSON.lerMassa("documentoIdentificacao");
	private String tipoDocumento = ReadJSON.lerMassa("tipoDocumento");
	private String numeroDocumento = ReadJSON.lerMassa("numeroDocumento");
	private String dataEmissaoDia = ReadJSON.lerMassa("dataEmissaoDia");
	private String dataEmissaoMes = ReadJSON.lerMassa("dataEmissaoMes");
	private String dataEmissaoAno = ReadJSON.lerMassa("dataEmissaoAno");
	private String orgaoEmissor = ReadJSON.lerMassa("orgaoEmissor");
	private String documentoUf = ReadJSON.lerMassa("documentoUf");
	private String estadoCivil = ReadJSON.lerMassa("estadoCivil");
	private String cpfConjuge = ReadJSON.lerMassa("cpfConjuge");
	private String tipoRenda = ReadJSON.lerMassa("tipoRenda");
	private String caracteristicaRenda = ReadJSON.lerMassa("caracteristicaRenda");
	private String tipoFontePagadora = ReadJSON.lerMassa("tipoFontePagadora");
	private String cpfOuCnpj = ReadJSON.lerMassa("cpfOuCnpj");
	private String tipoOcupacaoRendas = ReadJSON.lerMassa("tipoOcupacaoRendas");
	private String dataAdmissaoDia = ReadJSON.lerMassa("dataAdmissaoDia");
	private String dataAdmissaoMes = ReadJSON.lerMassa("dataAdmissaoMes");
	private String dataAdmissaoAno = ReadJSON.lerMassa("dataAdmissaoAno");
	private String rendaBruta = ReadJSON.lerMassa("rendaBruta");
	private String rendaLiquida = ReadJSON.lerMassa("rendaLiquida");
	private String mesAnoReferencia = ReadJSON.lerMassa("mesAnoReferencia");
	private String comprovanteRenda = ReadJSON.lerMassa("comprovanteRenda");
	private String segmento = ReadJSON.lerMassa("segmento");
	private String gerenteResponsavel = ReadJSON.lerMassa("gerenteResponsavel");
	private String cep = ReadJSON.lerMassa("cep");
	private String numero = ReadJSON.lerMassa("numero");
	private String complemento = ReadJSON.lerMassa("complemento");
	private String tipoImovel = ReadJSON.lerMassa("tipoImovel");
	private String ocupacaoImovel = ReadJSON.lerMassa("ocupacaoImovel");
	private String dataReferencia = ReadJSON.lerMassa("dataReferencia");
			
	@Page
	private LoginPage loginPage;	
	@Page
	private MenuPage menuPage;	
	@Page
	private BuscaPage buscaPage;
	@Page
	private DadosCadastraisPage dadosCadastraisPage;
	@Page
	private RendasPage rendasPage;
	@Page
	private PerfilPage perfilPage;
	@Page
	private EnderecosPage enderecosPage;
	
	@Test
	public void cadastroDeContaSimplesPF() throws Throwable {
		try {	
			
			logInfo("[Step 1]: Realizar Login");
			loginPage.logar(usuario, senha);
			
			logInfo("[Step 2]: Acessar o Menu de pessoa Fisica");
			menuPage.menuPessoaFisica();
			
			logInfo("[Step 3]: Buscar pelo CPF");
			buscaPage.buscarCpf(cpf);
			
			logInfo("[Step 4]: Preencher Dados Cadastrais");
			dadosCadastraisPage.preencherDadosCadastrais(sexo, naturalidade, municipio, grauIntrucao, tipoOcupacao, principalOcupacao);
			dadosCadastraisPage.preencherDadosCadastraisDocumentosIdentificacao(documentoIdentificacao, tipoDocumento, numeroDocumento,
					dataEmissaoDia, dataEmissaoMes, dataEmissaoAno, orgaoEmissor, documentoUf);
			dadosCadastraisPage.preencherDadosCadastraisConjuge(estadoCivil, cpfConjuge);
			
			logInfo("[Step 5]: Preencher Rendas");
			rendasPage.preencherRenda(tipoRenda, caracteristicaRenda, tipoFontePagadora, cpfOuCnpj);
			rendasPage.preencherOcupacao(tipoOcupacaoRendas, dataAdmissaoDia, dataAdmissaoMes, dataAdmissaoAno, 
					rendaBruta, rendaLiquida, mesAnoReferencia, comprovanteRenda);
			
			logInfo("[Step 6]: Preencher Perfil");
			perfilPage.preencherdadosDaRenda(segmento, gerenteResponsavel);
			
			logInfo("[Step 7]: Preencher Endereço");
			enderecosPage.preencherEndereco(cep, numero, complemento, tipoImovel, ocupacaoImovel, dataReferencia);
			
		} catch (Throwable e) {
			logError("ERRO: "+ e.getMessage());
			throw e;	
		}

	}

}

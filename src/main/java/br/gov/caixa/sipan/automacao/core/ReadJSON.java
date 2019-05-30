package br.gov.caixa.sipan.automacao.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public abstract class ReadJSON {
	
	public static JSONObject json;
	
	public static void fileName(String nomeArquivo) {

        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("C:\\Users\\f626282\\eclipse-workspace\\AutomacaoSipan\\src\\main\\java\\br\\gov\\caixa\\sipan\\automacao\\massa\\"+nomeArquivo+".json"))
        {
            Object obj = jsonParser.parse(reader);             
            json = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
	
	public static String lerMassa(String chave) {
		return (String) json.get(chave);		
	}

	public abstract String getNomeArquivo();

}
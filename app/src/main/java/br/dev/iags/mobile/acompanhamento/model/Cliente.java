package br.dev.iags.mobile.acompanhamento.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente {
    //atributos
    private int id;
    private String nome;
    private String codigo;
    private String servico;
    private String data;

    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Cliente (JSONObject jp) {
        try {
            //id
            Integer numero = (int) jp.get("id");
            this.setId(numero);
            //nome
            this.setNome((String) jp.get("nome"));
            //codigo
            this.setCodigo((String) jp.get("codigo"));
            //servico
            this.setServico((String) jp.get("servico"));
            //data
            this.setData((String) jp.get("data"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Cliente () {
        this.setId(0);
        this.setNome("");
        this.setCodigo("");
        this.setServico("");
        this.setData("");
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("nome", this.nome);
            json.put("codigo", this.codigo);
            json.put("servico", this.servico);
            json.put("data", this.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }


    //metodos
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    //-----------------------------------
    void setNome(String n) {
        if(n.length() < 3){
            this.nome = "A definir";
        }else{
            this.nome = n;
        }
    }
    public String getNome(){
        return this.nome;
    }
    //-----------------------------------
    void setCodigo(String c) {
        if(c.length() < 5){
            this.codigo = "A definir";
        }else{
            this.codigo = c;
        }
    }
    public String getCodigo(){
        return this.codigo;
    }
    //-----------------------------------
    void setServico(String s) {
        if(s.length() < 3){
            this.servico = "A definir";
        }else{
            this.servico = s;
        }
    }
    public String getServico(){
        return this.servico;
    }
    //-----------------------------------
    void setData(String d) {
        this.data = d;
    }
    public String getData(){
        return this.data;
    }
}

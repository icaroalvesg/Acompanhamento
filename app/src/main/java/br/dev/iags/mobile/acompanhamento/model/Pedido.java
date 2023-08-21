package br.dev.iags.mobile.acompanhamento.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
    //atributos
    private int idPedido;
    private String cpfCliente;
    private String detalheServico;
    private int codServico;
    private String data;

    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Pedido(JSONObject jp) {
        try {
            //id
            Integer numero = (int) jp.get("id");
            this.setIdPedido(numero);
            //nome
            this.setCpfCliente((String) jp.get("cliente"));
            //codigo
            numero = (int) jp.get("servico");
            this.setCodServico(numero);
            //servico
            this.setDetalheServico((String) jp.get("detalhe"));
            //data
            this.setData((String) jp.get("data"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Pedido() {
        this.setIdPedido(0);
        this.setCpfCliente("");
        this.setCodServico(0);
        this.setDetalheServico("");
        this.setData("");
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.idPedido);
            json.put("cliente", this.cpfCliente);
            json.put("servico", this.codServico);
            json.put("detalhe", this.detalheServico);
            json.put("data", this.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }


    //metodos

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDetalheServico() {
        return detalheServico;
    }

    public void setDetalheServico(String detalheServico) {
        this.detalheServico = detalheServico;
    }

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}

package br.dev.iags.mobile.acompanhamento.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
    public int id;
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
            this.setCpfCliente((String) jp.get("nrcpfcliente"));
            //codigo
            numero = (int) jp.get("idservico");
            this.setCodServico(numero);
            //servico
            this.setDetalheServico((String) jp.get("deinfservico"));
            //data
            this.setData((String) jp.get("dtservico"));

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
            //json.put("idservico", this.idPedido);
            json.put("nrcpfcliente", this.cpfCliente);
            json.put("idservico", this.codServico);
            json.put("deinfservico", this.detalheServico);
            json.put("dtservico", this.data);
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

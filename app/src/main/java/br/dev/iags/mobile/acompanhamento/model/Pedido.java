package br.dev.iags.mobile.acompanhamento.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
    public int id;
    //atributos
    private int idPedido;
    private String nrcpfcliente;
    private String deInfoServico;
    private int idServico;
    private String dtservico;

    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Pedido(JSONObject jp) {
        try {
            //id
            int numero = (int) jp.getInt("idPedido");
            this.setIdPedido(numero);
            //codigo spiner
            numero = (int) jp.getInt("idservico");
            this.setIdServico(numero);
            //nome
            this.setNrcpfcliente((String) jp.getString("nrcpfcliente"));
            //servico
            this.setDeInfoServico((String) jp.getString("deinfservico"));
            //data
            this.setDtservico((String) jp.getString("dtservico"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Pedido() {
        this.setIdPedido(0);
        this.setNrcpfcliente("");
        this.setIdServico(0);
        this.setDeInfoServico("");
        this.setDtservico("");
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            //json.put("idservico", this.idPedido);
            json.put("nrcpfcliente", this.nrcpfcliente);
            json.put("idservico", this.idServico);
            json.put("deinfservico", this.deInfoServico);
            json.put("dtservico", this.dtservico);
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

    public String getNrcpfcliente() {
        return nrcpfcliente;
    }

    public void setNrcpfcliente(String nrcpfcliente) {
        this.nrcpfcliente = nrcpfcliente;
    }

    public String getDeInfoServico() {
        return deInfoServico;
    }

    public void setDeInfoServico(String deInfoServico) {
        this.deInfoServico = deInfoServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDtservico() {
        return dtservico;
    }

    public void setDtservico(String dtservico) {
        this.dtservico = dtservico;
    }



}

package br.dev.iags.mobile.acompanhamento.ui.cliente;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.dev.iags.mobile.acompanhamento.R;
import br.dev.iags.mobile.acompanhamento.model.Pedido;


public class CadClienteFragment extends Fragment implements View.OnClickListener
        , Response.ErrorListener, Response.Listener {

    private View view = null;
    private Spinner spServico;
    private EditText etCPF;
    private EditText etDetalhe;
    private CalendarView cvData;
    private Button btSalvar;

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_cliente, container, false);
        //
        this.spServico = (Spinner) view.findViewById(R.id.spServico);
        this.etCPF = (EditText) view.findViewById(R.id.etCPF);
        this.etDetalhe = (EditText) view.findViewById(R.id.etDetalhe);
        this.cvData = (CalendarView)view.findViewById(R.id.cvData);
        this.btSalvar = (Button) view.findViewById(R.id.btSalvar);
        this.btSalvar.setOnClickListener(this);
        //
        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
        //inicializando a fila de requests do SO 18
        this.requestQueue.start();
        //
        return this.view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btSalvar:
                Pedido pedido = new Pedido();
                pedido.setCodServico(this.spServico.getSelectedItemPosition());
                pedido.setCpfCliente(this.etCPF.getText().toString());
                pedido.setDetalheServico(this.etDetalhe.getText().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataSelecionada = sdf.format(new Date(cvData.getDate()));
                pedido.setData(dataSelecionada);
                //mensagem de sucesso
               /* Context context = view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Snackbar.make(view,"Pedido cadastrado com sucesso!",Snackbar.LENGTH_LONG).show();
                */

                //chamar webservice
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2/cadPedido.php/segServer/rest/usuario",
                        pedido.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view, "Ops! Houve um problema ao realizar o cadastro: " + error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();

    }

    @Override
    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o JSON que recebemos
            JSONObject jo = new JSONObject(response.toString());
            //cvontext e text sao para a mensagem na tela o toast
            Context context = view.getContext();
            //pegando mesagem que veio no json
            CharSequence mensagem = jo.getString("mensage");
            //duração da mensgem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificando se salvou sem erro para limpar campos da tela
            if(jo.getBoolean("sucess")){
                //campos texto
                this.etCPF.setText("");
                this.etDetalhe.setText("");
                //selecionando primeiro item  dos spinners
                this.spServico.setSelection(0);
            }
            //mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText(context, mensagem, duration);
            toast.show();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        //mensagem de sucesso
               /* Context context = view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();*/
        Snackbar.make(view,"Pedido cadastrado com sucesso!",Snackbar.LENGTH_LONG).show();

    }
}
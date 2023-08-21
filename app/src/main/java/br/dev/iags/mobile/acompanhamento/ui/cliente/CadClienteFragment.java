package br.dev.iags.mobile.acompanhamento.ui.cliente;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import br.dev.iags.mobile.acompanhamento.R;
import br.dev.iags.mobile.acompanhamento.model.Pedido;


public class CadClienteFragment extends Fragment implements View.OnClickListener {

    private View view = null;
    private Spinner spServico;
    private EditText etCPF;
    private EditText etDetalhe;
    private CalendarView cvData;
    private Button btSalvar;

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

                break;
        }

    }
}
package br.dev.iags.mobile.acompanhamento.ui.cliente;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.dev.iags.mobile.acompanhamento.R;


public class CadClienteFragment extends Fragment {

    private View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_cliente, container, false);
        return this.view;
    }

}
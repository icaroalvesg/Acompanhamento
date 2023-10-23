package br.dev.iags.mobile.acompanhamento.ui.cliente;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.dev.iags.mobile.acompanhamento.databinding.FragmentConpedidoBinding;
import br.dev.iags.mobile.acompanhamento.model.Pedido;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pedido}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConPedidoRecyclerViewAdapter extends RecyclerView.Adapter<ConPedidoRecyclerViewAdapter.ViewHolder> {

    private final List<Pedido> mValues;

    public ConPedidoRecyclerViewAdapter(List<Pedido> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConpedidoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getIdPedido()));
        holder.mContentView.setText(String.valueOf(mValues.get(position).getCpfCliente()));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Pedido mItem;

        public ViewHolder(FragmentConpedidoBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
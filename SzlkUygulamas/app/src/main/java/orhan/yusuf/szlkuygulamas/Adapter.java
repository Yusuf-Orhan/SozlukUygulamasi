package orhan.yusuf.szlkuygulamas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import orhan.yusuf.szlkuygulamas.databinding.CardTasarimBinding;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    Context mContext;
    ArrayList<Kelimeler> kelimelerArrayList;
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.binding.ingilizceKelime.setText(kelimelerArrayList.get(position).getIngilizce());
        holder.binding.textViewTurkce.setText(kelimelerArrayList.get(position).getTurkce_kelime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public Adapter(ArrayList<Kelimeler> kelimelerArrayList,Context mContext) {
        this.kelimelerArrayList = kelimelerArrayList;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return kelimelerArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        CardTasarimBinding binding;
        public MyHolder(@NonNull CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

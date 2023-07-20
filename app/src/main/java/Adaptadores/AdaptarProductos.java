package Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea_reciclerview.MainActivity2;
import com.example.tarea_reciclerview.R;

import java.util.List;

import Modelos.Productos;

public class AdaptarProductos extends RecyclerView.Adapter<AdaptarProductos.ProductosViewHolder>{
    private Context Ctx;
    private List<Productos> lstProductos;
    public AdaptarProductos(Context mCtx, List<Productos> productos1) {
        this.lstProductos = productos1;
        Ctx=mCtx;
    }


    @NonNull
    @Override
    public AdaptarProductos.ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyitem, null);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptarProductos.ProductosViewHolder holder, int position) {
        Productos producto = lstProductos.get(position);

        holder.textViewTitle.setText(producto.getTitle());
        holder.textViewPrice.setText(producto.getPrice());
        holder.textViewURLAvatar.setText(producto.getWebsite());
        Glide.with(Ctx)
                .load(producto.getUrlavatar())
                .into(holder.imageView);

        /*holder.cardviewImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putStringArray("images", producto.getImages());
                b.putString("title", producto.getTitle());
                //b.putString("price", producto.getPrice());
                Intent intent = new Intent(Ctx, MainActivity2.class);
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {return lstProductos.size();}

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        CardView cardviewImages;
        TextView textViewTitle, textViewURLAvatar, textViewDescription, textViewPrice;
        ImageView imageView;
        public ProductosViewHolder(View view) {
            super(view);
            textViewTitle = view.findViewById(R.id.txtTitle);
            textViewURLAvatar = view.findViewById(R.id.txtAvatar);
            textViewPrice = itemView.findViewById(R.id.txtPrecio);
            imageView = view.findViewById(R.id.imgAvatar);
            cardviewImages=itemView.findViewById(R.id.productocard);
        }
    }
}

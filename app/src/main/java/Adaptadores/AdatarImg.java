package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea_reciclerview.R;

public class AdatarImg extends RecyclerView.Adapter<AdatarImg.ImagesViewHolder> {

    private Context Ctx;
    private String[] lstImages;
    public AdatarImg(Context mCtx, String[] images) {
        this.lstImages = images;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lymostrarimgs, null);
        return new AdatarImg.ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        String imagen = lstImages[position];
        Glide.with(Ctx)
                .load(imagen)
                .into(holder.imageProducto);
    }

    @Override
    public int getItemCount() {return lstImages.length;}

    class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProducto;
        CardView cardProducto;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            imageProducto = itemView.findViewById(R.id.productoimg);
            cardProducto = itemView.findViewById(R.id.productocard);
        }
    }
}

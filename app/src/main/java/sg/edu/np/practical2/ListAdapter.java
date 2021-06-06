package sg.edu.np.practical2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    ArrayList<User> user_members;
    private RecyclerViewClickListener listener;

    public ListAdapter(ArrayList<User> input, RecyclerViewClickListener listener) {
        this.user_members = input;
        this.listener = listener;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt1;
        TextView txt2;
        ImageView image;

        public ListViewHolder(View itemView){
            super(itemView);
            txt1 = itemView.findViewById(R.id.textView3);
            txt2 = itemView.findViewById(R.id.textView4);
            image = itemView.findViewById(R.id.imageView2);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            listener.onClick(view, getAdapterPosition());
        }
    }

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item;
        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ListViewHolder(item);
    }

    public void onBindViewHolder(ListViewHolder holder, int position){
        User user_item = user_members.get(position);
        holder.txt1.setText(user_item.getName());
        holder.txt2.setText(user_item.getDescription());
        holder.image.setImageResource(user_item.getMyImageID());
    }

    public int getItemCount() {
        return user_members.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }


}

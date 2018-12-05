package app.com.onefc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.com.onefc.R;
import app.com.onefc.models.Contact;

/**
 * Created by pawansingh on 21/11/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Contact> contacts = new ArrayList<>();

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textViewNumber;

        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);
            textViewNumber = view.findViewById(R.id.textViewNumber);
        }
    }

    public void refreshData(List<Contact> contacts) {
        this.contacts.clear();
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }


    public MyAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewName.setText(String.format("Name : %s", contacts.get(position).getName()));
        holder.textViewNumber.setText(String.format("Contact No. : %s", contacts.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}

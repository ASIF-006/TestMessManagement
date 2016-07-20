package com.example.mobileappdevelop.testmessmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AL ASIF on 7/20/2016.
 */
public class MealBazarCustomAdapter extends ArrayAdapter<Member> {

    Context context;
    ArrayList<Member> members;
    public MealBazarCustomAdapter(Context context,ArrayList<Member> members) {
        super(context, R.layout.meal_bazar_list_row, members);
        this.context = context;
        this.members = members;
    }

    private static class ViewHolder {
        TextView memberNameTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.meal_bazar_list_row, null, true);

            viewHolder.memberNameTV = (TextView) convertView.findViewById(R.id.memberNameTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.memberNameTV.setText(members.get(position).getMemberName());

        return convertView;
    }

}

package com.example.department_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter1 extends ArrayAdapter<Faculty> {

    public ArrayList<Faculty> MainList;

    public ArrayList<Faculty> FacultyListTemp;

    public ListAdapter1.SubjectDataFilter facultyDataFilter;

    public ListAdapter1(Context context, int id, ArrayList<Faculty> FacultyArrayList) {

        super(context, id, FacultyArrayList);

        this.FacultyListTemp = new ArrayList<Faculty>();

        this.FacultyListTemp.addAll(FacultyArrayList);

        this.MainList = new ArrayList<Faculty>();

        this.MainList.addAll(FacultyArrayList);
    }

    @Override
    public Filter getFilter() {

        if (facultyDataFilter == null) {

            facultyDataFilter = new ListAdapter1.SubjectDataFilter();
        }
        return facultyDataFilter;
    }


    public class ViewHolder {

        TextView Name;
        TextView Number;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListAdapter1.ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.custom_layout, null);

            holder = new ListAdapter1.ViewHolder();

            holder.Name = (TextView) convertView.findViewById(R.id.textviewName);

            holder.Number = (TextView) convertView.findViewById(R.id.textviewPhoneNumber);

            convertView.setTag(holder);

        } else {

            holder = (ListAdapter1.ViewHolder) convertView.getTag();
        }

        Faculty student = FacultyListTemp.get(position);

        holder.Name.setText(student.getFname());

        holder.Number.setText(student.getFId());

        return convertView;

    }

    private class SubjectDataFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            charSequence = charSequence.toString().toLowerCase();

            FilterResults filterResults = new FilterResults();

            if (charSequence != null && charSequence.toString().length() > 0) {

                ArrayList<Faculty> arrayList1 = new ArrayList<Faculty>();

                for (int i = 0, l = MainList.size(); i < l; i++) {
                    Faculty subject = MainList.get(i);

                    if (subject.toString().toLowerCase().contains(charSequence))

                        arrayList1.add(subject);
                }
                filterResults.count = arrayList1.size();

                filterResults.values = arrayList1;
            } else {
                synchronized (this) {
                    filterResults.values = MainList;

                    filterResults.count = MainList.size();
                }
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            FacultyListTemp = (ArrayList<Faculty>) filterResults.values;

            notifyDataSetChanged();

            clear();

            for (int i = 0, l = FacultyListTemp.size(); i < l; i++)
                add(FacultyListTemp.get(i));

            notifyDataSetInvalidated();
        }
    }
}

package com.example.department_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class list extends ArrayAdapter<Student> {

    public ArrayList<Student> MainList;

    public ArrayList<Student> StudentListTemp;


    public list(Context context, int id, ArrayList<Student> studentArrayList) {

        super(context, id, studentArrayList);

        this.StudentListTemp = new ArrayList<Student>();

        this.StudentListTemp.addAll(studentArrayList);

        this.MainList = new ArrayList<Student>();

        this.MainList.addAll(studentArrayList);
    }


    public class ViewHolder {

        TextView Name;
        TextView Number;
        TextView year;
        TextView Sem;
        TextView PhonenNo;
        TextView Aadhar;
        TextView Fn;
        TextView Mn;
        TextView Blood;
        TextView Address;
        TextView Day;
        TextView Fun;
        TextView Mun;
        TextView Dip;
        TextView DipClg;
        TextView Dipper;
        TextView DipPass;
        TextView Hsc;
        TextView HscClg;
        TextView HscPer;
        TextView HscPass;
        TextView SSLC;
        TextView SSLCClg;
        TextView SSLCPer;
        TextView SSLCPass;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        list.ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.custom1, null);

            holder = new list.ViewHolder();

            holder.Name = (TextView) convertView.findViewById(R.id.textviewName);

            holder.Number = (TextView) convertView.findViewById(R.id.textviewUsn);

            holder.year = (TextView)convertView.findViewById(R.id.textviewYear);

            holder.Sem =(TextView)convertView.findViewById(R.id.textviewSem);

            holder.PhonenNo=(TextView)convertView.findViewById(R.id.textviewContectNo);

            holder.Aadhar = (TextView)convertView.findViewById(R.id.textviewAadhar);

            holder.Fn =(TextView)convertView.findViewById(R.id.textviewFN);

            holder.Mn = (TextView)convertView.findViewById(R.id.textviewMN);

            holder.Blood = (TextView)convertView.findViewById(R.id.textviewBlood);

            holder.Address = (TextView)convertView.findViewById(R.id.textviewAddress);

            holder.Day = (TextView)convertView.findViewById(R.id.textviewDay);

            holder.Fun=(TextView)convertView.findViewById(R.id.textviewFUN);

            holder.Mun=(TextView)convertView.findViewById(R.id.textviewMUN);

            holder.Dip=(TextView)convertView.findViewById(R.id.textviewDip);

            holder.DipClg=(TextView)convertView.findViewById(R.id.textviewDipClg);

            holder.Dipper=(TextView)convertView.findViewById(R.id.textviewDipPer);

            holder.DipPass = (TextView)convertView.findViewById(R.id.textviewDipPass);

            holder.Hsc = (TextView)convertView.findViewById(R.id.textviewHsc);

            holder.HscClg=(TextView)convertView.findViewById(R.id.textviewHscClg);

            holder.HscPer = (TextView)convertView.findViewById(R.id.textviewHscPer);

            holder.HscPass =(TextView)convertView.findViewById(R.id.textviewHscPass);

            holder.SSLC = (TextView)convertView.findViewById(R.id.textviewSSLC);

            holder.SSLCClg=(TextView)convertView.findViewById(R.id.textviewSSLCSCH);

            holder.SSLCPer = (TextView)convertView.findViewById(R.id.textviewSSLCPER);

            holder.SSLCPass=(TextView)convertView.findViewById(R.id.textviewSSLCPASS);

            convertView.setTag(holder);

        } else {

            holder = (list.ViewHolder) convertView.getTag();
        }

        Student student = StudentListTemp.get(position);

        holder.Name.setText(student.getName());

        holder.Number.setText(student.getNumber());

        holder.year.setText(student.getCurrentYear());

        holder.Sem.setText(student.getCurrentSem());

        holder.PhonenNo.setText(student.getPhoneNumber());

        holder.Aadhar.setText(student.getAadharNo());

        holder.Fn.setText(student.getFatherName());

        holder.Mn.setText(student.getMotherName());

        holder.Blood.setText(student.getBloodGroup());

        holder.Address.setText(student.getComAdd());

        holder.Day.setText(student.getHostel());

        holder.Fun.setText(student.getFatherNum());

        holder.Mun.setText(student.getMotherNum());

        holder.Dip.setText(student.getDipB());

        holder.DipClg.setText(student.getDipClg());

        holder.Dipper.setText(student.getDipPer());

        holder.DipPass.setText(student.getDipQYear());

        holder.Hsc.setText(student.getHscB());

        holder.HscClg.setText(student.getHscClg());

        holder.HscPer.setText(student.getHscPer());

        holder.HscPass.setText(student.getHscQYear());

        holder.SSLC.setText(student.getSslcB());

        holder.SSLCClg.setText(student.getSslcClg());

        holder.SSLCPer.setText(student.getSslcPer());

        holder.SSLCPass.setText(student.getSslsQYear());

        return convertView;

    }
}

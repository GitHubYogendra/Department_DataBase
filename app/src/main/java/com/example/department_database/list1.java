package com.example.department_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

public class list1 extends ArrayAdapter<Faculty> {

    public ArrayList<Faculty> MainList;

    public ArrayList<Faculty> FacultyListTemp;

    public list1(Context context, int id, ArrayList<Faculty> FacultyArrayList) {

        super(context, id, FacultyArrayList);

        this.FacultyListTemp = new ArrayList<Faculty>();

        this.FacultyListTemp.addAll(FacultyArrayList);

        this.MainList = new ArrayList<Faculty>();

        this.MainList.addAll(FacultyArrayList);
    }

    public class ViewHolder {

        TextView FName;
        TextView FId;
        TextView FDep;
        TextView Phone1;
        TextView Phone2;
        TextView Aadhar;
        TextView Address;
        TextView Phd;
        TextView PhdClg;
        TextView PhdPer;
        TextView PhdPass;
        TextView Me;
        TextView MeClg;
        TextView MePer;
        TextView MePass;
        TextView Be;
        TextView BeClg;
        TextView BePer;
        TextView BePass;
        TextView Hsc;
        TextView HscClg;
        TextView HscPer;
        TextView HscPass;
        TextView Sslc;
        TextView SslcClg;
        TextView SslcPer;
        TextView SslcPass;
        TextView Award;
        TextView Member;
        TextView Indu;
        TextView Academic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        list1.ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.custom2, null);

            holder = new list1.ViewHolder();

            holder.FName = (TextView) convertView.findViewById(R.id.textviewName21);

            holder.FId = (TextView) convertView.findViewById(R.id.textviewId21);

            holder.FDep = (TextView) convertView.findViewById(R.id.textviewDep21);

            holder.Phone1 =(TextView)convertView.findViewById(R.id.textviewPhone11);

            holder.Phone2 = (TextView) convertView.findViewById(R.id.textviewPhone21);

            holder.Aadhar= (TextView)convertView.findViewById(R.id.textviewAadhar21);

            holder.Address = (TextView)convertView.findViewById(R.id.textviewAddress21);

            holder.Phd = (TextView)convertView.findViewById(R.id.textviewPhd21);

            holder.PhdClg =(TextView)convertView.findViewById(R.id.textviewPhdClg21);

            holder.PhdPer = (TextView)convertView.findViewById(R.id.textviewPhdPer21);

            holder.PhdPass = (TextView)convertView.findViewById(R.id.textviewPhdPass21);

            holder.Me = (TextView)convertView.findViewById(R.id.textviewMe21);

            holder.MeClg = (TextView)convertView.findViewById(R.id.textviewMeClgName21);

            holder.MePer = (TextView)convertView.findViewById(R.id.textviewMePer21);

            holder.MePass = (TextView)convertView.findViewById(R.id.textviewMePass21);

            holder.Be = (TextView)convertView.findViewById(R.id.textviewBe21);

            holder.BeClg = (TextView)convertView.findViewById(R.id.textviewBeClgName21);

            holder.BePer = (TextView)convertView.findViewById(R.id.textviewBePer21);

            holder.BePass = (TextView)convertView.findViewById(R.id.textviewBePass21);

            holder.Hsc = (TextView)convertView.findViewById(R.id.textviewHsc21);

            holder.HscClg = (TextView)convertView.findViewById(R.id.textviewHscClgName21);

            holder.HscPer = (TextView)convertView.findViewById(R.id.textviewHscPer21);

            holder.HscPass = (TextView)convertView.findViewById(R.id.textviewHscPass21);

            holder.Sslc = (TextView)convertView.findViewById(R.id.textviewSSLC21);

            holder.SslcClg = (TextView)convertView.findViewById(R.id.textviewSSLCCLGNAME21);

            holder.SslcPer = (TextView)convertView.findViewById(R.id.textviewSSLCPER21);

            holder.SslcPass =(TextView)convertView.findViewById(R.id.textviewSSLCPASS21);

            holder.Award = (TextView)convertView.findViewById(R.id.textviewPubAward21);

            holder.Member = (TextView)convertView.findViewById(R.id.textviewPubMember21);

            holder.Indu = (TextView)convertView.findViewById(R.id.textviewExpInd21);

            holder.Academic = (TextView)convertView.findViewById(R.id.textviewExpAcademic21);

            convertView.setTag(holder);

        } else {

            holder = (list1.ViewHolder) convertView.getTag();
        }

        Faculty student = FacultyListTemp.get(position);

        holder.FName.setText(student.getFname());

        holder.FId.setText(student.getFId());

        holder.FDep.setText(student.getFDepa());

        holder.Phone1.setText(student.getFphoneNumber1());

        holder.Phone2.setText(student.getFphoneNumber2());

        holder.Aadhar.setText(student.getFAadharNum());

        holder.Address.setText(student.getFCommAdd());

        holder.Phd.setText(student.getFPhd1());

        holder.PhdClg.setText(student.getFPhdClgName());

        holder.PhdPer.setText(student.getFPhdPer());

        holder.PhdPass.setText(student.getFPhdYear());

        holder.Me.setText(student.getFME1());

        holder.MeClg.setText(student.getFMeClgName());

        holder.MePer.setText(student.getFMePer());

        holder.MePass.setText(student.getFMeyear());

        holder.Be.setText(student.getFBe1());

        holder.BeClg.setText(student.getFBeClgName());

        holder.BePer.setText(student.getFBePer());

        holder.BePass.setText(student.getFBeYear());

        holder.Hsc.setText(student.getFHsc1());

        holder.HscClg.setText(student.getFHscClgName());

        holder.HscPer.setText(student.getFHscPer());

        holder.HscPass.setText(student.getFHscYear());

        holder.Sslc.setText(student.getFSslc1());

        holder.SslcClg.setText(student.getFSslcClgName());

        holder.SslcPer.setText(student.getFSslcPer());

        holder.SslcPass.setText(student.getFSslcYear());

        holder.Award.setText(student.getFAward());

        holder.Member.setText(student.getFMember());

        holder.Indu.setText(student.getFIndstry());

        holder.Academic.setText(student.getFAcademic());

        return convertView;

    }
}
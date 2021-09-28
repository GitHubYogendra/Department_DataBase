package com.example.department_database;

public class Student {
    String name = null;
    String number = null;
    String phoneNumber = null;
    String CurrentYear = null;
    String CurrentSem = null;
    String AadharNo = null;
    String FatherName = null;
    String MotherName = null;
    String comAdd = null;
    String BloodGroup = null;
    String FatherNum = null;
    String MotherNum = null;
    String Hostel = null;
    String DipB = null;
    String DipClg = null;
    String DipPer = null;
    String DipQYear = null;
    String HscB = null;
    String HscClg = null;
    String HscPer = null;
    String HscQYear = null;
    String SslcB = null;
    String SslcClg = null;
    String SslcPer = null;
    String SslsQYear = null;
    String StuId = null;

    public Student(String Sname, String Snumber,String SPhoneNumber,String SCurrentYear,String SCurrentSem,String SAadharNo,String SFatherName,String SMotherName,
    String ScomAdd,String SBloodGroup,String SFatherNum,String SMotherNum,String SHostel,String mDipB,String mDipClg,String mDipPer,String mDipQYear,
                   String mHscB,String mHscClg,String mHscPer,String mHscQYear,String mSslcB,String mSslcClg,String mSslcPer,String mSslcQYear,String mStuId ) {

        super();

        this.name = Sname;

        this.number = Snumber;

        this.phoneNumber = SPhoneNumber;

        this.CurrentYear = SCurrentYear;

        this.CurrentSem = SCurrentSem;

        this.AadharNo = SAadharNo;

        this.FatherName = SFatherName;

        this.MotherName  = SMotherName;

        this.comAdd=ScomAdd;

        this.BloodGroup=SBloodGroup;

        this.FatherNum = SFatherNum;

        this.MotherNum = SMotherNum;

        this.Hostel= SHostel;

        this.DipB = mDipB;

        this.DipClg = mDipClg;

        this.DipPer = mDipPer;

        this.DipQYear = mDipQYear;

        this.HscB = mHscB;

        this.HscClg = mHscClg;

        this.HscPer = mHscPer;

        this.HscQYear = mHscQYear;

        this.SslcB = mSslcB;

        this.SslcClg = mSslcClg;

        this.SslcPer = mSslcPer;

        this.SslsQYear = mSslcQYear;

        this.StuId = mStuId;
    }

    public String getName() {

        return name;

    }
    public void setName(String Name2) {

        this.name = Name2;

    }
    public String getNumber() {

        return number;

    }
    public void setNumber(String number2) {

        this.number = number2;

    }

    public void setCurrentYear(String currentYear) {
        CurrentYear = currentYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCurrentYear() {
        return CurrentYear;
    }

    public String getCurrentSem() { return CurrentSem; }

    public String getAadharNo() { return AadharNo; }

    public String getFatherName() { return FatherName; }

    public String getMotherName() { return MotherName; }

    public String getComAdd() { return comAdd; }

    public String getBloodGroup() { return BloodGroup; }

    public String getFatherNum() { return FatherNum; }

    public String getMotherNum() { return MotherNum; }

    public String getHostel() { return Hostel; }

    public String getDipB() { return DipB; }

    public String getDipClg() { return DipClg; }

    public String getDipPer() { return DipPer; }

    public String getDipQYear() { return DipQYear; }

    public String getHscB() { return HscB; }

    public String getHscClg() { return HscClg; }

    public String getHscPer() { return HscPer; }

    public String getHscQYear() { return HscQYear; }

    public String getSslcB() { return SslcB; }

    public String getSslcClg() { return SslcClg; }

    public String getSslcPer() { return SslcPer; }

    public String getSslsQYear() { return SslsQYear; }

    public String getStuId() {
        return StuId;
    }

    @Override
    public String toString() {

        return  name + " " + number;

    }

}

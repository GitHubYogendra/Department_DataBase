package com.example.department_database;

public class Faculty {
    String Fname = null;
    String FphoneNumber1 = null;
    String FphoneNumber2 = null;
    String FId = null;
    String FCommAdd = null;
    String FAadharNum = null;
    String FPhd1 = null;
    String FPhdYear = null;
    String FPhdClgName = null;
    String FPhdPer = null;
    String FME1 = null;
    String FMeyear= null;
    String FMeClgName = null;
    String FMePer = null;
    String FBe1 = null;
    String FBeClgName = null;
    String FBeYear = null;
    String FBePer = null;
    String FHsc1 = null;
    String FHscClgName = null;
    String FHscYear = null;
    String FHscPer = null;
    String FSslc1 = null;
    String FSslcClgName = null;
    String FSslcYear = null;
    String FSslcPer = null;
    String FAward = null;
    String FMember = null;
    String FIndstry = null;
    String FAcademic = null;
    String FUnique = null;

    public Faculty (String mFname,String mFId,String mFphoneNumber1,String mFphoneNumber2,String mFCommAdd,String mFAadharNum,
                    String mFPhd1,String mFPhdYear,String mFPhdClgName,String mFPhdPer,String mFME1,String mFMeyear,String mFMeClgName,
                    String mFMePer,String mFBe1,String mFBeClgName,String mFBeYear,String mFBePer,String mFHsc1,String mFHscClgName,
                    String mFHscYear,String mFHscPer,String mFSslc1,String mFSslcClgName,String mFSslcYear,String mFSslcPer,String mFAward,
                    String mFMember,String mFIndstry,String mFAcademic,String mFUnique){
        super();

        this.Fname = mFname;
        this.FphoneNumber1 = mFphoneNumber1;
        this.FphoneNumber2 = mFphoneNumber2;
        this.FId = mFId;
        this.FCommAdd = mFCommAdd;
        this.FAadharNum = mFAadharNum;
        this.FPhd1 = mFPhd1;
        this.FPhdYear = mFPhdYear;
        this.FPhdClgName = mFPhdClgName;
        this.FPhdPer = mFPhdPer;
        this.FME1 = mFME1;
        this.FMeyear = mFMeyear;
        this.FMeClgName = mFMeClgName;
        this.FMePer = mFMePer;
        this.FBe1= mFBe1;
        this.FBeClgName = mFBeClgName;
        this.FBeYear = mFBeYear;
        this.FBePer = mFBePer;
        this.FHsc1 = mFHsc1;
        this.FHscClgName = mFHscClgName;
        this.FHscYear = mFHscYear;
        this.FHscPer = mFHscPer;
        this.FSslc1 = mFSslc1;
        this.FSslcClgName = mFSslcClgName;
        this.FSslcYear = mFSslcYear;
        this.FSslcPer = mFSslcPer;
        this.FAward = mFAward;
        this.FMember = mFMember;
        this.FIndstry= mFIndstry;
        this.FAcademic = mFAcademic;
        this.FUnique = mFUnique;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFname() {
        return Fname;
    }

    public String getFId() {
        return FId;
    }

    public String getFphoneNumber1() {
        return FphoneNumber1;
    }

    public String getFphoneNumber2() {
        return FphoneNumber2;
    }

    public String getFCommAdd() {
        return FCommAdd;
    }

    public String getFAadharNum() {
        return FAadharNum;
    }

    public String getFPhd1() {
        return FPhd1;
    }

    public String getFPhdYear() {
        return FPhdYear;
    }

    public String getFPhdPer() {
        return FPhdPer;
    }

    public String getFPhdClgName() {
        return FPhdClgName;
    }

    public String getFME1() {
        return FME1;
    }

    public String getFMeyear() {
        return FMeyear;
    }

    public String getFMeClgName() {
        return FMeClgName;
    }

    public String getFMePer() {
        return FMePer;
    }

    public String getFBe1() {
        return FBe1;
    }

    public String getFBeClgName() {
        return FBeClgName;
    }

    public String getFBeYear() {
        return FBeYear;
    }

    public String getFBePer() {
        return FBePer;
    }

    public String getFHsc1() {
        return FHsc1;
    }

    public String getFHscYear() {
        return FHscYear;
    }

    public String getFHscClgName() {
        return FHscClgName;
    }

    public String getFHscPer() {
        return FHscPer;
    }

    public String getFSslc1() {
        return FSslc1;
    }

    public String getFSslcClgName() {
        return FSslcClgName;
    }

    public String getFSslcYear() {
        return FSslcYear;
    }

    public String getFSslcPer() {
        return FSslcPer;
    }

    public String getFMember() {
        return FMember;
    }

    public String getFIndstry() {
        return FIndstry;
    }

    public String getFAward() {
        return FAward;
    }

    public String getFAcademic() {
        return FAcademic;
    }

    public String getFUnique() {
        return FUnique;
    }

    @Override
    public String toString() {

        return  Fname + " " + FId;

    }

}

package com.example.department_database.data;

import android.provider.BaseColumns;

public class TeacherContact {

    private TeacherContact(){
    }

    public static final class TeacherEntry implements BaseColumns {


        public final static String TABLE_NAME = "Teacher";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_FACULTY_NAME = "nameT";

        public final static String COLUMN_FACULTY_ID = "FaculityIdT";

        public final static String COLUMN_FACULTY_AADHAR_NUMBER = "AadharNumberT";

        public final static String COLUMN_FACULTY_COMMUNICATION_ADDRESS = "addressT";

        public final static String COLUMN_FACULTY_PHD = "imageT";

        public final static String COLUMN_FACULTY_PHD_QUAL_YEAR = "phdQualYearT";

        public static final String COLUMN_FACULTY_PHD_Clg_NAME = "phdClgNameT";

        public static final String COLUMN_FACULTY_PHD_PER = "phdPercentageT";

        public static final String COLUMN_FACULTY_ME = "meBranchT";

        public static final String COLUMN_FACULTY_ME_QUAL_YEAR= "meQualYearT";

        public final static String COLUMN_FACULTY_ME_CLG_NAME = "meClgNameT";

        public final static String COLUMN_FACULTY_ME_PER = "mePercentageT";

        public final static String COLUMN_FACULTY_BE = "BEBranchT";

        public final static String COLUMN_FACULTY_BE_QUAL_YEAR = "BEQualYearT";

        public final static String COLUMN_FACULTY_BE_CLG_NAME = "BEClgNameT";

        public final static String COLUMN_FACULTY_BE_PER = "BEPercentageT";

        public final static String COLUMN_FACULTY_HSC = "HSCBranchT";

        public final static String COLUMN_FACULTY_HSC_CLG_NAME = "HSCClgNameT";

        public final static String COLUMN_FACULTY_HSC_QUL_YEAR = "HSCQualYearT";

        public final static String COLUMN_FACULTY_HSC_PER= "HSCPercentageT";

        public final static String COLUMN_FACULTY_SSLC = "SSLCBranchT";

        public final static String COLUMN_FACULTY_SSLC_QUAL_YEAR = "SSLCQualYearT";

        public final static String COLUMN_FACULTY_SSLC_SCH_NAME = "SSLCSchNameT";

        public final static String COLUMN_FACULTY_SSLC_PERCENTAGE = "SSLCPercentageT";

        public final static String COLUMN_FACULTY_CONTECT_NO1 = "phoneNum1T";

        public final static String COLUMN_FACULTY_CONTECT_NO2 = "phoneNum2T";

        public final static String COLUMN_FACULTY_EXEPERIENCE_ACADEMIC = "EXEPAcademicT";

        public final static String COLUMN_FACULTY_EXEPERIENCE_INDUSTRY = "EXEPIndustryT";

        public final static String COLUMN_FACULTY_PUBLICATION_MEMBERSHIP = "PUBLMemberT";

        public final static String COLUMN_FACULTY_PUBLICATION_AWARDS = "PUBLAwardsT";
    }
}


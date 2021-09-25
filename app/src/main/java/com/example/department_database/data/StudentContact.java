package com.example.department_database.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class StudentContact {

    private StudentContact() {
    }


    public static final class StudentEntry implements BaseColumns {


        public final static String TABLE_NAME = "Student";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_STUDENT_NAME = "name";

        public final static String COLUMN_STUDENT_AADHAR_NUMBER = "AadharNumber";

        public final static String COLUMN_STUDENT_FATHER_NAME = "FatherName";

        public final static String COLUMN_STUDENT_MOTHER_NAME = "MotherName";

        public final static String COLUMN_STUDENT_COMMUNICATION_ADDRESS = "address";

        public final static String COLUMN_STUDENT_YEAR = "CurrentYear";

        public final static String COLUMN_STUDENT_SEM = "sem";

        public static final String COLUMN_HOSTEL_DAY = "hotel";

        public static final String COLUMN_YEAR_QUAL_Sslc = "yearQualSslc";

        public static final String COLUMN_YEAR_QUAL_Hsc = "yearQualHsc";

        public static final String COLUMN_YEAR_QUAL_Dip = "yearQualDip";

        public final static String COLUMN_STUDENT_CONTACT_NO = "studentNum";

        public final static String COLUMN_STUDENT_BLOOD_GROUP = "BloodGroup";

        public final static String COLUMN_STUDENT_FATHER_CONTACT_NO = "studentFatherNum";

        public final static String COLUMN_STUDENT_MOTHER_CONTACT_NO = "studentMotherNum";

        public final static String COLUMN_STUDENT_USN = "usn";

        public final static String COLUMN_STUDENT_DIP_BRANCH = "BranchName";

        public final static String COLUMN_STUDENT_DIP_CLG_NAME = "DipClgName";

        public final static String COLUMN_STUDENT_DIP_PERCENTAGE = "DipPercentage";

        public final static String COLUMN_STUDENT_HSC_BRANCH = "HscBranch";

        public final static String COLUMN_STUDENT_HSC_CLG_NAME = "HscClgName";

        public final static String COLUMN_STUDENT_HSC_PERCENTAGE = "HscPercentage";

        public final static String COLUMN_STUDENT_SSLC_BRANCH = "SslcBranch";

        public final static String COLUMN_STUDENT_SSLC_SCH_NAME = "SslsSchName";

        public final static String COLUMN_STUDENT_SSLC_PERCENTAGE = "SslcPercentage";
    }
}

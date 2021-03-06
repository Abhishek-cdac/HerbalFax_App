package com.herbal.herbalfax.common_screen.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.herbal.herbalfax.R;

public class CommonClass {
    static CommonClass common;

        public static CommonClass getInstance() {
            if (common == null) {
                common = new CommonClass();
            }
            return common;
        }

        public void hideKeyboard(View view, AppCompatActivity activity) {

            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }


        public int getScreenHeight(FragmentActivity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        public void showDialogMsg(AppCompatActivity activity, String header, String body, String btnOk) {

            LayoutInflater factory = LayoutInflater.from(activity);
            View view = factory.inflate(R.layout.custom_dialog_yes, null);
            AlertDialog deleteDialog = new AlertDialog.Builder(activity).create();
            activity.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            deleteDialog.setView(view);
            TextView txt_msg = view.findViewById(R.id.txt_msg);
            txt_msg.setText(body);
            view.findViewById(R.id.btn_ok).setOnClickListener(view1 -> deleteDialog.dismiss());

            deleteDialog.show();

        }



        public void showDialogMsgFrag(FragmentActivity activity, String header, String body, String btnOk) {

            LayoutInflater factory = LayoutInflater.from(activity);
            View view = factory.inflate(R.layout.custom_dialog_yes, null);
            AlertDialog deleteDialog = new AlertDialog.Builder(activity).create();

            deleteDialog.setView(view);
            TextView txt_msg = view.findViewById(R.id.txt_msg);
            txt_msg.setText(body);
            view.findViewById(R.id.btn_ok).setOnClickListener(view1 -> deleteDialog.dismiss());

            deleteDialog.show();

            deleteDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        }


}

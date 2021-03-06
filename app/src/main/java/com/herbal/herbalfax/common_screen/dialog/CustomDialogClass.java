package com.herbal.herbalfax.common_screen.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.herbal.herbalfax.R;

public class CustomDialogClass extends Dialog implements  android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes;
    ImageView no;

    public CustomDialogClass(Activity a) {
        super(a);

        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.resend_verification_dialog);
        yes =  findViewById(R.id.send_button1);
        no =  findViewById(R.id.cancel);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_button:
                c.finish();
                break;
            case R.id.cancel:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
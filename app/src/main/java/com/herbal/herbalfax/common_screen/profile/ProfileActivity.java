package com.herbal.herbalfax.common_screen.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.herbal.herbalfax.R;
import com.herbal.herbalfax.common_screen.utils.session.SessionPref;
import com.herbal.herbalfax.customer.homescreen.favourites.FavouritesActivity;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    TextView userName, profileCategory, DOB, gendertype, cityname, mobilenumber, mailaddress;
    SessionPref pref;
    ImageView profileImage, back;
    Picasso picasso;
    CardView favCard;

    TextView MyDealsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        MyDealsBtn = findViewById(R.id.mydealsbtn);
        favCard = findViewById(R.id.favCard);
        back = findViewById(R.id.back);

        favCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FavouritesActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        MyDealsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyDealsActivity.class);
                startActivity(intent);
            }
        });
        pref = SessionPref.getInstance(this);

        profileImage = findViewById(R.id.profileImage);
        DOB = findViewById(R.id.DOB);
        userName = findViewById(R.id.userName);
        profileCategory = findViewById(R.id.profileCategory);
        gendertype = findViewById(R.id.gendertype);
        cityname = findViewById(R.id.cityname);
        mobilenumber = findViewById(R.id.mobilenumber);
        mailaddress = findViewById(R.id.mailaddress);
        try {
            if (null != SessionPref.LoginUserprofilePic) {
                picasso.load(pref.getStringVal(SessionPref.LoginUserprofilePic)).into(profileImage);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        userName.setText(pref.getStringVal(SessionPref.LoginUserfullName));
        DOB.setText(pref.getStringVal(SessionPref.LoginUserbirthDate));
      //gendertype.setText(pref.getStringVal(SessionPref.LoginUsergender));
        cityname.setText(pref.getStringVal(SessionPref.LoginUserCity));
        mailaddress.setText(pref.getStringVal(SessionPref.LoginUseremail));
        profileCategory.setText(pref.getStringVal(SessionPref.LoginProfession));
        mobilenumber.setText(pref.getStringVal(SessionPref.LoginUserphoneNo));

    }
}
package com.example.a2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;



public class MainActivity extends AppCompatActivity {
    int addFund, mySarmaye, zarib;
    RadioButton tomanRadio, dollarRadio;
    EditText edtDollarRate, edtInitFund, edtAddFund;
    TextView y0p3Result, y0p6Result, y0p9Result, y0p12Result, y0p15Result;
    TextView y3fund3Result, y3fund6Result, y3fund9Result, y3fund12Result, y3fund15Result;
    TextView y3p3Result, y3p6Result, y3p9Result, y3p12Result, y3p15Result;
    TextView y5fund3Result, y5fund6Result, y5fund9Result, y5fund12Result, y5fund15Result;
    TextView y5p3Result, y5p6Result, y5p9Result, y5p12Result, y5p15Result;
    TextView y10fund3Result, y10fund6Result, y10fund9Result, y10fund12Result, y10fund15Result;
    TextView y10p3Result, y10p6Result, y10p9Result, y10p12Result, y10p15Result;
    HorizontalScrollView section2Scroll, section3Scroll, section4Scroll, section5Scroll;
    String savedInputRate;
    String y0p3ResultFormat, y0p6ResultFormat, y0p9ResultFormat, y0p12ResultFormat, y0p15ResultFormat;
    String y3fund3ResultFormat, y3fund6ResultFormat, y3fund9ResultFormat, y3fund12ResultFormat, y3fund15ResultFormat;
    String y3fundplus3ResultFormat, y3fundplus6ResultFormat, y3fundplus9ResultFormat, y3fundplus12ResultFormat, y3fundplus15ResultFormat;
    String y3p3ResultFormat, y3p6ResultFormat, y3p9ResultFormat, y3p12ResultFormat, y3p15ResultFormat;
    String y5fund3ResultFormat, y5fund6ResultFormat, y5fund9ResultFormat, y5fund12ResultFormat, y5fund15ResultFormat;
    String y5p3ResultFormat, y5p6ResultFormat, y5p9ResultFormat, y5p12ResultFormat, y5p15ResultFormat;
    String y5fundplus3ResultFormat, y5fundplus6ResultFormat, y5fundplus9ResultFormat, y5fundplus12ResultFormat, y5fundplus15ResultFormat;
    String y10fund3ResultFormat, y10fund6ResultFormat, y10fund9ResultFormat, y10fund12ResultFormat, y10fund15ResultFormat;
    String y10p3ResultFormat, y10p6ResultFormat, y10p9ResultFormat, y10p12ResultFormat, y10p15ResultFormat;
    String y10fundplus3ResultFormat, y10fundplus6ResultFormat, y10fundplus9ResultFormat, y10fundplus12ResultFormat, y10fundplus15ResultFormat;
    long y0p3ResultLong, y0p6ResultLong, y0p9ResultLong, y0p12ResultLong, y0p15ResultLong;
    long y3fund3ResultLong, y3fund6ResultLong, y3fund9ResultLong, y3fund12ResultLong, y3fund15ResultLong;
    long y3fundplus3ResultLong, y3fundplus6ResultLong, y3fundplus9ResultLong, y3fundplus12ResultLong, y3fundplus15ResultLong;
    long y3p3ResultLong, y3p6ResultLong, y3p9ResultLong, y3p12ResultLong, y3p15ResultLong;
    long y5fundplus3ResultLong, y5fundplus6ResultLong, y5fundplus9ResultLong, y5fundplus12ResultLong, y5fundplus15ResultLong;
    long y5p3ResultLong, y5p6ResultLong, y5p9ResultLong, y5p12ResultLong, y5p15ResultLong;
    long y5fund3ResultLong, y5fund6ResultLong, y5fund9ResultLong, y5fund12ResultLong, y5fund15ResultLong;
    long y10fundplus3ResultLong, y10fundplus6ResultLong, y10fundplus9ResultLong, y10fundplus12ResultLong, y10fundplus15ResultLong;
    long y10p3ResultLong, y10p6ResultLong, y10p9ResultLong, y10p12ResultLong, y10p15ResultLong;
    long y10fund3ResultLong, y10fund6ResultLong, y10fund9ResultLong, y10fund12ResultLong, y10fund15ResultLong;
    DecimalFormat formatDeci = new DecimalFormat("###,###,###,###,###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
        syncScrolls();
        dollarRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
                if (isChecked) {
                    edtDollarRate.setEnabled(true);
                    edtDollarRate.setText(savedInputRate);

                } else {
                    edtDollarRate.setEnabled(false);
                    savedInputRate = edtDollarRate.getText()+"";
                    edtDollarRate.setText("");
                }

                mohasebe();
            }
        });
        edtInitFund.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mohasebe();
            }

        });
        edtAddFund.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mohasebe();
            }


        });
        edtDollarRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mohasebe();
            }
        });

    }

    private void syncScrolls() {

        section2Scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (section3Scroll.getScrollX() == section4Scroll.getScrollX()
                        && section4Scroll.getScrollX() == section5Scroll.getScrollX()
                        && section2Scroll.getScrollX() != section3Scroll.getScrollX()) {
                    int Xscroll = section2Scroll.getScrollX();
                    section3Scroll.setScrollX(Xscroll);
                    section4Scroll.setScrollX(Xscroll);
                    section5Scroll.setScrollX(Xscroll);
                }
            }
        });

        section3Scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (section2Scroll.getScrollX() == section4Scroll.getScrollX()
                        && section4Scroll.getScrollX() == section5Scroll.getScrollX()
                        && section3Scroll.getScrollX() != section2Scroll.getScrollX()) {
                    int Xscroll = section3Scroll.getScrollX();
                    section2Scroll.setScrollX(Xscroll);
                    section4Scroll.setScrollX(Xscroll);
                    section5Scroll.setScrollX(Xscroll);
                }
            }
        });

        section4Scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (section2Scroll.getScrollX() == section3Scroll.getScrollX()
                        && section3Scroll.getScrollX() == section5Scroll.getScrollX()
                        && section4Scroll.getScrollX() != section2Scroll.getScrollX()) {
                    int Xscroll = section4Scroll.getScrollX();
                    section2Scroll.setScrollX(Xscroll);
                    section3Scroll.setScrollX(Xscroll);
                    section5Scroll.setScrollX(Xscroll);
                }
            }
        });

        section5Scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (section2Scroll.getScrollX() == section3Scroll.getScrollX()
                        && section3Scroll.getScrollX() == section4Scroll.getScrollX()
                        && section5Scroll.getScrollX() != section2Scroll.getScrollX()) {
                    int Xscroll = section5Scroll.getScrollX();
                    section2Scroll.setScrollX(Xscroll);
                    section3Scroll.setScrollX(Xscroll);
                    section4Scroll.setScrollX(Xscroll);
                }
            }
        });


    }


    private void mohasebe() {

        if (edtAddFund.getText().length() == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (edtAddFund.getText().length() == 0) edtAddFund.setText("0");
                }
            }, 1500);
        } else if (edtAddFund.getText().length() > 0) {
            if (edtInitFund.getText().length() == 0) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (edtInitFund.getText().length() == 0) edtInitFund.setText("0");
                    }
                }, 1500);
            }
        }

        if (edtDollarRate.getText().toString().equals("") && dollarRadio.isChecked()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (edtDollarRate.getText().toString().equals("") && dollarRadio.isChecked())
                        edtDollarRate.setText(savedInputRate);
                }
            }, 1500);
        }

        if (edtAddFund.getText().length() >= 2 && edtAddFund.getText().charAt(0) == '0') {
            edtAddFund.getText().delete(0, 1);
        }
        if (edtInitFund.getText().length() >= 2 && edtInitFund.getText().charAt(0) == '0') {
            edtInitFund.getText().delete(0, 1);
        }
        if (edtDollarRate.getText().length() >= 2 && edtDollarRate.getText().charAt(0) == '0') {
            edtDollarRate.getText().delete(0, 1);
        }

        if (edtInitFund.getText().toString() != "" && edtAddFund.getText().toString() != "") {
            try {
                mySarmaye = Integer.parseInt(edtInitFund.getText().toString());
                addFund = Integer.parseInt(edtAddFund.getText().toString());


                if (dollarRadio.isChecked() && edtDollarRate.getText().length() >= 2) {
                    zarib = Integer.parseInt(edtDollarRate.getText().toString());
                } else if (tomanRadio.isChecked()) {
                    zarib = 1;
                }

                // Second Section
                y0p3ResultLong = (long) (mySarmaye * 0.03 * zarib);
                y0p3ResultFormat = formatDeci.format(y0p3ResultLong);
                y0p3Result.setText(y0p3ResultFormat);
                y0p6ResultLong = (long) (mySarmaye * 0.06 * zarib);
                y0p6ResultFormat = formatDeci.format(y0p6ResultLong);
                y0p6Result.setText(y0p6ResultFormat);
                y0p9ResultLong = (long) (mySarmaye * 0.09 * zarib);
                y0p9ResultFormat = formatDeci.format(y0p9ResultLong);
                y0p9Result.setText(y0p9ResultFormat);
                y0p12ResultLong = (long) (mySarmaye * 0.12 * zarib);
                y0p12ResultFormat = formatDeci.format(y0p12ResultLong);
                y0p12Result.setText(y0p12ResultFormat);
                y0p15ResultLong = (long) (mySarmaye * 0.15 * zarib);
                y0p15ResultFormat = formatDeci.format(y0p15ResultLong);
                y0p15Result.setText(y0p15ResultFormat);


                // Third Section
                if (addFund != 0) {
                    double mySarmaye3dar3 = mySarmaye;
                    double mySarmaye6dar3 = mySarmaye;
                    double mySarmaye9dar3 = mySarmaye;
                    double mySarmaye12dar3 = mySarmaye;
                    double mySarmaye15dar3 = mySarmaye;


                    for (int i = 0; i < 36; i++) {
                        mySarmaye3dar3 *= 1.03;
                        mySarmaye3dar3 += addFund;

                        mySarmaye6dar3 *= 1.06;
                        mySarmaye6dar3 += addFund;

                        mySarmaye9dar3 *= 1.09;
                        mySarmaye9dar3 += addFund;

                        mySarmaye12dar3 *= 1.12;
                        mySarmaye12dar3 += addFund;

                        mySarmaye15dar3 *= 1.15;
                        mySarmaye15dar3 += addFund;

                    }
                    y3fundplus3ResultLong = (long) (mySarmaye3dar3 * zarib);
                    y3fundplus3ResultFormat = formatDeci.format(y3fundplus3ResultLong);
                    y3fund3Result.setText(y3fundplus3ResultFormat);

                    y3fundplus6ResultLong = (long) (mySarmaye6dar3 * zarib);
                    y3fundplus6ResultFormat = formatDeci.format(y3fundplus6ResultLong);
                    y3fund6Result.setText(y3fundplus6ResultFormat);

                    y3fundplus9ResultLong = (long) (mySarmaye9dar3 * zarib);
                    y3fundplus9ResultFormat = formatDeci.format(y3fundplus9ResultLong);
                    y3fund9Result.setText(y3fundplus9ResultFormat);

                    y3fundplus12ResultLong = (long) (mySarmaye12dar3 * zarib);
                    y3fundplus12ResultFormat = formatDeci.format(y3fundplus12ResultLong);
                    y3fund12Result.setText(y3fundplus12ResultFormat);

                    y3fundplus15ResultLong = (long) (mySarmaye15dar3 * zarib);
                    y3fundplus15ResultFormat = formatDeci.format(y3fundplus15ResultLong);
                    y3fund15Result.setText(y3fundplus15ResultFormat);

                    y3p3ResultLong = (long) (y3fundplus3ResultLong * 0.03);
                    y3p3ResultFormat = formatDeci.format(y3p3ResultLong);
                    y3p3Result.setText(y3p3ResultFormat);

                    y3p6ResultLong = (long) (y3fundplus6ResultLong * 0.06);
                    y3p6ResultFormat = formatDeci.format(y3p6ResultLong);
                    y3p6Result.setText(y3p6ResultFormat);

                    y3p9ResultLong = (long) (y3fundplus9ResultLong * 0.09);
                    y3p9ResultFormat = formatDeci.format(y3p9ResultLong);
                    y3p9Result.setText(y3p9ResultFormat);

                    y3p12ResultLong = (long) (y3fundplus12ResultLong * 0.12);
                    y3p12ResultFormat = formatDeci.format(y3p12ResultLong);
                    y3p12Result.setText(y3p12ResultFormat);

                    y3p15ResultLong = (long) (y3fundplus15ResultLong * 0.15);
                    y3p15ResultFormat = formatDeci.format(y3p15ResultLong);
                    y3p15Result.setText(y3p15ResultFormat);


                } else if (addFund == 0) {
                    y3fund3ResultLong = (long) ((Math.pow(1.03, 36)) * mySarmaye * zarib);
                    y3fund3ResultFormat = formatDeci.format(y3fund3ResultLong);
                    y3fund3Result.setText(y3fund3ResultFormat);

                    y3fund6ResultLong = (long) ((Math.pow(1.06, 36)) * mySarmaye * zarib);
                    y3fund6ResultFormat = formatDeci.format(y3fund6ResultLong);
                    y3fund6Result.setText(y3fund6ResultFormat);

                    y3fund9ResultLong = (long) ((Math.pow(1.09, 36)) * mySarmaye * zarib);
                    y3fund9ResultFormat = formatDeci.format(y3fund9ResultLong);
                    y3fund9Result.setText(y3fund9ResultFormat);

                    y3fund12ResultLong = (long) ((Math.pow(1.12, 36)) * mySarmaye * zarib);
                    y3fund12ResultFormat = formatDeci.format(y3fund12ResultLong);
                    y3fund12Result.setText(y3fund12ResultFormat);

                    y3fund15ResultLong = (long) ((Math.pow(1.15, 36)) * mySarmaye * zarib);
                    y3fund15ResultFormat = formatDeci.format(y3fund15ResultLong);
                    y3fund15Result.setText(y3fund15ResultFormat);

                    y3p3ResultLong = (long) (y3fund3ResultLong * 0.03);
                    y3p3ResultFormat = formatDeci.format(y3p3ResultLong);
                    y3p3Result.setText(y3p3ResultFormat);

                    y3p6ResultLong = (long) (y3fund6ResultLong * 0.06);
                    y3p6ResultFormat = formatDeci.format(y3p6ResultLong);
                    y3p6Result.setText(y3p6ResultFormat);

                    y3p9ResultLong = (long) (y3fund9ResultLong * 0.09);
                    y3p9ResultFormat = formatDeci.format(y3p9ResultLong);
                    y3p9Result.setText(y3p9ResultFormat);

                    y3p12ResultLong = (long) (y3fund12ResultLong * 0.12);
                    y3p12ResultFormat = formatDeci.format(y3p12ResultLong);
                    y3p12Result.setText(y3p12ResultFormat);

                    y3p15ResultLong = (long) (y3fund15ResultLong * 0.15);
                    y3p15ResultFormat = formatDeci.format(y3p15ResultLong);
                    y3p15Result.setText(y3p15ResultFormat);
                }


                // Fourth Section
                if (addFund != 0) {
                    double mySarmaye3dar5 = mySarmaye;
                    double mySarmaye6dar5 = mySarmaye;
                    double mySarmaye9dar5 = mySarmaye;
                    double mySarmaye12dar5 = mySarmaye;
                    double mySarmaye15dar5 = mySarmaye;

                    for (int i = 0; i < 60; i++) {
                        mySarmaye3dar5 *= 1.03;
                        mySarmaye3dar5 += addFund;

                        mySarmaye6dar5 *= 1.06;
                        mySarmaye6dar5 += addFund;

                        mySarmaye9dar5 *= 1.09;
                        mySarmaye9dar5 += addFund;

                        mySarmaye12dar5 *= 1.12;
                        mySarmaye12dar5 += addFund;

                        mySarmaye15dar5 *= 1.15;
                        mySarmaye15dar5 += addFund;
                    }
                    y5fundplus3ResultLong = (long) (mySarmaye3dar5 * zarib);
                    y5fundplus3ResultFormat = formatDeci.format(y5fundplus3ResultLong);
                    y5fund3Result.setText(y5fundplus3ResultFormat);

                    y5fundplus6ResultLong = (long) (mySarmaye6dar5 * zarib);
                    y5fundplus6ResultFormat = formatDeci.format(y5fundplus6ResultLong);
                    y5fund6Result.setText(y5fundplus6ResultFormat);

                    y5fundplus9ResultLong = (long) (mySarmaye9dar5 * zarib);
                    y5fundplus9ResultFormat = formatDeci.format(y5fundplus9ResultLong);
                    y5fund9Result.setText(y5fundplus9ResultFormat);

                    y5fundplus12ResultLong = (long) (mySarmaye12dar5 * zarib);
                    y5fundplus12ResultFormat = formatDeci.format(y5fundplus12ResultLong);
                    y5fund12Result.setText(y5fundplus12ResultFormat);

                    y5fundplus15ResultLong = (long) (mySarmaye15dar5 * zarib);
                    y5fundplus15ResultFormat = formatDeci.format(y5fundplus15ResultLong);
                    y5fund15Result.setText(y5fundplus15ResultFormat);

                    y5p3ResultLong = (long) (y5fundplus3ResultLong * 0.03);
                    y5p3ResultFormat = formatDeci.format(y5p3ResultLong);
                    y5p3Result.setText(y5p3ResultFormat);

                    y5p6ResultLong = (long) (y5fundplus6ResultLong * 0.06);
                    y5p6ResultFormat = formatDeci.format(y5p6ResultLong);
                    y5p6Result.setText(y5p6ResultFormat);

                    y5p9ResultLong = (long) (y5fundplus9ResultLong * 0.09);
                    y5p9ResultFormat = formatDeci.format(y5p9ResultLong);
                    y5p9Result.setText(y5p9ResultFormat);

                    y5p12ResultLong = (long) (y5fundplus12ResultLong * 0.12);
                    y5p12ResultFormat = formatDeci.format(y5p12ResultLong);
                    y5p12Result.setText(y5p12ResultFormat);

                    y5p15ResultLong = (long) (y5fundplus15ResultLong * 0.15);
                    y5p15ResultFormat = formatDeci.format(y5p15ResultLong);
                    y5p15Result.setText(y5p15ResultFormat);


                } else if (addFund == 0) {
                    y5fund3ResultLong = (long) ((Math.pow(1.03, 60)) * mySarmaye * zarib);
                    y5fund3ResultFormat = formatDeci.format(y5fund3ResultLong);
                    y5fund3Result.setText(y5fund3ResultFormat);

                    y5fund6ResultLong = (long) ((Math.pow(1.06, 60)) * mySarmaye * zarib);
                    y5fund6ResultFormat = formatDeci.format(y5fund6ResultLong);
                    y5fund6Result.setText(y5fund6ResultFormat);

                    y5fund9ResultLong = (long) ((Math.pow(1.09, 60)) * mySarmaye * zarib);
                    y5fund9ResultFormat = formatDeci.format(y5fund9ResultLong);
                    y5fund9Result.setText(y5fund9ResultFormat);

                    y5fund12ResultLong = (long) ((Math.pow(1.12, 60)) * mySarmaye * zarib);
                    y5fund12ResultFormat = formatDeci.format(y5fund12ResultLong);
                    y5fund12Result.setText(y5fund12ResultFormat);

                    y5fund15ResultLong = (long) ((Math.pow(1.15, 60)) * mySarmaye * zarib);
                    y5fund15ResultFormat = formatDeci.format(y5fund15ResultLong);
                    y5fund15Result.setText(y5fund15ResultFormat);

                    y5p3ResultLong = (long) (y5fund3ResultLong * 0.03);
                    y5p3ResultFormat = formatDeci.format(y5p3ResultLong);
                    y5p3Result.setText(y5p3ResultFormat);

                    y5p6ResultLong = (long) (y5fund6ResultLong * 0.06);
                    y5p6ResultFormat = formatDeci.format(y5p6ResultLong);
                    y5p6Result.setText(y5p6ResultFormat);

                    y5p9ResultLong = (long) (y5fund9ResultLong * 0.09);
                    y5p9ResultFormat = formatDeci.format(y5p9ResultLong);
                    y5p9Result.setText(y5p9ResultFormat);

                    y5p12ResultLong = (long) (y5fund12ResultLong * 0.12);
                    y5p12ResultFormat = formatDeci.format(y5p12ResultLong);
                    y5p12Result.setText(y5p12ResultFormat);

                    y5p15ResultLong = (long) (y5fund15ResultLong * 0.15);
                    y5p15ResultFormat = formatDeci.format(y5p15ResultLong);
                    y5p15Result.setText(y5p15ResultFormat);
                }


                // Fifth Section
                if (addFund != 0) {
                    double mySarmaye3dar10 = mySarmaye;
                    double mySarmaye6dar10 = mySarmaye;
                    double mySarmaye9dar10 = mySarmaye;
                    double mySarmaye12dar10 = mySarmaye;
                    double mySarmaye15dar10 = mySarmaye;

                    for (int i = 0; i < 120; i++) {
                        mySarmaye3dar10 *= 1.03;
                        mySarmaye3dar10 += addFund;

                        mySarmaye6dar10 *= 1.06;
                        mySarmaye6dar10 += addFund;

                        mySarmaye9dar10 *= 1.09;
                        mySarmaye9dar10 += addFund;

                        mySarmaye12dar10 *= 1.12;
                        mySarmaye12dar10 += addFund;

                        mySarmaye15dar10 *= 1.15;
                        mySarmaye15dar10 += addFund;
                    }
                    y10fundplus3ResultLong = (long) (mySarmaye3dar10 * zarib);
                    y10fundplus3ResultFormat = formatDeci.format(y10fundplus3ResultLong);
                    y10fund3Result.setText(y10fundplus3ResultFormat);

                    y10fundplus6ResultLong = (long) (mySarmaye6dar10 * zarib);
                    y10fundplus6ResultFormat = formatDeci.format(y10fundplus6ResultLong);
                    y10fund6Result.setText(y10fundplus6ResultFormat);

                    y10fundplus9ResultLong = (long) (mySarmaye9dar10 * zarib);
                    y10fundplus9ResultFormat = formatDeci.format(y10fundplus9ResultLong);
                    y10fund9Result.setText(y10fundplus9ResultFormat);

                    y10fundplus12ResultLong = (long) (mySarmaye12dar10 * zarib);
                    y10fundplus12ResultFormat = formatDeci.format(y10fundplus12ResultLong);
                    y10fund12Result.setText(y10fundplus12ResultFormat);

                    y10fundplus15ResultLong = (long) (mySarmaye15dar10 * zarib);
                    y10fundplus15ResultFormat = formatDeci.format(y10fundplus15ResultLong);
                    y10fund15Result.setText(y10fundplus15ResultFormat);

                    y10p3ResultLong = (long) (y10fundplus3ResultLong * 0.03);
                    y10p3ResultFormat = formatDeci.format(y10p3ResultLong);
                    y10p3Result.setText(y10p3ResultFormat);

                    y10p6ResultLong = (long) (y10fundplus6ResultLong * 0.06);
                    y10p6ResultFormat = formatDeci.format(y10p6ResultLong);
                    y10p6Result.setText(y10p6ResultFormat);

                    y10p9ResultLong = (long) (y10fundplus9ResultLong * 0.09);
                    y10p9ResultFormat = formatDeci.format(y10p9ResultLong);
                    y10p9Result.setText(y10p9ResultFormat);

                    y10p12ResultLong = (long) (y10fundplus12ResultLong * 0.12);
                    y10p12ResultFormat = formatDeci.format(y10p12ResultLong);
                    y10p12Result.setText(y10p12ResultFormat);

                    y10p15ResultLong = (long) (y10fundplus15ResultLong * 0.15);
                    y10p15ResultFormat = formatDeci.format(y10p15ResultLong);
                    y10p15Result.setText(y10p15ResultFormat);


                } else if (addFund == 0) {
                    y10fund3ResultLong = (long) ((Math.pow(1.03, 120)) * mySarmaye * zarib);
                    y10fund3ResultFormat = formatDeci.format(y10fund3ResultLong);
                    y10fund3Result.setText(y10fund3ResultFormat);

                    y10fund6ResultLong = (long) ((Math.pow(1.06, 120)) * mySarmaye * zarib);
                    y10fund6ResultFormat = formatDeci.format(y10fund6ResultLong);
                    y10fund6Result.setText(y10fund6ResultFormat);

                    y10fund9ResultLong = (long) ((Math.pow(1.09, 120)) * mySarmaye * zarib);
                    y10fund9ResultFormat = formatDeci.format(y10fund9ResultLong);
                    y10fund9Result.setText(y10fund9ResultFormat);

                    y10fund12ResultLong = (long) ((Math.pow(1.12, 120)) * mySarmaye * zarib);
                    y10fund12ResultFormat = formatDeci.format(y10fund12ResultLong);
                    y10fund12Result.setText(y10fund12ResultFormat);

                    y10fund15ResultLong = (long) ((Math.pow(1.15, 120)) * mySarmaye * zarib);
                    y10fund15ResultFormat = formatDeci.format(y10fund15ResultLong);
                    y10fund15Result.setText(y10fund15ResultFormat);

                    y10p3ResultLong = (long) (y10fund3ResultLong * 0.03);
                    y10p3ResultFormat = formatDeci.format(y10p3ResultLong);
                    y10p3Result.setText(y10p3ResultFormat);

                    y10p6ResultLong = (long) (y10fund6ResultLong * 0.06);
                    y10p6ResultFormat = formatDeci.format(y10p6ResultLong);
                    y10p6Result.setText(y10p6ResultFormat);

                    y10p9ResultLong = (long) (y10fund9ResultLong * 0.09);
                    y10p9ResultFormat = formatDeci.format(y10p9ResultLong);
                    y10p9Result.setText(y10p9ResultFormat);

                    y10p12ResultLong = (long) (y10fund12ResultLong * 0.12);
                    y10p12ResultFormat = formatDeci.format(y10p12ResultLong);
                    y10p12Result.setText(y10p12ResultFormat);

                    y10p15ResultLong = (long) (y10fund15ResultLong * 0.15);
                    y10p15ResultFormat = formatDeci.format(y10p15ResultLong);
                    y10p15Result.setText(y10p15ResultFormat);
                }


            } catch (NumberFormatException e) {
            }

        }
    }

    private void findViewByIds() {
        section2Scroll = findViewById(R.id.section2Scroll);
        section3Scroll = findViewById(R.id.section3Scroll);
        section4Scroll = findViewById(R.id.section4Scroll);
        section5Scroll = findViewById(R.id.section5Scroll);

        tomanRadio = findViewById(R.id.radioToman);
        dollarRadio = findViewById(R.id.radioDollar);
        edtDollarRate = findViewById(R.id.edtDollarRate);
        edtInitFund = findViewById(R.id.edtFund);
        edtAddFund = findViewById(R.id.edtAddFund);

        y0p3Result = findViewById(R.id.y0p3Result);
        y0p6Result = findViewById(R.id.y0p6Result);
        y0p9Result = findViewById(R.id.y0p9Result);
        y0p12Result = findViewById(R.id.y0p12Result);
        y0p15Result = findViewById(R.id.y0p15Result);

        y3fund3Result = findViewById(R.id.y3fund3Result);
        y3fund6Result = findViewById(R.id.y3fund6Result);
        y3fund9Result = findViewById(R.id.y3fund9Result);
        y3fund12Result = findViewById(R.id.y3fund12Result);
        y3fund15Result = findViewById(R.id.y3fund15Result);

        y3p3Result = findViewById(R.id.y3p3Result);
        y3p6Result = findViewById(R.id.y3p6Result);
        y3p9Result = findViewById(R.id.y3p9Result);
        y3p12Result = findViewById(R.id.y3p12Result);
        y3p15Result = findViewById(R.id.y3p15Result);

        y5fund3Result = findViewById(R.id.y5fund3Result);
        y5fund6Result = findViewById(R.id.y5fund6Result);
        y5fund9Result = findViewById(R.id.y5fund9Result);
        y5fund12Result = findViewById(R.id.y5fund12Result);
        y5fund15Result = findViewById(R.id.y5fund15Result);

        y5p3Result = findViewById(R.id.y5p3Result);
        y5p6Result = findViewById(R.id.y5p6Result);
        y5p9Result = findViewById(R.id.y5p9Result);
        y5p12Result = findViewById(R.id.y5p12Result);
        y5p15Result = findViewById(R.id.y5p15Result);

        y10fund3Result = findViewById(R.id.y10fund3Result);
        y10fund6Result = findViewById(R.id.y10fund6Result);
        y10fund9Result = findViewById(R.id.y10fund9Result);
        y10fund12Result = findViewById(R.id.y10fund12Result);
        y10fund15Result = findViewById(R.id.y10fund15Result);

        y10p3Result = findViewById(R.id.y10p3Result);
        y10p6Result = findViewById(R.id.y10p6Result);
        y10p9Result = findViewById(R.id.y10p9Result);
        y10p12Result = findViewById(R.id.y10p12Result);
        y10p15Result = findViewById(R.id.y10p15Result);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (savedInputRate.length() > 1) getSharedPreferences("Last My Input Rate", MODE_PRIVATE).edit().putString("Dollar Rate", savedInputRate).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        savedInputRate = getSharedPreferences("Last My Input Rate", MODE_PRIVATE).getString("Dollar Rate", "");
    }
}

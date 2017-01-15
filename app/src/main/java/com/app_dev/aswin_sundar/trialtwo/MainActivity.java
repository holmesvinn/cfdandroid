package com.app_dev.aswin_sundar.trialtwo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.transition.move;

public class MainActivity extends AppCompatActivity {

    private Button mLeftTurn;
    private Button mForwardMove;
    private Button mRightTurn;
    private Button mReverseMove;
    private TextView mAction;
    private String mActionCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftTurn = (Button) findViewById(R.id.leftButton);
        mForwardMove = (Button) findViewById(R.id.frontButton);
        mRightTurn = (Button) findViewById(R.id.rightButton);
        mReverseMove = (Button) findViewById(R.id.reverseButton);
        mAction = (TextView) findViewById(R.id.actionTextView);

        mLeftTurn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    mAction.setText("Left Move");
                    mActionCommand="{\"move\":1}";
                    //Log.v("hiiiiiiiiiiiiii",mActionCommand);
                    new MoveCommand().execute(mActionCommand);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    mAction.setText("No Action Initiated");
                    mActionCommand="{\"move\":0}";
                    //Log.v("hellohowareU",mActionCommand);
                    new MoveCommand().execute(mActionCommand);
                }
                return false;
            }
        });
        mRightTurn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    mAction.setText("Right Move");
                    mActionCommand="{\"move\":2}";
                    new MoveCommand().execute(mActionCommand);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    mAction.setText("No Action Initiated");
                    mActionCommand="{\"move\":0}";
                    new MoveCommand().execute(mActionCommand);
                }
                return false;
            }
        });
        mForwardMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    mAction.setText("Forward Move");
                    mActionCommand="{\"move\":3}";
                    new MoveCommand().execute(mActionCommand);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    mAction.setText("No Action Initiated");
                    mActionCommand="{\"move\":0}";
                    new MoveCommand().execute(mActionCommand);
                }
                return false;
            }
        });
        mReverseMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    mAction.setText("Reverse Move");
                    mActionCommand="{\"move\":4}";
                    new MoveCommand().execute(mActionCommand);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    mAction.setText("No Action Initiated");
                    mActionCommand="{\"move\":0}";
                    new MoveCommand().execute(mActionCommand);
                }
                return false;
            }
        });
    }
}

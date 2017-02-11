package com.example.djeck.rcalc;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;
import android.widget.ScrollView;

import com.example.djeck.rcalc.core.Stack;
import com.example.djeck.rcalc.core.Standard;
import com.example.djeck.rcalc.core.Trigonometric;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    private EditText mText;
    private LinearLayout mLayout;
    private ScrollView mScrollView;
    private ArrayAdapter<Double> mAdapter;
    private ListView mListView;

    private Stack mStack;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (EditText) findViewById(R.id.editText);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mListView = (ListView) findViewById(R.id.listView);

        TextView mTextView = new TextView(getApplicationContext());
        mTextView.setTextColor(Color.GRAY);
        mLayout.addView(mTextView);

        mStack = new Stack(mTextView);
        mStack.addOperatorSet(new Standard(mTextView));
        mStack.addOperatorSet(new Trigonometric(mTextView));

        mAdapter = new ArrayAdapter<Double>(getApplicationContext(), R.layout.activity_listview, mStack.getArray());
        mListView.setAdapter(mAdapter);

        mText.requestFocus();

        mText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_NULL
                        && (event.getAction() == KeyEvent.ACTION_DOWN ||
                        event.getAction() == KeyEvent.KEYCODE_ENTER)) {
                    enterCallBack();
                }
                return true;
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void enterCallBack() {
        if(!mStack.handle(mText.getText().toString())) {
            //mTextView.setText("Doesn't understand command");
        } else {
            mAdapter.notifyDataSetChanged();
        }
        mText.setText("");
        mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
        mText.requestFocus();
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

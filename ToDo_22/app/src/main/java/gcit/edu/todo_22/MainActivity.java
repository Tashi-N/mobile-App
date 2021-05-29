package gcit.edu.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTitleText;
    private TextView mAuthorText;
    private EditText mBookInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = (EditText)findViewById(R.id.bookInput);
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);
    }
    public void searchBooks(View view) {
        // Get the search string from the input field.
        String queryString = mBookInput.getText().toString();
        new FetchBook(mTitleText, mAuthorText).execute(queryString);

        ConnectivityManager connMgr1 = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo1 = null;
        if (connMgr1 != null){
            networkInfo1 = connMgr1.getActiveNetworkInfo();
        }
        if (networkInfo1 != null && networkInfo1.isConnected()
        && queryString.length()!=0){
            new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("Loading.....");
        }
        else {
            if (queryString.length()==0){
                mAuthorText.setText("");
                mTitleText.setText("Please enter a search item");
            }else {
                mAuthorText.setText("");
                mTitleText.setText("Please check your network connection and try again");
            }
        }
    }
}
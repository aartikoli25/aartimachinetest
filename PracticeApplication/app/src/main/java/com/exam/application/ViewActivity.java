package com.exam.application;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.exam.application.view.utils.DBManager;
import com.exam.application.view.utils.DatabaseHelper;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    EditText editComment;
    Button btnSubmit;
    ListView listView;

    SimpleCursorAdapter adapter;

    DBManager dbManager;

    String imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //get bundle data
        String title = getIntent().getStringExtra("title");
        String img = getIntent().getStringExtra("img");
        imageId = getIntent().getStringExtra("id");

        ActionBar ab = getSupportActionBar();
        ab.setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        imageView = (ImageView) findViewById(R.id.image_view);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        editComment = (EditText) findViewById(R.id.edit_comment);
        listView = (ListView) findViewById(R.id.list_view_comment);

        Glide
                .with(this)
                .load(img)
                .centerCrop()
                .into(imageView);

        dbManager = new DBManager(this);
        dbManager.open();
        btnSubmit.setOnClickListener(this);

        if (dbManager.IsImageIdExists(imageId) == true) {
            fetchCommentData();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:

                if (editComment.getText().toString().trim().isEmpty()) {

                    Toast.makeText(
                            this, "Please write comment!",
                            Toast.LENGTH_LONG
                    ).show();

                } else {

                    final String comment = editComment.getText().toString();

                    dbManager.insert(imageId, comment);

                    editComment.setText("");

                    fetchCommentData();
                }

                break;
        }
    }

    public void fetchCommentData() {

        Cursor cursor = dbManager.fetchDataByImageId(imageId);

        final String[] from = new String[]{DatabaseHelper.COMMENT, DatabaseHelper.IMAGEID};

        final int[] to = new int[]{R.id.text_comment};

        adapter = new SimpleCursorAdapter(this, R.layout.commnet_view_item, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }

}
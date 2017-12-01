package demo.huangli.mydemosnew.logic_set_1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangli on 16/9/14.
 */
public class FeedReaderDbProxy {
    private Context mContext;
    private FeedReaderDbHelper mDbHelper;

    public FeedReaderDbProxy(Context context) {
        mContext = context;
        mDbHelper = new FeedReaderDbHelper(context);
    }

    public void insertEntry(FeedReaderDbItem feedReaderDbItem) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, feedReaderDbItem.getTitle());
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, feedReaderDbItem.getSubtitle());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }

    public List<FeedReaderDbItem> query(String title){
        List<FeedReaderDbItem> dbItems = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        };
        // Filter results WHERE "title" = 'My Title'
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { title };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        c.moveToFirst();
        do {
            String title_R = c.getString(c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE));
            String subtitle_R = c.getString(c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE));
            dbItems.add(new FeedReaderDbItem(title_R,subtitle_R));
        }while (c.moveToNext());

        return dbItems;
    }
}

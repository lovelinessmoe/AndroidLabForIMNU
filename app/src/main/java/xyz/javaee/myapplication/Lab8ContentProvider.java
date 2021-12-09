package xyz.javaee.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import xyz.javaee.myapplication.util.SQLiteUtil;

/**
 * 由于使用的是SQL语句执行，只重写了query方法，与其在对应的resolver中使用
 */
public class Lab8ContentProvider extends ContentProvider {

    //数据库Util
    private SQLiteUtil sqLiteUtil = null;
    //创建authority
    public static final String AUTHORITY = "loveliness";
    //创建UriMatcher对象
    private static UriMatcher uriMatcher;

    static {
        //实例化UriMatcher对象
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        //可以实现匹配URI的功能
        //参数1：authority 参数2：路径 参数3：自定义代码
        uriMatcher.addURI(AUTHORITY, null, 0);
    }

    public Lab8ContentProvider() {
    }

    @Override
    public boolean onCreate() {
        sqLiteUtil = new SQLiteUtil(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int match = uriMatcher.match(uri);
        if (0 != match) {
            return null;
        }
        SQLiteDatabase db = sqLiteUtil.getReadableDatabase();
        switch (sortOrder) {
            case "rawQuery": //查询SQL
                return db.rawQuery(selection, null);
            case "execSQL": //增删改SQL
                //发送通知，数据改变了
                getContext().getContentResolver().notifyChange(uri, null);
                db.execSQL(selection);
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
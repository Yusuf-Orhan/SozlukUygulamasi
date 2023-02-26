package orhan.yusuf.szlkuygulamas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class KelimelerDao {
    public ArrayList<Kelimeler> tümVeriler(Database db){
        ArrayList<Kelimeler> tümKelimeler = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM kelimeler",null);
        int ingilizceIx = cursor.getColumnIndex("ingilizce");
        int turkceIx = cursor.getColumnIndex("turkce");
        while (cursor.moveToNext()){
            String ingilizce = cursor.getString(ingilizceIx);
            String turkce = cursor.getString(turkceIx);
            Kelimeler kelimeler = new Kelimeler(ingilizce,turkce);
            tümKelimeler.add(kelimeler);
        }
        return tümKelimeler;
    }
    public ArrayList<Kelimeler> kelimeAra(Database db,String aramaKelime){
        ArrayList<Kelimeler> tümKelimeler = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        String sql = "SELECT * FROM kelimeler WHERE ingilizce like %"+aramaKelime+"%";
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM kelimeler WHERE turkce like '%"+aramaKelime+"%'",null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%"+aramaKelime+%',null);
        int ingilizceIx = cursor.getColumnIndex("ingilizce");
        int turkceIx = cursor.getColumnIndex("turkce");
        while (cursor.moveToNext()){
            String ingilizce = cursor.getString(ingilizceIx);
            String turkce = cursor.getString(turkceIx);
            Kelimeler kelimeler = new Kelimeler(ingilizce,turkce);
            tümKelimeler.add(kelimeler);
        }
        return tümKelimeler;
    }
}

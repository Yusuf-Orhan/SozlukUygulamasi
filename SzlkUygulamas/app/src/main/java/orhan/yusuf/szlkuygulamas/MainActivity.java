package orhan.yusuf.szlkuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import orhan.yusuf.szlkuygulamas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ActivityMainBinding binding;
    ArrayList<Kelimeler> kelimelerArrayList;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        database = new Database(this);
        db_kopyala();
        kelimelerArrayList = new KelimelerDao().tümVeriler(database);
        Adapter adapter = new Adapter(kelimelerArrayList,this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        aramaYap(newText);
        return false;
    }
    public void db_kopyala(){
        DatabaseCopyHelper copyHelper = new DatabaseCopyHelper(this);
        try {
            copyHelper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        copyHelper.openDataBase();
    }
    public void aramaYap(String aramaKelime){
        kelimelerArrayList = new KelimelerDao().kelimeAra(database,aramaKelime);
        Adapter adapter = new Adapter(kelimelerArrayList,this);
        binding.recyclerView.setAdapter(adapter);
    }
}
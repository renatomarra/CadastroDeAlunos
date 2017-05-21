package unipac.com.br.cadastrodealuno;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import unipac.com.br.cadastrodealuno.adapter.AlunoAdapter;
import unipac.com.br.cadastrodealuno.dao.AlunoDAO;
import unipac.com.br.cadastrodealuno.entidade.Aluno;
import unipac.com.br.cadastrodealuno.helper.FormHelper;

public class MainActivity extends AppCompatActivity {
    Button btnSalvar, btnListar;
    FormHelper helper;
    ListView listaDeAlunos;
    AlunoDAO dao;
    AlunoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dao = new AlunoDAO(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        helper = new FormHelper(MainActivity.this);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        listaDeAlunos = (ListView) findViewById(R.id.listaAlunos);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dao.salvar(helper.getAluno());
                Toast.makeText(MainActivity.this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);//Start the same Activity
                finish(); //finish Activity.
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Aluno> alunos = dao.lista();

        if (alunos.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Não tem alunos cadastrados", Toast.LENGTH_LONG);
        } else {
            adapter = new AlunoAdapter(alunos, this);
            listaDeAlunos.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package unipac.com.br.cadastrodealuno.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import unipac.com.br.cadastrodealuno.entidade.Aluno;
import unipac.com.br.cadastrodealuno.infra.DatabaseHandler;

/**
 * Created by rogeriofontes on 08/05/17.
 */

public class AlunoDAO {

    //List<Aluno> alunos = new ArrayList<>();

   // public void salvar(Aluno aluno){
       // alunos.add(aluno);
   // }

    //public List<Aluno> getAlunos() {
    //    return alunos;
   // }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    private static DatabaseHandler handler;

    // Contacts table name
    public static final String TABLE_ALUNO = "tbl_aluno";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NOME = "nome";
    private static final String KEY_CURSO = "curso";

    public static String CREATE_TABELA_ALUNO = "CREATE TABLE " + TABLE_ALUNO + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOME + " TEXT,"
            + KEY_CURSO + " TEXT" + ")";

    public AlunoDAO(Context context) {
        handler = new DatabaseHandler(context);
    }

    // Adding new aluno
    public void salvar(Aluno aluno) {
        SQLiteDatabase db = handler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOME, aluno.getNome()); // Aluno Name
        values.put(KEY_CURSO, aluno.getCurso()); // Aluno Phone

        // Inserting Row
        db.insert(TABLE_ALUNO, null, values);
        db.close(); // Closing database connection
    }

    // Getting single aluno
    Aluno getContact(int id) {
        SQLiteDatabase db = handler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ALUNO, new String[] { KEY_ID,
                        KEY_NOME, KEY_CURSO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Aluno aluno = new Aluno(Long.parseLong(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return aluno
        return aluno;
    }

    // Getting All Contacts
    public List<Aluno> lista() {
        List<Aluno> contactList = new ArrayList<Aluno>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ALUNO;

        SQLiteDatabase db = handler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Aluno aluno = new Aluno();
                aluno.setId(Long.parseLong(cursor.getString(0)));
                aluno.setNome(cursor.getString(1));
                aluno.setCurso(cursor.getString(2));
                // Adding aluno to list
                contactList.add(aluno);
            } while (cursor.moveToNext());
        }

        // return aluno list
        return contactList;
    }

    // Updating single aluno
    public int alterar(Aluno aluno) {
        SQLiteDatabase db = handler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOME, aluno.getNome());
        values.put(KEY_CURSO, aluno.getCurso());

        // updating row
        return db.update(TABLE_ALUNO, values, KEY_ID + " = ?",
                new String[] { String.valueOf(aluno.getId()) });
    }

    // Deleting single aluno
    public void deleteContact(Aluno aluno) {
        SQLiteDatabase db = handler.getWritableDatabase();
        db.delete(TABLE_ALUNO, KEY_ID + " = ?",
                new String[] { String.valueOf(aluno.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int totalDeAlunos() {
        String countQuery = "SELECT  * FROM " + TABLE_ALUNO;
        SQLiteDatabase db = handler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}

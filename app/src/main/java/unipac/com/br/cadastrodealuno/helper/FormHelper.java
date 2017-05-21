package unipac.com.br.cadastrodealuno.helper;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import unipac.com.br.cadastrodealuno.R;
import unipac.com.br.cadastrodealuno.entidade.Aluno;

/**
 * Created by rogeriofontes on 08/05/17.
 */

public class FormHelper {
    EditText edtNome;
    EditText edtCurso;

    Activity activity;
    Aluno aluno;

    public FormHelper(Activity activity) {
        this.activity = activity;

        edtNome = (EditText) activity.findViewById(R.id.edtNome);
        edtCurso = (EditText) activity.findViewById(R.id.edtCurso);
    }

    public Aluno getAluno() {
        Aluno novoAluno = new Aluno();

        novoAluno.setNome(edtNome.getText().toString());
        novoAluno.setCurso(edtCurso.getText().toString());

        return novoAluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}

package unipac.com.br.cadastrodealuno.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;

import unipac.com.br.cadastrodealuno.R;
import unipac.com.br.cadastrodealuno.entidade.Aluno;

/**
 * Created by rogeriofontes on 17/03/17.
 */

public class AlunoAdapter extends BaseAdapter {
    private List<Aluno> alunos = null;
    private Context context = null;

    public AlunoAdapter(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno c = alunos.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.aluno_item, null);

        if (alunos != null) {
            TextView nameTv = (TextView) view.findViewById(R.id.name);
            nameTv.setText(c.getNome() + "\n" + c.getCurso());
        }

        return view;
    }
}

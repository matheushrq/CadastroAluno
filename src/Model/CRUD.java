package Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class CRUD extends AbstractTableModel{
    
    private List<CadastroAluno> dados = new ArrayList<>();
    private String[] colunas = {"Código", "Nome", "Idade", "RA"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getIdade();
            case 3:
                return dados.get(linha).getRa();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setCodigo(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNome((String) valor);
                break;
            case 2:
                dados.get(linha).setIdade(Integer.parseInt((String) valor));
                break;
            case 3:
                dados.get(linha).setRa((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    public void adicionaLinha(CadastroAluno c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}

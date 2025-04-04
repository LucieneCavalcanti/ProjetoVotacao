package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Voto;

/*
 * create table tbVotos(
 * codigo int not null primary key auto_increment,
 * voto int not null,
 * datahora datetime default now(),
 * validador varchar(200))
 * 
 * //para não apagar efetivamente os registros
 * create table tbVotos(
 * codigo int not null primary key auto_increment,
 * voto int not null,
 * datahora datetime default now(),
 * validador varchar(200),
 * status varchar(25) default 'Ativo',
 * datahoraatualizacao datetime default null
 * )
 */
public class VotoRepository extends Conexao {
    public VotoRepository() throws Exception{}

    public boolean incluir(Voto voto) throws Exception{
        String sql = "Insert into tbVotos (voto) values (?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,voto.getVoto());
        return ps.executeUpdate()>0;
    }
    public boolean editar(Voto voto) throws Exception{
        String sql = "update tbVotos set voto=? where codigo=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,voto.getVoto());
        ps.setInt(2, voto.getCodigo());
        return ps.executeUpdate()>0;
    }
    public boolean excluir(int codigo) throws Exception{
        String sql = "delete from tbVotos where codigo=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,codigo);
        return ps.executeUpdate()>0;
    }
    // public boolean excluir(int codigo) throws Exception{
    //     String sql = "update tbVotos set status='Apagado'
    //     datahoraatualizacao = now() where codigo=?";
    //     PreparedStatement ps = getConexao().prepareStatement(sql);
    //     ps.setInt(1,codigo);
    //     return ps.executeUpdate()>0;
    // }

    public ArrayList<Voto> listar() throws Exception{
        ArrayList<Voto> dados = new ArrayList<>();
        String sql = "select * from votos order by voto";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dados.add(new Voto(rs.getInt("codigo"),
            rs.getInt("voto"), rs.getString("validador")));
        }
        return dados;
    }
    
    public ArrayList<Voto> listar(int codigo) throws Exception{
        ArrayList<Voto> dados = new ArrayList<>();
        String sql = "select * from votos where codigo=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,codigo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dados.add(new Voto(rs.getInt("codigo"),
            rs.getInt("voto"), rs.getString("validador")));
        }
        return dados;
    }
    public ArrayList mostrarResultados() throws Exception{
        String sql = "select voto, count(voto) as total "+
        " from tbVotos " + 
        "  group by voto " +
        " order by total desc";
        ArrayList<Integer> dados = new ArrayList<>();
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dados.add(rs.getInt("voto"));
            dados.add(rs.getInt("total"));
        }
        return dados;
    }

}

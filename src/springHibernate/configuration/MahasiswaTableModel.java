/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springHibernate.configuration;

import springHibernate.model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamcin
 */
public class MahasiswaTableModel extends AbstractTableModel{
    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private final String HEADER[] = {"NPM", "Nama", "Kelas", "Alamat"};

    public MahasiswaTableModel(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }

    @Override
    public int getRowCount() {
        return mahasiswas.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa mahasiswa = mahasiswas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return mahasiswa.getNpm();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getKelas();
            case 3:
                return mahasiswa.getAlamat();
            default:
                return null;
        }
    }
}

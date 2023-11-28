/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springHibernate.controller;

import springHibernate.App;
import springHibernate.MahasiswaView;
import springHibernate.model.Mahasiswa;
import springHibernate.configuration.MahasiswaTableModel;
import java.util.List;
import javax.swing.JOptionPane;
//import org.springframework.jdbc.datasource.DriverManagerDataSource

/**
 *
 * @author Tamcin
 */
public class MahasiswaController {
    private final MahasiswaView mahasiswaView;
    private MahasiswaTableModel mahasiswaTableModel;
    private List<Mahasiswa> mahasiswas;

    public MahasiswaController(MahasiswaView mahasiswaView) {
        this.mahasiswaView = mahasiswaView;
    }
    
    public void tampilData() {
        mahasiswas = App.getMahasiswaService().getMahasiswas();
        mahasiswaTableModel = new MahasiswaTableModel(mahasiswas);
        this.mahasiswaView.getTabel().setModel(mahasiswaTableModel);
    }
    
    public void show() {
        int index = this.mahasiswaView.getTabel().getSelectedRow();
        
        this.mahasiswaView.getNpm().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 0)));
        this.mahasiswaView.getNama().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 1)));
        this.mahasiswaView.getKelas().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 2)));
        this.mahasiswaView.getAlamat().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 3)));
    }
    
    public void clear() {
        this.mahasiswaView.getNpm().setText("");
        this.mahasiswaView.getNama().setText("");
        this.mahasiswaView.getKelas().setText("");
        this.mahasiswaView.getAlamat().setText("");
    }
    
    public void save() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
        
        App.getMahasiswaService().save(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data berhasil di simpan!", "Info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void update() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
        
        App.getMahasiswaService().update(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data berhasil di update!", "Info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void delete() {
        if (this.mahasiswaView.getNpm().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ini?", "Warning", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.YES_OPTION) {
                App.getMahasiswaService().delete(mahasiswa);
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}

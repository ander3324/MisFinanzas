/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriasDao;
import dao.GastosDao;
import dao.UsuariosDao;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import orm.Gastos;

/**
 *
 * @author ander
 */
@ManagedBean(name = "gC")
@SessionScoped
public class GastosController {

    //Inyectar dependencias a los EJB...
    @EJB
    GastosDao gasDao;
    @EJB
    CategoriasDao catDao;
    @EJB
    UsuariosDao usuDao;

    //Objetos y listas del contexto...
    private Gastos gasto;
    private List<Gastos> listaGastos;
    private List<Gastos> ultimosGastos;
    private List<String> listaCats;
    private List<String> listaUsuarios;

    //Variables y campos calculadas:
    private BigDecimal totalGastos;
    private String titulo;

    //Propiedades de los ComboBoxes:
    private String nombreUsuario;
    private String nombreCategoria;

    /**
     * Creates a new instance of GastosController
     */
    public GastosController() {
        gasto = new Gastos();
        nombreUsuario = "alumno";
        nombreCategoria="ALIMENTACIÓN";
    }

    public void cargarGastos() {
        ultimosGastos = gasDao.selectUltimosGastos();
        totalGastos = gasDao.selectTotalGastos();
    }

    @PostConstruct
    public void inicializar() {
        cargarGastos();
    }

    //Métodos de navegación:
    public String doNuevo() {
        titulo = "Nuevo Gasto: ";
        listaCats = catDao.selectNombresCategorias();
        listaUsuarios = usuDao.selectSoloNombres();
        gasto = new Gastos();
        return "nuevo_gasto";
    }

    public String doGuardar() {
        //Obtener los objetos relacionados:
        gasto.setFkIdUsu(usuDao.selectUsuarioPorNombre(nombreUsuario));
        gasto.setFkIdCat(catDao.selectCategoriaPorNombre(nombreCategoria));
        gasDao.insertGasto(gasto);

        //Actualizar listas con el nuevo gasto:
        cargarGastos();

        return "index";
    }

    public Gastos getGasto() {
        return gasto;
    }

    public void setGasto(Gastos gasto) {
        this.gasto = gasto;
    }

    public List<Gastos> getListaGastos() {
        return listaGastos;
    }

    public void setListaGastos(List<Gastos> listaGastos) {
        this.listaGastos = listaGastos;
    }

    public List<Gastos> getUltimosGastos() {
        return ultimosGastos;
    }

    public void setUltimosGastos(List<Gastos> ultimosGastos) {
        this.ultimosGastos = ultimosGastos;
    }

    public BigDecimal getTotalGastos() {
        return totalGastos;
    }

    public void setTotalGastos(BigDecimal totalGastos) {
        this.totalGastos = totalGastos;
    }

    public List<String> getListaCats() {
        return listaCats;
    }

    public void setListaCats(List<String> listaCats) {
        this.listaCats = listaCats;
    }

    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}

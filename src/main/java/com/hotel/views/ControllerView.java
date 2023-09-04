package com.hotel.views;

public class ControllerView {
    private MenuPrincipal menuPrincipal;
    private Loguin loguin;
    private MenuUsuarios menuUsuarios;
    private ReservasView reservasView;
    private RegistroHuespedes registroHuespedes;
    private Busqueda busqueda;
    private Exito exito;
    public ControllerView(){}
    public void setMenuPrincipal(MenuPrincipal menuPrincipal){
        this.menuPrincipal=menuPrincipal;
    }
    public void setLoguin(Loguin loguin){
        this.loguin=loguin;
    }
    public void setMenuUsuarios(MenuUsuarios menuUsuarios){
        this.menuUsuarios=menuUsuarios;
    }
    public void setReservasView(ReservasView reservasView){
        this.reservasView= reservasView;
    }
    public void setRegistroHuespedes(RegistroHuespedes registroHuespedes){
        this.registroHuespedes=registroHuespedes;
    }
    public void setBusqueda(Busqueda busqueda){
        this.busqueda=busqueda;
    }
    public void setExito(Exito exito) {
        this.exito = exito;
    }
    public void mostrarMenuPrincipal(){
        menuPrincipal.setVisible(true);
    }
    public void mostrarLoguin(){
        loguin.setVisible(true);
    }
    public void mostrarMenuUsuario(){
        menuUsuarios.setVisible(true);
    }
    public void mostrarReservasView(){
        reservasView.setVisible(true);
    }
    public void mostrarRegistroHuesped(){
        registroHuespedes.setVisible(true);
    }
    public void mostrarBusqueda(){
        busqueda.setVisible(true);
    }
    public void mostrarExito(){
        exito.setVisible(true);
    }
    public void noMostrarMenuPrincipal(){
        menuPrincipal.setVisible(false);
    }
    public void noMostrarLoguin(){
        loguin.setVisible(false);
    }
    public void noMostrarMenuUsuario(){
        menuUsuarios.setVisible(false);
    }
    public void noMostrarReservasView(){
        reservasView.setVisible(false);
    }
    public void noMostrarRegistroHuesped(){
        registroHuespedes.setVisible(false);
    }
    public void noMostrarBusqueda(){
        busqueda.setVisible(false);
    }
    public void noMostrarExito(){
        exito.setVisible(false);
    }
    public void cargarTablaReserva(){
        busqueda.tabla();
    }
    public void cargaerTablaHospedaje(){
         busqueda.tablaHospedaje();
    }
    public void cleanTReserva(){
        busqueda.limpiaTReserva();
    }
    public void cleanTHuespedes() {
        busqueda.limpiaTHuespedes();
    }
}

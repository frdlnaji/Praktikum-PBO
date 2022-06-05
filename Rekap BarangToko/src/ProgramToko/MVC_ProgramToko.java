/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgramToko;

/**
 *
 * @author ASUS
 */
public class MVC_ProgramToko {
    ViewProgramToko ViewProgramToko = new ViewProgramToko();
    ModelProgramToko ModelProgramToko = new ModelProgramToko();
    ControllerProgramToko ControllerProgramToko = new ControllerProgramToko(ModelProgramToko, ViewProgramToko);
}

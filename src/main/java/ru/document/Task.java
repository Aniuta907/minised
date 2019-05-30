package ru.document;

import java.time.LocalDate;

public class Task extends Document {
    private LocalDate dataExtradition; //дата выдачи поручения
    private int executionTime; //срок исполнения поручения
    private String responsibleExecutive; //ответственный исполнитель
    private int signControl; // признак контрольности
    private String controllerInstructions; //контролер поручения

    public Task(){

    }

    public Task(LocalDate  dataExtradition, int executionTime, String responsibleExecutive, int signControl,  String controllerInstructions) {
        this.dataExtradition = dataExtradition;
        this.executionTime = executionTime;
        this.responsibleExecutive = responsibleExecutive;
        this.signControl = signControl;
        this.controllerInstructions = controllerInstructions;
    }


    public void setSignControl(int signControl) {
        this.signControl = signControl;
    }

    public void setDataExtradition(LocalDate dataExtradition) {
        this.dataExtradition = dataExtradition;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        if (executionTime < 0) throw new IllegalArgumentException();
        this.executionTime = executionTime;
    }

    public void setRespExecutive(String responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public void setСontroller(String controllerInstructions) {
        this.controllerInstructions = controllerInstructions;
    }

    @Override
    public String toString() {
        return "Поручение №" + getID()+ " от "+dataExtradition;
    }
}

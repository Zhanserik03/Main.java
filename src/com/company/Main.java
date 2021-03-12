package com.company;

import com.company.controllers.TECHController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;

import com.company.repositories.TECHRepositories;

import com.company.repositories.interfaces.ITECHRepositories;



public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ITECHRepositories repo = new TECHRepositories(db);
        TECHController controller = new TECHController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}

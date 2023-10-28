package com.Maxim.crud_app;

import com.Maxim.crud_app.controller.DeveloperController;
import com.Maxim.crud_app.controller.SkillsController;
import com.Maxim.crud_app.controller.SpecialtyController;

import java.util.Scanner;

public class UserCommandHandler {
    public void getCommandConsole() {
        System.out.println("\nВведите команду из списка или воспользуйтесь файлом README.md: get all developers,get all skills," +
                "get all specialty,get developer by id,get skill by id,get specialty by id,delete developer by id, delete skill by id,delete specialty by id,update developer by id,update skill by id," +
                "update specialty by id, add skill, add specialty,add developer");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();

        DeveloperController developerController = new DeveloperController();
        SkillsController skillsController = new SkillsController();
        SpecialtyController specialtyController = new SpecialtyController();

        switch (command) {
            case "get all developers":
                developerController.getAllDevelopers();
                break;

            case "get all skills":
                skillsController.getAllSkills();
                break;

            case "get all specialty":
                specialtyController.getAllSpecialty();
                break;

            case "get developer by id":
                developerController.getDeveloperById();
                break;

            case "get skill by id":
                skillsController.getSkillById();
                break;

            case "get specialty by id":
                specialtyController.getSpecialtyById();
                break;

            case "delete developer by id":
                developerController.deleteDeveloperById();
                break;

            case "delete skill by id":
                skillsController.deleteSkillsById();
                break;

            case "delete specialty by id":
                specialtyController.deleteSpecialtyById();
                break;

            case "update developer by id":
                developerController.updateDeveloperById();
                break;

            case "update specialty by id":
                specialtyController.updateSpecialtyById();
                break;

            case "update skill by id":
                skillsController.updateSkillsById();
                break;

            case "add developer":
                developerController.addNewDeveloper();
                break;

            case "add skill":
                skillsController.addNewSkill();
                break;

            case "add specialty":
                specialtyController.addNewSpecialty();
                break;
            default:
                System.out.println("Проверьте правильность введенной команды для выхода введите exit");
        }


    }

}


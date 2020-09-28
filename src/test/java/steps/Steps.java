package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.frameworks.sberbank.managers.ManagerPages;

public class Steps {

    private ManagerPages app = ManagerPages.getManagerPages();

    @Когда("^Загрузка стартовой страницы$")
    public void getInitialPage(){
        app.getStartPage();
    }

    @Когда("^Закрытие куки$")
    public void closeCookies(){
        app.getStartPage().closeCookies();
    }

    @Когда("^Переход в меню '(.*)'$")
    public void selectMenu(String nameMenu){
        app.getStartPage().selectMenu(nameMenu);
    }

    @Когда("^Переход на страницу '(.*)'$")
    public void selectSubMenu(String nameSubMenu){
        app.getStartPage().selectSubMenu(nameSubMenu);
    }

    @Когда("^Заполнение поле/значение$")
    public void fillField(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getCompleteHomePage().fillField(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("^Выставление чекбокс/положение$")
    public void checkboxIs(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getCompleteHomePage().checkboxIs(raw.get(0), Boolean.valueOf(raw.get(1)));
                }
        );
    }

    @Тогда("^Проверка поле/значение$")
    public void checkResult(DataTable dataTable){
        dataTable.cells().forEach(
                raw -> {
                    app.getCompleteHomePage().checkResult(raw.get(0), raw.get(1));
                }
        );
    }

}

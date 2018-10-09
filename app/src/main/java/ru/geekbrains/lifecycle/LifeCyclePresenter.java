package ru.geekbrains.lifecycle;

// Делаем на основе шаблона Singleton
// Этот шаблон обладает свойством хранить только один экземпляр объекта
// Для реализации шаблона Singleton надо добавить static private поле instance
// Конструктор должен быть private
// Добавляем статический метод, который проверяет, существует ли этот объект; если нет, то создаем его
// Таким образом в приложении всегда существует только один объект Singleton
// Класс, реализующий Singleton, нельзя наследовать
public final class LifeCyclePresenter {

    // внутреннее поле, хранящее единственный экземпляр объекта
    private static LifeCyclePresenter instance = null;

    // Это наш счетчик
    private int counter;

    // Конструктор (вызывать извне его нельзя, поэтому он приватный)
    private LifeCyclePresenter(){
        counter = 0;
    }

    // Увеличение счетчика
    public void incrementCounter(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    // Метод, который возвращает экземпляр объекта.
    // Если объекта нет, то создаем его.
    public static LifeCyclePresenter getInstance(){
        // Здесь реализована «ленивая» инициализация объекта,
        // то есть, пока объект не нужен, не создаем его.
        if (instance == null){
            instance = new LifeCyclePresenter();
        }
        return instance;
    }
}

package Lesson4;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> {
    private final int DEFAULT_SIZE = 10; //стандартное количество ячеек массива
    private int currentSize = 0; //текущее количество элементов в массиве
    private Object[] myArrayList = new Object[DEFAULT_SIZE];//массив на 10 элементов


    public MyArrayList(Collection<T> collection) { //конструктор для создания на основе другой коллекции
        addAll(collection);
    }

    public MyArrayList() {}

    public void add(int index, T item){ //добавление элемента в ячейку index со значением item
        if ((index > DEFAULT_SIZE && index > currentSize) || index < 0) //проверка допустимых значений индекса (не больше ли допустимого и не ментьше ли 0)
            throw new IndexOutOfBoundsException(); //исключение
        if (currentSize + 1 == myArrayList.length){ //в случае, если не хватает выделенных ячеек на новый элемент массива
            changeLength((int)( myArrayList.length*1.5)); //увеличиваем количество ячеек на 50%
        }
        for (int i = currentSize; i >= index; i--){ //прочесываем массив с последнего элемента до нужного индекса ячейки
            myArrayList[i + 1] = myArrayList[i]; //перезаписываем в ячейку предыдущий элемент
        } //таким образом сдвигаем все элементы на ячейку вправо, тем самым сохраняем элементы, освободив ячейку с необходимым индексом
        myArrayList[index] = item; //запись элемента в освобожденную ячейку
        currentSize++;// увеличиваем счётчик элементов
    }

    public void add(T item){ //добавление элемента со значением item
        if (currentSize + 1 == myArrayList.length){ //в случае, если не хватает выделенных ячеек на новый элемент массива
            changeLength((int)( myArrayList.length*1.5)); //увеличиваем количество ячеек на 50%
        }
        myArrayList[currentSize] = item; //запись элемента в следующую ячейку
        currentSize++;// увеличиваем счётчик элементов
    }

    public <T> void addAll(Collection<? extends T> collection){ //принимаем некую коллекцию элементов с неким типом Т или его наследниками
        if (currentSize + collection.size() > myArrayList.length){ //если сумма количества элементов в myArrayList и количества элементов принимаемой коллекции
            changeLength(currentSize + collection.size()); //больше, чем количество ячеек в массиве, выделяем нужное количество ячеек
        }
        for (var object : collection) { //для каждого объекта принимаемой коллекции
            myArrayList[currentSize++] = object; //записываем элемент коллекции (object) в следующую ячейку массива
        }
    }

    public T get (int index) { //принимаем индекс нужного элемента
        if (index > currentSize || index < 0) // проверка допустимых значений
            throw new IndexOutOfBoundsException();
        else
            return (T) myArrayList[index]; //возврат необходимого элемента
    }

    public int size(){
        return currentSize;
    } //возврат количества элементов массива

    public void remove(int index){ //принимаем индекс удаляемого элемента
        if (index > currentSize || index < 0) //проверка допустимых значений
            throw new IndexOutOfBoundsException();
        for (int i = index; i < currentSize; i++){ //перебор элементов начиная с нужного индекса, до последнего элемента
            myArrayList[i] = myArrayList[i+1]; //сдвигаем элементы массива влево, перезаписывая с нужного индекса
        }
        myArrayList[currentSize] = null; //удаляем последний элемент (он уже перезаписан на ячейку левее)
        currentSize--; //уменьшаем счетчик количества элементов
    }

    public void removeAll(Collection<? extends T> collection){ //принимаем коллекцию элементов с неким типом Т или его наследниками
        for (var object : collection) {// для каждого элемента принятой коллекции
            for (int i = 0; i < currentSize; i++){// перебор всех элементов массива с 0 индекса до currentSize-1
                if (Objects.equals(object, myArrayList[i])){ //если элемент коллекции (object) совпадает с элементом массива myArrayList[i] выполняется цикл
                    for (int j = i; j < currentSize; j++){ //начиная с совпадающего элемента массива до конца
                        myArrayList[j] = myArrayList[j+1]; //сдвиг элементов влево
                    }
                    myArrayList[currentSize] = null; //удаляем последний элемент (он уже перезаписан на ячейку левее)
                    currentSize--; //уменьшаем счетчик количества элементов
                }
            }
        }
    }

    private void changeLength (int newLength){ //принимаем новое количество ячеек массива, которое нужно выделить
        Object[] newArrayList = new Object[newLength]; //создание временного массива с необходимой длинной
        System.arraycopy(myArrayList, 0, newArrayList, 0, currentSize); //копирование всех элементов массива из myArrayList в временный newArrayList
        myArrayList = newArrayList; //перезаписываем в основной массив значение временного массива
    }

    public void bubbleSort (){
        for (int j = 0; j < currentSize; j++){// запуск циклов сортировки в количестве равном количеству элементов в массиве
            boolean isSorted = true; //флаг для прекращения
            for (int i = 0; i < currentSize - 1; i++){ //перебор значений в массиве до предпоследнего элемента
                if (myArrayList[i].hashCode() > myArrayList[i+1].hashCode()){ //сравниваем элемент со следующим по хешкоду
                    Object temp = myArrayList[i]; //записываем элемент в временный объект
                    myArrayList[i] = myArrayList[i+1]; //записываем в ячейку i следующий элемент
                    myArrayList[i+1] = temp; //записываем в следующий элемент сохраненный ранее в temp элемент i
                    isSorted = false; //меняем флаг сортировки на false, таким образом, если хотя бы раз за цикл будет произведен обмен значениями между элементами
                }  //флаг не даст разорвать цикл
            }
            if (isSorted) break; // в случае, если перебор значений не выявит случаев, где левый элемент больше правого, isSorted останется true и цикл разорвется
        }
    }

    public static <T> void staticBubbleSort(@NotNull MyArrayList<? extends T> collection){//принимаем свой ArrayList, содержащий объекты Т или его наследники
        collection.bubbleSort(); //сортировка пузырьком
    }

}

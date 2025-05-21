# Втора лабораториска вежба по Софтверско инженерство

## Malik Alilovski, 211532

### Control Flow Graph

![211532 - Control Flow Graph](https://github.com/user-attachments/assets/ec787bad-4f47-46e8-aebf-6368fef610f9)

### Цикломатска комплексност

Цикломатска комплексност на овој код е 13, преки формулата V(G)=E-N+2, каде што E=34 (edges), N=23 (nodes), па од овде стигнуваме во цикломатската комлексност да биде V(G)=34-23+2=13

### Тест случаи според критериумот Every statement

testAllItemsNullThrows - Го тестира условот if (allItems==null) и активира throw new RuntimeException

testInvalidItemName - Го тестира условот if (item.getName()==null || item.getName().length()==0).

testPriceOver300 - Активира условот if (price>300) и казната sum -= 30.

testDiscountCalculation - Го тестира делот каде што се пресметува попуст: price*(1-discount)*quantity, и ја активира и казната од -30.

testCardNumberInvalidCharacter - Активира проверка на невалиден карактер во бројот на картичка.

testValidItemNoDiscount - Пресметка без попуст: price*quantity без да се активира услов за -30.

testInvalidCardNumber - Aктивира условот if (cardNumber==null || cardNumber.length()!=16) и фрла исклучок.

Минималниот број на тест случаи потребни е 7.

### Тест случаи според критериумот Multiple Condition

Test1: A(F), B(F), C(F), Никој услов не е исполнет

Test2: A(F), B(F), C(T), Само C e true

Test3: A(F), B(T), C(F), Само B e true

Test4: A(F), B(T), C(T), Само A e false

Test5: A(T), B(F), C(F), Само A e true

Test6: A(T), B(F), C(T), Само B e false

Test7: A(T), B(T), C(F), Само C e false

Test8: A(T), B(T), C(T), Сите услови се исполнети

Минималниот број на тест случаи потребни е 8.

### Објаснување на напишаните unit tests

За Every Statement критериумот, креирав 7 unit тестови кои поминуваат низ секој важен дел од методот checkCart барем еднаш. 
Секој тест таргетира различен извршен пат/услов, проверка за null вредности, валидација на името на предметот,
пресметка со попуст и формат на бројот на картичка.

За Multiple Condition критериумот, 
напишав 8 тестови за да ги покријам сите можни комбинации на вистинито/невистинито 
за трите услови во if изразот што проверува цена, попуст или количина.
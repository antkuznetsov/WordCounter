# WordCounter
Программа сканирует указанные файлы и собирает статистику по используемым словам. 

Работает в многопоточном режиме. 

Названия файлов нужно передать в параметры при запуске программы. 
Файл может быть размещен на удаленном сервере, для сканирования такого файла в параметры нужно передать -l <ссылка_на_файл>

Пример входных параметров: text1.txt text2.txt text3.txt -l https://example.com/text4.txt -l https://example.com/text5.txt